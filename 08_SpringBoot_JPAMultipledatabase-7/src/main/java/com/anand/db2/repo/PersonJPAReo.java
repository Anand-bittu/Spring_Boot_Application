package com.anand.db2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.db2.entity.PersonJpa;

public interface PersonJPAReo extends 
JpaRepository<PersonJpa, Integer>{

}
