<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link href="../css/list.css" rel="stylesheet">
</head>
<body>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../header.jsp" %>
	
	<div class="webcontainer"> 
		<h3> 글 쓰기 </h3>
		<form class="writeForm">
			카테고리 : <select name="bcno" class="bcno">
						<option value="1"> 공지사항 </option>
						<option value="2"> 자유게시판 </option>
						<option value="3"> 노하우 </option>
					 </select>
			제목 : <input type="text" name="btitle" class="btitle">
			내용 : <textarea name="bcontent" class="bcontent" rows=" " cols=""></textarea>
			첨부파일 : <input type="file" name="bfile" class="bfile">
			<button onclick="bwrite()" type="button"> 글등록 </button>
			<a href="list.jsp"> 목록보기 </a>
			<button type="reset"> 다시쓰기 </button>
		</form>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	<script src="list.js" type="text/javascript"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
	
</body>
</html>