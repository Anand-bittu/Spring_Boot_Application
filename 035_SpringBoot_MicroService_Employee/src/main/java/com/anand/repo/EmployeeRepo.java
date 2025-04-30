package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.Employee;

public interface EmployeeRepo extends
JpaRepository<Employee, Integer>{

}
