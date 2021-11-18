<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="${contextPath}/resources/css/all.css">
<script type="text/javascript" src="${contextPath}/resources/js/webUtil.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/urlEncoder.js"></script>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
<style type="text/css">
		a{
			text-decoration: none;	
			cursor:pointer;
		}
		
		/* header 영역 */
		.header-section{
			display:flex;
			justify-content:space-between;
			align-items:center;
			width:100%;
			height:5vh;
			background-color: white;
		}
		
		.header-section>*{
			display:flex;
			align-items:center;
			width:30%;
		}
		
		.wrap_user{
			width:15%;
			justify-content: space-around;
			font-size:1.5vw;
		}
		
		tr,td,th{
			border: 1px solid black;
		}
</style>