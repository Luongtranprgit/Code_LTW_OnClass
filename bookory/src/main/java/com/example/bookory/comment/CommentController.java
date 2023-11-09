package com.example.bookory.comment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CommentController {
	@Autowired
	private CommentService service;
	@GetMapping("/comments/{id}")
	public ResponseEntity<?> getComments(@PathVariable int id){
		List<CommentRes> res = service.getAll(id);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	@PostMapping("/comment/save")
	public ResponseEntity<?> addComment(@RequestBody Comment comment){
		String res = service.addComment(comment);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
}
