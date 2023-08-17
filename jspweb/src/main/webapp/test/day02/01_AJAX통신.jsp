<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_AJAX통신</title>
</head>
<body>

	<h6> AJAX [ JS ------ 자바[Servlet] 통신 ]</h6>
	<h1> 1. [응답:문자타입} JS에서 Servlet[자바웹클래스]에게 통신 </h1>
	<button onclick="예제1()" type="button"> 예제1</button>

	<h1> 2. [응답:문자타입/한글인코딩} JS에서 Servlet[자바웹클래스]에게 통신 </h1>
	<button onclick="예제2()" type="button"> 예제2</button>
	
	<h1> 3. [응답:JSON타입/한글인코딩} JS에서 Servlet[자바웹클래스]에게 통신 </h1>
	<button onclick="예제3()" type="button"> 예제3</button>
	
	<h1> 4. [응답:JSON타입/한글인코딩} JS에서 Servlet[자바웹클래스]에게 통신 </h1>
	<button onclick="예제4()" type="button"> 예제4</button>
	

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="01_AJAX통신.js" type="text/javascript"></script>

</body>
</html>