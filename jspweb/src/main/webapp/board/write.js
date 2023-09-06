
/* 썸머노트 실행 */
$(document).ready(function() {

   let option = { // 썸머노트 옵션관련 객체 만들기 
      lang : 'ko-KR' , 
      height : 500 , 
      placeholder : '여기에 내용작성'
   }
   
   $('#summernote').summernote( option );
  
});



// 1. 글쓰기 
function bwrite(){
	console.log('글쓰기 bwrite() 실행')
	//1. form 가져오기
	let form = document.querySelectorAll('.writeForm')[0];
	//2. form 객체화하기
	let formData = new FormData(form);
	//3. ajax으로 대용량 form 전송하기
	$.ajax({
		url : "/jspweb/BoardInfoController" ,
		method: "post" ,
		data : formData ,
		contentType : false ,
		processData : false ,
		success : r => { 
			console.log("bwrite() 통신성공"+r) 
			alert(' 글 등록 성공 ')
			location.href="/jspweb/board/list.jsp";
			} ,
		error : e => { 
			console.log("통신실패"+e) 
			alert(' 글 등록 실패 ')
			} ,
	})
}