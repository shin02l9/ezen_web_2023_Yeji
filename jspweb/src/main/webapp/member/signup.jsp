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
	
	
	<div><!-- 회원가입 전체 구역 -->
		아이디 : 			<input onkeydown="idkeydown()" class="mid" type="text">  <br/>
		<span class="idcheckbox"> </span>
		비밀번호 : 		<input class="mpw" type="password">  <br/>
		비밀번호확인 : 	<input class="mpwconfirm" type="password">  <br/>
		이메일 : 			<input class="memail" type="text">  <br/>
		이메일 인증코드 : 	<input class="ecode" type="text">  <br/>
		프로필등록 : 		<input class="mimg" type="text">  <br/>
		<button onclick="signup()" type="button"> 회원가입 </button>
	
	</div>
	
	
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
<script src="signup.js" type="text/javascript"></script>
</body>
</html>