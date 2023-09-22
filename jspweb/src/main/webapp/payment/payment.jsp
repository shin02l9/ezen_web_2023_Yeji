<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>payment</title>
</head>
<body>


	<div>
		<button onclick=""> 마일리지 5000 </button>
		<button onclick=""> 마일리지 10000 </button>
		<button onclick=""> 마일리지 15000 </button>
		<button onclick=""> 마일리지 20000 </button>
		<button onclick=""> 마일리지 25000 </button>
	</div>
	
	
	<div>
		<button onclick="requestPay()" > 신용카드 </button>
		<button onclick="requestPay()"> 실시간계좌이체 </button>
		<button onclick="requestPay()"> 가상계좌 </button>
		<button onclick="requestPay()"> 휴대폰소액결제 </button>
	</div>
	
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script src="payment.js" type="text/javascript"></script>
</body>
</html>