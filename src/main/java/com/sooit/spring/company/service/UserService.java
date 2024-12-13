package com.sooit.spring.company.service;

import java.util.List;

import com.sooit.spring.company.dto.UserDto;

public interface UserService {
	List<UserDto> getAllUsers();
	UserDto getUserByEmail(String email);
	void addUser(UserDto user);
	boolean checkPasswordMatch(UserDto user);
}
	
	
