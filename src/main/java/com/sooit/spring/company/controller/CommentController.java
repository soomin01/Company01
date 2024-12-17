package com.sooit.spring.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sooit.spring.company.dto.CommentDto;
import com.sooit.spring.company.service.CommentService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class CommentController {
	
	private CommentService commentService;
//	private BoardService boardService; //게시글 서비스 추가
//	
//	//게시글 상세 페이지 + 댓글 목록 조회 코드 보류
//	@GetMapping("/postDetail/{postId}")
//	public String postDetail(@PathVariable int postId, Model model) {
//		BoardPostDto post = boardService.read(postId); //게시글 정보 가져오기
//		List<CommentDto> comments = commentService.getCommentsByPostId((int)postId); //댓글 목록 가져오기
//		
//		model.addAttribute("post", post); //게시글 정보
//		model.addAttribute("comments", comments);
//		return "board/postDetail"; //게시글 상세 페이지
//	}
	
	//댓글 추가
	@PostMapping("/addComment")
	public String addComment(CommentDto commentDto) {
		commentService.addComment(commentDto);
		return "redirect:/board/read?postId=" + commentDto.getPostId(); //댓글 추가 후 해당 게시글로 리다이렉트
	}
	
	//댓글 삭제
	@PostMapping("/deleteComment/{commentId}")
	public String deleteComment(@PathVariable int commentId, @RequestParam int postId) {
		commentService.deleteComment(commentId);
		return "redirect:/board/read?postId=" + postId; //댓글 삭제 후 해당 게시글로 리다이렉트
	}
}
