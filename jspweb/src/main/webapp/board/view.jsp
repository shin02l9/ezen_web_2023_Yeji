<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
<link href="../css/list.css" rel="stylesheet">
</head>
<body>

	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../header.jsp" %>
	
	<div class="webcontainer"> 
		<h3> 글 상세 페이지 </h3>
		<div class="boardBox">
			부가정보1 : <div> 카테고리명, 조회수, 작성일 </div>
			부가정보2 : <div> 작성자, 프로필사진 </div>
			제목 : <div> 제목자리 </div>
			내용 : <div> 내용자리 </div>
			첨부파일 : <div> 첨부파일 </div>

			<a href="list.jsp"><button type="button"> 목록보기 </button> </a>
		</div>
	</div>
	
	
	
	
	
	<script src="view.js" type="text/javascript"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
</body>
</html>