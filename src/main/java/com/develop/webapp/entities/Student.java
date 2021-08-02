package com.develop.webapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name = "STUDENT")
@AttributeOverride(name = "id", column = @Column(name = "idNumber"))
public class Student extends Person implements Serializable{
	
	private static final long serialVersionUID = -6510534152855282002L;
		
	private String university;

	private String faculty;
			
	private Date yearOfRegistration;
		
	private String codId;
	
	@ManyToMany(mappedBy = "students")
	@JsonIgnore
	private List<Course> courses = new LinkedList<>();
		    
	public Student() {}		
		
	
	public Student(String name, String surname, String university) {
		super(name, surname);
		this.university = university;
	}


	public Student(String name, String surname, Date birthDate, int age, String university, String faculty,
			Date yearOfRegistration, String codId) {
		super(name, surname, birthDate, age);
		this.university = university;
		this.faculty = faculty;
		this.yearOfRegistration = yearOfRegistration;
		this.codId = codId;
		
	}


	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public Date getYearOfRegistration() {
		return yearOfRegistration;
	}
	public void setYearOfRegistration(Date year) {
		this.yearOfRegistration = year;
	}
	
	
	public String getCodId() {
		return codId;
	}

	public void setCodId(String codId) {
		this.codId = codId;
	}
	
	


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	@Override
	public String toString() {
		return "Student [university=" + university + ", faculty=" + faculty + ", yearOfRegistration="
				+ yearOfRegistration + ", codId=" + codId + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getSurname()=" + getSurname() + ", getAge()=" + getAge() + ", getBirthDate()=" + getBirthDate()
				+ "]";
	}
	
	
	
}
