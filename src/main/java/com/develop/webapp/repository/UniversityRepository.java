package com.develop.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.webapp.entities.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, String>{

}
