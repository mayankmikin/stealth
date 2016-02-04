package com.app.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.myapp.entity.User;

@Controller
@RequestMapping("/login")
public class LoginController 
{
		
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String getIndexPage(Model model)
	{
		String message="Hey Bro Welecome";
		model.addAttribute(new User());
		model.addAttribute("message", message);
		return "home";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String getIndexPagePost( @RequestParam(value="emailid",required=true)String emailid,@RequestParam(value="password",required=true)String password,Model model, HttpSession session )
	{
		System.out.println("inside  controller post method");
		System.out.println("emailid "+emailid+" password is "+password);
		String message="Hey Bro Welecome";		
		model.addAttribute("message", message);
		return "home";
	}
	

}
