package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.binding.PersonDetailes;

public interface PersonRepo extends
 JpaRepository<PersonDetailes,Integer>{

}
