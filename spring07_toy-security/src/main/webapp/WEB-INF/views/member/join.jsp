<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<style type="text/css">
.valid-msg{
	display:block;
	color:red;	
	font-size:10px;
}

input{
	display:block;
	width:400px;
	border: none;
	outline: none;
}

tr>td:nth-child(1){
	background-color: red;
	color:white;
}

#userId{
	display: inline-block;
	width: 80%;
}

input[type=submit]{
	width: 100%;
}

</style>

</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<h1>회원 가입 양식</h1>
    <form:form modelAttribute="joinForm"
   				   action="/member/join" method="post" id="frm_join" >
     <table border="1">
        <tr>
           <td>ID : </td>
           <td >
              <input type="text" name="userId" id="userId" size="10"  
				<c:if test="${empty error.userId }">
						value="${joinForm.userId}"
				</c:if>
           	  required/>
           	  <button type="button" id="btnIdCheck">check</button>
           	  <c:if test="${empty error.userId }">
           	  		<span id="idCheck" class="valid-msg"></span>
           	  </c:if>
           	  <form:errors path="userId" cssClass="valid-msg" id="idCheck"/>
           </td>
        </tr>
        <tr>
           <td>PASSWORD : </td>
           <td>
           	  <input type="password" name="password" id="password"
           	  		placeholder="영어,숫자,특수문자 조합의 8글자 이상의 문자열입니다." 
           	  	<c:if test="${empty error.password }">
						value="${joinForm.password}"
				</c:if>	
           	   required/>
           	 <form:errors path="password" cssClass="valid-msg"/>
           </td>
        </tr>
        <tr>
           <td>휴대폰번호 : </td>
           <td>
           	  <input id="tell" type="tel" name="tell" placeholder="숫자만 입력하세요"  
           	  		<c:if test="${empty error.tell }">
						value="${joinForm.tell}"
					</c:if>	
           	  required/>
           	  <form:errors path="tell" cssClass="valid-msg"/>
           </td>
        </tr>
        <tr>
           <td>EMAIL : </td>
           <td>
           	  <input type="email" name="email"  
           	  		<c:if test="${empty error.email }">
						value="${joinForm.email}"
					</c:if>	
           	  required/>
           </td>
        </tr>
        <tr>
           <td colspan="2">
              <input type="submit" value="가입" />
           </td>
       </tr>
   </table>
   </form:form>
   
   <script type="text/javascript" src="/resources/js/member/joinForm.js"></script>
   
   
   
   
   
</body>
</html>