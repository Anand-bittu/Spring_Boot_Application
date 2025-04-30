package com.anand.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserJPA")
public class UserJPA {
    @Id
	private int uid;
    
    @Column(name = "uname")
	private String uname;
    
    @Column(name = "city")
	private String city;
    
    @Column(name = "salary")
	private double salary;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createAt;
    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDate updataTableAt;
    
	public UserJPA() {
        System.out.println("0 parameter UserJPA");
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "UserJPA [uid=" + uid + ", uname=" + uname + ", city=" + city + ", salary=" + salary + "]";
	}
	
	
	
}
