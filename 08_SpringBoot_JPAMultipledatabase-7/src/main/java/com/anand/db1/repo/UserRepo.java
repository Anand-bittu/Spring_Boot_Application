package com.anand.db1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.db1.entity.UserEntiy;
public interface UserRepo extends
        JpaRepository<UserEntiy,Integer>{

}
