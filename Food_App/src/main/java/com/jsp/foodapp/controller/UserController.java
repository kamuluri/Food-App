package com.jsp.foodapp.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.Userdao;
import com.jsp.foodapp.entities.User;

@Controller
public class UserController {
		@Autowired
		Userdao u1;
		
		@RequestMapping("/adduser")
		public ModelAndView createuser() {
			ModelAndView mav=new ModelAndView("Createuser");
			User user=new User();
			mav.addObject("users",user);
			return mav;
		}
		
		@RequestMapping("/saveuser")
		public ModelAndView create_user(@ModelAttribute("users") User u) {
			ModelAndView mav=new ModelAndView("Loginuser");
			u1.saveUser(u);
			return mav;	
		}
		
		@RequestMapping("validateuser")
		public ModelAndView loginValidation(ServletRequest req,HttpSession session) {
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			User user=u1.login(email,password);
			if(user!=null) {
				ModelAndView mav=new ModelAndView("useroptions");
				session.setAttribute("user", user);
				mav.addObject("message","login successful");
				return mav;
				
			}
			else {
				
				ModelAndView mav=new ModelAndView("Loginuser");
				mav.addObject("message","invalid credentials");
				return mav;	
			}
		}
		
}


