<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>visitlog</title>
	
	<!-- 해당 CSS 호출 -->
	<link href="visitlog.css" rel="stylesheet">
</head>
<body>

	<div class="wrap"> <!-- 전체구역 -->
		<h1> 방문록 </h1>
		<!-- CRUD 기반의 비회원 게시판 구현 -->
		<div class="wrap_2"> <!------------------ 쓰기구역 -->
			<h6> 작성자 </h6>
			<input class="vwriter input" type="text"> <br/>
			<h6> 비밀번호 </h6>
			<input class="vpwd input" type="password" > <br/>
			<h6> 내용 </h6>
			<textarea class="vcontent input" rows="" cols="" ></textarea> <br/>
			<button class="button" onclick="vwrite()" type="button"> 등록 </button>
		
		</div> <!----------------- 쓰기구역 end-->
		
		<div class="wrap_3"> <!------------------ 출력구역 -->
			<div class="visit_bottom"> <!-- 방문록 1개 표시구역 -->

			</div> <!-- 방문록 1개 표시구역 end -->
			
		</div> <!----------------- 출력구역 end-->
	
	</div>
	




	<!-- 최신 JQUERY 라이브러리 호출 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 해당 JS 호출 -->
	<script src="visitlog.js" type="text/javascript"></script>
</body>
</html>