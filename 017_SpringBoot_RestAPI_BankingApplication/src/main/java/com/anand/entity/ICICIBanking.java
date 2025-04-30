package com.anand.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "icicibank")
public class ICICIBanking {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long pid;
	
	private String accountHolderName;
	
	private double balance;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "ICICIBanking [pid=" + pid + ", accountHolderName=" + accountHolderName + ", balance=" + balance + "]";
	}
	
	
	
}
