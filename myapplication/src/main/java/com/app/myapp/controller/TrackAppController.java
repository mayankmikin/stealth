package com.app.myapp.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/track")
public class TrackAppController 
{
	private static final Logger log = Logger.getLogger(TrackAppController.class);
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String getPhysicsIndex(@RequestParam(value="t_cid", required=false) String track_cid )
	{
		 if (log.isDebugEnabled()) {
	            log.debug(" >> GET trackIndex invoked.");
	            log.debug("t_cid is :"+track_cid);
	        }
		return "trackapp-index";
	}

}
