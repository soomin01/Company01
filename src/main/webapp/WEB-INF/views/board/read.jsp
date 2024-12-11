<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<%@page import="com.sooit.spring.company.dto.BoardPostDto" %>
<%@page import="java.time.LocalDateTime" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cp }/resources/common.css?after">
</head>
<body>
<%
BoardPostDto read = (BoardPostDto)request.getAttribute("read");
// long postId = read.getPost_id();
long postId = read.getPostId();
String title = read.getTitle();
String content = read.getContent();
String author = read.getAuthor();
LocalDateTime createdAt = read.getCreatedAt();
Long viewCount = read.getViewCount();
%>

글 본문
글 번호:<%=postId %>
제목:<%=title %>
글 내용:<%=content %>
작성자 id:<%=author %>
작성시간:<%=createdAt %>
조회수:<%=viewCount %>
<br><br>
<!-- [ ] 글삭제로 이동. 글번호를 넘겨야함. -->	
<a href="${cp }/board/del?postId=<%=postId %>">글 삭제</a>
<!-- [ ] 글 수정으로 이동. 글번호를 넘겨야함. -->	
<a href="${cp }/board/modify?postId=<%=postId %>">글 수정</a>
<!-- [ ] 글 리스트로 이동. -->	
<a href="${cp }/board/getList?currentPage=1">글 리스트</a>
</body>
</html>