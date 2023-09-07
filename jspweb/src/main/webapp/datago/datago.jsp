<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/datago.css" rel="stylesheet">
<title>datago</title>


</head>
<body>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../header.jsp" %>

	<div class="webcontainer">	
	
	
		<div>
			<h3> 카카오 지도 API </h3>
			<div class="detailbox"> 
			
			</div>
			<div id="map" style="width:1100px;height:400px;"></div>
		</div>
			
		
		<div>
			<h3> 안산시 착한가격업소 현황 </h3>
			<table class="apiTable">
				<tr>
					<th> 번호 </th>
					<th> 상호명 </th>
					<th> 주소 </th>
					<th> 연락처 </th>				
					<th> 대표메뉴1 </th>
					<th> 대표메뉴2 </th>
					<th> 대표메뉴3 </th>
				</tr>
			</table>
		</div>

	</div>











	<!-- 카카오 지도 API -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=827217b7ddc513af82155b97606cd13a&libraries=clusterer"></script>
	<script src="datago.js" type="text/javascript"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
</body>
</html>