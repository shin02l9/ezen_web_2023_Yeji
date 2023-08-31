console.log(' info js 실행 ')


getInfo();
//1. 로그인된 회원정보 호출
function getInfo(){
	$.ajax({
		url : "/jspweb/MemberInfo",
		method : "get",
		data : { type: "info"} ,
		success : function f(r){
			if (r == null){ // 비로그인
				alert('회원전용 페이지 입니다. 로그인페이지로 이동합니다.');
				location.href="/jspweb/member/login.jsp";
			} else { // 로그인 -> 마이페이지 구역에 정보 넣어주기
				document.querySelector('.preimg').src=`img/${r.mimg}`;
				document.querySelector('.mid').innerHTML = r.mid;
				document.querySelector('.memail').innerHTML = r.memail;
			}
		} ,
		error : function f(r){
		}
	})
}

//2. 수정
function mUpDate(){
	console.log(' mUpDate() 실행')
	// 첨부파일 전송할때.
		// 1. form 가져오기
	let form = document.querySelectorAll(".signupForm")[0]; 
	console.log( form );
		// 2. form 데이터 객체화 하기
	let formdata =new FormData( form ); 
	console.log( formdata );
	// * form 전송 ajax 
	$.ajax({
		url : "/jspweb/MemberInfo" ,
		method: "put" ,
		data : formdata ,
		// 폼 전송 타입은 일반적으로 문자가 아니다, json도 아님! multipart/form-data
		/*
			HTTP 전송 타입
				1. text/html			: 문자타입
				2. application			: json타입
				3. multipart/form-data 	: 대용량 form 전송타입
		*/
		contentType : false ,
		processData : false ,
		success : r => { console.log(r) 
			if(r){
				alert('수정 성공');
				logout();
			} else {
				alert('수정 실패');
			}
		} ,
		error : e => { console.log(e) } ,
	})
}

//3. 삭제
function mDelete(){
	// 1. 탈퇴여부 확인 confirm 확인/취소 버튼 알림창
	let dconfirm = confirm('정말 삭제하시겠습니까?')
	// 2. 확인 버튼을 눌렀을때
	if( dconfirm == true ){
		let mpwd = prompt('비밀번호 확인');
		// 3. ajax 입력받은 비밀번호와 로그인된 회원번호의 비밀번호와 일치하면 탈퇴가능
		$.ajax({
			url : "/jspweb/MemberInfo",
			method : "delete",
			data : { mpwd : mpwd } ,
			success : function f(r){
				if(r){
					alert('회원탈퇴 했습니다.')
					logout();
				} else {
					alert('비밀번호가 일치하지 않습니다.')
				}
			} ,
			error : function f(r){}
		})
	}
}