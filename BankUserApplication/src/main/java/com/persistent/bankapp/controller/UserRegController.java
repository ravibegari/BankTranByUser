package com.persistent.bankapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.persistent.bankapp.domain.User;
import com.persistent.bankapp.service.UserService;


@RestController
@RequestMapping("/signup")
public class UserRegController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/signUpUser",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.OK)
	public String signUpUser(@RequestBody User user) {

		String sStatus = null;
		if(userService.checkUsernameExists(user.getUsername())) {

			sStatus="The user is already exist";
		}else {
			userService.createUser(user);
			sStatus="The User is Created Successfully";

		}
		return sStatus ;

	}

}
