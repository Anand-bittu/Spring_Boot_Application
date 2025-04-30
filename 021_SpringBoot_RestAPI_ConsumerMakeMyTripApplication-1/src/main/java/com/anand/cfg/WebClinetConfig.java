package com.anand.cfg;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootConfiguration
public class WebClinetConfig {

	@Bean
	public WebClient myWebClinet() {
		return WebClient.builder().build();
	}
}
