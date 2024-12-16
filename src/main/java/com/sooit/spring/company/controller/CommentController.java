package com.sooit.spring.company.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sooit.spring.company.dto.CommentDto;
import com.sooit.spring.company.service.CommentService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class CommentController {
	
	private CommentService commentService;
	
	//게시글에 대한 댓글 목록 조회
	@GetMapping("/getComments/{postId}")
	public String getComments(@PathVariable int postId, Model model) {
		List<CommentDto> comments = commentService.getCommentsByPostId(postId);
		model.addAttribute("comments", comments);
		return "board/postDetail"; //게시글 상세 페이지
	}
}
