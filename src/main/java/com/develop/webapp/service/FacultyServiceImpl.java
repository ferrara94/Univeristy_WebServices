package com.develop.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.entities.Faculty;
import com.develop.webapp.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService{
	
	@Autowired
	private FacultyRepository facultyRepository;

	@Override
	public List<Faculty> getFaculties() {
		return facultyRepository.findAll();
	}

	@Override
	public void addFaculty(Faculty faculty) {
		facultyRepository.save(faculty);
	}

	@Override
	public Faculty getFaculty(String name) {
		return facultyRepository.findByName(name);
	}
	
	@Override
	public Faculty getFaculty(String name, String curriculum) {
		return facultyRepository.findByNameAndCurriculum(name, curriculum);
	}

	@Override
	public String deleteFaculty(String name, String curriculum) {
		 facultyRepository.deleteByKey(name, curriculum);	
		 return name;
	}

}
