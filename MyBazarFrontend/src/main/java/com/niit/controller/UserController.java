package com.niit.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.ProductDAO;
import com.niit.dao.UserDAO;
import com.niit.model.UserDetail;

@Controller
public class UserController
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping("/login_success")
	
	public String loginSuccess(Model m, HttpSession session) {
		/*
		 * System.out.println("Login Success"); return
		 * "redirect:/productDisplay";
		 */

		String page = "";
		boolean loggedIn = false;
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		String username = authentication.getName();
		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) authentication.getAuthorities();
		for (GrantedAuthority role : roles) {
			session.setAttribute("role", role.getAuthority());
			if (role.getAuthority().equals("ROLE_USER")) {
				loggedIn = true;
				page = "ProductDisplay"; 
				m.addAttribute("productList", productDAO.listProducts());
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);

			} else {
				loggedIn = true;
				page = "AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}

		}

		return page;
	}
	
	
	@RequestMapping(value="/registersave",method=RequestMethod.POST)
	public String registerSave
	(
			@RequestParam("username")String username,
			@RequestParam("email")String email,
			@RequestParam("firstname")String firstname,
			@RequestParam("lastname")String lastname,
			@RequestParam("address")String address,
			@RequestParam("mobile")String mobile,
			@RequestParam("password")String password,Model m)
	
	{
		
		List<UserDetail> ulist=userDAO.listUser();
		boolean hasError=false;
		for(UserDetail u:ulist)
		{
			if(u.getUsername().equals(username))
			{
				hasError=true;
				break;
			}
		}
		
		if(hasError){
			m.addAttribute("error", "You cannot use this username");
			return "Register";
		}
		
		UserDetail user=new UserDetail();
		user.setEmail(email);
		user.setUsername(username);
		user.setAddress(address);
		user.setMobile(mobile);
		user.setCoustomername(firstname+" "+lastname);
		user.setPassword(passwordEncoder.encode(password));
		user.setEnabled("True");
		user.setRole("ROLE_USER");

		userDAO.registerUser(user);
		
		
		return "redirect:/login";
	}
}
