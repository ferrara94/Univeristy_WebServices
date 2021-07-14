package com.develop.webapp.utils.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.develop.webapp.entities.Student;
import com.google.gson.Gson;

public class CreateStudentsFile {
	
	private final List<Student> students;
	

	public CreateStudentsFile(List<Student> students) {
		this.students = students;
	}
	
	public File createFileText() throws IOException {
		
		File file = new File("students.txt");
		
		if(!file.exists())
			file.createNewFile();
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Student s: this.students)
			bw.write(createStudentLine(s));
		
		bw.close();
		
		return file;
		
	}
	
public File createFileJson() throws IOException {
		
		File file = new File("students.json");
		
		if(!file.exists())
			file.createNewFile();
				
				
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		Gson gson = new Gson();
				
		if(this.students.size() > 1) {
			
			bw.write("[ " + gson.toJson(this.students.get(0)));
			
			for (int i=1; i < this.students.size(); i++)
				bw.write("," + gson.toJson(this.students.get(i)));
				
			bw.write(" ]");
			
		} else
			bw.write(gson.toJson(this.students.get(0)));
			
							
		bw.close();
		
		return file;
		
	}
	
	private String createStudentLine(Student s) {
		
		String str = "";
		str +=  s.getName()+";"+
				s.getSurname()+";"+
				s.getBirthDate().toString()+";"+
				s.getAge()+";"+
				s.getUniversity()+";"+				
				s.getFaculty()+";"+
				s.getYearOfRegistration()+"\n";
		
		return str;
	}
	

}
