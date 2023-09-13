<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> register </title>
<link href="../css/register.css" rel="stylesheet">
</head>
<body>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="/header.jsp" %>
	
	
	<div class="webcontainer">
		<form class="registerForm" >
			카테고리 :
			<select name="pcategory">
				<option value="1"> 아우터 </option>
				<option value="2"> 상의 </option>
				<option value="3"> 하의 </option>
				<option value="4"> 신발 </option>
				<option value="5"> 가방 </option>
			</select>
			제품명 : <input name="pname" type="text"> <br/>
			제품설명 : <textarea name="pcontent"  rows="" cols=""></textarea>  <br/>
			제품가격 : <input name="pprice" type="number"> <br/>
			
			제품이미지 : <input name="pimg" type="file" multiple="multiple"> <br/>
			
			
			<button onclick="onRegister()" > 등록 </button>
		</form> 
	
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- <h1> 제품 등록 페이지 [form 태그 없는 경우]</h1>
	<div>
		제품명 : <input class="pname1" type="text"/>
		제품설명 : <textarea class="pcontent1" rows="" cols=""></textarea>
		<button onclick="register1()" type="button"> 등록 1 </button>
	</div>

	<h1> 제품 등록 페이지 [form 태그 있 경우]</h1>
	<form class="registerForm" >
		제품명 : <input class="pname2" type="text"/>
		제품설명 : <textarea class="pcontent2" rows="" cols=""></textarea>
		<button onclick="register2()" type="button"> 등록 2 </button>
	</form> -->





	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="/footer.jsp" %>

<script src="register.js" type="text/javascript"></script>
</body>
</html>