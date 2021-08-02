package com.develop.webapp.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.entities.Student;
import com.develop.webapp.repository.StudentRepository;
import com.develop.webapp.utils.file.ExtractStudentFromFile;
import com.develop.webapp.utils.file.ExtractStudentsFromFile;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public Student getStudent(Long id) {
		
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) return student.get();
		else return null;		
	}
	
	@Override
	@Transactional
	public Student getStudentByName(String name) {
		return studentRepository.findByName(name);
	}
	
	@Override
	@Transactional
	public Student getStudentByFullName(String name, String surname) {
		return studentRepository.findByNameAndSurname(name, surname);
	}
	
	@Override
	@Transactional
	public List<Student> getStudentByBirthDate(Date birthDate) {
		return studentRepository.selectStudentByBirthDate(birthDate);
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		studentRepository.save(student);		
	}

	@Override
	@Transactional
	public Long deleteStudent(Long id) {
		studentRepository.deleteById(id);;
		return id;
	}

	@Override
	@Transactional
	public void addStudents(List<Student> students) {
		studentRepository.saveAll(students);
		
	}

	public Student extractStudentFromFile(File file) throws IOException, ParseException {
		
		ExtractStudentFromFile es = new ExtractStudentFromFile(file);
		
		return es.getStudent();
		
	}

	@Override
	@Transactional
	public List<Student> extractStudentsFromFile(File file) throws IOException, ParseException {
		ExtractStudentsFromFile es = new ExtractStudentsFromFile(file);
		return es.getStudents();
	}	
	

}
