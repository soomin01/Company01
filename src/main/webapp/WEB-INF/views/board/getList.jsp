<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<%@page import="com.sooit.spring.company.dto.BoardPostDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDateTime" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록- 글 목록</title>
<link rel="stylesheet" href="${cp}/resources/common.css?v=2">
</head>
<body>
	<h1>Company Board</h1>
	<h2>게시글</h2>
	<!-- 페이징 정보 출력 -->
	총 글 수: ${blp.count }
	총 페이지 수: ${blp.totalPage }
	현재 블럭: ${blp.currentBlockNo }
	블럭의 시작 페이지 번호: ${blp.blockStartNo }
	블럭의 끝 페이지 번호: ${blp.blockEndNo }
	이전 블럭 가능 여부: ${blp.hasPrev }
	다음 블럭 가능 여부: ${blp.hasNext }
	<table>
		<tr>
			<td>No</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성시간</td>
			<td>조회</td>

		</tr>
		<%
		Object o = request.getAttribute("list");
		@SuppressWarnings("unchecked")
		ArrayList<BoardPostDto> list = (ArrayList<BoardPostDto>) o;

		for (BoardPostDto post : list) {
			//     Long postId = list.get(i).getPost_id(); 
			Long postId = post.getPostId();
			String title = post.getTitle();
			String content = post.getContent();
			String author = post.getAuthor();
			LocalDateTime createdAt = post.getCreatedAt();
			Long viewCount = post.getViewCount();
		%>
		<tr>
			<td><%=postId%></td>
			<td><a href="${cp }/board/read?postId=<%=postId%>"> <%=title%>
			</a></td>
			<td><%=author%></td>
			<td><%=createdAt %>
			<td><%=viewCount %>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<!-- [] 글쓰기 페이지로 이동 -->
	<a href="${cp }/board/write">새글 쓰기</a>
	<a href="${cp }/board/restore?postId=5">글 복구</a>
	

</body>
</html>