package com.anand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.websocket.server.PathParam;

@Controller
@ResponseBody
public class Demo {

	
	
	@GetMapping("/mm/{name1}")
	public String PathVaue(@PathVariable("name1") String name1) {
		return name1+" , Hi";
	}
	
	
	//based on RequestParam
	@GetMapping("/grt")
	public String  ResponsBody(@RequestParam ("name") String name) {
		
		return name+", How are you";
	}
	
}
