package com.anand.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String ename;
	private Double salary;
	
	@OneToMany(mappedBy = "emp",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	private List<Address> add;
	public Employee() {
        System.out.println("Inside Employee");
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public List<Address> getAdd() {
		return add;
	}
	public void setAdd(List<Address> add) {
		this.add = add;
	}
	/*
	 * @Override public String toString() { return "Employee [eid=" + eid +
	 * ", ename=" + ename + ", salary=" + salary + ", add=" + add + "]"; }
	 * 
	 */
}
