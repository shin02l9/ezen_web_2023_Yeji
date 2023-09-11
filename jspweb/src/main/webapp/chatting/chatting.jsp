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

	
	<div class="webcontainer">	 <!-- 레이아웃 전체 구역 -->
	
		<h1> 채팅 </h1>

		<!-- 채팅 전체 구역 -->
		<div class="chatbox">
			<!-- 채팅 목록  -->
			<div class="chatcontent">  
				<!-- innerHTML -->

				<!-- 보냈을때 오른쪽
					<div class="Rcont"> 
						<div class="subcont">
							<div class="date"> 오전 10:02 </div>
							<div class="content"> ㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎ </div>
						</div>
					</div>
				알림
					<div class="alarm"> 김근배님이 입장하셨습니다. </div>
				받았을때 왼쪽
					<div class="Lcont"> 
						<img class="pimg" src="/jspweb/member/img/default.webp" >
						<div class="tocont">
							<div class="Lname"> 김근배 </div>
							<div class="subcont">
								<div class="content"> ㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇㅎㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎ </div>
								<div class="date"> 오전 10:02 </div>
							</div>
						</div>
					</div> -->
			
			</div>
			
			<!-- 채팅 인풋 -->
			<div class="chatbottom"> 
				<textarea onkeydown="enter()" class="inputcontent"> </textarea>
				<button onclick="onSend()" class="sendbtn" type="button"> 보내기 </button>
			</div>
			

		</div> <!-- 채팅 전체 구역 end -->
	</div> <!-- 레이아웃 전체 구역 end -->
	
	
	
	
	
	
	
	
	
	
	<script src="chatting.js" type="text/javascript"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
</body>
</html>