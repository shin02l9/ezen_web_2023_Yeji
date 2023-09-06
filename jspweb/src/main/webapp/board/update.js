

// 쿼리스트링 ( URL 주소상에 매개변수 )가져오기
let bno = new URL(location.href).searchParams.get("bno");
		console.log('bno : '+bno);
		
getBoard();

// 1. 수정할 게시물의 기존정보 보여주기
function getBoard(){

	$.ajax({
		url : "/jspweb/BoardInfoController",
		method : "get",
		data : { type : 2, bno : bno } ,
		success : function f(r){
			console.log("통신성공"+r)
			
			// 응답결과 HTML에 뿌려주기 
			document.querySelector('.bcno').value = `${r.bcno}`;
			document.querySelector('.btitle').value = `${r.btitle}`;
			document.querySelector('.bcontent').innerHTML = `${r.bcontent}`;
			if( r.bfile != null ){
				document.querySelector('.oldfile').innerHTML = `
				<img src ="/jspweb/board/upload/${r.bfile}" />`;
			} else {
				document.querySelector('.oldfile').innerHTML = `
				<img src ="/jspweb/member/img/default.webp" />`;
			}
			/* 썸머노트 실행 */
			$(document).ready(function() {
			
			   let option = { // 썸머노트 옵션관련 객체 만들기 
			      lang : 'ko-KR' , 
			      height : 500 , 
			      placeholder : '여기에 내용작성'
			   }
			   
			   $('#summernote').summernote( option );
			  
			});

			
			
		} ,
		error : function f(e){
			console.log("통신실패"+e)
		}
	})
	
}

function onUpdate(){
	console.log('글수정등록하기 onUpdate() 실행')
	//1. 수정된 입력값들 form 가져오기
	let form = document.querySelectorAll('.writeForm')[0];
	//2. form 객체화하기
	let formData = new FormData(form);
		//* form객체에 bno 추가하기 
		formData.set("bno",bno)
	//3. ajax으로 대용량 form 전송하기
	$.ajax({
		url : "/jspweb/BoardInfoController" ,
		method: "put" ,
		data : formData ,
		contentType : false ,
		processData : false ,
		success : r => { 
			console.log("onUpdate() 통신성공"+r) 
			if( r ){
				alert(' 글 수정 성공 ')
				location.href=`/jspweb/board/view.jsp?bno=${bno}`;
			} else {
				alert(' 글 수정 실패 ')
			}
			} ,
		error : e => { 
			console.log("통신실패"+e) 
			} ,
	})
}