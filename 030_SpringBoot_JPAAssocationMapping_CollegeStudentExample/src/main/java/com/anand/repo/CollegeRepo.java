package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.College;

public interface CollegeRepo  extends JpaRepository<College,Integer>{

}
