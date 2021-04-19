<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<head>
	<link rel="stylesheet" href="${context}/resources/css/board.css" />
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<div class="content">
	<h2 class="tit">*게시판</h2>
	<div class="desc_board">
		<form action="${context}/board/upload" method="post" enctype="multipart/form-data">
			<div>
				<div class="tit_board">
					제목 : <input type="text" name="title" required="required"/>
					파일 : <input type="file" name="files" id="contract_file" multiple/>
				</div>
				<div class="content_board">
					<textarea name="content" required="required"></textarea>
				</div>
				<div class="btn_section">
					<button style="background-color:red; color:white; width:100%">전송</button>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>