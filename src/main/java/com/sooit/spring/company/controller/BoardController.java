package com.sooit.spring.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sooit.spring.company.dto.BoardPostDto;
import com.sooit.spring.company.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
@Controller
public class BoardController {
	//위에 @AllArgsConstructor 을 사용하면
	//롬복라이브러리가 아래 코드를 자동으로 삽입해줌
//	public BoardController(BoardService service) {
//		this.service = service;
//	}
	private BoardService service;


//	@GetMapping("/getList")
//	public void getList(@RequestParam("currentPage") int currentPage, Model model) {
//		model.addAttribute("list",service.getList(currentPage));
//	}
	
	@GetMapping("/getList")
	public void getList(@RequestParam(value = "currentPage",required = false, defaultValue = "1") int currentPage, Model model) {
		model.addAttribute("list",service.getList(currentPage));
	}

	//	@GetMapping("/read")
//	public void read(@RequestParam("postId") Long postId, Model model) {
//		log.info("컨트롤러 ==== 글번호 ============"+postId);
//		model.addAttribute("read",service.read(postId));
//	}

	@GetMapping("/read")
	public String read(@RequestParam("postId") Long postId, Model model) {
		BoardPostDto post = service.read(postId); //조회수 증가 후 데이터를 가져옴
		model.addAttribute("read",post);
		return "board/read";
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("postId") Long postId) {
		log.info("컨트롤러 ==== 글번호 ============"+postId);
		service.del(postId);
		return "redirect:/board/getList";  //sendRedirect 로 이동하게 됨.
	}
	
	//게시물 작성 폼
	@GetMapping("/write")
	public void write() {
		
	}
	
	//게시물 작성 처리
	@PostMapping("/write")
	public String write(BoardPostDto dto) {
		service.write(dto);
		return "redirect:/board/getList?currentPage=1";
	}
	
	//게시물 수정 폼
	@GetMapping("/modify")
	public String modify(@RequestParam("postId") Long postId, Model model) {
		BoardPostDto read = service.read(postId);
		model.addAttribute("read",read);
		return "/board/modify"; //수정 폼 페이지로 이동
//		return "redirect:/board/getList?currentPage=1";
	}
	
	//게시물 수정 처리
	@PostMapping("/modify")
	public String modify(BoardPostDto dto) {
		service.modify(dto);
		return "redirect:/board/getList";
	}
	
	//삭제된 데이터 복구
	@GetMapping("/restore")
	public String restore(@RequestParam("postId") Long postId) {
		log.info("컨트롤러 ==== 복구 글 번호 ==========" + postId);
		service.restore(postId);
		return "redirect:/board/getList";
	}
	
}