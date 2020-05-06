package com.portal.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.portal.models.Project;
import com.portal.models.User;
import com.portal.service.ProjectService;
import com.portal.service.UserService;

@Controller
public class HomeController {

@Autowired
UserService userService;

  @RequestMapping(value="/",method=RequestMethod.GET)
  public String validateUser(Model map)  { 
	return"Login";
  }

  @Autowired
HttpSession session;
  
  @Autowired
  ProjectService projectService;
  


@RequestMapping(value="/validation",method=RequestMethod.POST)
public ModelAndView validateUser(@RequestParam(value = "email") String email,@RequestParam(value = "password") String password,ModelMap map){
	
	
	
	System.out.println(email+" "+password);
	User uObj=userService.validateUser(email,password);
	System.out.println(uObj);
	if(uObj!=null){
		
		session.setAttribute("userObj",uObj);
	
		if(uObj.getDesg().equalsIgnoreCase("ProjectManager")) {
			List<Project> proList=projectService.getAllProjects();
			 
			 System.out.println("Project List : "+proList);
		     List<User> dList=userService.getAllDeveloper();
		     
		     System.out.println("Developers List : "+dList);
		     
		     List<User> tList=userService.getAllTester();
		    System.out.println("Testers List : "+tList);
		     
		     ModelAndView mv=new ModelAndView("ProjectAllocationForm");
		     mv.addObject("projectList",proList);
		     mv.addObject("developerList",dList);
		     mv.addObject("testerList",tList);
		     System.out.println(proList+""+dList+""+tList);
		     return mv;
			
		}
		else if (uObj.getDesg().equalsIgnoreCase("Developer")) {
			int id=uObj.getId();
			session.setAttribute("userObj",uObj);
			System.out.println(uObj);
			User developerObj=userService.getUserById(id);
			List<Project> projectList=developerObj.getProjects();
			ModelAndView mv= new ModelAndView("Developer");
			mv.addObject("projectList",projectList);
			return mv;
		}
		else if (uObj.getDesg().equalsIgnoreCase("Tester")) {
			int id=uObj.getId();
			User testerObj=userService.getUserById(id);
			List<Project> projectList=testerObj.getProjects();
			
			ModelAndView mv=new ModelAndView("Tester");
			mv.addObject("projectList",projectList);
			return mv;
		}
	}
	
		return new ModelAndView("Login");
	
	
}


@RequestMapping(value= "/logout", method=RequestMethod.GET)
public String logout() {
            session.removeAttribute("uObj");
            session.invalidate();
            return "Login";
}

}