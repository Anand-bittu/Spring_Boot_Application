package com.anand.respo;

import org.springframework.data.repository.CrudRepository;

import com.anand.entity.Employee;

public interface EmployeeRespo extends CrudRepository<Employee,Integer> {

}
