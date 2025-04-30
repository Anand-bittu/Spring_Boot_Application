package com.anand.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.entity.UserJPA;
import com.anand.repo.UserJPARepo;

@Service
public class UserService {

	private UserJPARepo userRepo;

	@Autowired
	public UserService(UserJPARepo userRepo) {
		this.userRepo = userRepo;
	}
	
	//using findBy method
	public void findByCity(String city) {
		/*
		 * List<UserJPA> list= userRepo.findBycity(city);
		 * list.forEach(u->System.out.println(u));
		 */
		//by sql bASED
		List<UserJPA> list=userRepo.getCity(city);
		list.forEach(u->System.out.println(u));
		
	}
	//using HQL Quary
	public void getAllUser() {
		List<UserJPA> list=userRepo.getUser();
		list.forEach(e->System.out.println(e));
	}
     //using HQL Quary getting salary
	public void getSalary(double salary) {
		List<UserJPA> list=userRepo.getBySalary(salary);
		list.forEach(n->System.out.println(n));
	}
	//using HQL Quary Getting salary and City
	public void getSalaryANDCity(double salary,String city) {
		List<UserJPA> list=userRepo.getBySalaryandCity(salary, city);
		list.forEach(n->
		System.out.println(n));
	}
	
	public void update(int uid,String city) {
		userRepo.updatTable(uid, city);
		System.out.println("Record has Updataed");
	}
	
	//record to Delete
	public void deleteTable(String uname) {
		userRepo.deleteRecord(uname);
		System.out.println("Record is Deleted");
	}
	
	public void addUser() {
		UserJPA u1=new UserJPA();
		u1.setUid(101);u1.setUname("Anand");u1.setCity("hyd");
		u1.setSalary(10000);
		UserJPA u2=new UserJPA();
		u2.setUid(102);u2.setUname("Anand");u2.setCity("hyd");
		u2.setSalary(10000);
		UserJPA u3=new UserJPA();
		u3.setUid(103);u3.setUname("Anand"); u3.setCity("nodia");
		u3.setSalary(5000);
		UserJPA u4=new UserJPA();
		u4.setUid(104);u4.setUname("Lath");u4.setCity("Mum");u4.setSalary(600);
	    List<UserJPA> li=Arrays.asList(u1,u2,u3,u4); 	
		userRepo.saveAll(li);
	}
	
	
}
