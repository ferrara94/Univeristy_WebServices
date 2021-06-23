package com.develop.webapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.develop.webapp.entities.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String>{
	
	public Faculty findByName(String name);
	
	public Faculty findByNameAndCurriculum(String name, String curriculum);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Faculty f WHERE f.name = ?1 AND f.curriculum = ?2")
	public void deleteByKey(String name, String curriculum);
	
}
