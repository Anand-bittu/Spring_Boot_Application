package com.anand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anand.response.EmployeeResponse;
import com.anand.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping(value = "/employee/{emp_id}"
			,produces = "application/json")
	public ResponseEntity<EmployeeResponse> getEmployeeByID(
			@PathVariable Integer emp_id){
	EmployeeResponse employeeResponse=service.getEmployeeBYId(emp_id);
		return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.OK);
	}
	
}
