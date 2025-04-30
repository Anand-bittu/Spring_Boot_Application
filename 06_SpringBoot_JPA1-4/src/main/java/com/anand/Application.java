package com.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anand.service.PersonService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	  ConfigurableApplicationContext ctx	=
			  SpringApplication.run(Application.class, args);
	  //gettin service class Object
	  PersonService service=ctx.getBean(PersonService.class);
	//  service.insertData();
	//    service.sortByAge();
	 //     service.paggingData();
	         service.getQBE(null,null);
	  
	}

}
