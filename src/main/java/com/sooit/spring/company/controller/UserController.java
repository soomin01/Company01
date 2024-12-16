package com.sooit.spring.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sooit.spring.company.dto.UserDto;
import com.sooit.spring.company.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/user/*")
@AllArgsConstructor
@Controller
public class UserController {
	//위에 @AllArgsConstructor 을 사용하면
		//롬복라이브러리가 아래 코드를 자동으로 삽입해줌
//  @Autowired
//  public UserController(UserService userService) {
//      this.userService = userService;
//  }

    private final UserService userService;

    //로그인 페이지로 이동
    @GetMapping("/login")
    public String login() {
    	return "user/login"; //로그인 페이지 번호
    }
    
    //로그인 처리 (POST)
    @PostMapping("/login")
    public String login(@ModelAttribute UserDto user) {
    	boolean isValidUser = userService.checkUserCredentials(user);
    	if(isValidUser) {
    		return "redirect:/user/list"; //로그인 성공 후 사용자 목록 페이지로 리다이렉트
    	} else {
    		log.warn("로그인 실패: " + user.getEmail()); //로그인 실패 로그 추가
    		return "user/login"; //로그인 실패시 로그인 페이지로 돌아가기
    	}
    }

    // 사용자 목록 조회
    @GetMapping("/list") //경로를 `/list로 변경
    public String getUsers(Model model) {
    	//사용자 목록을 가져와 모델에 추가
    	try {
    		model.addAttribute("users", userService.getAllUsers());
    		return "user/userList"; //View 이름 반환
    	} catch(Exception e){
    		log.error("사용자 목록 조회 중 오류 발생: ", e);
    		return "user/userList"; //사용자 목록 페이지
    	}
    }

    // 사용자 추가
    @PostMapping("/add")
    public String addUser(@ModelAttribute UserDto user, Model model) {
        try {
        	userService.addUser(user); //사용자 추가
        	return "redirect:/user/login"; //성공 시 로그인 페이지로 이동
        } catch(IllegalArgumentException e) {
        	model.addAttribute("error", e.getMessage()); //중복 이메일 에러 메시지
        	return "user/signup"; //회원 가입 페이지로 돌아가기
        }
   
    }
    
    //회원가입 페이지로 이동(GET)
    @GetMapping("/signup")
    public String signup() {
    	return "user/signup"; //회원가입 페이지 반환
    }
}
