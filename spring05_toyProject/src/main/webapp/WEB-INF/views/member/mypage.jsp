<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<ul>
		<li>id : ${sessionScope.userInfo.userId}</li>
		<li>password : ${sessionScope.userInfo.password}</li>
		<li>tell : ${sessionScope.userInfo.tell}</li>
		<li>email : ${sessionScope.userInfo.email}</li>
		<li>grade : ${sessionScope.userInfo.grade}</li>
		<li>등록일자 : ${sessionScope.userInfo.regDate}</li>
	</ul>
</body>
</html>