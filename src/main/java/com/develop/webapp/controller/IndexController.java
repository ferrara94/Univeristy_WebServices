package com.develop.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class IndexController {
	
	@GetMapping
	public String index() {
		return "index_value";
	}
	
	@GetMapping(value = "index")
	public String indexPath() {
		return "index_value_Path";
	}
	
	
}
