package com.app.myapp.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.app.myapp.entity.Admin;
import com.app.myapp.service.AdminService;
import com.app.myapp.specification.AdminSpecification;

@Controller
@RequestMapping("/admin")
public class AdminController implements ServletContextAware
{
	private ServletContext servletContext;
	@Autowired
	private AdminService adminService;
	

	@RequestMapping(value="/index",method=RequestMethod.POST)
	public String getPhysicsIndex(Model model,HttpSession session,@RequestParam(value="key",required=true)String key)
	{
		Admin admin=adminService.findOne(AdminSpecification.fetchbyKey(key));
		if(admin==null)
		{
			return "wrong-credentials";
		}
		return "admin-panel";
	}
	@RequestMapping(value="/fileuploader",method=RequestMethod.GET)
	public String getFileUploader(Model model,HttpSession session)
	{
		
		
		return "admin-panel";
	}
	@RequestMapping(value="/fileuploader",method=RequestMethod.POST)
	public String postFileUploader(Model model,HttpSession session,@RequestParam(value="file",required=true) MultipartFile file1)
	{
		
		try {
				File file = new File(servletContext.getRealPath("/") + "/WEB-INF/views/videos/"
				+ file1.getName()+".jpeg");
				 
				FileUtils.writeByteArrayToFile(file, file1.getBytes());
				System.out.println("file location : " + file.toString()+".jpg"
				+ " on your computer and verify that the image has been stored.");
			} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println(e);
			}
		System.out.println("received file 1");
		
		
		return "admin-panel";
	}
	@RequestMapping(value="/videophysicsuploader",method=RequestMethod.POST)
	public String physicsVideoUpload(Model model,HttpSession session,@RequestParam(value="file",required=true) MultipartFile file1)
	{
		
		try {
				File file = new File(servletContext.getRealPath("/") + "/WEB-INF/views/videos/"
				+ file1.getName()+".mp4");
				 
				FileUtils.writeByteArrayToFile(file, file1.getBytes());
				System.out.println("file location : " + file.toString()+".jpg"
				+ " on your computer and verify that the image has been stored.");
			} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println(e);
			}
		System.out.println("received file 1");
		
		
		return "admin-panel";
	}
	
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}
	
	
}
