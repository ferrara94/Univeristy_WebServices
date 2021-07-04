package com.develop.webapp.scheduler;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.develop.webapp.entities.Student;
import com.develop.webapp.service.StudentService;

@Component
public class StudentScheduler {
	
	@Autowired
	StudentService	service;
	
	@Scheduled(fixedRate = 11000) //interval of 11 seconds
	public void scheduleStudentsWithFixedRate() {
		
		System.err.println("\nStudent\n\t");
		Consumer<Student> consumer = s -> System.err.println(s.toString());
		service.getStudents().stream().forEach(consumer);		
		
	}
	
	/*
	   @Scheduled(fixedDelay = 5000) public void scheduleStudentsWithFixedDelay() {}
	 
	   @Scheduled(fixedRate = 2000, initialDelay = 4000) //at first with 4s delay
	   public void scheduleStudentsWithInitialDelay() {}
	   
	   @Scheduled(cron = "0 * * * * ?") 
	   public void scheduleStudentsWithCron() {}
	 
	 */
	
}
