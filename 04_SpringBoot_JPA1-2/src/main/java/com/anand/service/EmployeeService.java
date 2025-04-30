package com.anand.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.entity.Employee;
import com.anand.repo.EmployeeRepo;

@Service
public class EmployeeService {

	
	private EmployeeRepo employRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employRepo) {
		this.employRepo = employRepo;
	}
	
	//method to One Record save 
	public void addEmployee() {
		Employee e1=new Employee();
		e1.setEid(101);e1.setEname("Raj");e1.setPhone(102530);e1.setEmail("A@gamil.com");
		employRepo.save(e1);
		System.out.println("employee is saved");
	}
	
	public void deletAllRedcord() {
		employRepo.deleteAll();
	}
	
	//method to save all Records
	public void saveAllRecord() {
		Employee e1=new Employee();
		e1.setEid(101);e1.setEname("Anand");e1.setPhone(1023);e1.setEmail("A@Emial");
		Employee e2=new Employee();
		e2.setEid(102);
		e2.setEname("Sonu");
		e2.setPhone(14538);
		e2.setEmail("Anand@g");
		Employee e3=new Employee();
		e3.setEid(103);e3.setEname("Rani");
		e3.setPhone(10253);e3.setEmail("e@GAMIL");
		List<Employee> le=Arrays.asList(e1,e2,e3);
		employRepo.saveAll(le);				
	}
	
	//method to get all Records
	public void getAllRecord() {
	  //get all the data
	  Iterable<Employee> ie=employRepo.findAll();
	  ie.forEach(emp->
	     System.out.println(emp)
			  );
	}
	//method to find employee by ID
	public void getByID(int uid) {
     Optional<Employee> op	=employRepo.findById(uid);
     if(op.isPresent()) {
    	 System.out.println(op.get());
     }else {
    	 System.out.println("no Record is Found");
     }
		
	}
}
