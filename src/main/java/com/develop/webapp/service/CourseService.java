package com.develop.webapp.service;

import java.util.List;

import com.develop.webapp.entities.Course;

public interface CourseService {

	public List<Course> getCourses();
	
	public void addCourses(List<Course> courses);
}
