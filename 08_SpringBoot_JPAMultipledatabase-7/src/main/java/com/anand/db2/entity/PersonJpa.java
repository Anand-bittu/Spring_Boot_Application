package com.anand.db2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personjpa")
public class PersonJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private String email;
	public PersonJpa() {
          System.out.println("0 parameter Person");
	}
	public PersonJpa(String pname, String email) {
		this.pname = pname;
		this.email = email;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "PersonJpa [pid=" + pid + ", pname=" + pname + ", email=" + email + "]";
	}
	
	
}
