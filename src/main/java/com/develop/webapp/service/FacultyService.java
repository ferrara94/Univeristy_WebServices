package com.develop.webapp.service;

import java.util.List;

import com.develop.webapp.entities.Faculty;

public interface FacultyService {
	
	public Faculty getFaculty(String name);
	
	public Faculty getFaculty(String name, String curriculum);
	
	public List<Faculty> getFaculties();
	
	public void addFaculty(Faculty faculty);
	
	public String deleteFaculty(String name, String curriculum);

}
