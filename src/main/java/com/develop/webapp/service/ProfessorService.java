package com.develop.webapp.service;

import java.util.List;

import com.develop.webapp.entities.Professor;

public interface ProfessorService {

	public List<Professor> getStudents();
	
	public void addStudents(List<Professor> students);
	
}
