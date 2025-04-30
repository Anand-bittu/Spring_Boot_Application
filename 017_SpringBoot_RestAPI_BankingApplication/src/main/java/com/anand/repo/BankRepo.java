package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.ICICIBanking;

public interface BankRepo extends 
   JpaRepository<ICICIBanking,Long>{

}
