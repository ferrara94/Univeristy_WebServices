package com.develop.webapp.controller;

import java.io.IOException;
import java.util.zip.ZipEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.webapp.service.StudentService;
import com.develop.webapp.utils.file.CreateSummaryZipFile;

@RestController
@RequestMapping("/api/university")
public class SummaryController {
	
	@Autowired
	StudentService service;
	
	@GetMapping(value = "download/summary/zip")
	public ResponseEntity<String> getStudentsZip() throws IOException {
		
		CreateSummaryZipFile cszf = new CreateSummaryZipFile(service.getStudents());
		
		ZipEntry zip = cszf.createSummaryZip();

        return ResponseEntity.ok()
               .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+zip.getName() + "\"")
               .body("summary.zip created successfully");
        
    }
	
}
