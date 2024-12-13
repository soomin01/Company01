package com.sooit.spring.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sooit.spring.company.dto.UserDto;
import com.sooit.spring.company.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public List<UserDto> getAllUsers(){
		return userMapper.getAllUsers();
	}
	
	@Override
	public UserDto getUserByEmail(String email) {
		return userMapper.findByEmail(email);
	}
	
	@Override
	public void addUser(UserDto user) {
		userMapper.adduser(user);
	}
	
	@Override
	public boolean checkPasswordMatch(UserDto user) {
		//실제로 비밀번호 확인 로직을 추가 (ex: 비밀번호 일치 여부 확인)
		return user.getPassword().equals(user.getConfirmPassword());
	}
}
