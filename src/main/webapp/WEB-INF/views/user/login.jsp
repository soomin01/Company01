<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>Login</h2>
<form action="${cp }/login" method="post">
<label for="email">Email:</label><br>
<input type="email" id="email" name="email" required><br><br>

<label for="password">Password:</label><br>
<input type="password" id="password" name="password" required><br><br>

<input type="submit" value="Login">
</form>
<p>Don't have an account? <a href="${cp }/signup">Sign up</a></p>
</body>
</html>