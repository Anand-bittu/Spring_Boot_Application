package com.anand.service;

import java.util.List;

import com.anand.entity.User;

public interface UserService {

	
	
	public boolean addUser(User user);
	
	public List<User> retrive();
	
	public boolean deleteRecord(int uid);
	
	public User editUser(int uid);
	
//	public User updatUser(int uid);

}
