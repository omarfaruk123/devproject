package dev.faruk.devproject.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.faruk.devproject.dto.UserDto;
import jakarta.transaction.Transactional;

@Service
@Transactional
@Component
public interface UserService {
	
	public List<UserDto> getAllUsers();
		
	
}
