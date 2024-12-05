package com.sooit.spring.company.dto;

import java.time.LocalDateTime;


import lombok.Data;

@Data
public class BoardPostDto {
	private Long postId;                //게시 글 ID(기본키)글번호
	private String title;               //게시 글 제목
	private String content;             //게시 글 내용
	private String author;              //작성자 이름
	private LocalDateTime createdAt;    //작성일시
	private LocalDateTime updatedAt;    //수정일시
	private Long viewCount;             //조회수
	private Boolean isDeleted;          //삭제여부
}
