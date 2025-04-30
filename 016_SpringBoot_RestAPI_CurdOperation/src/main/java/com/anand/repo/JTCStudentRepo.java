package com.anand.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.binding.JTCStudent;

public interface JTCStudentRepo extends 
JpaRepository<JTCStudent,Serializable> {

}
