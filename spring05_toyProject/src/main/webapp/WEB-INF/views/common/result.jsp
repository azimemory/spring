<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<body>
	<%-- request의 msg 속성에 담겨온 message를 alert 하고
		 url 속성에 담겨온 주소로 페이지를 이동 --%>
	<script type="text/javascript">
		let context = "${context}";
		
		<%-- 안내창 출력 --%>
		<c:if test="${msg != null}">
			alert("${msg}");		
		</c:if>
	
		<%-- 뒤로가기 --%>
		<c:if test="${back != null}">
			history.back();
		</c:if>
	
		<%-- 페이지 이동 --%>
		<c:if test="${url != null}">
			location.href = context + '${url}';		
		</c:if>
	
	</script>
</body>
</html>