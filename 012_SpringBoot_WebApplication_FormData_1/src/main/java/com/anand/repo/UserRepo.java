package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.User;

public interface UserRepo extends
          JpaRepository<User,Integer>{

}
