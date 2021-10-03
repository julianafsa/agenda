package br.com.santander.agenda.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("/file")
public class UploadController {
	
	private final String DIR = "/Users/t736457/Documents/digital_house_java/agenda/src/main/resources/static/upload/";
	
	@PostMapping
	public ResponseEntity<?> upload(@RequestBody MultipartFile file)  {
		File uploadFile = new File(DIR+file.getOriginalFilename());
		
		try {
			uploadFile.createNewFile();
			FileOutputStream fso = new FileOutputStream(uploadFile);
			fso.write(file.getBytes());
			fso.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().build();
	}
	
}
