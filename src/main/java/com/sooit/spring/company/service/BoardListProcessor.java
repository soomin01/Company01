package com.sooit.spring.company.service;

import java.util.ArrayList;

import com.sooit.spring.company.dto.BoardPostDto;
import com.sooit.spring.company.mapper.BoardMapper;

import lombok.Data;

@Data
public class BoardListProcessor {
	private BoardMapper mapper;
	public ArrayList<BoardPostDto> posts;
	public int totalPage = 0; //전체 페이지 수
	public int currentPage = 0; //현재 페이지 번호
	
	private String htmlPageList;
	private String word;
	private String cp; //contextPath
	
	int totalBlock = 0; //블록 총 갯수
	int currentBlockNo = 0; //현재 블록 번호
	int blockStartNo = 0; //블록 시작 페이지 번호
	int blockEndNo = 0; //블록 페이지 끝 번호
	int prevPage = 0; //이전 블록 첫 페이지 번호
	int nextPage = 0; //다음 블록 첫 페이지 번호
	boolean hasPrev = true; //이전 블록 이동 가능 여부
	boolean hasNext = true; //다음 블록 이동 가능 여부
	private int count; //전체 게시글 수 추가
	
	public BoardListProcessor(BoardMapper mapper, int currentPage, String word, String cp) {
		super();
		this.mapper = mapper;
		this.currentPage = currentPage;
		this.word =word;
		this.cp = cp;
		this.totalPage = getPageCount();
		getList(); //현재 페이지 번호와 전체 페이지 수를 기반으로 리스트 데이터 열기
		
		totalBlock = (int) Math.ceil((double) totalPage / Board.PAGE_LINK_AMOUNT );
		currentBlockNo = (int) Math.ceil((double) this.currentPage / Board.PAGE_LINK_AMOUNT);
		blockStartNo = (currentBlockNo - 1) * Board.PAGE_LINK_AMOUNT + 1;
		blockEndNo = currentBlockNo * Board.PAGE_LINK_AMOUNT;
		
		if(blockEndNo > totalPage) {
			blockEndNo = totalPage;
		}
		
		if(currentBlockNo == 1) {
			hasPrev = false;
		} else {
			hasPrev = true;
			prevPage = (currentBlockNo - 1) * Board.PAGE_LINK_AMOUNT;
		}
		if(currentBlockNo < totalBlock) {
			hasNext = true;
			nextPage = currentBlockNo * Board.PAGE_LINK_AMOUNT + 1;
		} else {
			hasNext = false;
		}
		
		this.htmlPageList = getHtmlPageList();
		this.count = mapper.getCount(); //게시글의 총 수를 가져옵니다.
		
	}
	
	/*페이징 블록 처리*/
//	public void getList() {
//		int startIndex = (currentPage - 1) * Board.LIST_AMOUNT;
//		posts = mapper.getList(startIndex);
//	}
	/*페이징 블록, 검색기능*/
	public void getList() {
		int startIndex = (currentPage - 1) * Board.LIST_AMOUNT;
		if(word.equals("")) {
			posts = mapper.getList(startIndex);
		} else {
			posts = mapper.getListSearch(startIndex,word);
			
		}
	}
	
	/* 총 페이지 수 구하기 */
//	public int getPageCount() {
//		int totalPageCount = 0;
//		int count = mapper.getCount();
//		if(count % Board.LIST_AMOUNT == 0) {
//			totalPageCount = count / Board.LIST_AMOUNT;
//		} else {
//			totalPageCount = count / Board.LIST_AMOUNT + 1;
//		}
//		return totalPageCount;
//		
//	}
	
	/* 총 페이지 수 구하기 */
	public int getPageCount() {
		int totalPageCount = 0;
		int count = 0;
		if(word.equals("")) {
			count = mapper.getCount();
		} else {
			count = mapper.getCountSearch(word);
		}
		if(count % Board.LIST_AMOUNT == 0) {
			totalPageCount = count / Board.LIST_AMOUNT;
		} else {
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
		
	}
	
	/* 리스트 객체 얻는 함수 */
	public ArrayList<BoardPostDto> getPosts(){
		return posts;
	}
	
	public String getHtmlPageList() {
		String html = "";
		
		if(hasPrev) {
			html = html + String.format("<a href='%s/board/getList?currentPage=%d&word=%s'>이전</a>",cp,prevPage,word);
		}
		
//		for(int i = blockStartNo; i<= blockEndNo; i++) {
//			html = html + String.format("<a href='%s/board/getList?currentPage=%d&word=%s'>%d</a>&nbsp;&nbsp;",cp,i,word,i);
//		}
		
		//코드 수정
		for(int i = blockStartNo; i<= blockEndNo; i++) {
			
			html = html + String.format("<a href='%s/board/getList?currentPage=%d&word=%s'>%d</a>&nbsp;&nbsp;",cp,i,word,i);
		}
		
		if(hasNext) {
			html = html + String.format("<a href='%s/board/getList?currentPage=%d&word=%s'>다음</a>",cp,nextPage,word);
			
		}
		
		return html;
	}
}

