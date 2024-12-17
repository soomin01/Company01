package com.sooit.spring.company.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserDto {
	private String email; //이메일 (고유값)
	private String password; //비밀번호 (암호화 저장 필요)
	private String confirmPassword; //비밀번호 확인 필드
	private String name; //이름
//	private LocalDate birthdate; //생년월일
//	private String birthdate; //생년월일
	private String gender; //성별 (M: 남성, F: 여성, Other: 기타)
	
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private LocalDate birthdate;

	    // Getter와 Setter
//	    public LocalDate getBirthdate() {
//	        return birthdate;
//	    }
//
//	    public void setBirthdate(LocalDate birthdate) {
//	        this.birthdate = birthdate;
//	    }
//	//Validation 로직 추가
//	public boolean isPasswordMatching() {
//		return password.equals(confirmPassword);
//	}
	
	 // Getter, Setter
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public LocalDate getBirthdate() {
//        return birthdate;
//    }
//
//    public void setBirthdate(LocalDate birthdate) {
//        this.birthdate = birthdate;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
}
