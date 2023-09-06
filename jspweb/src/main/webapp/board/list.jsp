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
	
		<!-- 1. 상단 페이지 제목 -->
		<div class="boardtop">
			<h1> 게시판 </h1> <br/>
			<p> 다양한 사람들과 정보를 공유하세요. </p>
		</div>
		
		
		<!-- 2. 상단 부가 버튼 -->
		<div class="boardtopetc">
			<div>
				<select onchange="onlistsize()" class="bbtn listsize">
					<option value="10"> 10 </option>
					<option value="15"> 15 </option>
					<option value="20"> 20 </option>
				</select>
				<span class="totalsize"> </span>
			</div>
			<button class="bbtn" onclick="onWrite()" type="button"> 글쓰기 </button>
		</div>
		
		<!-- 3. 카테고리 구역 -->
		<div class="boardcategorybox">
			<button onclick="oncategory(0)" class="bbtn" type="button"> 전체보기 </button>
			<button onclick="oncategory(1)" class="bbtn" type="button"> 공지사항 </button>
			<button onclick="oncategory(2)" class="bbtn" type="button"> 자유게시판 </button>
			<button onclick="oncategory(3)" class="bbtn" type="button"> 노하우 </button>
		</div>

		
		<!-- 4. 테이블 구역 -->
		<table class="boardTable" >
			<!-- innerHTML -->
		</table>
		
		
		<div class="boardbottom">
			<!-- 5. 페이징처리 구역 -->
			<div class="pagebox">
				<!-- innerHTML -->
			</div>
			
			<!-- 6. 검색 구역 -->
			<div class="">
				<select class="bbtn key"> 
					<option value="b.btitle" > 제목</option>
					<option value="b.bcontent" > 내용 </option>
					<option value="m.mid" > 작성자</option>
				</select>
				<input onkeydown="enter()" class="keyword" type="text">
				<button onclick="onSearch()" class="bbtn" type="button"> 검색 </button>
			</div>
		</div>
		
	</div>
	
	
	<script src="list.js" type="text/javascript"></script>
	<!-- JSP 안에 다른 JSP를 포함하기 -->
	<%@include file="../footer.jsp" %>
	
</body>
</html>