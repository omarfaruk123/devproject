package dev.faruk.devproject.dto;

import dev.faruk.devproject.model.User;

public class UserResponseDto {

	private User user;
	private boolean success;
	private String message;
	
	public UserResponseDto(boolean success, String message,User user) {
		super();
		this.success = success;
		this.message = message;
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
