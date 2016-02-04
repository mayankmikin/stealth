package com.app.myapp.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.myapp.entity.Account;
import com.app.myapp.entity.Permission;
import com.app.myapp.entity.Role;
import com.app.myapp.entity.User;
import com.app.myapp.security.UtilityService;
import com.app.myapp.service.AccountService;
import com.app.myapp.service.PermissionService;
import com.app.myapp.service.RoleService;
import com.app.myapp.service.UserService;
import com.app.myapp.specification.UserSpecification;


@Controller
@RequestMapping("/security")
public class SecurityController 
{
	
	@PersistenceContext(unitName="spring-jpa")
    private EntityManager em;
	@Autowired
	UserService userService;
	@Autowired
	UtilityService utilityService;
	@Autowired
	PermissionService permissionService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	AccountService accountService;
	   private static final Logger log = Logger.getLogger(SecurityController.class);
	/*   
	@RequestMapping("/login")
	public String getLogin(Model model,HttpSession session)
	{
		  if (log.isDebugEnabled()) 
		    {
	            log.debug(" >> GET getLoginPage invoked.");
	        }
		String message="secure login successful";
		model.addAttribute(new User());
		model.addAttribute("message", message);
		return "home";
	}
	*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model) 
	{
        if (log.isDebugEnabled()) {
            log.debug(" >> GET getLoginPage invoked.");
        }
        return "security/login";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLoginPsot(Model model,HttpSession session,@RequestParam(value="first_name",required=true)String first_name ,@RequestParam(value="last_name",required=true)String last_name,@RequestParam(value="display_name",required=true)String city,@RequestParam(value="country",required=true)String country,@RequestParam(value="email",required=true)String email,@RequestParam(value="password",required=true)String password,@RequestParam(value="gender",required=true)String gender,@RequestParam(value="datepicker",required=true)String dob,@RequestParam(value="phonenumber",required=true)String phonenumber) 
	{
        if (log.isDebugEnabled()) 
        {
            log.debug(" >> Post login page called to  Register a user");
        }
       
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dd=null;
        try {
        	//dd=format.parse(dob);
        	dd.parse(dob);
        	}
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        System.out.println("inside the post of manage users");
    	System.out.println(first_name+last_name);
    	String encryptedPassword=utilityService.encryptMD5(password);
    	User user= new User();
    	Role role=new Role();
    	Account acc= new Account();
    	Permission permission= new Permission();
    	acc.setAccessType("LIM");
    	acc.setAccountType("EU");
    	Date d=Calendar.getInstance().getTime();
    	acc.setCreated(new Timestamp(d.getTime()));
    	acc.setStatus("A");
    	acc.setUsername(first_name);
    	user.setName(first_name+" "+last_name);
    	user.setPhonenumber(phonenumber);
    	user.setAccount(acc);
    	user.setEmailid(email);
    	user.setAddress(city);
    	user.setCountry(country);
    	user.setPassword(encryptedPassword);
    	user.setGender(gender);
    	user.setStatus("A");
    	if(dd!=null)
    	{
    		user.setDob(new Timestamp(dd.getTime()));
    	}
    	Set<User>userset= new HashSet<User>();
    	userset.add(user);
    	acc.setUsers(userset);
    	Date jd=new Date(d.getYear(), d.getMonth()+3, d.getDay());
    	Timestamp t=new Timestamp(jd.getTime());
    	acc.setValidity(t);
    	accountService.save(acc);    	
    	 
    	role.setAccount(acc);
    	role.setName(email);
    	Set<Permission>permissions= new HashSet<Permission>();
    	role.setPermissions(permissions);
    	role.setType("EU");
    	role.setUsers(userset);
    	permission.setName("MANAGE_ACCOUNT");
    	
    	permissionService.save(permission);
    	roleService.save(role);
    	user.setRole(role);
    	userService.save(user); 
        return "user-registered";
    }
	
	@RequestMapping(value="/checkphone", method=RequestMethod.GET)
	public @ResponseBody String getIndexPagePost( @RequestParam(value="phonenumber",required=true)String phonenumber,Model model, HttpSession session )
	{
		String check="N";
		System.out.println("inside  checkphone post method");
		System.out.println(phonenumber);
		
		User user= userService.findOne(UserSpecification.checkPhonenumber(phonenumber));
		if(user!=null)
		{			
			check="Y";
		}
		return check;
	}	
	@RequestMapping(value="/checkemail", method=RequestMethod.GET)
	public @ResponseBody String checkEmail( @RequestParam(value="email",required=true)String email,Model model, HttpSession session )
	{
		String check="N";
		System.out.println("inside  checkphone post method");
		System.out.println(email);
		
		User user= userService.findOne(UserSpecification.checkEmail(email));
		if(user!=null)
		{			
			check="Y";
		}
		return check;
	}
}
