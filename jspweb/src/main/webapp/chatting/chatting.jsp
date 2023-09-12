<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>chatting</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
<link href="../css/chatting.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
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
								<div class="content"> ㅎㅇㅎㅇ ㅋㅋㅋ ㅎㅇㅎㅇ </div>
								<div class="date"> 오전 10:02 </div>
							</div>
						</div>
					</div> -->
			
			</div>
			
			<!-- 채팅 인풋 -->
			<div class="chatbottom"> 
				<textarea onkeyup="onEnterKey()" class="inputcontent"> </textarea>
				<button onclick="onSend()" class="sendbtn" type="button"> 보내기 </button>
			</div>
			
			<!-- 드랍메뉴 -->
			<div class="dropdown">
			  <button class="emobtn" type="button" data-bs-toggle="dropdown">
			  		<i class="far fa-smile"></i> <!-- 폰트어썸의 아이콘 코드 -->
			  </button>
			  <ul class="dropdown-menu emolistbox">
					<!-- innerHTML -->
			  </ul>
			</div>
			

		</div> <!-- 채팅 전체 구역 end -->
	</div> <!-- 레이아웃 전체 구역 end -->
	
	
	
	
	
	
	
	
	<script src="https://kit.fontawesome.com/6df33a20ce.js" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script src="chatting.js" type="text/javascript"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
</body>
</html>