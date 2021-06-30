package com.develop.webapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "STUDENT")
public class Student implements Serializable{
	
	private static final long serialVersionUID = -6510534152855282002L;
		
	@Id
	@GeneratedValue
	@Column(name="STUDENT_ID")
	private Long idNumber;
	
	private String name;
	private String surname;
	private Date birthDate;
	private int age;
	
	private String university;

	private String faculty;
	
	private Date yearOfRegistration;
	
    
	public Student() {}
	
	public Student(String name, String surname, String university) {
		this.name = name;
		this.surname = surname;
		this.university = university;
	}
			
	public Student(Long id, String name, String surname, Date birthDate, int age, String university, String faculty,
			Date yearOfRegistration) {
		
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.age = age;
		this.idNumber = id;
		this.university = university;
		this.faculty = faculty;
		this.yearOfRegistration = yearOfRegistration;
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

	public Long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [idNumber=" + idNumber + ", name=" + name + ", surname=" + surname + ", birthDate=" + birthDate
				+ ", age=" + age + ", university=" + university + ", faculty=" + faculty + ", yearOfRegistration="
				+ yearOfRegistration + "]";
	}
	
	
	
		
	
}
