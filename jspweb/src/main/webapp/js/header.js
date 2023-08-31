
console.log('header js 실행')

//1. 현재 로그인 된 회원정보 요청
getMemberInfo();
function getMemberInfo(){
	// 1. ajax를 이용한 서블릿 세션 정보 가져오기
	$.ajax({
		url : "/jspweb/MemberInfo",
		method : "get",
		data : { type: "info" } ,
		success : function f(r){
			console.log(r)
			
			let submenu = document.querySelector('.submenu');
			let HTML = ``;
			if(r==null){ // 비로그인
				HTML += `
				<li> <a href="/jspweb/member/signup.jsp"> 회원가입 </a></li>
				<li> <a href="/jspweb/member/login.jsp"> 로그인 </a></li>
				`;
			} else{ // 로그인
				HTML += `
				<li> ${r.mid} 님 </li>
				<li> <img class="hmimg" src="/jspweb/member/img/${r.mimg}"/></li>
				<li> <a href="/jspweb/member/info.jsp"> 마이페이지 </a></li>
				<li> <a onclick="logout()" href="#"> 로그아웃 </a></li>
				`;	
			}
			submenu.innerHTML = HTML;
		} ,
		error : function f(r){}
	})
	
}// f end

//2. 로그아웃 함수 [ 서블릿에 세션을 삭제, 그리고 로그아웃 성공시 메인 페이지로 이동 ]
function logout(){
	console.log('output')
	$.ajax({
		url : "/jspweb/MemberInfo",
		method : "get",
		data : { type: "logout" } ,
		success : function f(r){
			alert('로그아웃 되었습니다.')
			location.href="/jspweb/index.jsp";
			
		} ,
		error : function f(r){console.log('logout 에러 : ' + r)}
	})
	
	
	
}// f end