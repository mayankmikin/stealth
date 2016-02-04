/**
 * 
 */
package com.app.myapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.app.myapp.entity.User;


/**
 * @author Mayank Verma
 *
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * 
     */
	private static final Logger log = Logger.getLogger(CustomAuthenticationSuccessHandler.class);
    public CustomAuthenticationSuccessHandler() 
    {
    			
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException, ServletException 
    {

        User user = (User) auth.getDetails();
        String accountType = user.getAccount().getAccountType();
        String home = "";
        
        Long groupID = null;
        req.getSession().setAttribute("USER_NAME", user.getName());
        req.getSession().setAttribute("APP_USER", user);
       
        //String admin = "/administration/index.html";
        
     
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
            System.out.println("path:"+req.getContextPath()+" home:");
            res.sendRedirect(req.getContextPath() + home);
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

}
