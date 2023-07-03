/*
 */

 
 //1. 조작, 제어할 HTML 태그[DOM객체]를 호출
 let userbox = document.querySelector('.userbox');
 // 어떻게 : 현재 페이지(전체)에서 키보드를 누를때 
 	// DOM객체명.addEventListener('이벤트명', ()=>{})
 document.body.addEventListener('keydown', (e)=>{
	 console.log('키눌림')
	 //1. 눌린 키 상태 확인 .keyCode
	 console.log(e)
	 
	 if( e.keyCode == 37 ){
		 console.log("왼쪽으로 이동"); // css left 차감
		 userbox.style.left--;
	 }else if ( e.keyCode == 39 ){
		 console.log ("오른쪽으로 이동"); //css left 증가
		 userbox.style.left++;
	 }
	 console.log (userbox.style.left);
 })
 