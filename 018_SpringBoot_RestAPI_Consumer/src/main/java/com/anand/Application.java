package com.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.anand.binding.Quote;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	//	getMsg();
		getObjectMsg();
	}
	
	
	public static void getMsg() {
		System.out.println("inside get Msg Method");
		//url msg form the RestAPI
		String url="https://api.restful-api.dev/objects/";
		//create a Rest Template Object in the method
		RestTemplate template=new RestTemplate();	
	  ResponseEntity<String> response=template.getForEntity(url,String.class);	
		System.out.println(response.getStatusCode().value());
		System.out.println(response.getBody());		
	}
    
	public static void getObjectMsg() {
		System.out.println("inside Object Msg ");
		
		String url="https://dummyjson.com/quotes/random";
		
		RestTemplate template=new RestTemplate();
		ResponseEntity<Quote> response=
				template.getForEntity(url,Quote.class);
		System.out.println(response.getBody());
	}
	
	
}
