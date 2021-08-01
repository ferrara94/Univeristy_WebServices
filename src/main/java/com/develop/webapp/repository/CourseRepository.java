package com.develop.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.webapp.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{

}
