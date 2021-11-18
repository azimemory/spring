<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<head>
<link rel="stylesheet" href="${context}/resources/css/board.css" />
<style type="text/css">
	.content{
		width:80vw;
		position:relative;
		left:10vw;
		display: flex;
		flex-direction:column;
		justify-content: center;
	}
	
	.paging{
		display: flex;
		justify-content: center;		
	}
	
	.paging>*{
		margin: 10px 5px 0 5px;
	}
</style>
	
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="content">
	    <h2 class="tit">* 게시판</h2>
	    <a href="${context}/board/form">게시글 쓰기</a>
  	    <table style="text-align: center" border="1">
	       <thead>
	           <tr>
	               <th style="width: 10%; height:20%;"><span>번호</span></th>
	               <th style="width: 70%;"><span>제목</span></th>
	               <th style="width: 10%;"><span>작성자</span></th>
	               <th style="width: 10%;"><span>등록일</span></th>
	           </tr>
	       </thead>
	       <tbody>
	       <c:forEach items="${boardList}" var="board">
	           <tr>
	               <td>${board.bdIdx}</td>
	               <td><a href="${context}/board/article?bdIdx=${board.bdIdx}">${board.title}</a></td>
	               <td>${board.userId}</td>
	               <td>${board.regDate}</td>
	           </tr>
	        </c:forEach>
	       </tbody>
	    </table>
	    <!-- section pagination -->
	    <%@ include file="/WEB-INF/views/include/paging.jsp" %>
	   	<!-- // section pagination -->
	</div>
</body>
</html>