package com.backend.restaccountoperations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.restaccountoperations.entities.Employee;
import com.backend.restaccountoperations.repositories.EmployeeRepository;

@Service
public class EmployeeServices {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	public List<Employee> getEmps()
	{
		return empRepo.findAll();
	}

}
