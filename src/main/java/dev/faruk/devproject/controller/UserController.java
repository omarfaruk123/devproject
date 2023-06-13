package dev.faruk.devproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.faruk.devproject.dto.UserCreateDto;
import dev.faruk.devproject.dto.UserDeleteResponseDto;
import dev.faruk.devproject.dto.UserDto;
import dev.faruk.devproject.dto.UserResponseDto;
import dev.faruk.devproject.dto.UserUpdateDto;
import dev.faruk.devproject.dto.UserUpdateResponseDto;
import dev.faruk.devproject.model.User;
import dev.faruk.devproject.service.UserService;
import dev.faruk.devproject.service.impl.UserServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")

public class UserController {
	
	
	private final  UserServiceImpl userService;
	
	@Autowired
	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@GetMapping(value="/users")
	public ResponseEntity<?> getAllUsers(){
		List<UserDto> users = userService.getAllUsers();
		return  ResponseEntity.ok().body(users);
	}
	
	@PostMapping(value="/user")
	public ResponseEntity<?> saveUser(@RequestBody UserCreateDto user){
		UserResponseDto userResponseDto;
		try {
			User newuser = userService.saveUser(user);
			if (newuser != null) {
				userResponseDto = new UserResponseDto(true, "User Created Successfully",newuser);
				return ResponseEntity.ok().body(userResponseDto);
			}
			userResponseDto = new UserResponseDto( false, "Failed to create User",null);

			return ResponseEntity.badRequest().body(userResponseDto);
		}catch(Exception e) {
			userResponseDto = new UserResponseDto(false, "Failed to create User",null);

			return ResponseEntity.badRequest().body(userResponseDto);
		}
	}

	@PutMapping("/user/{userId}")
	@JsonIgnore
	public ResponseEntity<?> updateUser(@RequestBody UserUpdateDto user, @PathVariable("userId") Long userId)
	{
		UserUpdateResponseDto userUpdateResponseDto;
		try {
			User updateuser = userService.updateUser(userId ,user);
			if (updateuser != null) {
				userUpdateResponseDto = new UserUpdateResponseDto( true, "User Updated Successfully",updateuser);
				return ResponseEntity.ok().body(userUpdateResponseDto);
			}
			userUpdateResponseDto = new UserUpdateResponseDto(false, "Failed to update User",null);

			return ResponseEntity.badRequest().body(userUpdateResponseDto);
		}catch(Exception e) {
			userUpdateResponseDto = new UserUpdateResponseDto(false, "Failed to update User",null);

			return ResponseEntity.badRequest().body(userUpdateResponseDto);
		}
	}
	
	@DeleteMapping(value="/userdelete/{userId}")
	@JsonIgnore
	public ResponseEntity<?> userDelete(@PathVariable("userId") Long userId)
	{
		UserDeleteResponseDto  userResponseDeleteDto;
		try {
			User deleteUser = userService.deleteUser(userId);
			if (deleteUser != null) {
				userResponseDeleteDto = new UserDeleteResponseDto( true, "User Deleted Successfully");
				return ResponseEntity.ok().body(userResponseDeleteDto);
			}
			userResponseDeleteDto = new UserDeleteResponseDto(false, "User Not Found");

			return ResponseEntity.badRequest().body(userResponseDeleteDto);
		}catch(Exception e) {
			userResponseDeleteDto = new UserDeleteResponseDto(false, "Failed to Deleted User");

			return ResponseEntity.badRequest().body(userResponseDeleteDto);
		}
	}
}
	

