package com.anand.cfg;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeCfg {

	@Bean
	public ModelMapper modelMapper() {
		//creating the model MapperObject manually
		return new ModelMapper();
	}
	@Bean
	public WebClient webClient() {
		return WebClient
				.builder()
				.build();
	}
	
	
	
	/*
	 * @Bean public RestTemplate template() { return new RestTemplate(); }
	 */
	
	
	
	
}
