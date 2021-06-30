package com.develop.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.entities.University;
import com.develop.webapp.repository.UniversityRepository;

@Service
public class UniversityServiceImpl implements UniversityService{

	@Autowired
	UniversityRepository uniRepo;
	
	@Override
	public List<University> getUniversities() {
		return uniRepo.findAll();
	}

	@Override
	public void addUniversity(University university) {
		uniRepo.save(university);
	}

	@Override
	public void addUniversities(List<University> universities) {
		uniRepo.saveAll(universities);
		
	}
	
	

}
