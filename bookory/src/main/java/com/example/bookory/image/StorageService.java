package com.example.bookory.image;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
	@Autowired
	private ImageDataResponsitory repo;

	private final String FOLDER_PATH = "D:/imageWeb/ImageStore/";

	public String uploadImage(MultipartFile file, String slug) throws IllegalStateException, IOException {
		String filePath = FOLDER_PATH + file.getOriginalFilename();
		ImageData data = repo.findBySlug(slug).map(img -> {
			img.setFname(file.getOriginalFilename());
			img.setFtype(file.getContentType());
			img.setFilepath(filePath);
			return repo.save(img);
		}).orElseGet(() -> {
			ImageData newImg = new ImageData();
			newImg.setFname(file.getOriginalFilename());
			newImg.setFtype(file.getContentType());
			newImg.setFilepath(filePath);
			newImg.setSlug(slug);
			return repo.save(newImg);
		});

		file.transferTo(new File(filePath));
		if (data != null) {
			return "Tải lên thành công: " + filePath;
		}
		return null;
	}

	public byte[] downloadImage(String slug) throws IOException {
		Optional<ImageData> imgData = repo.findBySlug(slug);
		String imgPath = imgData.get().getFilepath();
		byte[] images = Files.readAllBytes(new File(imgPath).toPath());
		return images;
	}
}
