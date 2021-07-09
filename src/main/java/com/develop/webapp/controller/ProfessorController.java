package com.develop.webapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.webapp.entities.Professor;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

		
	@GetMapping(value = "/all")
	public ResponseEntity<List<Professor>> getStudents() {
		return new ResponseEntity<List<Professor>>(HttpStatus.OK);
			
	}
	
	

}
