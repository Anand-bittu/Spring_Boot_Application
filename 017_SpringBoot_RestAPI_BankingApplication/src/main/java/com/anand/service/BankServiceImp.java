package com.anand.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.entity.ICICIBanking;
import com.anand.repo.BankRepo;

@Service
public class BankServiceImp implements BankService {
 
	@Autowired
	private BankRepo brepo;
	@Override
	public ICICIBanking addAccount(ICICIBanking banking) {
      // add person
		  ICICIBanking bankingresult=brepo.save(banking);
		
		return bankingresult;
	}
	@Override
	public String depositeAmmount(Long pid, double balance) {
		 ICICIBanking bankin=brepo
				 .findById(pid)
				 .orElseThrow(()->new RuntimeException("Account does Not Exists"));
		           bankin.setBalance(bankin.getBalance()+balance);
		           //save the Object
		           brepo.save(bankin);
		   return "Ammount::"+balance+" is deposited";
		
		/*
		 * if(brepo.existsById(pid)) {
		 * Optional<ICICIBanking>getAccount=brepo.findById(pid); ICICIBanking
		 * banking=getAccount.get(); //balance to be added logical
		 * banking.setBalance(banking.getBalance()+balance); //know save in the database
		 * brepo.save(banking);
		 * System.out.println("After saving the data in database::"+banking); return
		 * "Balance::"+balance+" Added"; }else { return "account Doesn't exist"; }
		 * 
		 */
		   
	}
	@Override
	public ICICIBanking getAccountDetailes(Long pid) {
		 ICICIBanking bankin=brepo
				 .findById(pid)
				 .orElseThrow(()->new RuntimeException("Account does Not Exists"));
		     return bankin;
		     
		/*
		 * Optional<ICICIBanking> getAccount=brepo.findById(pid);
		 * if(getAccount.isPresent()) { return getAccount.get(); } return null;
		 */
	
	
	}
	@Override
	public String withDrawAmount(Long pid, double amount) {
		ICICIBanking bankin=brepo
				 .findById(pid)
				 .orElseThrow(()->new RuntimeException("Account does Not Exists"));
		if(amount<=bankin.getBalance()) {
			bankin.setBalance(bankin.getBalance()-amount);
			//save the data
		  brepo.save(bankin);
		  return "Amount::"+amount+" is withdrawn";
		}
		else {
			throw new RuntimeException("Insufficient Balance");
		}
		
		
		/*
		 * if(brepo.existsById(pid)) { Optional<ICICIBanking>
		 * getAccount=brepo.findById(pid); ICICIBanking fetchAccount=getAccount.get();
		 * if(amount<=fetchAccount.getBalance()) { //delete the Amount
		 * fetchAccount.setBalance(fetchAccount.getBalance()-amount); //now save the
		 * fetchAccount brepo.save(fetchAccount); return
		 * "Amount::"+amount+" is withDrawn SuccesFully"; }else { return
		 * "Insufficient Balance"; } }else { return "Account Number Doesn't Existes"; }
		 * 
		 */
		
		
	}
	@Override
	public String deletedAccount(Long pid) {
           ICICIBanking banking=brepo
        		   .findById(pid)
        		   .orElseThrow(()->new RuntimeException("Account Number doen't not exists"));
		  //save the deleted Object
           brepo.deleteById(pid);
		
		return "Record deleted succesfully";
	}

}
