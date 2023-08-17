


console.log('JS 통신')


//1. 예제 ----------------------------------------------------------
function 예제1(){
	// ajax 메소드 이용한 서블릿과 통신
		// $.ajax({ });
	$.ajax({
		url : "/jspweb/test02",
		mathod : "get",
		success : function 함수명( result ){ console.log(result +'통신 성공 ')}
	});
} // f e
/*
	$.ajax({
		url : "통신할경로/서블릿주소",
		mathod : "통신방법:get,post,put,delete 중에 선택",
		success : function 함수명(통신반환변수){통신에 성공했을때 실행코드}
		error : function 함수명(통신반환변수){통신에 실패했을때 실행코드}
	})
	
	- 1. success(성공했을때)/error(실패했을때) 속성에서 툥신결과의 반환함수 작성시 함수 시 유형 3가지
		1. success : function 함수명(통신반환변수){통신에 성공했을때 실행코드}
		2. success : function(통신반환변수){통신에 성공했을때 실행코드}
		3. success : (통신반환변수) => {통신에 성공했을때 실행코드}
	-----------------------------------------
	서블릿 
		response : 요청 객체
		request  : 응답 객체
			response.getWriter().print(데이터);
				웹출력 = 응답데이터
			response.setCharacterEncoding("UTF-8");
			response.setContentType(" 전송데이터의타입명; 인코딩타입명");
				출력할 데이터의 타입 혹은 인코딩
				-1. 문자전송 [defult]
					response.setContentType("text/html;charset=UTF-8");
				-2. JSON 전송
					response.setContentType("application/json;charset=UTF-8");
*/

//2. 예제 ----------------------------------------------------------
function 예제2(){
	// ajax 메소드 이용한 서블릿과 통신
		// $.ajax({ });
	$.ajax({
		url : "/jspweb/test03",
		mathod : "get",
		success : function 함수명( result ){ console.log(result +'통신 성공 ')}
	});
}  // f e

//3. 예제 ----------------------------------------------------------
function 예제3(){
	// ajax 메소드 이용한 서블릿과 통신
		// $.ajax({ });
	$.ajax({
		url : "/jspweb/test04",
		mathod : "get",
		success : function 함수명( result ){ console.log(result);
		console.log( result.title );console.log( result.content );
			}
	});
}  // f e

//4. 예제 ----------------------------------------------------------
function 예제4(){
	// ajax 메소드 이용한 서블릿과 통신
		// $.ajax({ });
	$.ajax({
		url : "/jspweb/test05",
		mathod : "get",
		success : function 함수명( result ){ console.log(result);
		console.log( result.title );console.log( result.content );
		}
	});
}  // f e