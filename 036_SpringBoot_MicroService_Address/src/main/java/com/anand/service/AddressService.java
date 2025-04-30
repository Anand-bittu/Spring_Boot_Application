package com.anand.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.entity.Address;
import com.anand.repo.AddressRepo;
import com.anand.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	private AddressRepo repo;
	@Autowired
	private ModelMapper mapper;
	
	public AddressResponse getAddressByEmpId(Integer emp_id) {
		System.out.println("inside address Service class Object");
	Address address=repo.findAddressByEmpID(emp_id);
	AddressResponse response=mapper.map(address,AddressResponse.class);
		return response;
	}
	
	
	
	
	
}
