<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="header-section">
	<div class="wrap_top-logo">
		<a class="top-logo-text" href="${context}/index">PCLASS</a>
	</div>
	<c:if test="${empty sessionScope.userInfo}">
		<div class="wrap_user">
			<a class="top_user top_join" href="${context}/member/login">login</a>
			<a class="top_user" href="${context}/member/join">join</a>
		</div>
	</c:if>
	<c:if test="${!empty sessionScope.userInfo}">
		<div class="wrap_user">
			<a class="top_user top_join" href="${context}/member/logout">logout</a>
			<a class="top_user" href="${context}/member/mypage">mypage</a>
		</div>
	</c:if>
</header>