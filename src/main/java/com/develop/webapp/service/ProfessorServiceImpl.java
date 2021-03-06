package com.develop.webapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.entities.Professor;
import com.develop.webapp.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	ProfessorRepository repo;

	@Override
	@Transactional
	public List<Professor> getStudents() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public void addStudents(List<Professor> professors) {
		repo.saveAll(professors);
	}

}
