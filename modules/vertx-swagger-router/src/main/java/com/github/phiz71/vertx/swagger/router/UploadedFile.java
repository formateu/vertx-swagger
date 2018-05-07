package com.github.phiz71.vertx.swagger.router;

import java.io.File;

public class UploadedFile {

	private final File file;
	private final String formFileName;
	
	public UploadedFile(String uploadedFileName, String formFileName) {
		this.file = new File(uploadedFileName);
		this.formFileName = formFileName;
	}
	
	public File getFile() {
		return file;
	}
	
	public String getFormFileName() {
		return formFileName;
	}
	
}
