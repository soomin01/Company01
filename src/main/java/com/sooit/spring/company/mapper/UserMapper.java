package com.sooit.spring.company.mapper;

import java.util.List;

import com.sooit.spring.company.dto.UserDto;

public interface UserMapper {
	List<UserDto> getAllUsers(); //모든 사용자 조회
	void addUser(UserDto user); //사용자 추가
	UserDto findByEmail(String email); //이메일로 사용자 조회
	boolean checkEmailExists(String email); //이메일 중복 확인
}
