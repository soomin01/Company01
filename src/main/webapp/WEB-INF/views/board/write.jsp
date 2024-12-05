<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${cp }/board/write" method="post">
<!-- 제목 입력 필드 -->
<label for="title">제목</label>
<input type="text" name="title" id="title" required><br>

<!-- 내용 입력 필드 -->
<label for="content">내용</label>
<textarea rows="3" name="content" id="content" required></textarea><br>

<!-- 작성자 입력 필드 -->		
<label for="author">작성자</label>
<input type="text" name="author" id="author" required><br>

<!-- 제출 버튼 -->
		<input type="submit" value="글쓰기">
</form>

</body>
</html>