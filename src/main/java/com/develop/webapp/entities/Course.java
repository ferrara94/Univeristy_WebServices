package com.develop.webapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "COURSE")
public class Course implements Serializable {

	private static final long serialVersionUID = -1678229687133151477L;
	
	@Id
	@Column(name = "id_course")
	private String name;
	
	private int hours;
		
	private Long prof;
	
	@ManyToMany
	@JoinTable(
				name="students_enrolled",
				joinColumns = @JoinColumn(name = "id_course"),
				inverseJoinColumns = @JoinColumn(name = "id_student")
			)
	Set<Student> students = new HashSet<>();

	public Course(String name, int hours) {
		this.name = name;
		this.hours = hours;
	}
	
	public Course(String name, int hours, Long prof) {
		super();
		this.name = name;
		this.hours = hours;
		this.prof = prof;
	}
	
	
	
	public Course() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Long getProf() {
		return prof;
	}

	public void setProf(Long prof) {
		this.prof = prof;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}	
	

}
