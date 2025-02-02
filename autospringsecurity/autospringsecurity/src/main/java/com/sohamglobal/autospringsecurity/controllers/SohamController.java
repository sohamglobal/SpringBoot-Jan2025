package com.sohamglobal.autospringsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SohamController {
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to sohams spring security";
	}

}
