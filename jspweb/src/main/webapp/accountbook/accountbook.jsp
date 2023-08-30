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
	<%@include file="/header.jsp" %>

	<div class="wrap"> <!-- 전체 레이아웃 -->
	
		<div class="inputBox"> <!-- 입력칸 --------------------->
			<div class="content">  
				<h4> 내용 </h4>
				<input class="contentInput" type="text"/><br/>
			</div>
			<div class="price"> 
				<h4> 가격 </h4>
				<input class="priceInput" type="text"/><br/>
			</div>
			<div class="date"> 
				<h4> 날짜 </h4>
				<input class="dateInput" type="datetime-local"><br/>
			</div>
			<div class="btn"> 
				<button onclick="C()" class="btnC" type="button"> 등록 </button> 
			</div>
			
		
		</div> <!-- 입력칸 end-->
		
		<div class="printBox"> <!-- 출력칸 --------------------->
			<table class="printTable">
				
					<!-- inner HTML로 출력 할 구역 -->

			
			</table>
		</div> <!-- 출력칸 end-->
		
	
	
	</div>  <!-- 전체 레이아웃 end -->


	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%-- <%@include file="/jspweb/footer.jsp" %> --%>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="accountbook.js" type="text/javascript"></script>
</body>
</html>