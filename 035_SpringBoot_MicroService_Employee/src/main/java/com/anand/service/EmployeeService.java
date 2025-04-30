package com.anand.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.anand.entity.Employee;
import com.anand.repo.EmployeeRepo;
import com.anand.response.AddressResponse;
import com.anand.response.EmployeeResponse;

@Service
public class EmployeeService {
    @Autowired
	private EmployeeRepo repo;
	
    @Autowired
    private ModelMapper modelMapper;
   
    @Autowired
    private WebClient webClient;
    
  //  @Autowired
  //  private RestTemplate template;
   	
	public EmployeeResponse getEmployeeBYId(Integer emp_id) {
		System.out.println("inside Get EMployee");
		/*
		 * Employee employee=repo.findById(emp_id).get(); EmployeeResponse
		 * employeeResponse=modelMapper.map(employee,EmployeeResponse.class);
		 * AddressResponse addressResponse=template.getForObject(
		 * "http://localhost:8080/address/{emp_id}",AddressResponse.class, emp_id);
		 * System.out.println("after RestCall -------------------------------");
		 * employeeResponse.setResponse(addressResponse);
		 */
		Employee employee=repo.findById(emp_id).get();
		EmployeeResponse employeeResponse=modelMapper.map(employee,EmployeeResponse.class);
		String url="http://localhost:8080/address/"+emp_id;
		AddressResponse addressResponse=webClient
		     .get()
		     .uri(url)
		     .retrieve()
		     .bodyToMono(AddressResponse.class)
		     .block();
		employeeResponse.setResponse(addressResponse);
	return employeeResponse;
	}
	
	
	
}
