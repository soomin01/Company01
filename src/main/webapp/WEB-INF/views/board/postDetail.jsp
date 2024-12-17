<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post Detail</title>
</head>
<body>

<h2>Post Detail</h2>
<!-- 게시글 내용 출력 -->
<div>
<h3>${post.title }</h3>
<p><strong>Author:</strong> ${post.author }</p>
<p><strong>Created At:</strong> ${post.createdAt }</p>
<p>${post.content }</p>
</div>

<h3>Comments</h3>
<!-- 댓글 목록 출력 -->
<c:forEach var="comment" items="${comments }">
<div>
<p><strong>${comment.author }</strong>(${comment.createdAt }): ${comment.content }</p>
<form action="${cp }/board/deleteComment/${comment.commentId }" method="post">
<input type="hidden" name="postId" value="${comment.postId }">
<input type="submit" value="Delete Comment">
</form>
</div>
</c:forEach>

<!-- 댓글 추가 -->
<h3>Add a Comment</h3>
<form action="${cp }/board/addComment" method="post">
<input type="hidden" name="postId" value="${post.postId }">
<textarea name="content" required></textarea><br><br>
<input type="text" name="author" required placeholder="Your Name"><br><br>
<input type="submit" value="Add Comment">
</form>

</body>
</html>