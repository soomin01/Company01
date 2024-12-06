package com.sooit.spring.company.service;

import com.sooit.spring.company.dto.BoardPostDto;

public interface BoardService {
//	public ArrayList<BoardPostDto> getList(int currentPage);
	public BoardListProcessor getList(int currentPage);
	public BoardPostDto read(long postId);
	public void del(long postId);
	public void write(BoardPostDto dto);
	public void modify(BoardPostDto dto);
//	public void increaseViewCount(long postId);
	public void restore(long postId);
	//git 테스트
}
