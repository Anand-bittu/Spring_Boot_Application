package com.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anand.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	 ConfigurableApplicationContext ctx=	
			 SpringApplication.run(Application.class, args);
	UserService  service=ctx.getBean(UserService.class);
	System.out.println("User is Inserting");
	   service.addUsers();
	   System.out.println("User inserted in Mysql Db");
	   System.out.println("Person inserting");
	   service.addPerson();
	   System.out.println("Person Inserted in H2 db");
	}

}
