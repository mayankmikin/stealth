package com.app.myapp.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.myapp.entity.Permission;
import com.app.myapp.entity.Role;
import com.app.myapp.entity.User;
import com.app.myapp.security.UtilityService;
import com.app.myapp.service.DataService;

/**
 * @author Mayank Verma
 * 
 *
 */
@Controller
@RequestMapping("/rest")
public class RestfulLogin 
{
	private static final Logger log = Logger.getLogger(RestfulLogin.class);
	@Autowired
	DataService dataService;
	@Autowired
	private UtilityService utilityService;
	@PersistenceContext(unitName="spring-jpa")
    private EntityManager em;
    
    private Md5PasswordEncoder encoder;
    

	public RestfulLogin() {
		super();
		encoder = new Md5PasswordEncoder();
	}
	@Transactional
	@RequestMapping(value = "/log", method = RequestMethod.GET)	
	public @ResponseBody String getLoginPage(@RequestParam(value="username" , required=true) String username,@RequestParam(value="password" , required=true) String password, Model model) 
	{
		//correct string http://localhost:8080/rest/login.html?username=mayank&password=hi
		if (log.isDebugEnabled()) 
		{
            log.debug(" >> GET rest login invoked");
            log.debug("credentias are :"+username+" "+password);
        }
		model.addAttribute("reply", "12345");
		return "rest-try";
	}
	@RequestMapping(value = "/getmessage/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String getmessage(@PathVariable  String name) {
		if (log.isDebugEnabled()) 
		{
            log.debug(" >> GET rest login invoked");
            log.debug("credentias are :"+name);
        }
		System.out.println(name);
		return "hello user ";

	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)	
	public @ResponseBody String getLoginCredentials(@RequestParam(value="username" , required=true) String username,@RequestParam(value="password" , required=true) String password,HttpServletRequest req, HttpServletResponse res, Model model) 
	{
		//correct string http://localhost:8080/rest/login.html?username=mayank&password=hi
		//http://localhost:8080/rest/login.html?username=negi.gaurav@gmail.com&password=123
		
		 String encryptedPasswordString=utilityService.encryptMD5(password);
	        System.out.println("name="+username+" password="+password);
	        User user = null;
	        TypedQuery<User> query1 = em.createQuery("select u from User u WHERE u.emailid = ?1", User.class);
	        query1.setParameter(1, username);
	        try 
	        {
	        	
	            user = query1.getSingleResult();
	            System.out.println("inside custom authentication");
	            System.out.println("user peoperties are :"+user.getName()+user.getPhonenumber()+" password is :"+user.getPassword());
	        } catch(NoResultException ex) {
	            throw new BadCredentialsException("User not Found");
	        }
	        
	        if(user == null) {
	        	 System.out.println("user not found");
	            throw new BadCredentialsException("User not Found");
	        }
	        
	        if(!user.getStatus().equals("A")) 
	        {
	        	System.out.println("User not Active");
	            throw new BadCredentialsException("User not Active");
	        }
	       
	       /* if(encoder.isPasswordValid(user.getPassword(), password, null) == false) 
	        {
	        	 System.out.println("password not valid");
	            throw new BadCredentialsException("Wrong Password");
	        }*/
	        if(user.getPassword().equals(encryptedPasswordString))
	        {
	        	System.out.println("password valid");
	        }
	        System.out.println("i m here ");
	        TypedQuery<Role> query2 = em.createQuery("select r from Role r LEFT JOIN FETCH r.permissions p WHERE r.id = ?1", Role.class);
	        query2.setParameter(1, user.getRole().getId());
	        Role role = query2.getSingleResult();
	       
	        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        for(Permission permission : role.getPermissions()) {
	            authorities.add(new GrantedAuthorityImpl("ROLE_" + permission.getName()));
	        }
	       
	      /*  Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	 
	            authorities.add(new GrantedAuthorityImpl("ROLE_" + user.getName()));*/
	        
	        
	        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, authorities);
	        token.setDetails(user); 
	       
	        String accountType = user.getAccount().getAccountType();
	        String home = "";
	        
	        Long groupID = null;
	        req.getSession().setAttribute("USER_NAME", user.getName());
	        req.getSession().setAttribute("APP_USER", user);
	       
	        //String admin = "/administration/index.html";
	  try
	  {
	     
	        if(accountType.equals("SU")) 
	        {
	           // home = "/index.jsp";
	            home = "/adminindex.jsp";
	            req.getSession().setAttribute("HOME_URL", home);

	            System.out.println("inside Authentication SuccessHandler");
	            System.out.println("context path is "+req.getContextPath().toString());
	        
	           res.sendRedirect(req.getContextPath()+home);
	        }
	        if(accountType.equals("EU")) 
	        {
	        	home = "/index.jsp";
	        	
	            
	            req.getSession().setAttribute("HOME_URL", home);
	/*            
	            if(user.getRole().getType().equals("SU") || user.getRole().getType().equals("EU")) {
	                res.sendRedirect(req.getContextPath() + admin);
	            } else {
	                res.sendRedirect(req.getContextPath() + home);
	            }*/
	            //res.sendRedirect(req.getContextPath() + home);
	           // res.sendRedirect("http://localhost:8080/WEB-INF/views/trackapp/index.html");
	            
	        }
	        if(accountType.equals("DEMO")) 
	        {
	            home = "/demo/dashboard.html";
	            req.getSession().setAttribute("HOME_URL", home);
	/*            
	            if(user.getRole().getType().equals("SU") || user.getRole().getType().equals("EU")) {
	                res.sendRedirect(req.getContextPath() + admin);
	            } else {
	                res.sendRedirect(req.getContextPath() + home);
	            }*/
	            res.sendRedirect(req.getContextPath() + home);
	        }
	        
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	 
	  return "trackapp-index";
	}

}
