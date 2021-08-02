package com.develop.webapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.entities.Employee;
import com.develop.webapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public void addEmployees(List<Employee> employees) {
		employeeRepository.saveAll(employees);
	}

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		
		employeeRepository.save(employee);
		
		//studentService.addStudent(null);		
		/*
		 	
		 	this method generates an error; without @Transactional
		 	
		 	it will execute the save method causing the writing on the
		 	database and then it will generate an internal error which will 
		 	block the execution.
		 	
		 	with @Transactional the eriting on the database won't be executed
		 	since it will be executed the RollBack
		 
		*/
	}

}
