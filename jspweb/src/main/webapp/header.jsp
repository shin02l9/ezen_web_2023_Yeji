<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 헤더 </title>
<link href="/jspweb/css/header.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
	
	<div id="header">
		<div class="mainlogo">
			<!-- 로고 -->
			<a href="/jspweb/index.jsp">
				<img alt="" src="/jspweb/img/logo.PNG"/>
			</a>
		</div>
		<ul class="mainmenu">
			<li> <a href="/jspweb/visitlog/visitlog.jsp"> 방문록 </a></li>
			<li> <a href="3"> 기능1 </a></li>
			<li> <a href="3"> 기능2 </a></li>
			<li> <a href="3"> 기능3 </a></li>
			<li> <a href="/jspweb/accountbook/accountbook.jsp"> 과제1:가계부 </a> </li>
			<li> <a href="#"> 과제2:독서관열람실 </a> </li>
		</ul>
		<ul class="submenu"> 
			<li> <a href="/jspweb/member/signup.jsp"> 회원가입 </a></li>
			<li> <a href="/jspweb/member/login.jsp"> 로그인 </a></li>
			<li> <a href="3"> 로그아웃 </a></li>
			<li> <a href="3"> 마이페이지 </a></li>
			<li> <img class="hmimg" src="/jspweb/member/img/default.webp"/></li>
		</ul>
		

	</div>
	
	
	
	
	
	<!-- 헤더에 넣어주면 좋은 것( 공통적인 코드 )
		1. 제이쿼리 라이브러리 ( AJAX 를 위해 사용함 ) 
		
	
	 -->
	
	<!-- 최신 제이쿼리 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</body>
</html>