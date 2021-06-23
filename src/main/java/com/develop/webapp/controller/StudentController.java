package com.develop.webapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.develop.webapp.entities.Student;
import com.develop.webapp.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Student>> getStudents() {
		
		List<Student> students = service.getStudents();
		
		if(students.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	@GetMapping(value = "/all/onDate")
	public ResponseEntity<List<Student>> getStudentsByBirthDate() {
		
		Date now = new Date();
		List<Student> students = service.getStudentByBirthDate(now);
		
		if(students.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	@GetMapping(value = "/student/id/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable Long id){
		
		Student student = service.getStudent(id);
		
		if(student == null) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@GetMapping(value = "/student/name/{name}")
	public ResponseEntity<Student> getStudentByName(@PathVariable String name){
		
		name = name.toUpperCase();
		Student student = service.getStudentByName(name);
		
		if(student == null) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	/*
	 http://localhost:8080/api/students/student/fullname?name=xxx&surname=yyy 
	*/
	@GetMapping(value = "/student/fullname")
	public ResponseEntity<Student> getStudentByFullName(@RequestParam String name, @RequestParam String surname){
		
		name = name.toUpperCase();
		surname = surname.toUpperCase();
		
		Student student = service.getStudentByFullName(name, surname);
		
		if(student == null) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PostMapping(value = "student/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		
		student.setName(student.getName().toUpperCase());
		
		if(student.getIdNumber() == null) 
			student.setIdNumber((long)999);
		
		service.addStudent(student);
		
		return new ResponseEntity<Student>(new HttpHeaders(), HttpStatus.CREATED);
		
	}
	
	@PutMapping(value = "student/modify")
	public ResponseEntity<?> updateStudent(@RequestBody Student student ) {
		
				
		if(service.getStudent(student.getIdNumber()) == null) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		else {
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode responseNode = mapper.createObjectNode();
			
			service.addStudent(student);
						
			responseNode.put("code", HttpStatus.OK.toString());
			responseNode.put("message", "student " + student.getName() + " with ID_NUMBER " +
					student.getIdNumber() + " successfully modified");
		
			return new ResponseEntity<>(responseNode, HttpStatus.CREATED);
		}
		
	}
	
	@DeleteMapping(value = "student/delete/{id}")
	public  ResponseEntity<?> deleteStudent(@PathVariable Long id) {
		
		Student student = service.getStudent(id);
		
		
		if(student == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode responseNode = mapper.createObjectNode();
					
			service.deleteStudent(id);
						
			responseNode.put("code", HttpStatus.OK.toString());
			responseNode.put("message", "student " + student.getName() + " with ID_NUMBER " +
					student.getIdNumber() + " successfully removed");
		
			return new ResponseEntity<>(responseNode, HttpStatus.OK);
		}
	}
	

}
