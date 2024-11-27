package com.jsp.foodapp.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.Productdao;
import com.jsp.foodapp.entities.Product;

@Controller
public class ProductController {
	@Autowired
	Productdao pd;
	
	@RequestMapping("/addproduct")
	public ModelAndView addproduct() {
		Product p=new Product();
		ModelAndView mav=new ModelAndView("createproduct");
		mav.addObject("addproduct",p);
		return mav;
	}
	
	@RequestMapping("/saveproduct")
	public ModelAndView saveroduct(@ModelAttribute("addproduct") Product p) {
		
		ModelAndView mav=new ModelAndView("adminoptions");
		pd.saveProduct(p);
		
		return mav;
	}
	
	@RequestMapping("/viewallproducts")
	public ModelAndView viewallprod() {
		List<Product> product=pd.viewAllProducts();
		ModelAndView mav=new ModelAndView("viewallproducts");
		mav.addObject("productslist",product);
		return mav;
	}
	
	@RequestMapping("/editproduct")
	public ModelAndView editproduct(@RequestParam("id") int id) {
		Product p=pd.viewProductById(id);
		ModelAndView mav=new ModelAndView("updateproduct");
		mav.addObject("productsdata",p);
		return mav;
	}
	
	@RequestMapping("/updatepro")
	public ModelAndView updateproduct(ServletRequest req) {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String type=req.getParameter("type");
		String cost=req.getParameter("cost");
		
		Product p=new Product();
		p.setId(Integer.parseInt(id));
		p.setName(name);
		p.setType(type);
		p.setCost(Double.parseDouble(cost));
		
		pd.UpdateProduct(p);
		
		ModelAndView mav=new ModelAndView("redirect:/viewallproducts");
		return mav;
		
	}
	
	@RequestMapping("/deleteproduct")
	public ModelAndView deleteproduct(@RequestParam("id") int id) {
		ModelAndView mav=new ModelAndView("redirect:/viewallproducts");
		pd.deleteProductById(id);
		return mav;
	}
	
	
	@RequestMapping("/viewallproduct")
	public ModelAndView viewallproducts() {
		List<Product> product=pd.viewAllProducts();
		ModelAndView mav=new ModelAndView("viewproducts");
		mav.addObject("productslist",product);
		return mav;
	}
		
}

