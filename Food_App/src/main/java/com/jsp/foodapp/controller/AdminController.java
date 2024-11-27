package com.jsp.foodapp.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.AdminDao;
import com.jsp.foodapp.entities.Admin;

@Controller
public class AdminController {
	
	@Autowired
	AdminDao adminDao;
	@RequestMapping("/addAdmin")
	public ModelAndView m1() {
		ModelAndView mav=new ModelAndView("CreateAdmin");
		Admin admin = new Admin();
		mav.addObject("admin",admin);
		return mav;
		
	}
	
	@RequestMapping("/saveadmin")
	public ModelAndView saveAdmin(@ModelAttribute("admin") Admin a) {
		ModelAndView mav=new ModelAndView("LoginAdmin");
		adminDao.saveAdmin(a);
		return mav;
		
	}
	@RequestMapping("/validateAdmin")
	public ModelAndView loginValidation(ServletRequest req) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Admin admin=adminDao.login(email,password);
		if(admin==null) {
			ModelAndView mav=new ModelAndView("LoginAdmin");
			mav.addObject("message","invalid credentials");
			return mav;
		}
		else {
			ModelAndView mav=new ModelAndView("adminoptions");
			mav.addObject("message1","login successful");
			return mav;
					
		}
	}
}
