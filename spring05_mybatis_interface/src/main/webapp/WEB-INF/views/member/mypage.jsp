<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<body>
	<ul>
		<li>id : ${sessionScope.user.userId}</li>
		<li>password : ${sessionScope.user.password}</li>
		<li>tell : ${sessionScope.user.tell}</li>
		<li>email : ${sessionScope.user.email}</li>
		<li>grade : ${sessionScope.user.grade}</li>
		<li>등록일자 : ${sessionScope.user.regDate}</li>
	</ul>
</body>
</html>