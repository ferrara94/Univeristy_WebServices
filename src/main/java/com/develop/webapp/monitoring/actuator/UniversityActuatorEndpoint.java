package com.develop.webapp.monitoring.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import com.develop.webapp.entities.University;
import com.develop.webapp.service.UniversityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Endpoint(id="universities")
@Component
public class UniversityActuatorEndpoint {
	
	@Autowired
	UniversityService service;
	
	@ReadOperation
	public Map<String, String> universityEndpoint() {
		
		Map<String, String> map = new HashMap<>();
		
		List<University> universities = service.getUniversities();
		
		for(University u: universities)
			map.put(u.getName(), u.getDescription());
		
		return map;
		
	}

}
