package com.develop.webapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


public  class Person implements Serializable{
	
	private static final long serialVersionUID = -1532951710012009701L;
	
	private UUID id;
	private String name;
	private String surname;
	private Date birthDate;
	private int age;
		
	public Person(UUID id, String name, String surname, Date birthDate, int age) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.age = age;
	}
	
	//public Person() {}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
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

