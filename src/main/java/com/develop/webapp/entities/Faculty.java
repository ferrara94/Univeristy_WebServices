package com.develop.webapp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
//@IdClass(Enrollment.class)
public class Faculty implements Serializable{

	private static final long serialVersionUID = 4730522190457907955L;
	
	@Id
	@Column(name = "codId")
	private String codId; 
	
	@Column(name = "FACULTY_NAME")
	private String name;
	
	@Column(name = "CURRICULUM")
	private String curriculum;
	
	private String description;
	private int yearsOfStudy;
		
	
	@OneToMany(mappedBy = "codId")
	private List<Student> students;
				
	public Faculty(String codId, String name, String description, String curriculum, int yearsOfStudy) {
		this.codId = codId;
		this.name = name;
		this.description = description;
		this.curriculum = curriculum;
		this.yearsOfStudy = yearsOfStudy;
	}
	
	
	public Faculty() {}
	
	
	
	public String getCodId() {
		return codId;
	}


	public void setCodId(String codId) {
		this.codId = codId;
	}


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


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


}
