/*

	이벤트함수
	HTML 에 이벤트 적용하는 방법
	1. 
		<태그 이벤트속성명 = "함수명()"> </태그명>
	2. 
		1. document.addEventListener(' 이벤트명 ', 함수명 ) 		 -> 기존 함수명 적용
		2. document.addEventListener(' 이벤트명 ', ()=>{} )		 -> 이견 화살표 함수 정의해서 적용
		3. document.addEventListener(' 이벤트명 ', function(){} ) -> 익명 함수 정의해서 작용
		
			document.addEventListener('이벤트명' , ( 이벤트결과인수=e )=>{ } )
		
	3. 이벤트
		이벤트명
		1. DONContentLoaded : HTML이 완전히 열렸을때 [모두 로드되었을때] 실해되는 이벤트
		2. window.onload	: 해당 객체가 호출되었을때 
		3. click			: 해당 객체를 클릭 했을때
		4. keyup			: 해당 객체에서 키보드를 누르고 떼어있을때
		5. keydown			: 해당 객체에서 키보드를 눌렀을때 
			- 키 상태 확인
 */

 //1. 
 let textbox = document.querySelector('.textbox')
 textbox.addEventListener('keyup', (event)=>{ console.log('키보드 입력하고 떼어있을때')
	let h3 = document.querySelector('.h3box')
	console.log ( textbox.value.length )
	h3.innerHTML = ` 입력된 문자 길이 : ${textbox.value.length}`;
	//1. 키상태 확인 => 키보드 제어도 가능 
	 console.log ( event );
	 console.log ( event.altKey );   // alt 눌렀는지
	 console.log ( event.ctrlKey );  // ctrl 눌렀는지
	 console.log ( event.shiftKey ); // shift 눌렀는지
	 console.log ( event.code );	 // 입력된 키보드의 코드 
	 console.log ( event.Key );		 // 
	 console.log ( event.KeyCode );  // 입력된 키보드의 코드 번호
	 
	 // 만약에 키보드에서 엔터를 눌렀을때
	 if( event.KeyCode == 13 ){alert ('엔터를 입력 했습니다.');}
 })