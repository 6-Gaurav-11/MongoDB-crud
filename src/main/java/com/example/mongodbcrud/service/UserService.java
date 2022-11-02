package com.example.mongodbcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodbcrud.model.User;
import com.example.mongodbcrud.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User updateUser(Long id, User user) {
		Optional<User> findById = userRepository.findById(id);
		if (findById.isPresent()) {
			User userEntity = findById.get();
			if (user.getName() != null && !user.getName().isEmpty())
				userEntity.setName(user.getName());
			if (user.getAge() != null)
				userEntity.setAge(user.getAge());
			return userRepository.save(userEntity);
		}
		return null;
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}