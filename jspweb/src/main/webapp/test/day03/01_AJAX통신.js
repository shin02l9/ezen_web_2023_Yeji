

console.log('01_AJAX.JS 연결')


function 예제1(){
	$.ajax({
		url : "/jspweb/test06",
		data : { 'value1':'반갑다.'},
		mathod : "get",
		success : function 함수명(r){
			console.log('서블릿이 응답한 내용 : '+r);
		},
	})
	
	
}// 예제1 f e

function 예제2(){
	// 1. 입력 받은 데이터를 가져온다.
	let nameData = document.querySelector('.name').value;
	let ageData = document.querySelector('.age').value;
	
	// 2. 객체화
	let info = {
		name : nameData,
		age : ageData
	}
	
	// 3. 서블렛에게 전달
	$.ajax({
		url : "/jspweb/test07",
		data : info,
		mathod : "get",
		success : function 함수명(r){
			console.log('통신 성공');
		},
	})
	
	
}// 예제2 f e







/*	
	$.ajax({
		url : "통신할경로/서블릿주소", <- 문자처리해야함
		data : {보내는 데이터},
		mathod : "통신방법:get,post,put,delete 중에 선택", <- 문자처리해야함
		success : function 함수명(통신반환변수){통신에 성공했을때 실행코드},
								통신반환변수로 응답 매개변수 받기
		error : function 함수명(통신반환변수){통신에 실패했을때 실행코드}
								통신반환변수로 실패사유를 매개변수 받기
	})
*/