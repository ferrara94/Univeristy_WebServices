package com.develop.webapp.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.develop.webapp.entities.Student;

public class CreateSummaryZipFile {
			
	List<Student> students;	
		
	public CreateSummaryZipFile(List<Student> students) {
		this.students = students;
	}

	public ZipEntry createSummaryZip() throws IOException {
						
		CreateStudentsFile csf = 
				new CreateStudentsFile(this.students);
		File students = csf.createFileText();
		
		FileInputStream fis = new FileInputStream(students);
		
		FileOutputStream fos = new FileOutputStream("summary.zip");
		ZipOutputStream zipOut = new ZipOutputStream(fos);
		
		ZipEntry zipEntry = new ZipEntry(students.getName());
        zipOut.putNextEntry(zipEntry);
        
        byte[] bytes = new byte[1024];
        int lenght;

        while( (lenght = fis.read(bytes)) >= 0 ) {
            zipOut.write(bytes, 0, lenght);
        }
        fis.close();
       
        zipOut.close();
        fos.close();
		        
		return zipEntry;
		
	}

}
