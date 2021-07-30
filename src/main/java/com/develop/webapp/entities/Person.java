package com.develop.webapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person implements Serializable{
	
	private static final long serialVersionUID = -1532951710012009701L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String surname;
	private Date birthDate;
	private int age;
	
	
		
	public Person(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public Person(String name, String surname, Date birthDate, int age) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.age = age;
	}
	
	public Person() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}

