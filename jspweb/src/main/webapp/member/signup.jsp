<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup</title>
<link href="signup.css" rel="stylesheet">
</head>
<body>

	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="/header.jsp" %>
	
	
	<div > <!-- 회원가입 전체 구역  -->
		<form class="signupForm">
			아이디 : <input onkeyup="idcheck() " name="mid" class="mid" type="text" /> 
			<span class="idcheckbox"></span>
			<br/>
			
			비밀번호 : <input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password" /> <br/>
			비밀번호 확인 : <input onkeyup="pwcheck()"  class="mpwdconfirm" type="password" />
			
			<span class="pwcheckbox"></span>
			<br/>
			
			이메일 : <input onkeyup="emailcheck()" name="memail" class="memail" type="text" /> 
			<!-- 이메일 인증요청 버튼 -> 유효성검사 통과시 사용가능 -->
			<button disabled class="authReqBtn" onclick="authReq()"  type="button">인증요청</button> <br/>
			
			<div class="authbox">
				<!-- 인증요청 버튼 클릭시 보이는 구역  -->
			</div>
			
			<span class="emailcheckbox"></span> <br/>
			
			프로필 : 	<input onchange="preimg(this)" name="mimg" class="mimg" type="file" accept="image/*"/> <br/>
				<!-- <태그명 이벤트명="함수명(this)"/> -->
			<img class="preimg" alt="" src="img/defailt.webp" width="100px"> <!-- 등록된 사진을 미리보기 할 사진 태그 -->
			<button onclick="signup()" type="button">회원가입</button>
		</form>
	</div>
	
	
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
<script src="signup.js" type="text/javascript"></script>
</body>
</html>