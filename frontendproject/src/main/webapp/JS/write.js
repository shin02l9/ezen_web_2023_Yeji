
console.log('write.js 실행')

// 썸머노트를 사용할때 사용되는 코드
	$(document).ready(function() {
	  // $('#summernote').summernote( {설정객체} );
	  $('#summernote').summernote( { 
		lang : 'ko-KR', // 한글 적용 [ 한글.JS CDN 필요]  
		height : 500 , 
		placeholder : '여기에 내용작성'
	  });
	});

/*
	JS는 HTML에 포함된 문서, 그래서 HTML가 우선이다.
	1. 해당 HTML이 새로고침되거나 페이지 전환이 되면 JS도 재 호출이 된다. -> 메모리가 휘발된다는 의미
	2. 영구적인 저장은 서버에서 한다 ! [ 서버 = DB ]
	3. 임시로 브라우저에 저장할 수 있다. 1. 세선 / 2. 쿠키 (단점은 오픈이라 보안의 문제가 있음, 보안 필요없는 데이터만 사용!) -> JS 새로고침해도 유지된다.
		세션(서버PC) : 모든 브라우저가 꺼지면 초기화 된다.
		쿠키(사용자PC) : 모든 브라우저나 윈도우같은 운영체제가 꺼져도 유지가 된다.
		-> 사용 방법 = JS에서 객체 제공 = 키와 값으로 이루어진 객체 
			- 문자 타입으로 저장이 된다.
			sessionStorage : 세션
				sessionStorage.setItem('키',값)	: 해당 값을 '키'라는 이름으로 저장하는 것
				sessionStorage.getItem('키')		: 해당 키를 호출하면 저장된 값 호출 
				sessionStorage.clear()			: 삭제
			localStorage : 쿠키
				localStorage.setItem('키',값)
				localStorage.getItem('키')
				localStorage.clear()
*/

// 로그인제 게시판 [로그인 했다는 가정하에 임의로 로그인된 아이디를 변수에 저장]
let loginId = 'blue1234';

//1. 등록함수 [실행조건 : 등록버튼을 클릭했을때]
function onWrite(){ // f s 
	//1. 입력받은 값을 가져온다
	let title = document.querySelector('.title').value; console.log(title)
	let content = document.querySelector('#summernote').value; console.log(content)
	
	//유효성 검사 실행
	
	
	//2. 입력받은 값이 여러개면 객체화
	let board = {
		title : title ,			// 입력받은 값 넣기 
		content : content ,		// 입력받은 값 넣기 
		no : 1 ,				// 게시물 번호 [ 마지막게시물 +1 ]
		date : `${new Date().getFullYear()}-${new Date().getMonth()+1 }-${new Date().getDate() }` , // 게시물 작성일 [ 연도 , 월+1 , 일 ]
		view : 0 ,				// 게시물 조회수 기본값이 0 부터 시작 
		like : 0 , 				// 게시물 추천수는 기본값이 0 부터 시작 
		writer : loginId // 게시물 작성자 [ 로그인된 아이디 ]
	}
	console.log( board )
	
	//3. 해당 객체/변수를 배열에 저장한다.
		// 함수{}안에서 선언된 배열 : 자역변수
		// 함수{}밖에서 선언된 배열 : 전역변수
		// 세션(서버PC)/쿠키(사용자PC) : 브라우저 저장소 -> JS 새로고침해도 유지된다.
	sessionStorage.setItem('세션', 1 );	
	localStorage.setItem('쿠키', 2 );
	console.log (sessionStorage.getItem('세션'))
	console.log (localStorage.getItem('쿠키'))
	
	
}// f e
































