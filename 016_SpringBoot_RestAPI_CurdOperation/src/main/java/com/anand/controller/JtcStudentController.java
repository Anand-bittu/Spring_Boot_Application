package com.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anand.binding.JTCStudent;
import com.anand.service.JTCStudentService;

@RestController
public class JtcStudentController {

	@Autowired
	private JTCStudentService service;
	
	
	@PostMapping(value = "/student"
			,consumes = {"application/json","application/xml"}
			,produces = "text/string")
	public ResponseEntity<String> addPerson(@RequestBody
			JTCStudent std){
		System.out.println(std);
		//logic to save in database
	   String result=service.upsert(std);
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/student/{sid}"
			,produces = {"application/json","application/xml"})
	public ResponseEntity<JTCStudent> getByID(@PathVariable int sid){
		//get the person Object
		 JTCStudent st=service.getJTCStudentById(sid);
          //send the json object
		return new ResponseEntity<JTCStudent>(st,HttpStatus.OK);
	}
	
	@GetMapping(value = "/students"
			,produces = {"application/json","application/xml"})
	public ResponseEntity<List<JTCStudent>> getAllStudent(){
		  List<JTCStudent> lresult=service.getListOfStudent();
		  System.out.println("inside get all students");
		  return new ResponseEntity<List<JTCStudent>>(lresult,HttpStatus.OK);
	}
	
	//update data
	@PutMapping(value = "/student"
			,consumes = "application/json"
			,produces = "text/string")
	public ResponseEntity<String> updateRecord
	(@RequestBody JTCStudent std){
	String result=service.upsert(std);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	//delete the Record
	
	@DeleteMapping(value = "/student/{sid}"
			,produces = "text/string")
	public ResponseEntity<String> deleteById(@PathVariable("sid") Integer sid){
		System.out.println("inside delete method");
		//student is deleted
	 String result=	service.deleteStudentByID(sid);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	
	
}
