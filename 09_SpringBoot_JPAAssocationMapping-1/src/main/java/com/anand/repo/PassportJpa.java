package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.Passport;

public interface PassportJpa  extends 
JpaRepository<Passport, Integer>{

}
