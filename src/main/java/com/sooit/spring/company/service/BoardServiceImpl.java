package com.sooit.spring.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sooit.spring.company.dto.BoardPostDto;
import com.sooit.spring.company.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Override
//	public ArrayList<BoardPostDto> getList(int currentPage){
//		log.info("비지니스 계층===============");
//		int limitIndex = (currentPage-1) * 5;
//		return mapper.getList(limitIndex);
//	}
	
//	@Override
//	public BoardListProcessor getList(int currentPage) {
//		return new BoardListProcessor(mapper, currentPage);
//	}
	
	@Override
	public BoardListProcessor getList(int currentPage, String word, String cp, String type) {
		return new BoardListProcessor(mapper, currentPage, word, cp, type);
	}
	
	@Override
	public BoardPostDto read(long postId) {
		mapper.increaseViewCount(postId); //조회수 증가
		return mapper.read(postId);
	}
	
	@Override
	public void del(long postId) {
		mapper.del(postId);
	}
	
	@Override
	public void write(BoardPostDto dto) {
		mapper.write(dto);
	}
	
	@Override
	public void modify(BoardPostDto dto) {
		mapper.modify(dto);
	}
	
	@Override
	public void restore(long postId) {
		mapper.restore(postId); //단일 복구
	}
	
	@Override
	public void restore(List<Long> postIds) {
		mapper.restore(postIds); //Mapper에 다중 복구 처리하는 SQL 연결
	}
	
}