<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
	<script type="text/javascript">
	
		<%-- 안내창 출력 --%>
		<c:if test="${not empty msg}">
			alert("${msg}");		
		</c:if>
		
		<%-- 뒤로 가기 --%>
		<c:if test="${not empty back}">
			history.back();	
		</c:if>

		<%-- 페이지 이동 --%>
		<c:if test="${not empty url}">
			location.href = '${url}'
		</c:if>
			
	</script>
</body>
</html>