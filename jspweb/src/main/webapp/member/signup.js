console.log(' signup JS 실행 ')


/*
	정규표현식 : 문자열에 특정 규칙/패턴 집합 표현 할때 사용되는 언어
		문법
			/^ 		: 정규 표현식의 시작을 알림.
			$/ 		: 정규 표현식의 끝을 알림.
			[a-z]	: 소문자 a-z 패턴
			[A-Z]	: 대문자 A-Z 패턴
			[0-9]	: 숫자 0-9 패턴
			[가-힣]	: 한글 패턴
			{ 최소길이, 최대길이 } : 문자열 길이 패턴
			
			
			예시]
			1. [a-z]			: 소문자 검색
			2. [a-zA-Z]			: 영문[대,소] 모두 검색
			3. [a-zA-Z0-9]		: 영문 + 숫자 조합 검색
			4. [a-zA-Z0-9가-힣]	: 영문 + 숫자 + 한글까지 검색
			5. [ac]				: a와 c 가 포함된 패턴
			6. /^ [a-z0-9]{ 5, 30 } $/  :  5~30글자사이 이면서 영문[소]과 숫자의 조합
			
			
		패턴 검사
			"패턴".test( 검사 데이터 ) : 해당 데이터가 패턴에 일치하면 true / 아니면 fales 반환

*/
// 아이디 유효성 검사
//function idcheck(){ // 포커스가 바뀌었을때 실행된다. 
//function idkeyup(){ // 키보드에서 키을 누르고 떼어냈을때 실행되는 이벤트이다.
function idkeydown(){ // 키를 누를때마다 실행된다.
	console.log('idkeydown() 실행');
	
	// 1. 값 가져오기
	let mid = document.querySelector('.mid').value;
	// innerHTML 출력을 위한 지역변수
	let idcheckbox = document.querySelector('.idcheckbox')
	
	// 2. 유효성 검사
	//if( mid.length < 5 && mid.length >= 30 ){
		
	// 이제는 정규표현식을 사용해서 유효성 검사를 할 것임!
	// 5~30글자사이 이면서 영문[소]과 숫자의 조합
		// 1. 정규표현식 작성
		let midj = /^[a-z0-9]{5,30}$/ 
		// 2. 정규표현식 검사
		console.log(midj.test(mid));
		

	if(midj.test(mid)){
		// 아이디가 패턴과 일치하면 중복검사 실시하기
		$.ajax({
			url : "/jspweb/MemberFindController",
			method : "get",
			data : mid,
			success : r => {
				// 3. 결과 출력
				console.log(' 통신성공 ')
				if( r ){
					idcheckbox.innerHTML = `사용중인 아이디입니다.<br/>`;	
				} else {
					idcheckbox.innerHTML = `사용가능한 아이디입니다.<br/>`;
				}
			},
			error : r => {
				console.log(' 통신실패 ')
			}
		});
	} else {
		idcheckbox.innerHTML = `영문(소문자)+숫자 조합의 5~30글자 사용가능합니다.<br/>`;
	}
}
// 2. 비밀번호 유효성검사 [ 1.정규표현식 검사 2. 비밀번호 와 비밀번호 확인 일치여부 ]
function pwcheck(){	console.log('패스워드 입력중');
	let pwcheckbox = document.querySelector('.pwcheckbox')
	// 1. 입력 값 호출 
	let mpwd = document.querySelector('.mpwd').value; 					console.log('mpwd : ' + mpwd);	
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;		console.log('mpwdconfirm : ' + mpwdconfirm);	
	
	// 2. 유효성검사 
		// 1. 정규표현식 만들기 [ 영대소문자(1개필수) + 숫자(1개필수) 조합 5~20글자 사이 ]
		// let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
		let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
		
		if( mpwdj.test( mpwd ) ){  // 1.비밀번호 정규표현식 검사 
			// 2.비밀번호 확인 정규표현식 검사 
			if( mpwdj.test( mpwdconfirm) ){
				// 3. 비밀번호 와 비밀번호 확인 일치여부
				if( mpwd == mpwdconfirm ){
					pwcheckbox.innerHTML = `사용가능한 비밀번호`;
				}else{
					pwcheckbox.innerHTML = `비밀번호가 일치하지 않습니다.`;
				}
			}else{
				pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`
			}
		}else{
			pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`
		}
} // f end 

// 3. 이메일 유효성검사 [ 1. 정규표현식 2. 중복검사 ]
function emailcheck(){
	let emailcheckbox = document.querySelector('.emailcheckbox');
	let authReqBtn = document.querySelector('.authReqBtn');
	// 1. 입력된 값 호출 
	let memail = document.querySelector('.memail').value 
	// 2. 이메일 정규표현식 [  영대소문자,숫자,_-  @  ]
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/
	// 3. 유효성검사 
	if( memailj.test( memail) ) {
		$.ajax({
			url : "/jspweb/MemberFindController" , 
			method : "get" , 
			// *type 사용하는 이유 : 서로 다른 ajax가 동일한 서블릿과 동일한 get메소드 사용할때.
			data :  { type : "memail" , data : memail }, // : 이메일 중복검사
			// data :  { type : "mid" , data : mid }, : 아이디 중복검사  
			success : r => {  
				if( r ){
					emailcheckbox.innerHTML =`사용중인 이메일입니다.`;
					authReqBtn.disabled = true; // 해당 버튼의 disabled 속성 적용
				}else{
					emailcheckbox.innerHTML =`사용가능한 이메일입니다.`;
					authReqBtn.disabled = false; // 해당 버튼의 disabled 속성 해제 
				}
			} ,
			error : r => { console.log(r); } 
		})
	}else{
		emailcheckbox.innerHTML = `이메일형식에 맞게 입력해주세요.`;
		authReqBtn.disabled = true; // 해당 버튼의 disabled 속성 적용
	}
} // f end 

// 4. 인증요청 버튼을 눌렀을때.
function authReq(){ console.log('인증요청');
	// 1. 'authbox' div 호출 
	let authbox = document.querySelector('.authbox')
	
	// 2. auth html 구성 
	let html = `<span class="timebox">02:00</span>
				<input class="ecode" type="text" /> 
				<button onclick="auth()" type="button">인증</button> `
	// 3. auth html 대입 
	authbox.innerHTML = html;
	// 4. 타이머 실행
	authcode = '1234';  // [ 테스트용 ] 임의로 인증 코드를 '1234'
	timer = 10; 		// [ 테스트용 ] 인증 제한시간 10초 
	settimer();			// 타이머 실행 
} // f end 

// 4번,5번,6번 함수에서 공통적으로 사용할 변수[전역변수]
let authcode = ''; 	// 인증코드 
let timer = 0; 		// 인증 시간(초) 변수 
let timerInter; 	// setInterval() 함수를 가지고 있는 변수 [ setInterval 종료시 필요. ]

// 5. 타이머 함수 만들기 
function settimer(){
	timerInter = setInterval( () => {
		// 시간 형식 만들기 
			// 1. 분 만들기 [ 초 / 60 ] => 분  /  [ 초 % 60 ] => 나머지 초
		let m = parseInt( timer / 60 ); // 분 계산 [ 몫 ] 
		let s = parseInt( timer % 60 ); ; // 초 계산 [ 나머지 ]
			// 2. 두자리수 맞춤  3 -> 03 
		m = m < 10 ? "0"+m : m; // 만약에 분 이 10보다 작으면 한자리수 이므로 0 붙이고 아니면 
		s = s < 10 ? "0"+s : s; 
		
		document.querySelector('.timebox').innerHTML = `${m}:${s}`; // 현재 인증 시간(초) HTML 대입
		timer--; // 1씩 차감
		
		// 만약에 타이머가 0 보다 작으면 [ 시간 끝 ]
		if( timer < 0 ){ 
			// 1. setInterval 종료 [ 누구를 종료할건지 식별자.. 변수 선언 = timerInter ]
			clearInterval( timerInter )
			// 2. 인증실패 알림
			document.querySelector('.emailcheckbox').innerHTML =`인증실패`;
			// 3. authbox 구역 HTML 초기화 
			document.querySelector('.authbox').innerHTML=``;
		}
	} , 1000 ); // 1초에 한번씩 실행되는 함수
} // f end 

// 6. 인증요청후 인증코드를 입력하고 인증하는 함수
function auth(){ console.log('auth() open')
	// 1. 입력받은 인증코드
	let ecode = document.querySelector('.ecode').value;
	// 2. 비교[ 인증코드 와 입력받은 인증코드 ]
	if( authcode == ecode ){
		clearInterval( timerInter ); // 1. setInterval 종료
		document.querySelector('.emailcheckbox').innerHTML =`인증성공`; // 2. 인증성공 알림
		document.querySelector('.authbox').innerHTML=``; // 3. authbox 구역 HTML 초기화 
	}else{
		// 1. 인증코드 불일치 알림
		document.querySelector('.emailcheckbox').innerHTML =`인증코드 불일치`;
	}
} // f end 



function signup(){
	// 1. 필요한 값을 가져오기
	let midInput = document.querySelector('.mid');
	let mpwInput = document.querySelector('.mpw');
	let mpwconfirmInput = document.querySelector('.mpwconfirm');
	let memailInput = document.querySelector('.memail');
	let mimgInput = document.querySelector('.mimg');

	// 2. 객체화하기
	let data = {
		mid : midInput.value,
		mpw : mpwInput.value,
		memail : memailInput.value,
		mimg : mimgInput.value
	}
	
	// 3. 유효성 검사
	
	// 4. 서블릿과 통신
	$.ajax({
		url : "/jspweb/MemberInfo",
		method : "post",
		data : data,
		success : r => {
			console.log('통신 성공')
			if( r == true ){
				console.log(' 회원가입 성공 ')
			} else { 
				console.log(' 회원가입 실패 ')
			}
		},
		error: e => {console.log('통신실패')}
	});
}

/*

	setInterval() : 특정시간마다 함수를 실행 함수 
		1. 정의
			let 변수명 = setInterval( functuon 함수명(){ } , 밀리초 )
			let 변수명 = setInterval( functuon (){ } , 밀리초 )
			let 변수명 = setInterval( 함수명() , 밀리초 )
			let 변수명 = setInterval( () => { } , 밀리초 )
		2. 종료
			clearInterval( setInterval변수명 )

*/
