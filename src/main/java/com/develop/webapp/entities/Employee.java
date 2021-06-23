package com.develop.webapp.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee extends Person{
	
	private static final long serialVersionUID = -3523710038463454423L;
	
	@Id
	private UUID idNumber;
	private String workingPosition;
	private int yearsService;
	private int hoursOfWork;
			
	
	public Employee(UUID id, String name, String surname, Date birthDate, int age, String workingPosition,
			int yearsService, int hoursOfWork) {
		
		super(id, name, surname, birthDate, age);
		this.idNumber = id;
		this.workingPosition = workingPosition;
		this.yearsService = yearsService;
		this.hoursOfWork = hoursOfWork;
	}
	
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
	
	

}
