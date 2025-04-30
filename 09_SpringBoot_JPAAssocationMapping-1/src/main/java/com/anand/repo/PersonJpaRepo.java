package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.PersonJpa;

public interface PersonJpaRepo  extends
JpaRepository<PersonJpa,Integer>{

}
