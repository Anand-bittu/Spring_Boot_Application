package com.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anand.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		   ConfigurableApplicationContext 
		   ctx=SpringApplication.run(Application.class, args);
		UserService service= ctx.getBean(UserService.class);
	//	service.addUser();
	
	//	service.findByCity("hyd");
		//by JPA
	//	service.getAllUser();
	//	service.getSalary(10000);
	//	service.getSalaryANDCity(600,"hyd");
	//	service.update(104,"banglor");
	//	service.addRecord();
		service.deleteTable("Lath");
		
		
	}
}
