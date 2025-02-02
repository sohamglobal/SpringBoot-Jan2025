package com.sohamglobal.daospringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final UserDetailsService userDetailsService;
	
	
	public SecurityConfig(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http
				.csrf(customizer->customizer.disable())
				.authorizeHttpRequests(request->
				request.requestMatchers("register").permitAll()
				.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.build();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		return provider;
	}
}
