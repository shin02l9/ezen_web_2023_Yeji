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
			<li> <a href="/jspweb/board/list.jsp"> 게시판 </a></li>
			<li> <a href="3"> 기능2 </a></li>
			<li> <a href="3"> 기능3 </a></li>
			<li> <a href="/jspweb/accountbook/accountbook.jsp"> 과제1:가계부 </a> </li>
			<li> <a href="/jspweb/library/library.jsp"> 과제2:열람실 </a> </li>
			<li> <a href="/jspweb/hrm/hrm.jsp"> 과제3:직원등록 </a> </li>
			
		</ul>
		<ul class="submenu"> 
			<!-- innerHTML -->	
		</ul>
		

	</div>
	
	
	
	
	
	<!-- 헤더에 넣어주면 좋은 것( 공통적인 코드 )
		1. 제이쿼리 라이브러리 ( AJAX 를 위해 사용함 ) 
		
	
	 -->
	
	<!-- 최신 제이쿼리 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspweb/js/header.js" type="text/javascript"></script>
</body>
</html>