package com.jsp.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.FoodOrderdao;
import com.jsp.foodapp.dao.Userdao;
import com.jsp.foodapp.entities.FoodOrder;
import com.jsp.foodapp.entities.Item;
import com.jsp.foodapp.entities.User;

@Controller
public class FoodorderController {
	
	@Autowired
	FoodOrderdao fd;
	
	@Autowired
	Userdao ud;
	
	double totalbill=0;
	
	@RequestMapping("/createorder")
	public ModelAndView createorder() {
		ModelAndView mav=new ModelAndView("createfoodorder");
		FoodOrder fo=new FoodOrder();
		mav.addObject("foodorder",fo);
		return mav;
	}
	
	@RequestMapping("/savefoodorder")
	public ModelAndView saveorder(@ModelAttribute("foodorder") FoodOrder order,HttpSession session) {
		session.setAttribute("userfoodorder",order );
		ModelAndView mav=new ModelAndView("redirect:/viewallproduct");
		return mav;
	}
	@RequestMapping("/submitfoodorder")
	public ModelAndView submitfoodorder(HttpSession session) {
		FoodOrder fo=(FoodOrder) session.getAttribute("userfoodorder");
		List<Item> items =(List<Item>) session.getAttribute("itemsList");
		fo.setItems(items);
		
		
		items.stream().forEach(i->{
			totalbill= totalbill+i.getCost();
		});
		fo.setTotalbill(totalbill);
		
		User u=(User)session.getAttribute("user");
		List<FoodOrder> orders=u.getFoodorder();
		if(orders.size()>0) {
			orders.add(fo);
			fo.setUser(u);
			u.setFoodorder(orders);
		}
		else {
			List<FoodOrder> orders1 =new ArrayList<FoodOrder>();
			orders1.add(fo);
			fo.setUser(u);
			u.setFoodorder(orders1);
			
			
		}
		fd.saveFoodOrder(fo);
		ud.UpdateUser(u);
		
		ModelAndView mav = new ModelAndView("useroptions");
		return mav;
		
		
		
	}
	
}
