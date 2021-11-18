<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%--
<div class="paging">
        <a href="${context}/${paging.type}/list" class="nav first">《</a>
        <a href="${context}/${paging.type}/list?page=${paging.prev}">〈</a>
      
        <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
        	<a href="${context}/${paging.type}/list?page=${page}"><span>${page}</span></a>
        </c:forEach> 
       
        <a href="${context}/${paging.type}/list?page=${paging.next}">〉</a>
	   	 <a href="${context}/${paging.type}/list?page=${paging.lastPage}">》</a>
</div>
 --%>

    <nav class="paging" >
	  <ul class="pagination">
	  
	    <li class="page-item">
	      <a class="page-link" href="${context}/${paging.type}/list?page=${paging.prev}" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    
	    <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
		    <li class="page-item">
		    	<a href="${context}/${paging.type}/list?page=${page}" class="page-link" >${page}</a>
		    </li>
	    </c:forEach> 
	    
	    <li class="page-item" >
	      <a class="page-link" href="${context}/${paging.type}/list?page=${paging.next}">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	    
	  </ul>
	</nav>
	
	