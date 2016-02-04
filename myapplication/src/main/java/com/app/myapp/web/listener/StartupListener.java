
package com.app.myapp.web.listener;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class StartupListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(StartupListener.class);
    
    
    @Override
    public void contextInitialized(ServletContextEvent context) 
    {
        if (log.isInfoEnabled()) {
            log.info("Servlet Context Initialized..");
        }
/*        
        String root = context.getServletContext().getRealPath("/");
        root = root.replace("\\", "/");
        String[] paths = root.split("/");
        if(paths.length > 0) {
            System.out.println(paths[paths.length-1]);
            System.setProperty("logPath", paths[paths.length-1]);
        }*/
        
        context.getServletContext().setAttribute("PAGE_SIZE", 20);
        context.getServletContext().setAttribute("project_Name", "Project Stealth");
        Map<String, String> applicationScope = new HashMap<String, String>();
        applicationScope.put("Notification", "0");
       /* Map<String, String> alertOn = new HashMap<String, String>();
        alertOn.put("X", "Both Direction");
        alertOn.put("I", "Entering");
        alertOn.put("O", "Leaving");
        context.getServletContext().setAttribute("AlertOn", alertOn);*/
        
        /*Map<String, String> alertMode = new HashMap<String, String>();
       // alertMode.put("D", "Not Aplicable");
        alertMode.put("A", "Email & SMS");
        alertMode.put("E", "Email");
        alertMode.put("S", "SMS");
        context.getServletContext().setAttribute("AlertMode", alertMode);
        
        Map<String, String> alertType = new HashMap<String, String>();
        alertType.put("GEO", "GeoZone");
        alertType.put("POI", "LandMark");
        alertType.put("IGN", "Ignition");
        alertType.put("SPD", "OverSpeed");
        alertType.put("PDC", "PowerDiconnection");
        alertType.put("AC", "AC");
        context.getServletContext().setAttribute("AlertType", alertType);
        
        Map<String, String> status = new HashMap<String, String>();
        status.put("A", "Active");
        status.put("D", "Deleted");
        status.put("I", "Inactive");
        status.put("S", "Suspend");
        context.getServletContext().setAttribute("Status", status);
        
        Map<String, String> assetStatus = new HashMap<String, String>();
        assetStatus.put("A", "Active");
        assetStatus.put("I", "Inactive");
        context.getServletContext().setAttribute("AssetStatus", assetStatus);
        
        Map<String, String> fuelFormula = new HashMap<String, String>();
        fuelFormula.put("V", "Valid");
        fuelFormula.put("I", "Invalid");
        context.getServletContext().setAttribute("FuelFormula", fuelFormula);
        
        Map<Boolean, String> userStatus = new HashMap<Boolean, String>();
        userStatus.put(true, "Active");
        userStatus.put(false, "Inactive");
        context.getServletContext().setAttribute("UserStatus", userStatus);
        
        Map<String, String> operator = new HashMap<String, String>();
        operator.put("GT", "Greater Than");
        operator.put("LT", "Less Than");
        context.getServletContext().setAttribute("Operator", operator);
        
         Configuration Items 
        Map<String, String> accountType = new HashMap<String, String>();
        accountType.put("TP", "Transport Operator");
        accountType.put("DL", "Showroom Dealer");
        //accountType.put("TX", "Taxi Service Operator");
        context.getServletContext().setAttribute("AccountType", accountType);
        
        Map<String, String> roleType = new HashMap<String, String>();
        roleType.put("AO", "Account Owner");
        roleType.put("AU", "Account User");
        roleType.put("GO", "Group Owner");
        roleType.put("GU", "Group User");
        context.getServletContext().setAttribute("RoleType", roleType);
        
        Map<String, String> assetIcon = new HashMap<String, String>();
        assetIcon.put("TRUCK", "Truck");
        assetIcon.put("CAR", "Car");
        context.getServletContext().setAttribute("AssetIcon", assetIcon);
        
        Map<String, String> timezone= new HashMap<String, String>();
        timezone.put("GMT", "Greenwich Mean Time (GMT)");
        //timezone.put("IST", "Indian Standard Time (IST)");
        context.getServletContext().setAttribute("TimeZone", timezone);
        
        Map<String, String> smsstatus = new HashMap<String, String>();
        smsstatus.put("A", "To be Processed");
        smsstatus.put("L", "Not Delivered (Limit)");
        smsstatus.put("M", "Not Delivered (Manual)");
        smsstatus.put("P", "Processed");
        smsstatus.put("X", "Not Delivered (DND)");
        context.getServletContext().setAttribute("SMSStatus", smsstatus);
        
        Locale.setDefault(Locale.ENGLISH);*/
        
    }

    
    @Override
    public void contextDestroyed(ServletContextEvent context) 
    {
        if (log.isInfoEnabled()) {
            log.info("Servlet Context Destroyed..");
        }
        
    }

}
