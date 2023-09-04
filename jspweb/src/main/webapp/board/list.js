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


// 2. 모든글 조회
getlist();
function getlist(){
	$.ajax({
		url : "/jspweb/BoardInfoController",
		method : "get",
		data : {} ,
		success : function f(r){
			console.log("getlist() 통신성공"+r) 
			if ( r != null ){
				// 출력할 내용 구성
				let boardTable = document.querySelector('.boardTable');
				let HTML = `<tr>
								<th> 번호 </th>
								<th> 카테고리 </th>
								<th> 제목 </th>
								<th> 작성자 </th>
								<th> 조회수 </th>
								<th> 작성일 </th>
							</tr>`;
				// 반복해서 HTML 출력하기
				// 배열명.forEach( 변수명아무거나 => { 실행 코드 }) 

				r.forEach( b => {
					HTML += `<tr>
								<th> ${b.bno} </th>
								<th> ${b.bcno} </th>
								<th> ${b.btitle} </th>
								<th> ${b.mid} / <img class="hmimg" src="/jspweb/member/img/${b.mimg}"/></th> 
								<th> ${b.bview} </th>
								<th> ${b.bdate} </th>
							</tr>`;
					console.log('b.mimg : '+b.mimg)
				})
				boardTable.innerHTML = HTML;
			}
		} ,
		error : function f(r){}
	})
}





// ------------------------------------------------------------------
//1. 글쓰기 
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