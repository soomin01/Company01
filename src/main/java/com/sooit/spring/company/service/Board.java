package com.sooit.spring.company.service;

public class Board {
	static public final int LIST_AMOUNT = 5; //하나의 리스트에 보일 글 수
	static public final int PAGE_LINK_AMOUNT = 3; //페이지 링크 한 블록에 보일 페이지 링크 갯수
	
	/* table 이름들 */
	public static final String TABLE_BOARD_POSTS = "company_board_posts"; //게시판 테이블
	public static final String TABLE_BOARD_COMMENTS = "company_board_comments"; //댓글 테이블
	public static final String TABLE_BOARD_FILES = "company_board_files"; //파일 첨부 테이블
}
