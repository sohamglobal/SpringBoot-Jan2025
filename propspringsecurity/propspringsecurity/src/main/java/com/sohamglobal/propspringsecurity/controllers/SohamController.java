package com.sohamglobal.propspringsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SohamController {
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "authenticated using application properties";
	}

}
