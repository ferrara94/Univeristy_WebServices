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

import com.develop.webapp.entities.Course;
import com.develop.webapp.service.CourseServiceImpl;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	@Autowired
	CourseServiceImpl service;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Course>> getCourses() {
		
		List<Course> courses = service.getCourses();
		
		if(courses.isEmpty()) {
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
	}
	
	@PostMapping(value = "add")
	public ResponseEntity<List<Course>> addCourses(@RequestBody List<Course> courses) {
		
		if(courses == null) {
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
				
		for(Course c: courses)
			c.setName(c.getName().toUpperCase());
						
		service.addCourses(courses);
		
		return new ResponseEntity<List<Course>>(new HttpHeaders(), HttpStatus.CREATED);
		
	}

}
