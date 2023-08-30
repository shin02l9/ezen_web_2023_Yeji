<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup</title>
<link href="../css/member.css" rel="stylesheet">
</head>
<body>

	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../header.jsp" %>
	
	
	<div class="webcontainer"> <!-- 회원가입 전체 구역  -->
		<form class="signupForm">
		
			<h2> 커뮤니티 회원가입 </h2>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼을 제공합니다. </p>
			<br/><br/>
		
		
			<div class="intitie"> 아이디 </div> 
			<input maxlength="30" onkeyup="idcheck() " name="mid" class="mid" type="text" /> 
			<div class="idcheckbox"></div>
			
			<div class="intitie"> 비밀번호 </div>
			<input maxlength="20" onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password" />
			<div class="pwcheckbox"></div>
			
			<div class="intitie"> 비밀번호 확인 </div> 
			<input maxlength="20" onkeyup="pwcheck()" class="mpwdconfirm" type="password" />
			
			
			
			<div class="intitie"> 이메일 </div> 
				<div class="emailbox">
					<input onkeyup="emailcheck()" name="memail" class="memail" type="text" /> 
					<!-- 이메일 인증요청 버튼 -> 유효성검사 통과시 사용가능 -->
					<button disabled class="authReqBtn" onclick="authReq()"  type="button">인증요청</button> <br/>
				</div>
				<div class="emailcheckbox"></div>
				<div class="authbox">
					<!-- 인증요청 버튼 클릭시 보이는 구역  -->
				</div>
			
			
			<div class="intitie"> 프로필 </div>
				<input onchange="preimg(this)" name="mimg" class="mimg" type="file" accept="image/*"/> <br/>
				<!-- <태그명 이벤트명="함수명(this)"/> -->
				
				<img class="preimg" alt="" src="img/defailt.webp"> 
				<!-- 등록된 사진을 미리보기 할 사진 태그 -->
				
			<button class="signupbtn" onclick="signup()" type="button">회원가입</button>
		</form>
	</div>
	
	
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
<script src="signup.js" type="text/javascript"></script>

	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
</body>
</html>