package com.app.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/maths")
public class MathsController 
{
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String getPhysicsIndex()
	{
		
		//return "/maths-index";
		return "physics-index";
	}

}
