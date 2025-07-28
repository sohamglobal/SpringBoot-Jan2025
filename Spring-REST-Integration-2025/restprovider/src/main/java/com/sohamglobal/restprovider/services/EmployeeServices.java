package com.sohamglobal.restprovider.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sohamglobal.restprovider.models.Employee;

@Service
public class EmployeeServices {
	
	public List<Employee> getEmpList()
	{
		List<Employee> list=new ArrayList<Employee>();
		Employee e1=new Employee(101, "Lewis Hamilton","Marketing","London",23500);
		Employee e2=new Employee(102, "Fernando Alonso","Finance","Paris",37000);
		Employee e3=new Employee(103, "Max Verstappen","Sales","Berlin",25900);
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		return list;
	}

}
