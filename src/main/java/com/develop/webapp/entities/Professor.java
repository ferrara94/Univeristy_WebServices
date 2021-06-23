package com.develop.webapp.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professor extends Person{

	private static final long serialVersionUID = 3035097401880148591L;

	@Id
	private UUID idNumber;
	private String position;
	private Faculty faculty;
	private int yearsService;
	private String degree;
	
	public Professor(UUID id, String name, String surname, Date birthDate, int age, String position, Faculty faculty,
			int yearsService, String degree) {
		
		super(id, name, surname, birthDate, age);
		this.idNumber = id;
		this.position = position;
		this.faculty = faculty;
		this.yearsService = yearsService;
		this.degree = degree;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public int getYearsService() {
		return yearsService;
	}

	public void setYearsService(int yearsService) {
		this.yearsService = yearsService;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	
	
	
}
