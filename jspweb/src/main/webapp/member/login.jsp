<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="../css/member.css" rel="stylesheet">
</head>
<body>

	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../header.jsp" %>
	
	
	<div class="webcontainer"> <!-- 회원가입 전체 구역  -->
		<form class="signupForm">
		
			<h2> 커뮤니티 로그인 </h2>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼을 제공합니다. </p>
			<br/><br/>
		
		
			<div class="intitie"> 아이디 </div> 
			<input maxlength="30"  name="mid" class="mid" type="text" /> 
			
			<div class="intitie"> 비밀번호 </div>
			<input maxlength="20"  name="mpwd" class="mpwd" type="password" />
			
			
			<!-- 로그인 유효성 검사 구역 -->
			<div class="logincheckbox">  </div> <br/>


			<button class="loginbtn signupbtn" onclick="login()" type="button">로그인</button>
			 
			
			<!-- 아이디/비번 찾기 구역 -->
			<div class="findbtnbox">
				<a href="#"> 아이디찾기 </a>
				<a href="#"> 비밀번호찾기 </a>
			</div>
		
		
		</form>
	</div>
	
	
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
<script src="login.js" type="text/javascript"></script>

	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
</body>
</html>