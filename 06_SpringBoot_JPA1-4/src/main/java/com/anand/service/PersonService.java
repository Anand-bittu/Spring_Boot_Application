package com.anand.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anand.entity.Person;
import com.anand.repo.PersonRepo;

@Service
public class PersonService {

	 @Autowired
	 private PersonRepo personRepo;
	 
	 
	 //quary by Example
	 public void getQBE(String gender,String country) {
			/*
			 * System.out.println("isnid getQBE"); Person person=new Person(); if(gender !=
			 * null) { person.setGender(gender);
			 * 
			 * } if(country != null) { person.setCountry(country); } Example<Person>
			 * example=Example.of(person); System.out.println(); //example Based
			 * List<Person> li=personRepo.findAll(example); li.forEach(System.out::println);
			 */
		   if (gender == null && country == null) {
	            // If both gender and country are null, retrieve all persons
	            List<Person> allPersons = personRepo.findAll();
	            allPersons.forEach(System.out::println);
	        } else {
	            Person person = new Person();
	            if (gender != null) {
	                person.setGender(gender);
	            }
	            if (country != null) {
	                person.setCountry(country);
	            }
	            Example<Person> example = Example.of(person);
	            System.out.println("Executing QBE based on provided criteria:");
	            List<Person> filteredPersons = personRepo.findAll(example);
	            filteredPersons.forEach(System.out::println);
	        }	 
	 }
	 //Page Based Logical
	 public void paggingData() {
		 int pageSize=3;
		 int pageNo=3;
		 //pageRequest Object 
       	PageRequest preq=	 PageRequest.of(pageNo-1, pageSize);
   	//page Object
   	 Page<Person> page=personRepo.findAll(preq);
   	 //getting Content Object
   	 List<Person> content=page.getContent();
   	  content.forEach(n->System.out.println(n)); 
	 } 
	 //sort by age using JPAResposrity
	 public void sortByAge() {
		 //sort the data by age application
		   Sort sort=Sort.by("age").descending();
		   List<Person> li=personRepo.findAll(sort);
		  li.forEach(n->
		     System.out.println(n));
		  
	 }
	 
	 //insert data
	 public void insertData() {
		   Person p1 = new Person(1, "Raj", 20, "Male", "India");
			Person p2 = new Person(2, "Anil", 32, "Male", "India");
			Person p3 = new Person(3, "Sunil", 23, "Male", "India");
			Person p4 = new Person(4, "John", 24, "Male", "USA");
			Person p5 = new Person(5, "Robert", 55, "Male", "UK");
			Person p6 = new Person(6, "Sita", 46, "Fe-Male", "India");
			Person p7 = new Person(7, "Gita", 27, "Fe-Male", "Japan");
			Person p8 = new Person(8, "Cathy", 38, "Fe-Male", "Canada");
			List<Person> li=Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8);
			//person save
			personRepo.saveAll(li);
			System.out.println("Person is saved");
			
	 }
	 
	
}
