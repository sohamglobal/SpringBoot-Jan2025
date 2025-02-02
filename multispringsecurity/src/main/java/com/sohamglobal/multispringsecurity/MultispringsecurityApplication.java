package com.sohamglobal.multispringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultispringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultispringsecurityApplication.class, args);
		System.out.println("multiple users authenticated...");
	}

}
