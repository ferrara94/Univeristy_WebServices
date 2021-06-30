package com.develop.webapp.service;

import java.util.Date;
import java.util.List;

import com.develop.webapp.entities.Student;

public interface StudentService {
	
	public List<Student> getStudents();
	
	public Student getStudent(Long id);
	
	public Student getStudentByName(String name);
	
	public Student getStudentByFullName(String name, String surname);
	
	public List<Student> getStudentByBirthDate(Date birthDate);
	
	public void addStudent(Student student);
	
	public void addStudents(List<Student> students);
	
	public Long deleteStudent(Long id);

}
