package com.develop.webapp.test.university;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.develop.webapp.entities.University;
import com.develop.webapp.service.UniversityService;

//here we use JUnit5

@SpringBootTest
public class UniversityServiceTest {

	@Autowired
	UniversityService service;
	
	@Test
	void TestUniversityNumber() {
		
		List<University> universities = new LinkedList<>();
		University u = new University();
		u.setDescription("");
		u.setName("x");
		u.setStudents(null);
		universities.add(u);
		
		service.addUniversities(universities);
		
		int number = service.getUniversities().size();
		System.err.println(number);
		Assertions.assertTrue(number==1);
		
				
	}
	
	
}
