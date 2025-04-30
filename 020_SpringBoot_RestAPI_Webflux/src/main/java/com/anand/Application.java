package com.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import com.anand.binding.Quote;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	//	getQuote1();
	//	getQuote2();
		getQuote3();
		
	}
	
	public static  void getQuote1() {
		System.out.println("inside  a get quote 1");
		String url="https://dummyjson.com/quotes/random";
	    //create a WebClient Object		
		WebClient client= WebClient.create();
		//clint
		Mono<String> mono=client.get()
		           .uri(url)
		           .retrieve()
		           .bodyToMono(String.class);
		  String msg=mono.block();
		  System.out.println(msg);
	}
	
	public static void getQuote2() {
		System.out.println("inside a get Quote2 method");	
		String url="https://dummyjson.com/quotes/random";
		//create a WebClient Object
		WebClient client=WebClient.create();
		Mono<Quote> mon=client
		    .get()
		    .uri(url)
		    .retrieve()
		    .bodyToMono(Quote.class);
		//for synchronous Comunucation
	  Quote result=mon.block();
	  System.out.println(result);
	}
	
	public static void getQuote3() {
		System.out.println("inside a getQuote 3 Method");
		String url="https://dummyjson.com/quotes/random";
		//Create  WebClient
	WebClient clinet=WebClient.create();
		System.out.println("======= Request sending - start  =======");
		clinet
		.get()
		.uri(url)
		.retrieve()
		.bodyToMono(Quote.class)
		.subscribe(response
				->{
					handleResponse(response);
				});
		System.out.println("==== Request sending - completed ======");
	}
	public static void handleResponse(Quote response) {
		System.out.println(response);
		//push Response to kafaka
	}

}
