<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chatting</title>
<link href="../css/chatting.css" rel="stylesheet">
</head>
<body>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../header.jsp" %>

	
	<div class="webcontainer">	
		<h1> 채팅 </h1>
	
		<div>
			<div class="contentbox"> </div>
			<input class="inputcontent" type="text"/>
			<button onclick="msgsend()" class="sendbtn" type="button"> 보내기 </button>
		
		
		
		</div>
	
	
	
	
	</div>
	
	
	
	
	
	
	
	
	
	
	<script src="chatting.js" type="text/javascript"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
</body>
</html>