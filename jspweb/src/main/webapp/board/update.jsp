<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<link href="../css/list.css" rel="stylesheet">
   <!-- 부트스트랩에서 만든 CSS 적용 -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
   <!-- 썸머노트 css 적용 - 부트스트랩v5 -->
   <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">
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
			내용 : <textarea id="summernote" name="bcontent" class="bcontent" rows=" " cols=""></textarea> <br/>
			첨부파일 : <input type="file" name="bfile" class="bfile"> <br/> 
			<div class="oldfile" > 
				<img src ="../폴더명/파일명" />
			</div>
			<button onclick="onUpdate()" type="button"> 수정하기 </button>
		</form>
		</div>
		<a href="list.jsp"><button type="button"> 목록보기 </button> </a>
	
	</div>
	
	
	
	<!-- 부트스트랩에서 만든 JS 적용 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<!-- 썸머노트 js 적용 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.js"></script>
	<!-- 썸머노트 한글적용  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>
	
	
	<script src="update.js" type="text/javascript"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
</body>
</html>