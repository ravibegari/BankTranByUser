package com.persistent.bankapp.service;

import java.util.List;
import java.util.Set;

import com.persistent.bankapp.domain.User;
import com.persistent.bankapp.security.UserRole;

public interface UserService {

	User findByUsername(String username);
	boolean checkUsernameExists(String username);
	public List<User> getAllUsers();
	public User saveUser(User user);
	public User createUser(User user,Set<UserRole> userRoles);
	
}
	