package com.develop.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.develop.webapp.entities.Faculty;
import com.develop.webapp.service.FacultyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping(value = "api/faculties")
public class FacultyController {
	
	@Autowired
	private FacultyService service;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Faculty>> getFaculties() {
		
		List<Faculty> faculties = service.getFaculties();
		
		if(faculties.isEmpty()) {
			return new ResponseEntity<List<Faculty>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Faculty>>(faculties,HttpStatus.OK);
	}
	
	
	@PostMapping(value = "faculty/add")
	public ResponseEntity<?> addStudent(@RequestBody Faculty faculty) {
		
		if(faculty == null) 
			return new ResponseEntity<Faculty>(HttpStatus.NO_CONTENT);
		
		Faculty facultyTemp = service.getFaculty(faculty.getName(), faculty.getCurriculum());
		if(facultyTemp != null) {
			
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode responseNode = mapper.createObjectNode();
			
			responseNode.put("code", HttpStatus.ALREADY_REPORTED.toString());
			responseNode.put("message", "faculty " + faculty.getName() + " (" + faculty.getCurriculum() + ") already existed");
		
			return new ResponseEntity<>(responseNode, HttpStatus.ALREADY_REPORTED);
			
		}
		
		faculty.setName(faculty.getName().toUpperCase());
				
		service.addFaculty(faculty);
		
		return new ResponseEntity<Faculty>(new HttpHeaders(), HttpStatus.CREATED);
		
	}
	
	/*
	 http://localhost:8080/api/faculties/faculty/delete?name=xxx&curriculum=yyy 
	*/
	@DeleteMapping(value = "faculty/delete")
	public  ResponseEntity<?> deleteStudent(@RequestParam String name, @RequestParam String curriculum) {
		
		Faculty faculty = service.getFaculty(name, curriculum);
		
		
		if(faculty == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
 			
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode responseNode = mapper.createObjectNode();
					
			service.deleteFaculty(name, curriculum);
						
			responseNode.put("code", HttpStatus.OK.toString());
			responseNode.put("message", "faculty " + faculty.getName() + " successfully removed");
		
			return new ResponseEntity<>(responseNode, HttpStatus.OK);
		}
	}
	
}
