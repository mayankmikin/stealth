/**
 * 
 */
package com.app.myapp.security;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.app.myapp.entity.Permission;
import com.app.myapp.entity.Role;
import com.app.myapp.entity.User;

/**
 * @author Manas Sahu
 *
 */
@SuppressWarnings("deprecation")
public class CustomAuthenticationManager implements AuthenticationManager {
    
	@Autowired
	private UtilityService utilityService;
	@PersistenceContext(unitName="spring-jpa")
    private EntityManager em;
    
    private Md5PasswordEncoder encoder;
    
    /**
     * Mayank Verma
     */
    public CustomAuthenticationManager() {
        encoder = new Md5PasswordEncoder();
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        
        String name = auth.getName();
        String password = (String) auth.getCredentials();
        String encryptedPasswordString=utilityService.encryptMD5(password);
        System.out.println("name="+name+" password="+password);
        User user = null;
        TypedQuery<User> query1 = em.createQuery("select u from User u WHERE u.emailid = ?1", User.class);
        query1.setParameter(1, name);
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
        
        
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), authorities);
        token.setDetails(user);       
        return token;
    }

}
