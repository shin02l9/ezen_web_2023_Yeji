<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link href="/jspweb/css/Plist.css" rel="stylesheet">
</head>
<body>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="/header.jsp" %>

	<div class="mapcontent"> <!-- 지도와 사이드바 포함된 구역 -->

		<p style="margin-top: -12px">
			사용한 데이터를 보시려면 <em class="link"> <a
				href="/download/web/data/chicken.json" target="_blank">여기를
					클릭하세요!</a>
			</em>
		</p>
		<div id="map" style="width: 100%; height: 350px;"></div>

		<!-- 사이드바 구역 -->
		<div class="sidebar"> 
		
		
		</div>
	
	
	</div> <!-- 지도와 사이드바 포함된 구역 end -->






	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="/footer.jsp" %>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=827217b7ddc513af82155b97606cd13a&libraries=clusterer"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="list.js" type="text/javascript"></script>
</body>
</html>