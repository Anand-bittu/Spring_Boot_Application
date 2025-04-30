package com.anand.binding;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jtcstudent")
public class JTCStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name;
	private double fees;
	public JTCStudent() {
         System.out.println("0 parameter JTCStudent");
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
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "JTCStudent [sid=" + sid + ", name=" + name + ", fees=" + fees + "]";
	}
	
	
	
}
