package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.PersonJPA;

public interface PersonJPARepo extends
JpaRepository<PersonJPA,Integer> {

}
