console.log(' Js 통신 도착 ')

function 예제1(){
	console.log(' 예제1 실행 ')
	
	//https://jsonplaceholder.typicode.com/posts
	//외부사이트에 JSON 데이터 통신
	//AJAX [에이젝스 or 아작트] : JQUERY 라는 라이브러리에서 통신HTTP 함수 제공
		// JQUERY 란 JS언어로 여러개 함수를 제공하는 라이브러리 집합소이다.
	
	/*
	
	AJAX [에이젝스 or 아작트] : JQUERY 라는 라이브러리에서 통신HTTP 함수 제공
		- JQUERY 란 JS언어로 여러개 함수를 제공하는 라이브러리 집합소이다.
		1. 정의 : JS 언어에서 외부와 통신 하는 목적
		2. 형태 : $.ajax({});
		3. 필수! JQUERY 라이브러리 호출
			<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
			- is not defined : JQUERY 라이브러리 추가 안했을때 뜨는 오류
		4. 매개변수 : 객체 {속성 : 값, 속성 : 값, 속성 : 값}
			<속성>
			1. URL 속성 			: 통신할 대상/링크/주소
			2. HTTP 의 통신 메소드 : get, post, put, delete 등등 [rest = CRUD]
			3. success 결과속성	: 통신을 성공 했을때 반환된 데이터를 함수의 매개변수로 반환 받음
			
		
		   $.ajax( { 
		      url : ""  ,    // 1. 통신할 경로
		      method : "",   // 2. 통신할 HTTP 메소드 방식 
		      success : function 결과( result ){ console.log(result); }   // 3. 통신을 성공했을때 반환된 데이터
		   });
	*/
	
	$.ajax({
		url : "https://jsonplaceholder.typicode.com/posts", // 1. 통신할 경로
		method : "get",										// 2. 통신할 HTTP 메소드 방식
		success : function 결과( result ){console.log(result);}	// 3. 통신을 성공 했을때 반환된 데이터
		//success : ( ) => {console.log(result)}			// 가능
		});
}


function 예제2(){
	console.log(' 예제2 실행 ')
	$.ajax({
		url : "/jspweb/Test01",
		method : "get",										
		success : function 결과( result ){console.log(result);}			
		});
}