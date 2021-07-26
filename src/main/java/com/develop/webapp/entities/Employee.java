package com.develop.webapp.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable{
	
	private static final long serialVersionUID = -3523710038463454423L;
	
	@Id
	@GeneratedValue
	private UUID idNumber;
	
	private String name;
	private String surname;
		
	private String workingPosition;
	private int yearsService;
	private int hoursOfWork;
			
	private String company;	
	
	public Employee(UUID idNumber, String name, String surname, String workingPosition, int yearsService,
			int hoursOfWork, String company) {
		this.idNumber = idNumber;
		this.name = name;
		this.surname = surname;
		this.workingPosition = workingPosition;
		this.yearsService = yearsService;
		this.hoursOfWork = hoursOfWork;
		this.company = company;
	}
	
	public Employee() {}
	
	public String getWorkingPosition() {
		return workingPosition;
	}
	public void setWorkingPosition(String workingPosition) {
		this.workingPosition = workingPosition;
	}
	public int getYearsService() {
		return yearsService;
	}
	public void setYearsService(int yearsService) {
		this.yearsService = yearsService;
	}
	public int getHoursOfWork() {
		return hoursOfWork;
	}
	public void setHoursOfWork(int hoursOfWork) {
		this.hoursOfWork = hoursOfWork;
	}

	public UUID getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(UUID idNumber) {
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
			
	

}
