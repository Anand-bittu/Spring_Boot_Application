package com.anand.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.anand.entity.UserJPA;

public interface UserJPARepo extends 
   CrudRepository<UserJPA,Integer>{

	
	
//	public List<UserJPA> findBycity(String city);
	
//	public List<UserJPA> findBycityAnduname(String city,String uname);
	
//	public List<UserJPA> findBycityAndname(String city,String uname);
	
//	public List<UserJPA> findBycityAndsalary(String city,double salary);
	
	//SQL BASED
	@Query(value = "SELECT * from UserJPA WHERE CITY=?",nativeQuery = true)
	public List<UserJPA> getCity(String city);
	
	//JPA BASED
	@Query("FROM UserJPA")
	public List<UserJPA> getUser();
	
	@Query("FROM UserJPA S WHERE S.salary = :salary")
	public List<UserJPA> getBySalary(double salary);
	
	@Query("FROM UserJPA where salary=:salary or city=:city")
	public List<UserJPA> getBySalaryandCity(double salary,String city);
	
	@Modifying
	@Transactional
	@Query("UPDATE UserJPA a set a.city=:city where a.uid=:uid")
	public void updatTable(int uid,String city);
	
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query(value = "INSERT INTO UserJPA VALUES(?,?,?,?)",nativeQuery = true)
	 * public void inserTable(UserJPA user);
	 * 
	 */
	@Modifying
	@Transactional
	@Query("DELETE FROM UserJPA where uname=:uname")
	public void deleteRecord(String uname);
	
	
	
	
}
