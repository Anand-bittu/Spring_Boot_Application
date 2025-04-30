package com.anand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MsgController {

	
	@GetMapping("/greating")
	public ModelAndView getGreating() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg","Good Evening Anand");
		mv.setViewName("index");
		return mv;
	}
	
	
	
	@GetMapping("/welcome")
	public ModelAndView getWelcome() {
		//create Model and view Object
		ModelAndView mv=new ModelAndView();
		//set the data in ModelAnd View Object in Key and value format
		mv.addObject("msg","Welcome to Spring MVC Application anand");
		//setting  View Page name
		mv.setViewName("index");
		//send modelandview Object to FrontController
		return mv;
	}
}
