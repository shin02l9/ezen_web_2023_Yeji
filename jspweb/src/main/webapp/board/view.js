/*
	< 쿼리스트링 방식 >
	HTTP URL에 매개변수(파라미터) 전달
		- 정의 : 페이지 전환시 매개변수(PK, 식별키) 전달
		- 형태
			URL?변수명=데이터 
			URL?변수명=데이터&변수명=데이터
			http://localhost/jspweb/board/view.jsp?bno=3
		- 스크립트에서 URL의 매개변수를 호출하는 방법
			new URL(location.href).searchParams.get("매개변수명");
		
*/

// 1. list.jsp에서 클릭된 제목의 bno를 전달받아 게시물 1개 가지고 오기 
getBoard();
function getBoard(){
	// 1. URL에 있는 매개변수(쿼리스트링) 가지고 오기
							// 현재 주소상의 매개변수 가지고 오기 
	let urlParams = new URL(location.href).searchParams;
		console.log(urlParams)
	let bno = urlParams.get("bno"); // url 주소에서 bno데이터 가져오기 
	// new URL(location.href).searchParams.get("매개변수명");
		console.log("클릭된 bno : "+bno)
	
	
	// 2. ajax 이용한 bno 전달해서 게시물의 상세 정보를 모두 가져오기
	$.ajax({
		url : "/jspweb/BoardInfoController",
		method : "get",
		data : { type : 2, bno : bno } ,
		success : function f(r){
			console.log(r) 
				console.log("ishost : "+ r.host)
			// 출력할 내용 구성
			let boardBox = document.querySelector('.boardBox');
			let HTML = `부가정보1 : <div> 
									${r.bcname}, 
									${r.bview}, 
									${r.bdate} 
								  </div>
						부가정보2 : <div> 
									${r.mid}, 
									${r.mimg} 
								  </div>
						제목 : <div> ${r.btitle} </div>
						내용 : <div> ${r.bcontent} </div>
						첨부파일 : <div> ${r.bfile} </div>
						`;		
			if ( r.host ){
				HTML += `<button onclick="onUpdate(${bno})" type="button"> 수정 </button>
						 <button onclick="onDelete(${bno})" type="button"> 삭제 </button>`;
			}
			boardBox.innerHTML = HTML;	
		} ,
		error : function f(e){
			console.log("getBoard() 통신실패"+e)
		}
	})
}


// 2. 게시물 삭제
function onDelete( bno ){

	$.ajax({
		url : "/jspweb/BoardInfoController",
		method : "delete",
		data : { bno : bno } ,
		success : function f(r){
			console.log("onDelete() 통신성공"+r)
			if( r ){
				alert('게시물 삭제 성공')
				location.href = `/jspweb/board/list.jsp`;
			} else {
				alert('게시물 삭제 실패')
			}
			
		} ,
		error : function f(e){
			console.log("onDelete() 통신실패"+e)
		}
	})
	
}



// 3. 게시물 수정
function onUpdate( bno ){
	location.href = `/jspweb/board/update.jsp?bno=${bno}`;

}