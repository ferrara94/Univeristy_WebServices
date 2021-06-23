package com.develop.webapp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Enrollment.class)
public class Faculty implements Serializable{

	private static final long serialVersionUID = 4730522190457907955L;
	
	@Id
	private String name;
	@Id
	private String curriculum;
	
	private String description;
	private int yearsOfStudy;
			
	public Faculty(String name, String description, String curriculum, int yearsOfStudy) {
		super();
		this.name = name;
		this.description = description;
		this.curriculum = curriculum;
		this.yearsOfStudy = yearsOfStudy;
	}
	
	public Faculty() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	public int getYearsOfStudy() {
		return yearsOfStudy;
	}
	public void setYearsOfStudy(int yearsOfStudy) {
		this.yearsOfStudy = yearsOfStudy;
	}
		
	
	
}
