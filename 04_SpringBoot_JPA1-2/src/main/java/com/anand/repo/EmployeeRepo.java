package com.anand.repo;

import org.springframework.data.repository.CrudRepository;

import com.anand.entity.Employee;

public interface EmployeeRepo extends 
CrudRepository<Employee,Integer>{

	
}
