<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/board.css" />
<link rel="stylesheet" href="/resources/css/reset.css"/>
<body>
<div class="content">   
    <h2 class="tit">*게시판</h2>
    <div class="desc_board">
      <h4 class="tit_board">제목 : ${data.board.title}</h4>
      <div class="info" >
          <span>게시글 번호 : ${data.board.bdIdx}</span>
          <span>등록일 : ${data.board.regDate}</span>
          <span>작성자 : ${data.board.userId}</span>
      </div>
      <div class="info">
      	<c:forEach var="file" items="${data.fileList}">
      	 	<button type="button" class="btn_down-file"  
      	 			onclick="downloadFile('${file.originFileName}','${file.renameFileName}','${file.savePath}')">  
      	 		${file.originFileName}        
        	 </button><br>
      	</c:forEach>
        
      </div>
      <div class="text">
          ${data.board.content}
      </div>
      <div class="btn_section btn_list">
          <button style="color:white" onclick="submitData('list')"><span>목록</span></button>
      </div>
      
       <div class="btn_section btn_delete">
        <button style="color:white"><span>삭제</span></button>
      </div>
      <div class="btn_section btn_modify">
        <button style="color:white"><span>수정</span></button>
      </div>
   </div>
</div>
<footer class="bottom">bottom</footer>
<script type="text/javascript">
   function submitData(url){
      location.href = url;
   } 
   
   function downloadFile(ofname,rfname,savePath){
	  let params = {'ofname':ofname,
			  		'rfname':rfname,
			  		'savePath':savePath};
	  
      location.href = '${context}' + "/board/download?" + urlEncodedForm(params);
   }

</script>










</body>
</html>