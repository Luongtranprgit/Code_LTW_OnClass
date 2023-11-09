package com.example.bookory.image;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/image")
@CrossOrigin
public class ImageDataController {
	@Autowired
	private StorageService service;
	
	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file, @RequestParam("slug")String slug) throws IllegalStateException, IOException{
		String upload = service.uploadImage(file,slug);
		return ResponseEntity.status(HttpStatus.OK).body(upload);
	}
	
	@GetMapping("/{slug}")
	public ResponseEntity<?> downloadImage(@PathVariable String slug) throws IOException{
		byte[] imageData = service.downloadImage(slug);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
	}
}
