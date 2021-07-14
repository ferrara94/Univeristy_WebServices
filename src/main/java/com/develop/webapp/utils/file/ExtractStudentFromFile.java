package com.develop.webapp.utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.develop.webapp.entities.Student;

public class ExtractStudentFromFile {

	private final File file;

	public ExtractStudentFromFile(File file) {
		this.file = file;
	}
	
	public Student getStudent() throws IOException, ParseException {
		
		if(!file.exists()) {
			System.err.println("file doesn't exist");
			return null;
		}
		
		Student student = new Student();
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		
		student = obtainStudent(line);
		
		br.close();
		
		return student;
	}
	
	public static Student obtainStudent(String line) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
		Student student = new Student();
		String[] s = line.split(";");
		
		student.setName(s[0].toUpperCase());
		student.setSurname(s[1].toUpperCase());
		student.setBirthDate(formatter.parse(s[2]));
		student.setAge( Integer.parseInt(s[3]));
		student.setUniversity(s[4].toUpperCase());
		student.setFaculty(s[5].toUpperCase());
		student.setYearOfRegistration(formatter.parse(s[6]));
		
		return student;
	}
	
}
