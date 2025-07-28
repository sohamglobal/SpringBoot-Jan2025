package com.sohamglobal.restprovider.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sohamglobal.restprovider.models.Employee;
import com.sohamglobal.restprovider.services.EmployeeServices;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServices empServices;
	
	@GetMapping("/allemp")
	public List<Employee> getEmploees()
	{
		return empServices.getEmpList();
	}

}
