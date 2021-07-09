package com.develop.webapp.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.entities.Student;
import com.develop.webapp.repository.StudentRepository;
import com.develop.webapp.utils.ExtractStudentFromFile;
import com.develop.webapp.utils.ExtractStudentsFromFile;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(Long id) {
		
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) return student.get();
		else return null;		
	}
	
	@Override
	public Student getStudentByName(String name) {
		return studentRepository.findByName(name);
	}
	
	@Override
	public Student getStudentByFullName(String name, String surname) {
		return studentRepository.findByNameAndSurname(name, surname);
	}
	
	@Override
	public List<Student> getStudentByBirthDate(Date birthDate) {
		return studentRepository.selectStudentByBirthDate(birthDate);
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);		
	}

	@Override
	public Long deleteStudent(Long id) {
		studentRepository.deleteById(id);;
		return id;
	}

	@Override
	public void addStudents(List<Student> students) {
		studentRepository.saveAll(students);
		
	}

	public Student extractStudentFromFile(File file) throws IOException, ParseException {
		
		ExtractStudentFromFile es = new ExtractStudentFromFile(file);
		
		return es.getStudent();
		
	}

	@Override
	public List<Student> extractStudentsFromFile(File file) throws IOException, ParseException {
		ExtractStudentsFromFile es = new ExtractStudentsFromFile(file);
		return es.getStudents();
	}	
	

}
