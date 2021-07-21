package com.develop.webapp.test.student;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.develop.webapp.entities.Student;
import com.develop.webapp.service.StudentService;


/*
	by default the tests execution doesn't follow an order and to
	do that, we use @FixMethodOrder() annotation
	if you need to execute test in order, and to be sure, 
	let's put as a suffix letters A, B, C etc...
*/

@RunWith(SpringRunner.class)
//@ContextConfiguration()
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentControllerTest {

	private MockMvc mockMvc;
	
	private List<Student> students;
	private boolean isInitialized = false;
	
	@Autowired
	StudentService service;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup() {
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
				
		if(!isInitialized) { //in order to not repeat for each test
			
		}
		
				
	}
	
	@Test
	public void A_TestGetStudents() throws Exception {
		
		String uri = "/api/students/all";
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(
						content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) //tipo restituito 
				.andDo(print())
				//.andExpect(jsonPath("$", hasSize(1)))
				
		
		;
	}
	
	@Test
	public void B_TestGetStudents() throws Exception {
		
		String url = "/api/students/all";
		
		Student s = new Student("marco","rossi","salerno");		
		Student s2 = new Student("pasquale","bruno","salerno");	
		Student s3 = new Student("paolo","verdi","salerno");
		
		students = new LinkedList<>();
		students.add(s);
		students.add(s2);
		students.add(s3);
		
		service.addStudent(s);
		
		mockMvc.perform(MockMvcRequestBuilders.get(url)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(
						content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) //tipo restituito 
				.andDo(print())
				//.andExpect(jsonPath("$", hasSize(1)))
			
		
		;
	}
	
	@Test
	public void C_TestAddStudent() throws Exception {
		
		String url = "/api/students/student/add";

		mockMvc.perform(MockMvcRequestBuilders.post(url)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonData)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andDo(print())
			;
				
	}
	
	@Test
	public void D_TestGetStudentByID() throws Exception {
		
		String url = "/api/students/student/id/" + "2" ;

		mockMvc.perform(MockMvcRequestBuilders.get(url)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonData)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				
				.andExpect(jsonPath("$.idNumber").exists()) //check if the first key is present
				
				.andDo(print())
			;
		
	}
	
		 
	String jsonData = "{\n"
			+ "    \"name\": \"ALBERTO\",\n"
			+ "    \"surname\": \"POLLA\",\n"
			+ "    \"birthDate\": \"1995-07-08T22:00:00.000+00:00\",\n"
			+ "    \"age\": 26,\n"
			+ "    \"university\": \"SALERNO\",\n"
			+ "    \"faculty\": \"MECHANIC ENGINEERING\",\n"
			+ "    \"yearOfRegistration\": \"2013-09-11T22:00:00.000+00:00\"\n"
			+ "}";
	
}
