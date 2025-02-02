package com.sohamglobal.daospringsecurity.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sohamglobal.daospringsecurity.CustomUserDetails;
import com.sohamglobal.daospringsecurity.entities.SpringUser;
import com.sohamglobal.daospringsecurity.repositories.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		SpringUser user=userRepository.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("user not found");
		
		return new CustomUserDetails(user);
	}
	
	

}
