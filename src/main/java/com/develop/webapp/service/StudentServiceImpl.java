package com.develop.webapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.entities.Student;
import com.develop.webapp.repository.StudentRepository;

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

	
	
	

}
