package com.sooit.spring.company.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentDto {
	private int commentId;
	private int postId;
	private String content;
	private String author;
	private LocalDateTime createdAt;
	private boolean isDeleted;
	
}
