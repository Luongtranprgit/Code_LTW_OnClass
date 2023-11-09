package com.example.bookory.image;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDataResponsitory extends JpaRepository<ImageData, Integer> {
	Optional<ImageData> findBySlug(String bookslug);
}
