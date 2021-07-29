package com.akhilesh.techademy.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ImageService {

	
	public void saveImage(MultipartFile image, String fileName) throws IOException {
		String fileLocation = new File("src\\main\\resources\\static\\images").getAbsolutePath() + "\\" + fileName;
		System.out.println(fileLocation);
		FileOutputStream output = new FileOutputStream(fileLocation);

		output.write(image.getBytes());

		output.close();
	}
}
