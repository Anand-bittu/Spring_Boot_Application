package com.anand.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping("/demoMsg")
	public ResponseEntity<String> getDemoMsg(){
		String msg="Demo Msg";
		int bmsg=10/0;
		return new ResponseEntity<String>("bmsg",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
