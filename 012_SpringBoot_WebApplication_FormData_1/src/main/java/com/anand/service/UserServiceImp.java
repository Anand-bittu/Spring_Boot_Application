package com.anand.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.entity.User;
import com.anand.repo.UserRepo;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userrepo;
	
	
	@Override
	public boolean addUser(User user) {
		System.out.println("inside  add Service method");
        User saveduser=userrepo.save(user);
		if(saveduser.getUid()!=0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<User> retrive() {
       //retrive data from the table
	    List<User> result=	userrepo.findAll();
		return result;
	}

	@Override
	public boolean deleteRecord(int uid) {
            System.out.println("inside delete Record");
            if(userrepo.existsById(uid)) {
            	userrepo.deleteById(uid);
            	return true;
            }
		return false;
	}

	@Override
	public User editUser(int uid) {
       Optional<User> userSaved=userrepo.findById(uid);
       if(userSaved.isPresent()) {
    	   return userSaved.get();
       }
		return null;
	}


	
}
