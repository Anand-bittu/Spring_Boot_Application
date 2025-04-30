package com.anand.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreattingController {

	@GetMapping("/contact")
	public String getContact() {
		return "Contact to these number::100";
	}
	
	
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello Anand";
	}
	@GetMapping("/greating")
	public String getGreating() {
		return "GoodEvening";
	}
	
	
}
