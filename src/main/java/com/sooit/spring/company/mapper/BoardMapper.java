package com.sooit.spring.company.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sooit.spring.company.dto.BoardPostDto;

public interface BoardMapper {
	public int getCount();
//	public int getCountSearch(String word);
	public int getCountSearch(@Param("word") String word, @Param("type") String type);
	public ArrayList<BoardPostDto> getList(int limitIndex);
	public ArrayList<BoardPostDto> getListSearch(@Param("limitIndex") int limitIndex, @Param("word") String word, @Param("type") String type);
	public BoardPostDto read(long postId);
	public void del(long postId);
	public void write(BoardPostDto dto);
	public void modify(BoardPostDto dto);
	public void increaseViewCount(long postId);
	public void restore(long postId); //삭제된 데이터복구 메서드
	public void restore(@Param("postIds") List<Long> postIds); //여러 게시글 복구 메서드
}
