package com.app.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.myapp.entity.User;
import com.app.myapp.service.DataService;

/**
 * @author Mayank Verma
 * 
 *
 */
@Controller
@RequestMapping("/api/users")
public class RestController {

	@Autowired
	DataService dataService;

	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<User> list() {
		return dataService.getUserList();

	}*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String getmessage(ModelMap model) {
		
		model.addAttribute("reply", "12345");
		return "rest-try";

	}
}
