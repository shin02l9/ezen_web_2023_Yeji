<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info</title>
<link href="../css/member.css" rel="stylesheet">
</head>
<body>

	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../header.jsp" %>
	
	
	<div class="webcontainer"> <!-- 회원가입 전체 구역  -->
		<form class="signupForm">
		
			<h2> 마이페이지 </h2>
			<br/>
			
			<div class="intitie"> 프로필 변경 </div>
				<input onchange="preimg(this)" name="mimg" class="mimg" type="file" accept="image/*"/> <br/>
				<!-- <태그명 이벤트명="함수명(this)"/> -->
				<img class="preimg" alt="" src="img/defailt.webp"> 
				<!-- 등록된 사진을 미리보기 할 사진 태그 -->
		
			<div class="intitie"> 아이디 </div> 
			<div class="mid"> qweqwe </div>
			
			<div class="intitie"> 이메일 </div> 
			<div class="memail"> qweqwe@qwe.qwe </div>
			
			<div class="intitie"> 기존 비밀번호 </div>
			<input maxlength="20" name="mpwd" class="mpwd" type="password" />
			
			<div class="intitie"> 새로운 비밀번호 </div> 
			<input maxlength="20" class="mpwdconfirm" type="password" />
			
		
				
			<button class="signupbtn" onclick="mUpDate()" type="button">수정</button>
			<button class="signupbtn" onclick="mDelete()" type="button">탈퇴</button>
		</form>
	</div>
	
	
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
<script src="signup.js" type="text/javascript"></script>
<script src="info.js" type="text/javascript"></script>

	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
	
</body>
</html>