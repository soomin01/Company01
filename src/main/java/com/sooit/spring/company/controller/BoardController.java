package com.sooit.spring.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sooit.spring.company.dto.BoardPostDto;
import com.sooit.spring.company.service.BoardListProcessor;
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
	
//	@GetMapping("/getList")
//	public String getList(@RequestParam(value = "currentPage",required = false, defaultValue = "1") int currentPage, Model model) {
//		// blp는 게시글 목록, 페이징 정보 등을 포함하는 객체
//	    BoardListProcessor blp = service.getList(currentPage);  // 게시글 목록을 가져오는 서비스 메소드 호출
//	    model.addAttribute("blp", blp);  // 'blp'를 Model에 추가하여 JSP에서 사용할 수 있도록 설정
//	    return "board/getList";  // board/getList.jsp 페이지로 이동
//	}
	
	@GetMapping("/getList")
	public String getList(@RequestParam(value = "currentPage",required = false, defaultValue = "1") int currentPage, 
			@RequestParam(value = "word", required = false, defaultValue = "") String word, 
			HttpServletRequest request, Model model) {
		
		log.info("컨트롤러 ==== 현재 페이지: " + currentPage + ", 검색어: " + word);
		
		String contextPath = request.getContextPath(); //contextPath 가져오기
		
		// blp는 게시글 목록, 페이징 정보 등을 포함하는 객체
		BoardListProcessor blp = service.getList(currentPage, word, contextPath);  // 게시글 목록을 가져오는 서비스 메소드 호출
		model.addAttribute("blp", blp);  // 'blp'를 Model에 추가하여 JSP에서 사용할 수 있도록 설정
		return "board/getList";  // board/getList.jsp 페이지로 이동
	}
	
	//	@GetMapping("/read")
//	public void read(@RequestParam("postId") Long postId, Model model) {
//		log.info("컨트롤러 ==== 글번호 ============"+postId);
//		model.addAttribute("read",service.read(postId));
//	}

	@GetMapping("/read")
	public String read(@RequestParam("postId") Long postId, Model model) {
		log.info("컨트롤러=====글 번호 조회:" + postId);
		BoardPostDto post = service.read(postId); //조회수 증가 후 데이터를 가져옴
		model.addAttribute("read",post);
		return "board/read";
	}
	
	//게시글 삭제
//	@GetMapping("/del")
//	public String del(@RequestParam("postId") Long postId) {
//		log.info("컨트롤러 ==== 글번호 ============"+postId);
//		service.del(postId);
//		return "redirect:/board/getList";  //sendRedirect 로 이동하게 됨.
//	}
	@PostMapping("/del")
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
//	@GetMapping("/restore")
//	public String restore(@RequestParam("postId") Long postId) {
//		log.info("컨트롤러 ==== 복구 글 번호 ==========" + postId);
//		service.restore(postId);
//		return "redirect:/board/getList";
//	}
	@PostMapping("/restore")
	public String restore(@RequestParam("postId") Long postId) {
		log.info("컨트롤러 ==== 복구 글 번호 ==========" + postId);
		service.restore(postId);
		return "redirect:/board/getList";
	}
	
}