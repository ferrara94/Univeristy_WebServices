package com.develop.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class IndexController {
	
	Logger logger = LoggerFactory.getLogger(FacultyController.class);
	
	@GetMapping
	public String index() {
		
		/*
		 	example of logging use
		*/
		
		logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
		
		return "index_value";
	}
	
	@GetMapping(value = "index")
	public String indexPath() {
		return "index_value_Path";
	}
	
	
}
