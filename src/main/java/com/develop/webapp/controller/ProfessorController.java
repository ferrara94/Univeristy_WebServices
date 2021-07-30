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

import com.develop.webapp.entities.Professor;
import com.develop.webapp.service.ProfessorService;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {
	
	@Autowired
	ProfessorService service;

		
	@GetMapping(value = "/all")
	public ResponseEntity<List<Professor>> getStudents() {
		
		List<Professor> professors = service.getStudents();
		
		if(professors.isEmpty()) {
			return new ResponseEntity<List<Professor>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Professor>>(professors,HttpStatus.OK);
			
	}
	
	@PostMapping(value = "add")
	public ResponseEntity<List<Professor>> addUniversity(@RequestBody List<Professor> professors) {
		
		if(professors == null) {
			return new ResponseEntity<List<Professor>>(HttpStatus.NO_CONTENT);
		}
				
		for(Professor s: professors) {
			s.setName(s.getName().toUpperCase());
			//s.setCodId(s.getUniversity() + "-" + s.getFaculty());
		}
								
		service.addStudents(professors);
		
		return new ResponseEntity<List<Professor>>(new HttpHeaders(), HttpStatus.CREATED);
		
	}
	

}
