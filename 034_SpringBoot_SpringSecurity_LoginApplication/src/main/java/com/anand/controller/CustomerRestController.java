package com.anand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anand.entity.CustomerJPA;
import com.anand.service.CustomerJPAService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerJPAService service;
	@Autowired
	private AuthenticationManager authManger;
	
	@PostMapping(value = "/register"
			,consumes = "application/json"
			,produces = "text/String")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerJPA c){
	boolean status=	service.saveUser(c);
	if(status) {
		return new ResponseEntity<String>("Customer is Added",HttpStatus.CREATED);
	}else {
		return new ResponseEntity<String>("Customer is Not Created",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@PostMapping(value = "/login"
			,consumes = "application/json"
			,produces = "text/String")
	public ResponseEntity<String> loginCrean(@RequestBody CustomerJPA c){
	   UsernamePasswordAuthenticationToken
	   token=new
	   UsernamePasswordAuthenticationToken(c.getEmail(), c.getPassword());
		//send this to authatication manger
	   
		Authentication authentication=authManger.authenticate(token);
	    
		boolean status=authentication.isAuthenticated();
		
		if(status) {
			return new ResponseEntity<String>("Welcome",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Failed",HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
