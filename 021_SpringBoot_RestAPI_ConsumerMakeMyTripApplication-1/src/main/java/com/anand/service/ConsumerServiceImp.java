package com.anand.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.anand.biding.PersonDetailes;

import reactor.core.publisher.Mono;

@Service
public class ConsumerServiceImp implements ConsumerService{

	private final WebClient myWebClinet;
	
   public ConsumerServiceImp(WebClient myWebClinet) {
	   this.myWebClinet=myWebClinet;
   }
	
	//save the Ticket in database
	@Override
	public Mono<String> sendDataToTheProvider(PersonDetailes detailes) {
         //Call For Rest API URL
		String url="http://localhost:9090/ticketBooking";
		Mono<String> bodyTOMono=myWebClinet.
		               post()
		              .uri(url)
		              .body(BodyInserters.fromValue(detailes))
		              .retrieve()
		              .bodyToMono(String.class);

	  System.out.println("ouptut from RestAPI Call::"+bodyTOMono);
		return bodyTOMono;
	}

	//get The Total Ticket
	@Override
	public Mono<List<PersonDetailes>> getTotalTickets() {
		//call for RestAPI URL get Class Method in java
           String url="http://localhost:9090/ticketDetailes";
     Mono<List<PersonDetailes>> getDetailes=myWebClinet
              .get()
              .uri(url)
              .retrieve()
              .bodyToFlux(PersonDetailes.class)//Convert each JSON object in the array to a Ticket object
              .collectList();//Collect the Flux of Ticket objects into a Mono of List<Ticket>
        //getDetailes 
		return getDetailes;
	}

   //Get Person By ID
	@Override
	public Mono<PersonDetailes> getPersonByID(Integer ticketid) {
         String url="http://localhost:9090/ticketDetaile/"+ticketid;
   Mono<PersonDetailes> getPersonBYID=myWebClinet.get()
         .uri(url)
         .retrieve()
         .bodyToMono(PersonDetailes.class);
		return getPersonBYID;
	}

     @Override
	public Mono<String> deletePersonByID(Integer ticketid) {
	    String url = "http://localhost:9090/ticketDelete/" + ticketid;
	    System.out.println("inside service deleted Method");
	  Mono<String> deletePersonByID=myWebClinet.delete()
	       .uri(url)
	       .retrieve()
	       .bodyToMono(String.class);
	  System.out.println("after deletion of the Object in service delete Method");
	  
	    return deletePersonByID;
	}
	
	
	
	
	
	
	
	

	/*
	 * @Override public Mono<String> deletePersonByID(Integer ticketid) { String
	 * url="http://localhost:9090/ticketDelete/"+ticketid; Mono<String> deleteByIDP=
	 * myWebClinet.delete() .uri(url) .retrieve()
	 * .onStatus(HttpStatus::is2xxSuccessful, response ->
	 * Mono.just("Record deleted successfully")) .bodyToMono(String.class) ;//
	 * Consume the successful response body (optional) return deleteByIDP; }
	 */

}
