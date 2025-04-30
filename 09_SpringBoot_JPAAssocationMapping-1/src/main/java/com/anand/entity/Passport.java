package com.anand.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "passport")
public class Passport {
    
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int pid;
	private String passportNumber;
	private LocalDate issueAt;
	private LocalDate experAt;
	@OneToOne
	@JoinColumn(name = "person_Id")
	private PersonJpa personJpa;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public LocalDate getIssueAt() {
		return issueAt;
	}
	public void setIssueAt(LocalDate issueAt) {
		this.issueAt = issueAt;
	}
	public LocalDate getExperAt() {
		return experAt;
	}
	public void setExperAt(LocalDate experAt) {
		this.experAt = experAt;
	}
	public PersonJpa getPersonJpa() {
		return personJpa;
	}
	public void setPersonJpa(PersonJpa personJpa) {
		this.personJpa = personJpa;
	}
	
	
	/*
	 * @Override public String toString() { return "Passport [pid=" + pid +
	 * ", passportNumber=" + passportNumber + ", issueAt=" + issueAt + ", experAt="
	 * + experAt + ", personJpa=" + personJpa + "]"; }
	 * 
	 */
	
}
