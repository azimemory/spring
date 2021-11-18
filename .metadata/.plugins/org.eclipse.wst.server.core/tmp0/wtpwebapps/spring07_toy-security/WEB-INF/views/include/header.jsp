<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="header-section">
	<div class="wrap_top-logo">
		<a class="top-logo-text" href="/">PCLASS</a>
	</div>
	<sec:authorize access="not isAuthenticated()">
		<div class="wrap_user">
			<a class="top_user top_join" href="${context}/member/login">login</a>
			<a class="top_user" href="${context}/member/join">join</a>
		</div>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<div class="wrap_user">
			<a class="top_user top_join" href="${context}/member/logout">logout</a>
			<a class="top_user" href="${context}/member/mypage">mypage</a>
		</div>
	</sec:authorize>
</header>