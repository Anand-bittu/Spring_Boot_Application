package com.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	//	insertEmployee();
	}
	public static void insertEmployee() {
		System.out.println("insideEmployee");
		//first URL
		String url="http://localhost:9090/msgV";
		//create a Client Object
	  WebClient client=WebClient.create();
	Mono<String> mono=client.get()
	     .uri(url)
	     .retrieve()
	     .bodyToMono(String.class);
	  System.out.println(mono);
	}
}
