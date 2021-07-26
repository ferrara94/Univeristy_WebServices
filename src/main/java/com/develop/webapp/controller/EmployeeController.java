package com.develop.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.webapp.entities.Employee;
import com.develop.webapp.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Employee>> getEmployees() {
		
		List<Employee> employees = service.getEmployees();
		
		if(employees.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}

	@PostMapping(value = "add")
	public ResponseEntity<List<Employee>> addEmployees(@RequestBody List<Employee> employees) {
		
		if(employees == null) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
				
		for(Employee s: employees)
			s.setName(s.getName().toUpperCase());
						
		service.addEmployees(employees);
		
		return new ResponseEntity<List<Employee>>(new HttpHeaders(), HttpStatus.CREATED);
		
	}
	
}
