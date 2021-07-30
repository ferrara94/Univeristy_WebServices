package com.develop.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(FacultyController.class);
	
	@Autowired
	private FacultyService service;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Faculty>> getFaculties() {
		
		
		
		List<Faculty> faculties = service.getFaculties();
		
		if(faculties.isEmpty()) {
			
			logger.warn("There is no faculties at the moment");
			
			return new ResponseEntity<List<Faculty>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Faculty>>(faculties,HttpStatus.OK);
	}
	
	
	@PostMapping(value = "faculty/add")
	public ResponseEntity<?> addStudent(@RequestBody Faculty faculty) {
		
		if(faculty == null) { 
			
			logger.warn("The faculty object provided is empty|null");
			
			return new ResponseEntity<Faculty>(HttpStatus.NO_CONTENT);
		}
		
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
	
	@PostMapping(value = "faculties/add")
	public ResponseEntity<List<Faculty>> addUniversity(@RequestBody List<Faculty> faculties) {
		
		if(faculties == null) {
			return new ResponseEntity<List<Faculty>>(HttpStatus.NO_CONTENT);
		}
				
		for(Faculty f: faculties) {
			f.setName(f.getName().toUpperCase());
		}
								
		service.addFaculties(faculties);
		
		return new ResponseEntity<List<Faculty>>(new HttpHeaders(), HttpStatus.CREATED);
		
	}
	
	/*
	 http://localhost:8080/api/faculties/faculty/delete?name=xxx&curriculum=yyy 
	*/
	@DeleteMapping(value = "faculty/delete")
	public  ResponseEntity<?> deleteStudent(@RequestParam String name, @RequestParam String curriculum) {
		
		Faculty faculty = service.getFaculty(name, curriculum);
		
		
		if(faculty == null) {
			
			logger.warn("There is no faculty with info specified");
			
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
