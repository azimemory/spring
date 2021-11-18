<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<h1>마이페이지</h1>
<table border="1">
	<tr>
		<th>아이디</th>
		<td>${principal.username}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${principal.member.password}</td>
	</tr>
	<tr>
		<th>휴대폰번호</th>
		<td>${principal.tell}</td>
	</tr>
	<tr>
		<th>email</th>
		<td>${principal.email}</td>
	</tr>
</table>


</body>
</html>