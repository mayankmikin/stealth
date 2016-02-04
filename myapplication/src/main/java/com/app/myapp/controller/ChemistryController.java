package com.app.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/chemistry")
public class ChemistryController 
{
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String getPhysicsIndex()
	{
		
		return "chemistry-index";
	}

}
