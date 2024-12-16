<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 목록</title>
</head>
<body>

<h1>사용자 목록</h1>
<ul>
<c:forEach var="user" items="${users }">
<li>${user.name }(${user.email })</li>
</c:forEach>
</ul>

</body>
</html>