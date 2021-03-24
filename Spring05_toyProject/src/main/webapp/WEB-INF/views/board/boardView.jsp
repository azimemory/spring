<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="${context}/resources/css/board.css" />
<link rel="stylesheet" href="/resources/css/reset.css"/>
<body>
<div class="content">   
    <h2 class="tit">*게시판</h2>
    <div class="desc_board">
      <div class="info" >
          <span>번호 : ${board.bdIdx}</span>
          <span>제목 : ${board.title}</span>
          <span>등록일 : ${board.regDate}</span>
          <span>작성자 : ${board.userId}</span>
      </div>
      <div class="info file_info">
      	<c:forEach var="file" items="${files}">
      	 	<button type="button" class="btn_down-file"  
      	 			onclick="downloadFile('${file.originFileName}','${file.renameFileName}','${file.savePath}')">  
      	 		${file.originFileName}        
        	 </button>
      	</c:forEach>
      </div>
      <div class="article_content">
          ${board.content}
      </div>
      <div class="btn_section">
          <button onclick="submitData('list')"><span>목록</span></button>
          <button ><span>삭제</span></button>
          <button><span>수정</span></button>
      </div>
   </div>
</div>
<script type="text/javascript">
   function submitData(url){
      location.href = url;
   } 
   
   function downloadFile(ofname,rfname,savePath){
	  let params = {'originFileName':ofname,
			  		'renameFileName':rfname,
			  		'savePath':savePath};
	  
      location.href = '${context}' + "/board/download?" + urlEncodeForm(params);
   }

</script>










</body>
</html>