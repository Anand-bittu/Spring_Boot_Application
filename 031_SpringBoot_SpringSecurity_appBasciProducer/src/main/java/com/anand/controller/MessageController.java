package com.anand.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("/welcome")
	public String getWelcomePage() {
		return "Welcome Anand";
	}
	
}
