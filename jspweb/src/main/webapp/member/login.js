
//1. 로그인 함수
function login(){
	console.log('login() 실행')
	
	// 1. 입력받은 아이디와 비밀번호 가져온다.
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	console.log(mid)
	console.log(mpwd)
	
	// 2. ajax 에게 전달해서 회원이 존재 하는지 반환 받는다.
		// 2-1. 로그인 성공시 메인페이지로 이동한다.
		//			  실패시 실패 알림 'logincheckbox'
		$.ajax({
			url : "/jspweb/MemberFindController",
			method : "post", // 개인정보가 있을땐 무조건 post 메소드 써야함, get은 보안에 취약함
			data : { mid : mid, mpwd : mpwd } ,
			success : function f(r){ 
				console.log(r) 
				if(r){
					location.href ='/jspweb/index.jsp';
				} else {
					document.querySelector('.logincheckbox').innerHTML = `동일한 회원정보가 없습니다.`;
				}
				
				
				
				} ,
			error : function f(r){ console.log(r) }
		})
			
	
}