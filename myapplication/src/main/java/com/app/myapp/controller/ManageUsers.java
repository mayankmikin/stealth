package com.app.myapp.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.JodaDateTimeFormatAnnotationFormatterFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.myapp.entity.Account;
import com.app.myapp.entity.User;
import com.app.myapp.security.UtilityService;
import com.app.myapp.service.AccountService;
import com.app.myapp.service.UserService;
import com.app.myapp.specification.UserSpecification;

@Controller
@RequestMapping("/user")
public class ManageUsers 
{
	@Autowired
	UserService userService;
	@Autowired
	UtilityService utilityService;

	@Autowired
	AccountService accountService;
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String getRegisterInvoke(Model model,HttpSession session )
	{	
		System.out.println("inside register user");
		
		return "user-register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody String postRegisterInvoke(Model model,HttpSession session,@RequestParam(value="first_name",required=true)String first_name ,@RequestParam(value="last_name",required=true)String last_name,@RequestParam(value="display_name",required=true)String city,@RequestParam(value="country",required=true)String country,@RequestParam(value="email",required=true)String email,@RequestParam(value="password",required=true)String password)
	{	
		
		System.out.println("inside the post of manage users");
	System.out.println(first_name+last_name);
	String encryptedPassword=utilityService.encryptMD5(password);
	User user= new User();
	
	Account acc= new Account();
	acc.setAccessType("limited");
	acc.setAccountType("free");
	Date d=Calendar.getInstance().getTime();
	acc.setCreated(new Timestamp(d.getTime()));
	acc.setStatus("A");
	acc.setUsername(first_name);
	user.setAccount(acc);
	Set<User>userset= new HashSet<User>();
	userset.add(user);
	acc.setUsers(userset);
	Date jd=new Date(d.getYear(), d.getMonth()+3, d.getDay());
	Timestamp t=new Timestamp(jd.getTime());
	acc.setValidity(t);
	user.setCity(city);
	user.setCountry(country);
	user.setPassword(encryptedPassword);
	userService.save(user);
	accountService.save(acc);
		return "user-saved";
	}
	@RequestMapping(value="/check",method=RequestMethod.GET)
	public @ResponseBody User checkuserExists(Model model,HttpSession session,@RequestParam(value="email",required=true)String email )
	{	
		System.out.println("inside check user");
		//User user=userService.findOne(UserSpecification.fetchAll(email));		
		User user=new User();
		return user;
	}
	


}
