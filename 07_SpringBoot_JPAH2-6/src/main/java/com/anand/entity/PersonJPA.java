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
	private int sid;
	private String name;
	private String eamil;
	public PersonJPA() {
		// TODO Auto-generated constructor stub
	}
	public PersonJPA(String name, String eamil) {
		this.name = name;
		this.eamil = eamil;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	@Override
	public String toString() {
		return "PersonJPA [sid=" + sid + ", name=" + name + ", eamil=" + eamil + "]";
	}
	
	
}
