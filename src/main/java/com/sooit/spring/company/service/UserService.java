package com.sooit.spring.company.service;

import java.util.List;

import com.sooit.spring.company.dto.UserDto;

public interface UserService {
	/*
	 * 모든 사용자 목록을 가져옵니다
	 * @return 사용자 리스트
	 */
	List<UserDto> getAllUsers();
	
	/*
	 * 이메일로 사용자를 조회합니다.
	 * @param email 조회할 사용자의 이메일
	 * @return 사용자 정보
	 * */
	UserDto getUserByEmail(String email);
	
	/*
	 * 새로운 사용자를 추가합니다
	 * @param user 추가할 사용자 정보
	 * */
	void addUser(UserDto user);
	
	/*
	 * 비밀번호와 확인 비밀번호가 일치하는지 확인합니다
	 * @param user 사용자 객체
	 * @return 비밀번호 일치 여부
	 * */
	boolean checkPasswordMatch(UserDto user);
	
	//사용자의 자격 증명(이메일 및 비밀번호)가 유효한지 확인합니다
	boolean checkUserCredentials(UserDto user);
}
	
	
