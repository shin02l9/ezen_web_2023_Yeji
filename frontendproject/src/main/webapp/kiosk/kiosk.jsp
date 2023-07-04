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
			<img class="himg" src="../img/himg1.png"/>
			
			<!-- 카테고리 구역-->
			<ul class="categorymenu">
				<!-- 내용 JS로 출력 -->
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
				
				
				
			</div> <!-- 제품구역  end -->
			
			<div class="cartbox"> <!-- 장바구니구역 -->
			
				<div class="cartcontent"> <!-- 선택정보구역 -->
					<div class="carttop"> <!-- 선택 제품개수/가격 출력 구역 -->
						<div> 카트 <span class="ccount">3</span> </div>
						<div> 총 주문금액 <span class="ctotal"> 31,000원<span></span> </div>
					</div>
					<div class="cartbottom">
					
						<!-- 장바구니내 제품 1개  -->
						<div class="citem">
							<div class="iname"> 더블비프 불고기버거 </div> <!-- 제품이름  -->
							<div class="iprice"> 12,000원 </div> <!-- 제품가격 -->
							<span class="icencel"> x </span> <!-- 취소 버튼 -->
						</div>

					</div>
				</div> <!-- 선택정보구역 end -->
				
				<div class="cartbtn"> <!-- 버튼구역 -->

					<button class="cencelbtn"> 취소하기 </button>
					<button class="orderbtn"> 결제하기 </button>

				</div> <!-- 버튼구역 end -->
				
				
			</div> <!-- 장바구니구역 end -->
		</div> <!-- 본문 끝 -->
	</div> <!-- 키오스크 끝 -->
	
	
	
	
	
	
	
	
	
	<!-- 다른 JSP 파일이 호출 가능함 -->
	<%@ include file="../footer.jsp" %>
	
	<script src="/frontendproject/JS/kiosk.js" type="text/javascript"></script>

</body>
</html>