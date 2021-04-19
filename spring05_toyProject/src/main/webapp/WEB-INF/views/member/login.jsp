<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<head>
	<link href="/resources/css/member.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<h1>로그인</h1>
	<span class="valid_info"></span><br>	
	<span class="tit">ID :</span><input type="text" name="userId" id="id"><br>
	<span class="tit">PW :</span><input type="password" name="password" id="pw">
	<button onclick="login()">로그인</button>
	
	<script type="text/javascript">
	
	let login = () => {
		
		const url = '/member/loginimpl';
		let params = {};
		params.userId = id.value;
		params.password = pw.value;

		//post방식으로 진행
		//헤더 설정
		let headerObj = new Headers();
		//form태그의 기본 content 타입인 application/x-www-form-urlencoded 로
		//content-type을 맞춰야 서버에서 편하게 getParameter로 사용 할 수 있다.
		//name=value&name=value
		headerObj.append("content-type","application/json");
		
		fetch(url,{
			method:"post",
			headers:headerObj,
			body:JSON.stringify(params)
		})
		.then(response => {
			//200번대 응답코드라면
			if(response.ok){
				return response.text();
			}else{
				throw new AsyncResponseError(response.text());
			}
		})
		.then(text => {
			if(text == 'fail'){
				document.querySelector('.valid_info').innerHTML = '아이디나 비밀번호를 확인하세요.';
			}else if(text == 'success'){
				location.href = "/index";
			}
		}).catch((error)=>{
			error.alertMessage();
		})
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</script>	
		
		
		
		
		
		
		
		
</body>













</html>