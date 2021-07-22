package com.develop.webapp.test.university;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.develop.webapp.entities.University;
import com.develop.webapp.service.UniversityService;

//here we use JUnit5

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class UniversityServiceTest {

	@Autowired
	UniversityService service;
	
	@BeforeAll
	static void startTest() {
		System.err.println("starting test");
	}
	
	@Test
	@Order(1)
	@DisplayName("university test") //specify the test description and we'll see this string instead of method name
	void TestUniversityNumber() {
		
		List<University> universities = new LinkedList<>();
		University u = new University();
		u.setDescription("");
		u.setName("x");
		u.setStudents(null);
		universities.add(u);
		
		service.addUniversities(universities);
		
		int number = service.getUniversities().size();
		Assertions.assertTrue(number==1);
		
				
	}
	
	@Test
	@DisplayName("university test 2") //specify the test description and we'll see this string instead of method name
	@Disabled("Test DeleteStudentByID Null not implemented") //test will be disabled
	void TestUniversityNumberSecond() {
		
		List<University> universities = new LinkedList<>();
		University u = new University();
		u.setDescription("");
		u.setName("x");
		u.setStudents(null);
		universities.add(u);
		
		service.addUniversities(universities);
		
		int number = service.getUniversities().size();
		Assertions.assertTrue(number==1);
						
	}
	
	@AfterAll
	static void endTest() {
		System.err.println("ending test");
	}
	
	
}
