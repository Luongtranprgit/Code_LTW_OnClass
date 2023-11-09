package com.example.bookory.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);
	Optional<User> findByUsername(String name);
	Optional<User> findByEmailAndUsername(String email,String name);
}
