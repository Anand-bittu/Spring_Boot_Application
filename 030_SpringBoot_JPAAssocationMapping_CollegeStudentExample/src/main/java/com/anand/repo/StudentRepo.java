package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.anand.entity.Student;

public interface StudentRepo  extends JpaRepository<Student,Integer>{

}
