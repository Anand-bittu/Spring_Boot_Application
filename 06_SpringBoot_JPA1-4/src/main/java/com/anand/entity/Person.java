package com.anand.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
    @Id
	private int pid;
	private String name;
	private int age;
	private String gender;
	private String country;
	public Person() {
         System.out.println("0 parameter Person");
	}
	public Person(int pid, String name, int age, String gender, String country) {
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.country = country;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		System.out.println("inside TOString method");
		return "Person [pid=" + pid + ", name=" + name + ", age=" + age + ", gender=" + gender + ", country=" + country
				+ "]";
	}
	

	
	
}
