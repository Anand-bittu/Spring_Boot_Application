package com.anand.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.entity.Address;
import com.anand.entity.Employee;
import com.anand.repo.AddressRepo;
import com.anand.repo.EmployeeRepo;

@Service
public class EmployeeService {
      @Autowired
	  private EmployeeRepo erepo;
      @Autowired
	  private AddressRepo arepo;
	  
      public void getEmployee() {
    	Optional<Employee> op=  erepo.findById(1);
    	if(op.isPresent()) {
    		System.out.println(op.get());
    	}else {
    		System.out.println("Object does not exits");
    	}
      }
      public void getAddress() {
    	  Optional<Address> op=arepo.findById(2);
    	  if(op.isPresent()) {
    		  System.out.println(op.get());
    	  }else {
    		  System.out.println("Object does not exists");
    	  }
      }
      
      public void deleteEmployee() {
    	  System.out.println("delet Employee");
    	  erepo.deleteById(2);
      }
      
      public void saveEmployee() {
    	  Employee e1=new Employee();
    	  e1.setEname("Rani");
    	  e1.setSalary(15000.0);
    	  
    	  Address a1=new Address();
    	  a1.setCity("Hyd");a1.setState("TS");a1.setType("Permanent");
    	  Address a2=new Address();
    	  a2.setCity("Mumbai"); a2.setState("Ma"); a2.setType("Tempo");
          Address a3=new Address();
          a3.setCity("EP");a3.setState("MH");a3.setType("Office");
          //set address to the employee
          List<Address> ls=Arrays.asList(a1,a2,a3);
          e1.setAdd(ls);
          //set employee to the address
          a1.setEmp(e1); a2.setEmp(e1); a3.setEmp(e1);
          
          //saving Only Employee Object
          
          erepo.save(e1);      
      }
	
}
