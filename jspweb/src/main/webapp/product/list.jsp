<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>list</title>
<link href="/jspweb/css/Plist.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
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
			<div class="card mb-3" style="max-width: 540px;">
			  <div class="row g-0">
			    <div class="col-md-4">
			      <img src="..." class="img-fluid rounded-start" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Card title</h5>
			        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			        <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
			      </div>
			    </div>
			  </div>
			</div>
		
		</div>
	
	
	</div> <!-- 지도와 사이드바 포함된 구역 end -->






	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=827217b7ddc513af82155b97606cd13a&libraries=clusterer"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="list.js" type="text/javascript"></script>
</body>
</html>