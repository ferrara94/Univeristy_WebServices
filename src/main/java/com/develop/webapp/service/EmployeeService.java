package com.develop.webapp.service;

import java.util.List;

import com.develop.webapp.entities.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	public void addEmployees(List<Employee> employees);

}
