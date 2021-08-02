package com.develop.webapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.entities.Course;
import com.develop.webapp.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository repo;
	
	@Override
	@Transactional
	public List<Course> getCourses() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public void addCourses(List<Course> courses) {
		repo.saveAll(courses);
	}

	@Override
	@Transactional
	public void addCourse(Course course) {
		repo.save(course);
	}

	@Override
	@Transactional
	public Course getCourse(String id) {
		
		Optional<Course> course = repo.findById(id);
		if (course.isPresent()) return course.get();
		else return null;	
			
	}

	

}
