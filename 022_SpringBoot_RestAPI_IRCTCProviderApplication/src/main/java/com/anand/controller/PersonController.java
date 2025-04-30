package com.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anand.binding.PersonDetailes;
import com.anand.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;
	
	@PostMapping(value = "/ticketBooking"
			,consumes = "application/json"
			,produces = "text/String")
	public ResponseEntity<String> booking(@RequestBody PersonDetailes booking ){
		System.out.println("Controller Booking Value");
		//calling service method 
		String msg=   service.bookTicket(booking);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/msgV"
			,produces = "text/String")
	public ResponseEntity<String> getValue(){
		System.out.println("getValue");
		String msg="Anand";
		return new ResponseEntity<String> (msg,HttpStatus.OK);
	}
	@GetMapping(value = "/ticketDetailes"
			,produces = "application/json")
	public ResponseEntity<List<PersonDetailes>> getPersonDetailes(){
		System.out.println("inside the ticketDetailes booking");
		//service Method
	       List<PersonDetailes> ls=service.getPerson();
	       
		return new ResponseEntity<List<PersonDetailes>>(ls,HttpStatus.OK);
	}
	@GetMapping(value = "/ticketDetaile/{ticketID}"
			,produces = "application/json")
	public ResponseEntity<PersonDetailes> getPersonByID(@PathVariable ("ticketID") Integer ticketID ){
		System.out.println("insde GetPersonBYID");
		PersonDetailes det=service.getPersonByID(ticketID);
		return new ResponseEntity<PersonDetailes>(det,HttpStatus.OK);
	}
	@DeleteMapping(value = "/ticketDelete/{ticketID}"
			,produces = "text/String")
	public ResponseEntity<String> deletePerson(@PathVariable("ticketID") Integer ticketID){
		System.out.println("inside Delete the Person ");
		 String msg=service.deletePersonBYID(ticketID);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
}
