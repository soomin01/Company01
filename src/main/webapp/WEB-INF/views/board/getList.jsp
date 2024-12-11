<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<%@page import="com.sooit.spring.company.dto.BoardPostDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDateTime"%>
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
	<br>, 총 페이지 수: ${blp.totalPage }
	<br>, 현재 블럭: ${blp.currentBlockNo }
	<br>, 블럭의 시작 페이지 번호: ${blp.blockStartNo }
	<br>, 블럭의 끝 페이지 번호: ${blp.blockEndNo }
	<br>, 이전 블럭 가능 여부: ${blp.hasPrev }
	<br>, 다음 블럭 가능 여부: ${blp.hasNext }
	<hr>
	<form action="${cp }/board/restore" method="post">
		<table>
			<tr>
				<td>No</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성시간</td>
				<td>조회</td>

			</tr>

			<!-- 데이터가 없을 경우 메시지 출력 -->
			<c:if test="${empty blp.posts }">
				<tr>
					<td colspan="6">등록된 글이 없습니다.</td>
				</tr>
			</c:if>

			<!-- 게시글 목록 출력 -->
			<c:forEach var="post" items="${blp.posts }">
				<tr>
					<td>${post.postId }</td>
					<td><a href="${cp }/board/read?postId=${post.postId}">${post.title }</a></td>
					<td>${post.author }</td>
					<td>${post.createdAt }</td>
					<td>${post.viewCount }</td>
					<td>
						<!-- 복구할 게시글 선택을 위한 체크 박스 --> 
						<input type="checkbox" name="postIds" value="${post.postId }">
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>

		<!-- 복구버튼 -->
		<button type="submit">선택한 글 복구</button>
	</form>
	<hr>
	${blp.htmlPageList }
	<hr>

	<!-- [] 글쓰기 페이지로 이동 -->
	<a href="${cp }/board/write">새글 쓰기</a>

	<form action="${cp }/board/getList">
		<input name="word" placeholder="검색어 입력"> 
		<input type="submit" value="검색">
	</form>



</body>
</html>