package com.anand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anand.entity.CustomerJPA;
import com.anand.entity.PersonJPA;
import com.anand.repo.CustJPARepo;
import com.anand.repo.PersonJPARepo;

@Service
public class TXService {
    @Autowired
	private PersonJPARepo prepo;
    @Autowired
	private CustJPARepo custrepo;
    
   @Transactional(rollbackFor = Exception.class)
	public void savePersonData() {
		PersonJPA pjpa=new PersonJPA("Mani","B@gamil.com");
		
		prepo.save(pjpa);
		
		int a=10/0;
		
		CustomerJPA cjpa=new CustomerJPA("B","T");
		custrepo.save(cjpa);	
	}
	
}
