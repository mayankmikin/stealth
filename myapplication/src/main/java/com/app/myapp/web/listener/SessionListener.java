
package com.app.myapp.web.listener;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionListener implements HttpSessionListener {

    private static final Logger log = Logger.getLogger(SessionListener.class);
    
  
    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        if (log.isInfoEnabled()) {
            HttpSession session = hse.getSession();
            log.info("Session ID=" + session.getId() + " maxInactiveInterval=" + session.getMaxInactiveInterval() + " seconds");
        }
        java.util.Date date= new java.util.Date();
        String ipAddress = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
        System.out.println("Session Created: " + hse.getSession().getId() + " at " + new Timestamp(date.getTime()) + " with " + ipAddress);
    }

    
    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        if (log.isInfoEnabled()) {
            HttpSession session = hse.getSession();
            log.info("Session ID=" + session.getId());
        }
        java.util.Date date= new java.util.Date();
        System.out.println("Session Destroyed: " + hse.getSession().getId() + " at " + new Timestamp(date.getTime()));
    }
}
