<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="${cp }/resources/common.css?after">
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="${cp }/test/getOnePlusTwo">1+2확인하러가기</a>
<a href="${cp }/board/getList">리스트</a>
<a href="${cp }/board/read?postId=1">내용</a>
<!-- <a href="/board/del?postId=1">삭제</a> -->
<a href="${cp }/board/del?postId=2">삭제</a>
<a href="${cp }/board/write">글쓰기</a>
<a href="${cp }/board/modify?postId=1">수정</a>
<a href="${cp }/board/getList?currentPage=1">[방명록]</a>
<h2>Welcome, ${user.name}!</h2>
    <a href="${cp }/user/login">Logout</a>
</body>
</html>
