package com.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anand.entity.Employee;
import com.anand.respo.EmployeeRespo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx=	
		SpringApplication.run(Application.class, args);
	
	EmployeeRespo res=ctx.getBean(EmployeeRespo.class);
	
		Employee e1=new Employee();
		e1.setEid(102); e1.setEname("Rani");e1.setEaddress("Nodia");
		//call save Method
		res.save(e1);
		
		
	}

}
