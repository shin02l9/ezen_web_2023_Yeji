<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hrm</title>
<link href="hrm.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>


	<div class="webcontainer"> <!-- 직원 페이지 전체 구역  -->
		<div> <!-- 직원등록 ---------------------------------------------------->
			<form class="registerEmployeeForm">
			
				<h2> 직원등록 시스템 </h2>
				<br/>
			
				<div class="intitie"> 직원사진 </div> 
					<input onchange="preimg(this)" name="mimg" class="mimg" type="file" accept="image/*"/> <br/>
					<!-- <태그명 이벤트명="함수명(this)"/> -->
					<img class="preimg" alt="" src="img/defailt.webp"> 
					<!-- 등록된 사진을 미리보기 할 사진 태그 -->
					
				<div class="intitie"> 직원명 </div> 
				<input  class="hname" type="text"> <br/>
				
				<div class="intitie"> 직원전화번호 </div> 
				<input  class="hphone" type="text" > <br/>
				
				<div class="intitie"> 직급 </div> 
				  <select>
				  	<option> 사장 </option>
				  	<option> 부장 </option>
				  	<option> 팀장 </option>
				  	<option> 대리 </option>
				  	<option> 주임 </option>
				  	<option> 사원 </option>
				  </select>	<br/>
		
				<button class="registerbtn" onclick="register()" type="button">등록하기</button>
			</form>
		</div> <!-- 직원등록 end -->
	
		<div> <!-- 직원 출력 ---------------------------------------------------->
			<table class="printTable">
					
				<!-- inner HTML로 출력 할 구역 -->
	
			</table>
		</div> <!-- 직원 출력 end -->
	
	
	</div> <!-- 직원 페이지 전체 구역 end -->
	
	
	
	
	
	
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<script src="hrm.js" type="text/javascript"></script>
	<%@include file="../footer.jsp" %>


</body>
</html>