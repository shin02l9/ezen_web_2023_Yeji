console.log(' signup JS 실행 ')


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
		success : r => {console.log('통신성공')},
		error: e => {console.log('통신실패')}
	});
	
}