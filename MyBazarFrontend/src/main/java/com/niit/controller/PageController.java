package com.niit.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

@Controller
public class PageController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	
     @RequestMapping(value="/login")
     public String showLoginPage(@RequestParam(name="error",required=false)String error,@RequestParam(name="logout",required=false)String logout,Model model)
     {
    	 if(error!=null){
    		 model.addAttribute("msg", "Username or Password is invalid !");
    	 }
    	 if(logout!=null){
    		 model.addAttribute("msg", "Logout sucess !");
    	 }
    	 return "Login";
     }

     @RequestMapping(value="/register")
     public String showRegisterPage()
     {
    	 return "Register";
     }

     @RequestMapping(value="/contactus")
     public String showContactUs()
     {
    	 return "ContactUs";
     }


     @RequestMapping(value="/aboutus")
     public String showAboutUs()
     {
    	 return "AboutUs";
     }
     
     
}
