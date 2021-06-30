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

import com.develop.webapp.entities.University;
import com.develop.webapp.service.UniversityService;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {
	
	@Autowired
	UniversityService service;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<University>> getUniversities() {
		
		List<University> universities = service.getUniversities();
		
		if(universities.isEmpty()) {
			return new ResponseEntity<List<University>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<University>>(universities,HttpStatus.OK);
	}
	
	@PostMapping(value = "university/add")
	public ResponseEntity<University> addUniversity(@RequestBody University university) {
		
		if(university == null) {
			return new ResponseEntity<University>(HttpStatus.NO_CONTENT);
		}
		
		university.setName(university.getName().toUpperCase());
				
		service.addUniversity(university);
		
		return new ResponseEntity<University>(new HttpHeaders(), HttpStatus.CREATED);
		
	}
	
	@PostMapping(value = "add")
	public ResponseEntity<List<University>> addUniversity(@RequestBody List<University> universities) {
		
		if(universities == null) {
			return new ResponseEntity<List<University>>(HttpStatus.NO_CONTENT);
		}
				
		for(University uni: universities)
			uni.setName(uni.getName().toUpperCase());
						
		service.addUniversities(universities);
		
		return new ResponseEntity<List<University>>(new HttpHeaders(), HttpStatus.CREATED);
		
	}

}
