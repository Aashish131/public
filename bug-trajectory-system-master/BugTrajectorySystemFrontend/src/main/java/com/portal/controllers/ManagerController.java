package com.portal.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.portal.models.BugAllocationDetails;
import com.portal.models.BugStatus;
import com.portal.models.Project;
import com.portal.models.User;
import com.portal.service.BugAllocationService;
import com.portal.service.ProjectService;
import com.portal.service.StatusService;
import com.portal.service.UserService;

@Controller
public class ManagerController {
    @Autowired
    UserService userService;
    
	@Autowired
	ProjectService projectService;
	
    @Autowired
    StatusService statusService;

	@Autowired
	HttpSession session;
	
	@Autowired
	BugAllocationService bugAllocationDetailService;
	
	public boolean checkSession(ModelMap map) {
		if(session.getAttribute("userObj")==null) {
		map.addAttribute("msg","Session does not exist");
		return true;
		}
		return false;
		}

	@RequestMapping(value="/projectAllocated",method=RequestMethod.POST)
	public ModelAndView getProjectAllocation(@RequestParam String project,@RequestParam int[] developer,@RequestParam int[] tester,ModelMap map) {

		if(checkSession(map)) {
			ModelAndView mv=new ModelAndView("Login");
			return mv;
			}
		Project pObj=projectService.getProjectById(project);
	
		List<User> usersList=pObj.getUsers();
		
		for(int i:developer) {
			
			User uObj=userService.getUserById(i);

			uObj.getProjects().add(pObj);
			
			usersList.add(uObj);
			}
		
		for(int i:tester) {
			User uObj=userService.getUserById(i);
			uObj.getProjects().add(pObj);
			usersList.add(uObj);
		}
		
		pObj.setUsers(usersList);
		
		System.out.println("Project Obj : "+pObj);
		
		System.out.println(pObj);
		try {
		projectService.updateProject(pObj);
		map.addAttribute("msg","Project allocated successfully");
		}
		catch(Exception e) {
			map.addAttribute("msg","Project has already been allocated to developer or tester");
		}
		List<Project> proList=projectService.getAllProjects();
	    List<User> dList=userService.getAllDeveloper();
	    List<User> tList=userService.getAllTester();
		ModelAndView mv=new ModelAndView("ProjectAllocationForm");
	     mv.addObject("projectList",proList);
	     mv.addObject("developerList",dList);
	     mv.addObject("testerList",tList);
	     mv.addObject("msg","project allocated successfully");
	     
	     System.out.println(proList+""+dList+""+tList);
	     return mv;
		
	}
	
	@RequestMapping(value="/ViewBugDetail",method=RequestMethod.GET)
	public ModelAndView getBugDetails(ModelMap map)
	{
		if(checkSession(map)) {
			ModelAndView mv=new ModelAndView("Login");
			return mv;
			}
		List<BugAllocationDetails> bugAllocationList=bugAllocationDetailService.getAllBugDesc();
		System.out.println(bugAllocationList);
		ModelAndView mv=new ModelAndView("ViewBugDetail");
		mv.addObject("bugAllocatedList",bugAllocationList);
		 session.setAttribute("bugAllocate",bugAllocationList);
		return mv;
	}
	
	
	@RequestMapping(value="/showBugDetail/{bugAllocateId}",method=RequestMethod.GET)
	public ModelAndView assignBug(@PathVariable("bugAllocateId")int bugAllocateId,ModelMap map )
	{ 

		if(checkSession(map)) {
			ModelAndView mv=new ModelAndView("Login");
			return mv;
			}
		

		BugAllocationDetails bugAllocDet=bugAllocationDetailService.getBugAllocationById(bugAllocateId);
		List<BugStatus> staList=statusService.getAllStatus();
		Project pObj=projectService.getProjectById(bugAllocDet.getProjectId());
		List<User> usersList=pObj.getUsers();
		System.out.println("UserList Corresponding to that project "+usersList);
		System.out.println(bugAllocDet);
		System.out.println(staList);
		ModelAndView mv=new ModelAndView("AssignBug");
		mv.addObject("bugAlloactionDetails",bugAllocDet);
		mv.addObject("statusList",staList);
		mv.addObject("uList",usersList);
		return mv;
	}
	
	@RequestMapping(value="/assigned",method=RequestMethod.GET)
	public ModelAndView bugAssigned(@RequestParam String status,@RequestParam("from") @DateTimeFormat(pattern="dd-MM-yyyy")  Date assignedDate,@RequestParam("from") @DateTimeFormat(pattern="dd-MM-yyyy") Date endDate,ModelMap map)
	{ 
		if(checkSession(map)) {
			ModelAndView mv=new ModelAndView("Login");
			return mv;
			}

		
		BugAllocationDetails bugAssign=new BugAllocationDetails();
		bugAssign.setStatusId(status);;
		bugAssign.setPlannedStartdate(assignedDate);
		bugAssign.setPlannedEndDate(endDate);
		bugAllocationDetailService.update(bugAssign);
	      ModelAndView mv=new ModelAndView("ViewBugDetail");
		return mv;
	}

}