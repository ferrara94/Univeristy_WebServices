package com.develop.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.entities.Course;
import com.develop.webapp.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository repo;
	
	@Override
	public List<Course> getCourses() {
		return repo.findAll();
	}

	@Override
	public void addCourses(List<Course> courses) {
		repo.saveAll(courses);
	}

}
