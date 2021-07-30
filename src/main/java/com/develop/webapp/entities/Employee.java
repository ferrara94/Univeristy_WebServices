package com.develop.webapp.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Employee extends Person implements Serializable{
	
	private static final long serialVersionUID = -3523710038463454423L;
		
	private String workingPosition;
	private int yearsService;
	private int hoursOfWork;
			
	private String company;	
				
	
	
	public Employee() {
		super();
	}		

	public Employee(String name, String surname, String workingPosition, int yearsService, int hoursOfWork,
			String company) {
		super(name, surname);
		this.workingPosition = workingPosition;
		this.yearsService = yearsService;
		this.hoursOfWork = hoursOfWork;
		this.company = company;
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

	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
			
	

}
