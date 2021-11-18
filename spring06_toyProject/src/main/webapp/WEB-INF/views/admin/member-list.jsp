<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>

<h1>회원 관리</h1>
<table>
	<thead>
		<th>아이디</th>
		<th>휴대폰번호</th>
		<th>이메일</th>
		<th>탈퇴처리</th>
	</thead>
	<tbody>
		<c:forEach items="${members}" var="member">
		<tr>
			<td><c:out value="${member.userId}"/></td>
			<td><c:out value="${member.tell}"/></td>
			<td><c:out value="${member.email}"/></td>
			<td><a href="/admin/member/leave">탈퇴</a></td>
		</tr>		
		</c:forEach>
	</tbody>

</table>


</body>
</html>