package com.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anand.biding.PersonDetailes;
import com.anand.service.ConsumerService;

import reactor.core.publisher.Mono;

@Controller
public class ConsumerController {

	@Autowired
	private ConsumerService service;
	
	@GetMapping("/tcw")
	public String loadingPage(Model model) {
		System.out.println("inside Loading Page");
		//sending the Empty Object to the form
		PersonDetailes objectdetailes=new PersonDetailes();
		model.addAttribute("detailes",objectdetailes);
		return "index";
	}	
	 @PostMapping("/detailes")
	    public Mono<String> bookingPage(PersonDetailes detailes, Model model) {
	        System.out.println("inside Post Method:");
	        Mono<String> providerResponseMono = service.sendDataToTheProvider(detailes);
	        // Use flatMap to process the Mono<String> and add the result to the model
	        return providerResponseMono.flatMap(providerResponse -> {
	            model.addAttribute("smsg", providerResponse);
	            model.addAttribute("detailes", detailes);
	            System.out.println("post Mapping method Final result form Provider: " + providerResponse);
	            return Mono.just("index"); // Return the view name as a Mono<String>
	        });
	    }
	
	 @GetMapping("/users")
	 public Mono<String> getBookedTickets(Model model) {
		 System.out.println("inside get all Ticket Booking ");
		 //now got the response Object
		  Mono<List<PersonDetailes>> providerResponse=service.getTotalTickets();
		 
		  //send the data to the page

		 return providerResponse.flatMap(tickets->{
			 model.addAttribute("users",tickets);
			 System.out.println("get Final Result");
			 return Mono.just("users");
		 });
	 }
	 //Get By ID Page
	 @GetMapping("/getPerson")
	 public String getPersonByIDPage(Model model){
		 System.out.println("inside the getId Object");
		 PersonDetailes objectdetailes=new PersonDetailes();
		 model.addAttribute("detailes",objectdetailes);
		 return "getPerson";
	 }
	 
	 //get Person ByID
	 @GetMapping("/getP")
	 public Mono<String>  getPersonByID(@RequestParam("ticketID")Integer ticketID
			 ,Model model){
		 System.out.println("inside ------>GetUserBYID---------->");
		Mono<PersonDetailes> providerResponse=service.getPersonByID(ticketID);
	return	providerResponse.flatMap(ticket->
		{
			model.addAttribute("users",ticket);
			System.out.println("---------->"+providerResponse);
			return Mono.just("users");
		});
	 }
	 //Delete the Person By ID
	@GetMapping("/delete")
	public Mono<String> deletePersonByID(@RequestParam("ticketID") Integer ticketID,
			Model model){
		System.out.println("inside deleted Method");
		Mono<String> providerResponse=service.deletePersonByID(ticketID);
		   model.addAttribute("smg","Ticket has been deleted");
		   Mono<List<PersonDetailes>> listOfReposeses=service.getTotalTickets();
		   return listOfReposeses.flatMap(tickets->{
			   System.out.println();
				 model.addAttribute("users",tickets);
				 System.out.println("get Final Result");
				 return Mono.just("users");
			 });
	}
	 
	 
}
