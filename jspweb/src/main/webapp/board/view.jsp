<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
<link href="../css/view.css" rel="stylesheet">
</head>
<body>

	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../header.jsp" %>
	
	<div class="webcontainer"> 
		<h3> 글 상세 페이지 </h3>
		<div class="boardBox">
			<!-- innerHTML -->
		</div>
		<a href="list.jsp"><button type="button"> 목록보기 </button> </a>
	</div>
	
	
	
	
	
	<script src="view.js" type="text/javascript"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
</body>
</html>