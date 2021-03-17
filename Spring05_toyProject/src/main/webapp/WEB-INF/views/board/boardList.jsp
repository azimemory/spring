<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<head>
<style type="text/css">
	.paging{
		width:100%;
		display: flex;
		justify-content: space-around;
	}
</style>
	
</head>
<body>
	<div class="content">
	    <h2 class="tit">*게시판</h2>
  	    <table>
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
	        <tr>
	        	<td colspan="4">
        		 <!-- section pagination -->
			      <div class="paging">
			         <a href="${context}/${paging.type}/list" class="nav first">처음</a>
			         <a href="${context}/${paging.type}/list?page=${paging.prev}" class="nav prev">이전</i></a>
			       
			         <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
			         	<a href="${context}/${paging.type}/list?page=${page}" class="num active"><span>${page}</span></a>
			         </c:forEach> 
			        
			         <a href="${context}/${paging.type}/list?page=${paging.next}" class="nav next">다음</a>
			 	   	 <a href="${context}/${paging.type}/list?page=${paging.lastPage}" class="nav last">마지막</a>
			   	  </div>
			   	  <!-- // section pagination -->
	        	</td>
	        </tr>
	       </tbody>
	    </table>
		 
	   	  
	   	  <div class="btn_section" style="background-color:white">
	      	 <a href="${context}/board/write">쓰기</a>
	   	  </div>
	    </div>
</body>
</html>