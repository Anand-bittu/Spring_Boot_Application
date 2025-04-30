package com.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anand.service.TXService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx	=
			SpringApplication.run(Application.class, args);
	    TXService tx=ctx.getBean(TXService.class);
	    tx.savePersonData();
	}

}
