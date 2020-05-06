package com.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeveloperController {

@RequestMapping(value="/assigned",method=RequestMethod.POST)
public ModelAndView getAssignedBug()
{
	return new ModelAndView("AssignedBugToDeveloper");
}
}