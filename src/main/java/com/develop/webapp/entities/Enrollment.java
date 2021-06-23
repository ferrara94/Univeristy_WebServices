package com.develop.webapp.entities;

import java.io.Serializable;

public class Enrollment implements Serializable{

	
	private static final long serialVersionUID = 5528580556206241597L;
	
	private String name;
	private String curriculum;
		
	public Enrollment(String name, String curriculum) {
		super();
		this.name = name;
		this.curriculum = curriculum;
	}
		
	public Enrollment() {}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	
	

}
