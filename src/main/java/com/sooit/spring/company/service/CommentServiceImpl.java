package com.sooit.spring.company.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sooit.spring.company.dto.CommentDto;
import com.sooit.spring.company.mapper.CommentMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class CommentServiceImpl implements CommentService {
	@Setter(onMethod_ = @Autowired) //Lombok의 Setter 사용, @Autowired추가
	private CommentMapper commentMapper;
	
	@Override
	public List<CommentDto> getCommentsByPostId(long postId){
		return commentMapper.getCommentsByPostId(postId);
	}
	
	@Override
	public void addComment(CommentDto comment) {
		commentMapper.addComment(comment);
	}
	
	@Override
	public void deleteComment(int commentId) {
		commentMapper.deleteComment(commentId);
	}
}
