<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>

<h2>Sign Up</h2>
<form action="${cp }/user/add" method="post"> <!-- POST 방식으로 '/user/add' 경로로 전송 -->

<c:if test="${not empty error }">
<p style="color:red">${error }</p><!-- 이메일 중복 에러 메시지 -->
</c:if>

<label for="name">Name:</label><br>
<input type="text" id="name" name="name" required><br><br>

<label for="email">Email:</label><br>
<input type="email" id="email" name="email" required><br><br>

<label for="password">Password:</label><br>
<input type="password" id="password" name="password" required><br><br>

<label for="confirmPassword">Confirm Password:</label><br>
<input type="password" id="confirmPassword" name="confirmPassword" required><br><br>


<label for="birthdate">Birthdate:</label>
<input type="date" id="birthdate" name="birthdate" required><br><br>

<label for="gender">Gender:</label><br>
<select id="gender" name="gender" required>
<option value="M">Male</option>
<option value="F">Female</option>
<option value="Other">Other</option>
</select><br><br>

<input type="submit" value="Sign Up">
</form>

<p>Already have an account? <a href="${cp }/user/login">Login</a></p>

</body>
</html>