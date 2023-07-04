<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>kiosk</title>
	<link href="/frontendproject/CSS/kiosk.css" rel="stylesheet">
</head>
<body>
	<!-- 다른 JSP 파일이 호출 가능함 -->
	<%@ include file="../header.jsp" %>
	
	
	<div class="kioskwrap"> <!-- 키오스크 시작 -->
		<div> <!-- 헤더 : 광고이미지/카테고리 출력 구역 -->
			<!-- 광고이미지 구역-->
			<img class="himg" src="../img/header_img1.png"/>
			
			<!-- 카테고리 구역-->
			<ul class="categorymenu">
				<li class="categoryselect"> 신제품(new) </li>
				<li> 프리미엄 </li>
				<li> 와퍼&주니어 </li>
				<li> 치킨&슈림프버거 </li>
				<li> 올데이킹&킹모닝 </li>
			</ul>
		</div> <!-- 헤더 끝 -->
		
		<div class="kioskcontent"> <!-- 본문 : 제품/장바구니 출력 구역 -->
		
			<div class="productbox"> <!-- 제품구역  -->
			
				<!-- 제품 1개 기준 -->
				<div class="product"> 
					<img src="../img/헬로디아블로와퍼.png"/> <!-- 제품이미지 -->
					<div class="pinfo">
						<div class="pname"> 헬로 디아블로 와퍼  </div> <!-- 제품이름 -->
						<div class="pprice"> 15,000원  </div> <!-- 제품가격 -->
					</div>
				</div>
				<!-- 제품 1개 end -->
				
				<!-- 제품 1개 기준 -->
				<div class="product"> 
					<img src="../img/헬로디아블로와퍼.png"/> <!-- 제품이미지 -->
					<div class="pinfo">
						<div class="pname"> 헬로 디아블로 와퍼  </div> <!-- 제품이름 -->
						<div class="pprice"> 15,000원  </div> <!-- 제품가격 -->
					</div>
				</div>
				<!-- 제품 1개 end -->
				
				<!-- 제품 1개 기준 -->
				<div class="product"> 
					<img src="../img/헬로디아블로와퍼.png"/> <!-- 제품이미지 -->
					<div class="pinfo">
						<div class="pname"> 헬로 디아블로 와퍼  </div> <!-- 제품이름 -->
						<div class="pprice"> 15,000원  </div> <!-- 제품가격 -->
					</div>
				</div>
				<!-- 제품 1개 end -->
				
				<!-- 제품 1개 기준 -->
				<div class="product"> 
					<img src="../img/헬로디아블로와퍼.png"/> <!-- 제품이미지 -->
					<div class="pinfo">
						<div class="pname"> 헬로 디아블로 와퍼  </div> <!-- 제품이름 -->
						<div class="pprice"> 15,000원  </div> <!-- 제품가격 -->
					</div>
				</div>
				<!-- 제품 1개 end -->
				
				<!-- 제품 1개 기준 -->
				<div class="product"> 
					<img src="../img/헬로디아블로와퍼.png"/> <!-- 제품이미지 -->
					<div class="pinfo">
						<div class="pname"> 헬로 디아블로 와퍼  </div> <!-- 제품이름 -->
						<div class="pprice"> 15,000원  </div> <!-- 제품가격 -->
					</div>
				</div>
				<!-- 제품 1개 end -->
				
				<!-- 제품 1개 기준 -->
				<div class="product"> 
					<img src="../img/헬로디아블로와퍼.png"/> <!-- 제품이미지 -->
					<div class="pinfo">
						<div class="pname"> 헬로 디아블로 와퍼  </div> <!-- 제품이름 -->
						<div class="pprice"> 15,000원  </div> <!-- 제품가격 -->
					</div>
				</div>
				<!-- 제품 1개 end -->
				
				<!-- 제품 1개 기준 -->
				<div class="product"> 
					<img src="../img/헬로디아블로와퍼.png"/> <!-- 제품이미지 -->
					<div class="pinfo">
						<div class="pname"> 헬로 디아블로 와퍼  </div> <!-- 제품이름 -->
						<div class="pprice"> 15,000원  </div> <!-- 제품가격 -->
					</div>
				</div>
				<!-- 제품 1개 end -->
				
				<!-- 제품 1개 기준 -->
				<div class="product"> 
					<img src="../img/헬로디아블로와퍼.png"/> <!-- 제품이미지 -->
					<div class="pinfo">
						<div class="pname"> 헬로 디아블로 와퍼  </div> <!-- 제품이름 -->
						<div class="pprice"> 15,000원  </div> <!-- 제품가격 -->
					</div>
				</div>
				<!-- 제품 1개 end -->
				
				<!-- 제품 1개 기준 -->
				<div class="product"> 
					<img src="../img/헬로디아블로와퍼.png"/> <!-- 제품이미지 -->
					<div class="pinfo">
						<div class="pname"> 헬로 디아블로 와퍼  </div> <!-- 제품이름 -->
						<div class="pprice"> 15,000원  </div> <!-- 제품가격 -->
					</div>
				</div>
				<!-- 제품 1개 end -->
				
				
			</div> <!-- 제품구역  end -->
			
			<div class="cartbox"> <!-- 장바구니구역 -->
			
			</div> <!-- 장바구니구역 end -->
			
		</div> <!-- 본문 끝 -->
	</div> <!-- 키오스크 끝 -->
	
	
	
	
	
	
	
	
	
	<!-- 다른 JSP 파일이 호출 가능함 -->
	<%@ include file="../footer.jsp" %>
	
	<script src="/frontendproject/JS/kiosk.js" type="text/javascript"></script>

</body>
</html>