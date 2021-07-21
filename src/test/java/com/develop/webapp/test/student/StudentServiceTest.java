package com.develop.webapp.test.student;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.develop.webapp.entities.Student;
import com.develop.webapp.service.StudentService;

//here we use JUnit4

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
	
	@Autowired
	StudentService service;
	
	private List<Student> students;
	private boolean isInitialized = false;
		
	@Before
	public void setupDB() {
		
		if(!isInitialized) { //in order to not repeat for each test
			
			Student s = new Student("marco","rossi","salerno");		
			Student s2 = new Student("pasquale","bruno","salerno");	
			Student s3 = new Student("paolo","verdi","salerno");
			
			students = new LinkedList<>();
			students.add(s);
			students.add(s2);
			students.add(s3);
			
			service.addStudent(s);
			
			//Student s2 = service.getStudent((long) 1);
			
			isInitialized = true;
			
			System.err.println("not initialized");
		}
		
		System.err.println("just initialized ");
		
	}
		
				
	@Test
	public void TestGetStudentByID() {
		
		String test = "marco";
		
		assertThat( service.getStudent((long) 1))
					.extracting(Student::getName)
					.isEqualTo(test)
		;
		
		
		
	}
	
	@Test
	public void TestGetStudents() {
					
		service.addStudents(students);
		
		List<Student> studentsTest = service.getStudents();
				
		assertEquals(3, studentsTest.size());
		
		//here it will give us back an error -> show stack trace in console to see the error
		assertEquals("paolo", studentsTest.get(2));
		
		/*
		 	-> check if the list is empty
	 		assertThat(service.getStudents()).isEmpty();
		*/
		
		
		
	}
	
}
