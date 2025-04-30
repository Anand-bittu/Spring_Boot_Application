package com.anand.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Jpacollege")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String cname;
	private String email;
	@OneToMany(mappedBy = "college",cascade = CascadeType.ALL
			,fetch = FetchType.EAGER)
	private List<Student> student;
	
	public College() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "College [cid=" + cid + ", cname=" + cname + ", email=" + email + ", student=" + student + "]";
	}
	
	
}
