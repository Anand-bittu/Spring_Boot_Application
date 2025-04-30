package com.anand.db1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userEntity")
public class UserEntiy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String uname;
	private String email;
	public UserEntiy() {
        System.out.println("user 0 parameter");
	}
	public UserEntiy(String uname, String email) {
		this.uname = uname;
		this.email = email;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", email=" + email + "]";
	}
	
	
	
}
