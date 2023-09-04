<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<link href="../css/list.css" rel="stylesheet">
</head>
<body>

	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../header.jsp" %>
	
	<div class="webcontainer"> 
		<h3> 글 수정 페이지 </h3>
		<div class="boardBox">
		<form class="writeForm">
			카테고리 : <select name="bcno" class="bcno">
						<option value="1"> 공지사항 </option>
						<option value="2"> 자유게시판 </option>
						<option value="3"> 노하우 </option>
					 </select> <br/>
			제목 : <input type="text" name="btitle" class="btitle"> <br/>
			내용 : <textarea name="bcontent" class="bcontent" rows=" " cols=""></textarea> <br/>
			첨부파일 : <input type="file" name="bfile" class="bfile"> <br/> 
			<div class="oldfile" > 
				<img src ="../폴더명/파일명" />
			</div>
			<button onclick="onUpdate()" type="button"> 수정하기 </button>
		</form>
		</div>
		<a href="list.jsp"><button type="button"> 목록보기 </button> </a>
	
	</div>
	
	
	
	
	
	<script src="update.js" type="text/javascript"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
</body>
</html>