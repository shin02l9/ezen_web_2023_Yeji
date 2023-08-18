<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>01_AJAX통신</title>
	</head>
<body>

	<h6> AJAX [ JS ------ 자바[서블릿] 통신 ]</h6>
	<h3> 1. JS에서 서블릿[자바웹클래스]에게 데이터 보내기 </h3>
	<button onclick="예제1()" type="button"> 예제1</button>
	
	<h6> AJAX [ JS ------ 자바[서블릿] 통신 ]</h6>
	<h3> 2. JS에서 서블릿[자바웹클래스]에게 ()입력받은 값)데이터 보내기 </h3>
	성명 : <input class="name" type="text"> <br/>
	나이 : <input class="age" type="number"> <br/>
	<button onclick="예제2()" type="button"> 예제2</button>











<!-- jquery 호출 -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- JS호출 -->
<script src="01_AJAX통신.js" type="text/javascript"></script>

</body>
</html>