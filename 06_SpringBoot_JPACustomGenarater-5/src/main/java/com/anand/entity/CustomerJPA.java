package com.anand.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "custjpa")
public class CustomerJPA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String city;
	private String state;
	public CustomerJPA() {
	}
	public CustomerJPA(String city, String state) {
		this.city = city;
		this.state = state;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "CustomerJPA [pid=" + pid + ", city=" + city + ", state=" + state + "]";
	}
	
	
	
}
