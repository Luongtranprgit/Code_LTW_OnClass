package com.example.bookory.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping
	private ResponseEntity<?> createUser(@RequestBody UserRequest user) {
		int status = service.createUser(user.getUsername(), user.getEmail(), user.getPass());
		if (status == 409) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already used!");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Created success");
	}

	@PostMapping("/login")
	private ResponseEntity<?> loginUser(@RequestBody UserRequest user) {
		Optional<User> data = service.getUserLogin(user.getEmail(), user.getPass());
		if (data != null) {
			return ResponseEntity.status(HttpStatus.OK).body(data);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Password or email wrong!");
	}

	@GetMapping("/{id}")
	private ResponseEntity<?> getUser(@PathVariable int id) {
		Optional<User> data = service.getUser(id);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	@PutMapping
	private ResponseEntity<?> updateUser(@RequestBody UserUpdate user) {
		Optional<User> data = service.updateUser(user);
		if (data != null)
			return ResponseEntity.status(HttpStatus.OK).body(data);
		return ResponseEntity.status(HttpStatus.OK).body(409);
	}
}
