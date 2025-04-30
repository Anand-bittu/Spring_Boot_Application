package com.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anand.entity.User;
import com.anand.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {
    
	@Autowired
	private UserService userService;
	
	@GetMapping("/wel")
	public String displayPage(Model model) {
		System.out.println("inside Display Method");
		User userObject=new User();	
		model.addAttribute("user", userObject);	
		return "index";
	}
	
	@PostMapping("/user")
	public String handleUserTable(@Valid User user,BindingResult result,Model model) {
		System.out.println("inside Record Insert Method");
		
		if(result.hasErrors()) {
			
			return "index";
		}
		
	  boolean value=userService.addUser(user);
	  if(value) {
		  model.addAttribute("smsg","User is Inserted");
	  }else {
		  model.addAttribute("emsg","User is not Inserted");
	  }
		return "index";
	}
	//method to View the Page 
	@GetMapping("/users")
	public String viewPageR(Model model) {
		System.out.println("dispaly students");
		 List<User> savedUser=   userService.retrive();
		 model.addAttribute("users", savedUser);
		return "users";
		
	}
	
	//method to delete the Record in database
	@GetMapping("/delete")
	public String deletePage(@RequestParam("id") int id,Model model) {
		System.out.println("inside delete Method");
	  boolean values=userService.deleteRecord(id);
	  if(values) {
		  model.addAttribute("smsg","Record has been Deleted");
		  List<User> listUser=userService.retrive();
		  model.addAttribute("users",listUser);
	  }
	  else {
		  model.addAttribute("emsg","Record not Found");
	  }
	  return "users";
	}
	
	//method to edit the record in database
	
	
	@GetMapping("/edit")
	public String editPage(@RequestParam("uid")int uid,Model model) {
	        User savedUser=userService.editUser(uid);
	        model.addAttribute("user",savedUser);
	        return "index";
	}
	
	
}
