package com.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anand.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx=
			SpringApplication.run(Application.class, args);
	EmployeeService service=ctx.getBean(EmployeeService.class);
      //	service.addEmployee();
     // 	service.deletAllRedcord();
	    //    service.saveAllRecord();
	   //       service.getAllRecord();
	           service.getByID(108);
      	
	}

}
