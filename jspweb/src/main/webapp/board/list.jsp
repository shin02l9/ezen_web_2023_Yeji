<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
<link href="../css/list.css" rel="stylesheet">
</head>
<body>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../header.jsp" %>
	
	<div class="webcontainer"> 
		<h3> 글 목록 </h3>
		
		<table class="boardTable" >
			<!-- innerHTML -->
		</table>
		
		
		
		
		
		
		<button onclick="onWrite()" type="button"> 글쓰기 </button>
		
	</div>
	
	
	
	
	
	<script src="list.js" type="text/javascript"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
	
</body>
</html>