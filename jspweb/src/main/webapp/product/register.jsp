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
			
			<div id="map" style="width:100%;height:350px;"></div>
				<p><em>지도를 클릭해주세요!</em></p> 
			<div id="clickLatlng"></div>
						
			
			<!-- 드래그엔 드랍 -->
			<div class="fileDropBox" style="width: 300px; height: 100px; border: 1px solid red;" >
				여기에 드래그해서 파일을 올려주세요.
			
			<!-- 	<div>
					<span> 파일명 </span>
					<span> 파일사이즈 </span>
					<span> <button type="button"> 삭제 </button></span>
				</div> -->
				
			
			</div>

			
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




<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=827217b7ddc513af82155b97606cd13a"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="/footer.jsp" %>

<script src="register.js" type="text/javascript"></script>
</body>
</html>