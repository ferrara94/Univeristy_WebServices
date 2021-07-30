package com.develop.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.webapp.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
