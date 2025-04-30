package com.anand.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anand.feign.WelcomeFeignClient;

@RestController
public class GreattingMsgRest {

	@Autowired
	private WelcomeFeignClient welcomeFeign;
	
	
	@GetMapping("/greating")
	public String getGreattingMessage() {
		System.out.println("inside Greating Message");
		System.out.println("interservice Communcation");
		String gret="Welcome Anand GoodEvening............!!";
		String wel=welcomeFeign.invokeWelcomeMsg();
		return gret+","+wel;
	}
}
