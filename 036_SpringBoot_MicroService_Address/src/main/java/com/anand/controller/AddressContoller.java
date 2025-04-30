package com.anand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anand.response.AddressResponse;
import com.anand.service.AddressService;

@RestController
public class AddressContoller {

	@Autowired
	private AddressService service;
	
	@GetMapping(value = "/address/{emp_id}"
			,produces = "application/json")
	public ResponseEntity<AddressResponse> getAddress(
			@PathVariable Integer emp_id){
		System.out.println("inside  Controller Address Class Method::");
	AddressResponse addressResponse=service.getAddressByEmpId(emp_id);
	
		return  new ResponseEntity<>(addressResponse,HttpStatus.OK);
	}
	
	
	
}
