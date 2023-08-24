<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accountbook</title>
<link href="accountbook.css" rel="stylesheet">
</head>
<body>

	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="/jspweb/header.jsp" %>

	<div class="wrap"> <!-- 전체 레이아웃 -->
	
		<div class="inputBox"> <!-- 입력칸 --------------------->
			<div class="content">  
				<h4> 내용 </h4>
				<input type="text"/><br/>
			</div>
			<div class="price"> 
				<h4> 가격 </h4>
				<input type="text"/><br/>
			</div>
			<div class="date"> 
				<h4> 날짜 </h4>
				<input type="datetime-local"><br/>
			</div>
			<div class="btn"> 
				<button onclick="C()" class="btnC" type="button"> 등록 </button> 
			</div>
			
		
		</div> <!-- 입력칸 end-->
		
		<div class="printBox"> <!-- 출력칸 --------------------->
			<table class="printTable">
				<tr class="title"> <!-- 제목 행 --> 
					<th class="title01"> 내용 </th> 
					<th class="title01"> 가격 </th> 
					<th class="title01"> 날짜 </th> 
					<th class="title01">  </th>
				</tr>
				
				<!-- inner HTML로 출력 할 구역 -->
				<tr class="printValue"> <!-- 출력 행 --> 
					<th class="title02" > 엽기떡볶이 </th> 
					<th class="title02"> 15000 </th> 
					<th class="title02"> 2023-08-24 12:00:00 </th> 
					<th class="title02"> 
						<button onclick="U()" class="btnU" type="button"> 수정 </button> 
						<button onclick="D()" class="btnD" type="button"> 삭제 </button> 
					</th>
				</tr>
			
			</table>
		</div> <!-- 출력칸 end-->
		
	
	
	</div>  <!-- 전체 레이아웃 end -->


	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="/jspweb/footer.jsp" %>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="accountbook.js" type="text/javascript"></script>
</body>
</html>