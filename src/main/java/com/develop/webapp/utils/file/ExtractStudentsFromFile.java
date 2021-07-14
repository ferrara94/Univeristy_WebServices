package com.develop.webapp.utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import com.develop.webapp.entities.Student;

public class ExtractStudentsFromFile {
	
	private final File file;

	public ExtractStudentsFromFile(File file) {
		this.file = file;
	}
	
public List<Student> getStudents() throws IOException, ParseException {
	
		List<Student> students = new LinkedList<Student>();
	
		if(!file.exists()) {
			System.err.println("file doesn't exist");
			return null;
		}
				
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		
		while(line != null) {
			students.add(ExtractStudentFromFile.obtainStudent(line));
			line = br.readLine();
		}		
		
		br.close();
		
		return students;
	}

}
