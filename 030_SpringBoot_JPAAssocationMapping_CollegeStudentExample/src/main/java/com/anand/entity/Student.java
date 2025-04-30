package com.anand.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpastudent")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String sname;
	private String email;
	@ManyToOne
	@JoinColumn(name = "cid")
	private College college;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", email=" + email + ", college=" + college.getCid() + "]";
	}

	
	
}
