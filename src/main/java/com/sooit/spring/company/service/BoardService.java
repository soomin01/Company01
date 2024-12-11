package com.sooit.spring.company.service;

import java.util.List;

import com.sooit.spring.company.dto.BoardPostDto;

public interface BoardService {
//	public ArrayList<BoardPostDto> getList(int currentPage);
//	public BoardListProcessor getList(int currentPage);
	public BoardListProcessor getList(int currentPage, String word, String cp);
	public BoardPostDto read(long postId);
	public void del(long postId);
	public void write(BoardPostDto dto);
	public void modify(BoardPostDto dto);
//	public void increaseViewCount(long postId);
	public void restore(long postId); //단일 복구
	public void restore(List<Long> postIds); //다중 복구
	//git 테스트
}
