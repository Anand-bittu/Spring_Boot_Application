package com.anand.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@GetMapping("/msg")
	public String firstMsg() {
		String msg="Welcome to First RestAPI Application";
		return msg;
	}
	
	@GetMapping("/grt")
	public ResponseEntity<String> greatingMsg(){
		String msg="Good Evening";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	
	
}
