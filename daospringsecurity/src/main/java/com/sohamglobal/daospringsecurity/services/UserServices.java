package com.sohamglobal.daospringsecurity.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sohamglobal.daospringsecurity.entities.SpringUser;
import com.sohamglobal.daospringsecurity.repositories.UserRepository;

@Service
public class UserServices {
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserServices(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public SpringUser addNewUser(SpringUser user)
	{
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	

}
