package com.persistent.bankapp.service;

import java.util.List;

import com.persistent.bankapp.domain.User;

public interface UserService {

	User findByUsername(String username);
	boolean checkUsernameExists(String username);
	public List<User> getAllUsers();
	public User saveUser(User user);
	public User createUser(User user);
	
}
	