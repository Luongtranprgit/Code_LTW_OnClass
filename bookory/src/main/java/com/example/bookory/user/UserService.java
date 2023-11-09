package com.example.bookory.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRespository repo;

	public int createUser(String name, String email, String password) {
		Optional<User> user = repo.findByEmailAndUsername(email, name);

		if (user.isEmpty()) {
			User newUser = new User();
			newUser.setEmail(email);
			newUser.setUsername(name);
			newUser.setPass(password);
			newUser.setUserrole("user");
			newUser.setAvatar(1);
			repo.save(newUser);
			return 200;
		}
		return 409;
	}

	public Optional<User> getUserLogin(String email, String password) {
		Optional<User> user = repo.findByEmail(email);
		if (user.isEmpty()) {
			return null;
		}
		if (user.get().getPass().equals(password)) {
			return user;
		}
		return null;
	}

	public Optional<User> getUser(int id) {
		Optional<User> user = repo.findById(id);
		return user;
	}

	public Optional<User> updateUser(UserUpdate newUser) {
		Optional<User> find = repo.findByUsername(newUser.getName());
		if (find.isEmpty() || find.get().getId() == newUser.getId())
			return repo.findById(newUser.getId()).map(user -> {
				user.setUsername(newUser.getName());
				user.setAvatar(newUser.getAvatar());
				return repo.save(user);
			});
		return null;
	}
}
