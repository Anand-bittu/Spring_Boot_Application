package com.anand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anand.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@GetMapping("/v")
	public String loadPage(Model model) {
		System.out.println("Inside Loading class Object");
		User userObject=new User();
		model.addAttribute("user",userObject);
		return "index";
	}
	
	@PostMapping("/login")
	public String loginPage(HttpServletRequest request,User user,Model model) {
		System.out.println("inside Login Page Method");
		String email=user.getEmail();
		String password=user.getPassword();
		if(email.equals("anand@gmail.com")&& password.equals("abc@123")) {
			//create Session object
		    HttpSession session=request.getSession(true);
			   session.setAttribute("email",email);   
			return "dashboard";	
		}else {
			//invalid login
			model.addAttribute("emsg", "Invalid Crediation");
		}
		return "index";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest req,Model model) {
		System.out.println("inside LogOut page");
		User userObject=new User();
		model.addAttribute("user", userObject);
	    HttpSession session= req.getSession(false);
	    //session Object is deleted
	    session.invalidate();
		return "index";
	}
	
	@GetMapping("/det")
	@ResponseBody
	public String getDetailes(HttpServletRequest req) {
		System.out.println("inside detailes");
	     HttpSession session	=req.getSession(false);
	     String email=(String)session.getAttribute("email");
		return "det"+email;
	}
	
	
	
}
