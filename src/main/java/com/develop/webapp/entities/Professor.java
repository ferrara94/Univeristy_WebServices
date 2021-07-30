package com.develop.webapp.entities;

import javax.persistence.Entity;

@Entity
public class Professor extends Person{

	private static final long serialVersionUID = 3035097401880148591L;
	
	private String university;
	private String faculty;
	private String position;
	private int yearsService;
	private String degree;	
	
	
	public Professor(String name, String surname, String university, String position, String faculty, int yearsService, String degree) {
		super(name, surname);
		this.position = position;
		this.university = university;
		this.faculty = faculty;
		this.yearsService = yearsService;
		this.degree = degree;
	}
	
	public Professor() {}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
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

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}
	
	
	
	
}
