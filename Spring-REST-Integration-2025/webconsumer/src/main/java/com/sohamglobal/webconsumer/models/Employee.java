package com.sohamglobal.webconsumer.models;

public class Employee {
	private int empNumber;
	private String empName;
	private String department;
	private String baseLocation;
	private float salary;
	public Employee(int empNumber, String empName, String department, String baseLocation, float salary) {
		super();
		this.empNumber = empNumber;
		this.empName = empName;
		this.department = department;
		this.baseLocation = baseLocation;
		this.salary = salary;
	}
	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	

}
