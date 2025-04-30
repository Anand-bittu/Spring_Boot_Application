package com.anand.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.entity.Passport;
import com.anand.entity.PersonJpa;
import com.anand.repo.PassportJpa;
import com.anand.repo.PersonJpaRepo;



@Service
public class PersonService {
	@Autowired
    private PersonJpaRepo repo;
	
	@Autowired
    private PassportJpa passportrepo;
	
	//adding the person in the database
	public void addPerson() {
		PersonJpa jpa=new PersonJpa();
		jpa.setPname("Raj");
		jpa.setEmail("B@g.com");
		
		//save Person
	    PersonJpa ttt=repo.save(jpa);
		
		Passport pw=new Passport();
		pw.setPassportNumber("5678aj");
		pw.setIssueAt(LocalDate.now());
	    pw.setExperAt(LocalDate.now().plusYears(10));
	   
	    pw.setPersonJpa(ttt);
	    
	    //save in  Repo
	    passportrepo.save(pw);
	}
	
	public void retrivePerson(){
		System.out.println("person Retrive");
	   Optional<PersonJpa> ps=repo.findById(1);
	   if(ps.isPresent()) {
		   System.out.println(ps.get());
	   }else {
		   System.out.println("person does not exits");
	   }
	}
	
	public void retrivePassport() {
		System.out.println("passPort Retrive");
		Optional<Passport> passport=passportrepo.findById(2);
		if(passport.isPresent()) {
			System.out.println(passport.get());
		}else {
			System.out.println("passport does not exit");
		}
	}
	//delete
	public void deletePerson() {
		System.out.println("inside delete Person");
		    repo.deleteById(1);
		   System.out.println("person is deleted");
	}
	
	public void deletePassport() {
		System.out.println("inside delete Passport");
		passportrepo.deleteById(1);
		System.out.println("passport is deleted");
	}
	
	
}
