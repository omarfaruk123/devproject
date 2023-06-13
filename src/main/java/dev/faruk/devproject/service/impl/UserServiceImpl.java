package dev.faruk.devproject.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.faruk.devproject.dto.UserCreateDto;
import dev.faruk.devproject.dto.UserDto;
import dev.faruk.devproject.dto.UserUpdateDto;
import dev.faruk.devproject.model.User;
import dev.faruk.devproject.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
@Component

public class UserServiceImpl {
	@Autowired
	 UserRepository userRepository;
	
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(UserDto::new ).collect(Collectors.toList());
	}

	public User saveUser(UserCreateDto user) {
		User newUser = new User();
		newUser.setFirstName(user.getFirstName()); 
		newUser.setLastName(user.getLastName());
		newUser.setFullName(user.getFullName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		userRepository.save(newUser);
		return newUser;
	}

	public User updateUser(Long userId, UserUpdateDto user) {
		User updateUser = userRepository.findById(userId).get();
		updateUser.setFirstName(user.getFirstName()); 
		updateUser.setLastName(user.getLastName());
		updateUser.setFullName(user.getFullName());
		updateUser.setEmail(user.getEmail());
		updateUser.setPassword(user.getPassword());
		
		userRepository.save(updateUser);
		
		return updateUser;
	}

	public User deleteUser(Long userId) {
		User deleteUser = userRepository.findById(userId).get();
		if(deleteUser !=null) {
			userRepository.deleteById(userId);
			return deleteUser;
		}
		return null;
	}

}
