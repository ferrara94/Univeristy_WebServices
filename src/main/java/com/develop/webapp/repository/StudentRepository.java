package com.develop.webapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.develop.webapp.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	public Student findByName(String name);
	
	public Student findByNameAndSurname(String name, String surname);
	
	@Query("SELECT s FROM Student s WHERE s.birthDate <= ?1 ")
	public List<Student> selectStudentByBirthDate(Date birthDate);
	
}
