package com.sooit.spring.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sooit.spring.company.dto.UserDto;
import com.sooit.spring.company.mapper.UserMapper;

import lombok.Setter;

@Service
public class UserServiceImpl implements UserService {
	
//	@Autowired
//	public UserServiceImpl(UserMapper userMapper) {
//		this.userMapper = userMapper;
//	}
	
	@Setter(onMethod_ = @Autowired)
	private UserMapper mapper;
	
	@Override
	public List<UserDto> getAllUsers(){
		return mapper.getAllUsers();
	}
	
	@Override
	public UserDto getUserByEmail(String email) {
		return mapper.findByEmail(email);
	}
	
	@Override
	public void addUser(UserDto user) {
		//이메일 중복 체크
		if(isEmailDuplicate(user.getEmail())) {
			throw new IllegalArgumentException("이미 사용된 이메일입니다.");
		}
		//비밀번호 확인 로직을 서비스 계층에서 처리
		if(checkPasswordMatch(user)) {
			mapper.addUser(user); //비밀번호가 일치하면 사용자 추가
		} else {
			//비밀번호가 불일치 시 처리 로직 추가 가능
			throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
		}
	}
	
	//이메일 중복 확인
	public boolean isEmailDuplicate(String email) {
		return mapper.checkEmailExists(email);
	}
	
	@Override
	public boolean checkPasswordMatch(UserDto user) {
		//실제로 비밀번호 확인 로직을 추가 (ex: 비밀번호 일치 여부 확인)
		return user.getPassword().equals(user.getConfirmPassword());
	}
	
	@Override
	public boolean checkUserCredentials(UserDto user) {
		//이메일로 사용자를 조회
		UserDto foundUser = mapper.findByEmail(user.getEmail());
		//사용자가 존재하지 않거나 비밀번호가 일치하지 않으면 false 반환
		if(foundUser == null || !foundUser.getPassword().equals(user.getPassword())) {
			return false;
		}
		
		return true; //이메이로가 비밀번호가 일치하면 ture 반환
	}
}
