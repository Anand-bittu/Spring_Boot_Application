package com.anand.service;

import java.util.List;

import com.anand.biding.PersonDetailes;

import reactor.core.publisher.Mono;

public interface ConsumerService {

	//save the Person Object
	public Mono<String> sendDataToTheProvider(PersonDetailes detailes);
	
	//get total Ticket
	public Mono<List<PersonDetailes>> getTotalTickets();
	//get Ticket by ID
	public Mono<PersonDetailes> getPersonByID(Integer ticketid);
	
	public Mono<String> deletePersonByID(Integer ticketid);
}
