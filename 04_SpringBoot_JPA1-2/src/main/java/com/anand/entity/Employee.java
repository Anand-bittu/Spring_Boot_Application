package com.anand.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "EmployeeJPA")
public class Employee {
      @Id
	private Integer eid;
      @Column(name = "ename")
	private String ename;
      @Column(name = "phone")
	private long phone;
      @Column(name="email")
	private String email;
      
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createAt;
    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDate lastUpdate;
      
      public Employee() {
        System.out.println("0 parameter Employee");
      }
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", phone=" + phone + ", email=" + email + "]";
	}
      
	
	
}
