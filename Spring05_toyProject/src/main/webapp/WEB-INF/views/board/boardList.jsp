<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<head>
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
		width:30vw;
		position:relative;
		left:25vw;
		display: flex;
		justify-content:space-around;
	}
</style>
	
</head>
<body>
	<div class="content">
	    <h2 class="tit">* 게시판</h2>
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
	       <c:forEach items="${blist}" var="board">
	           <tr>
	               <td>${board.bdIdx}</td>
	               <td><a href="${context}/board/detail.do?bdIdx=${board.bdIdx}">${board.title}</a></td>
	               <td>${board.userId}</td>
	               <td>${board.regDate}</td>
	           </tr>
	        </c:forEach>
	       </tbody>
	    </table>
	    <!-- section pagination -->
	      <div class="paging">
	         <a href="${context}/${paging.type}/list" class="nav first">《</a>
	         <a href="${context}/${paging.type}/list?page=${paging.prev}">〈</i></a>
	       
	         <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
	         	<a href="${context}/${paging.type}/list?page=${page}"><span>${page}</span></a>
	         </c:forEach> 
	        
	         <a href="${context}/${paging.type}/list?page=${paging.next}">〉</a>
	 	   	 <a href="${context}/${paging.type}/list?page=${paging.lastPage}">》</a>
	   	  </div>
	   	  <!-- // section pagination -->
	</div>
</body>
</html>