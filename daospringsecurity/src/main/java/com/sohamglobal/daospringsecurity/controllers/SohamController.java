package com.sohamglobal.daospringsecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sohamglobal.daospringsecurity.entities.SpringUser;
import com.sohamglobal.daospringsecurity.services.UserServices;

@RestController
public class SohamController {
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to DAO based authentication";
	}
	
	@PostMapping("/register")
	public SpringUser register(@RequestBody SpringUser user)
	{
		return userServices.addNewUser(user);
	}

}
