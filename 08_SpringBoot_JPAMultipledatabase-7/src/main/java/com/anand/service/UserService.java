package com.anand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.db1.entity.UserEntiy;
import com.anand.db1.repo.UserRepo;
import com.anand.db2.entity.PersonJpa;
import com.anand.db2.repo.PersonJPAReo;

@Service
public class UserService {
	
	  @Autowired
	  private UserRepo userRepo;
	 
	@Autowired
	private PersonJPAReo personRepo;
	
	public void addUsers() {
		
		  UserEntiy ue=new UserEntiy("Anand","bc@gamil.com");
		  userRepo.save(ue);
		  System.out.println("record inserted in Mysql");
		 
	}
	
	public void addPerson() {
		PersonJpa jpo=new PersonJpa("Bittu","bc@gamil.com");
		personRepo.save(jpo);
		System.out.println("record inserted in H2 dataBase");
	}
	
	
	
}
