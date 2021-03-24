<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<body>
	<h1>MyPage</h1>
	<table>
		<tr>
			<td>id</td>
			<td>
				<input type="text" readonly="readonly" name="userId" value=" ${sessionScope.userInfo.userId}"/>
			</td>
		</tr>
		<tr>
			<td>password</td>
			<td>  
				<input type="text" value="${sessionScope.userInfo.password}"/>
			</td>		
		</tr>
		<tr>
			<td>tell</td>
			<td> <input type="text" value="${sessionScope.userInfo.tell}"/></td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="text" value="${sessionScope.userInfo.email}"/></td>
		</tr>
		<tr>
			<td>등록일자</td>
			<td>${sessionScope.user.regDate}</td>
		</tr>
	</table>
	
</body>
</html>