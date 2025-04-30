package com.anand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.entity.PersonJPA;
import com.anand.repo.PersonRepo;

@Service
public class PersonService {
    
	@Autowired
	private PersonRepo repo;
	
	public void addPerson() {
		PersonJPA jpa=new PersonJPA("Raj","Mumbai");
		repo.save(jpa);
		System.out.println("person is add in database");
	}
	
}
