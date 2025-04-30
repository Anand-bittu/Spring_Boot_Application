package com.anand.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personjpa")
public class PersonJPA {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  private String name;
	  private String email;
	  public PersonJPA() {
		// TODO Auto-generated constructor stub
	}
	public PersonJPA(String name, String email) {
		this.name = name;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "PersonJPA [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
}
