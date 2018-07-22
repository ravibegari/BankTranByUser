package com.persistent.bankapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.persistent.bankapp.domain.User;


public interface UserDao extends CrudRepository<User, Long> {
	
	List<User> findAll();
	
	// User save(User user);
	 User findByUsername(String username);
	
	
	
}
