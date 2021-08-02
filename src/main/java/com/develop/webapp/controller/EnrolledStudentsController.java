package com.develop.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.webapp.entities.Course;
import com.develop.webapp.entities.Student;
import com.develop.webapp.service.CourseServiceImpl;
import com.develop.webapp.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api/enrolled")
public class EnrolledStudentsController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseServiceImpl courseService;
	
	@PutMapping(value = "/add/relation/student/{student}/course/{course}")
	public ResponseEntity<?> updateStudent(@PathVariable long student, @PathVariable String course ) {
		
		course = course.toUpperCase();
				
		Student s = studentService.getStudent(student);
		Course c = courseService.getCourse(course);
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode responseNode = mapper.createObjectNode();
		
		if(s == null) {
			responseNode.put("code", HttpStatus.NO_CONTENT.toString());
			responseNode.put("message", "student with ID_NUMBER " +
					student + " isn't available\n You could insert him before");
		
			return new ResponseEntity<>(responseNode, HttpStatus.OK);
		}
		if(c == null) {
			responseNode.put("code", HttpStatus.NO_CONTENT.toString());
			responseNode.put("message", "course with ID_NUMBER " +
					course + " isn't available\n You could insert it before");
		
			return new ResponseEntity<>(responseNode, HttpStatus.OK);
		}
						
		s.getCourses().add(c);
		c.getStudents().add(s);
		
		studentService.addStudent(s);
		courseService.addCourse(c);
			
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "enrolled relation: " + s.getName() + " - " + c.getName() + " successfully created");
		
		return new ResponseEntity<>(responseNode, HttpStatus.CREATED);
		
		
	}
		
}
