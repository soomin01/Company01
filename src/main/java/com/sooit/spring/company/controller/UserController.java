package com.sooit.spring.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sooit.spring.company.dto.UserDto;
import com.sooit.spring.company.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 사용자 목록 조회
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/userList";
    }

    // 사용자 추가
    @PostMapping("/users/add")
    public String addUser(UserDto user) {
        if (userService.checkPasswordMatch(user)) {
            userService.addUser(user);
            return "redirect:/users";
        } else {
            return "user/signup"; // 비밀번호 불일치시 다시 회원가입 페이지로
        }
    }
}
