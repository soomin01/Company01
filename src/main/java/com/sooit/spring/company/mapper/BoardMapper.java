package com.sooit.spring.company.mapper;

import java.util.ArrayList;


import com.sooit.spring.company.dto.BoardPostDto;

public interface BoardMapper {
	public int getCount();
//	public Integer getCount();
	public ArrayList<BoardPostDto> getList(int limitIndex);
	public BoardPostDto read(long postId);
	public void del(long postId);
	public void write(BoardPostDto dto);
	public void modify(BoardPostDto dto);
	public void increaseViewCount(long postId);
	public void restore(long postId); //삭제된 데이터복구 메서드
}
