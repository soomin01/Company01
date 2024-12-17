package com.sooit.spring.company.service;

import java.util.List;

import com.sooit.spring.company.dto.CommentDto;

public interface CommentService {
	//게시글에 대한 댓글 목록 조회
	List<CommentDto> getCommentsByPostId(long postId);
	
	//댓글 추가
	void addComment(CommentDto comment);
	
	//댓글 삭제
	void deleteComment(int commentId);
}
