<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<%@page import="com.sooit.spring.company.dto.BoardPostDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시판 글 수정

<%
BoardPostDto read = (BoardPostDto)request.getAttribute("read");
long postId = read.getPostId();
String content = read.getContent();
%>

글 번호:<%=postId %><br>
<form action="${cp }/board/modify" method="post">
<!-- 숨겨진 글 ID -->
<input type="hidden" name='postId' value='<%=postId %>'>
<!-- 제목 수정 -->
<label for="title">제목 :</label>
<input type="text" name="title" id="title" value="${title }" required><br><br>
<!-- 내용 폼 -->
<!-- 글 내용: -->
<label for="content">글 내용 :</label>
<textarea name='content'><%=content %></textarea><br><br>
<!-- 작성자ID 수정 -->
<label for="author">작성자 ID :</label>
<input type="text" name="author" id="${author }" required><br><br>
<!-- 수정 버튼 -->
<input type="submit" value="수정하기">
</form>
</body>
</html>