package com.anand.service;

import com.anand.entity.ICICIBanking;

public interface BankService {

	
	//add account
	public ICICIBanking addAccount(ICICIBanking banking);
	
	//deposite amount
	public String depositeAmmount(Long pid,double balance);
	
	//getAccountdetailes by Id
	public ICICIBanking getAccountDetailes(Long pid);
	
	//withDraw Balance
	public String withDrawAmount(Long pid,double amount);
	
	//delete the Record
	public String deletedAccount(Long pid);

	
}
