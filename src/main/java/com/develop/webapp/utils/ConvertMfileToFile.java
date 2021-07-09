package com.develop.webapp.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public class ConvertMfileToFile {
	
	private final MultipartFile mfile;

	public ConvertMfileToFile(MultipartFile mfile) {
		this.mfile = mfile;
	}
	
	public File getFile() throws IOException {
		File f = new File("student");
		
		OutputStream os = new FileOutputStream(f);
		os.write(this.mfile.getBytes());
		os.close();
		
		return f;
		
	}

}
