package com.sooit.spring.company.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDto {
	private String email; //이메일 (고유값)
	private String password; //비밀번호 (암호화 저장 필요)
	private String confirmPassword; //비밀번호 확인 필드
	private String name; //이름
	private LocalDate birthdate; //생년월일
	private String gender; //성별 (M: 남성, F: 여성, Other: 기타)
}
