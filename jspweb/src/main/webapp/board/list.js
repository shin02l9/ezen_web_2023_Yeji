console.log('list JS 실행')

// 1. 글쓰기 버튼을 클릭하면
function onWrite(){
	if(loginstate){
		location.href="write.jsp";
	} else {
		alert('로그인 후 사용 가능합니다.')
		location.href="/jspweb/member/login.jsp";
	}
}


//2. 글쓰기 
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
			console.log("통신성공"+r) 
			alert(' 글 등록 성공 ')
			location.href="/jspweb/board/list.jsp";
			} ,
		error : e => { 
			console.log("통신실패"+e) 
			alert(' 글 등록 실패 ')
			} ,
	})
}