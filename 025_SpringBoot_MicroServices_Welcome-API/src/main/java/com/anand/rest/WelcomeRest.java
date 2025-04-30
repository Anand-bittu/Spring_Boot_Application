package com.anand.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRest {
	
	@Autowired
	private Environment enviroment;

	@GetMapping("/welcome")
	public String getWeclomePage() {
		String port=enviroment.getProperty("server.port");
		String msg="Welcome TO Microservices......!!!(" +port+ " )";
		System.out.println("inside Welcome Page");
		return msg;
	}
	
	
}
