package com.develop.webapp.service;

import java.util.List;

import com.develop.webapp.entities.University;

public interface UniversityService {

	public List<University> getUniversities();
	
	public void addUniversity(University university);
	
	public void addUniversities(List<University> universities);
	
}
