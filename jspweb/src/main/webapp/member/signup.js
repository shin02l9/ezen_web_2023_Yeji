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

