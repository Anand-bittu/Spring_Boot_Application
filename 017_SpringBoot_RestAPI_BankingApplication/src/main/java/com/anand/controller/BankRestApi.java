package com.anand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anand.entity.ICICIBanking;
import com.anand.service.BankService;

@RestController
public class BankRestApi {
    
	@Autowired
	private BankService service;
	
	
	@PostMapping(value = "/account",
			consumes = "application/json"
			,produces = "application/json")
	public ResponseEntity<ICICIBanking> addAccount(@RequestBody ICICIBanking banking) {
		//save in the DataBase
	    ICICIBanking bresult=service.addAccount(banking);
	    return new ResponseEntity<ICICIBanking>(bresult,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/account"
			,consumes = "application/json"
			,produces = "text/string")
	public ResponseEntity<String> depositeAmmount(@RequestBody
			ICICIBanking banking){
		String result=service.depositeAmmount(banking.getPid(),banking.getBalance());
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@GetMapping(value = "/account/{pid}",
			produces = "application/json")
	public ResponseEntity<ICICIBanking> getAccountDetailes
	(@PathVariable("pid") Long pid){
		ICICIBanking accountDetailes=service.getAccountDetailes(pid);
		return new ResponseEntity<ICICIBanking>(accountDetailes,HttpStatus.OK);
	}
	
	@PutMapping(value = "/account/remove"
			,consumes = "application/json"
			,produces = "text/string")
	public ResponseEntity<String> withDrawAmount(@RequestBody ICICIBanking banking)
	{
		System.out.println("inside WithDrawAmount");
	   String msg=service.withDrawAmount(banking.getPid(),banking.getBalance());
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/account/{pid}"
			,produces = "text/string")
	public ResponseEntity<String> deletedRecord(@PathVariable ("pid") Long pid){
		 String msg=service.deletedAccount(pid);
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	
}
