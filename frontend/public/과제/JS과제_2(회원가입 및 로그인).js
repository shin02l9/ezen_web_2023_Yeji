/* 비어 있는 배열 선언 */
let id = []
let pw = []

/* 회원가입 함수 */
function 회원가입(){
	/* 입력값 받아오기 */
	let id_input = document.querySelector(".id")
	let pw_input = document.querySelector(".pw")
	
	/* 입력받은 데이터를 저장하는 과정 */
	let id0 = id_input.value
	let pw0 = pw_input.value
	
	/* 유효성 검사*/
	if (id.indexOf(id0) == -1 ) {
		id.push (id0)
		pw.push (pw0)
		console.log ('회원가입 되었습니다.') 
		alert('회원가입 되었습니다.');
	} 
	else {
		console.log (' 이미 존재하는 아이디 입니다.') 
		alert (' 이미 존재하는 아이디 입니다.');
	}

	/* 콘솔창에 출력 */
	console.log(id)
	console.log(pw)
	
	/* 데이터 저장 이후 <input> 객체안의 입력값 초기화 */
	id_input.value = ''
	pw_input.value = ''
}

/* 로그인 함수*/
function 로그인(){
	/* 입력값 받아오기 */
	let id_input = document.querySelector(".id")
	let pw_input = document.querySelector(".pw")
	
	/* 입력받은 데이터를 저장하는 과정 */
	let id0 = id_input.value
	let pw0 = pw_input.value
	
	/* 유효성 검사*/
	if (id.indexOf(id0) != -1 ){
		if (pw.indexOf (pw0 != -1)){
		console.log (' 로그인 성공.') 
		alert (' 로그인 성공.');
		}
	} else {
		console.log ('로그인 실패 (회원정보가 없습니다.)') 
		alert('로그인 실패 (회원정보가 없습니다.)');
	}
	
	
	/* 콘솔창에 출력 */
	console.log(id)
	console.log(pw)
	
	/* 데이터 저장 이후 <input> 객체안의 입력값 초기화 */
	id_input.value = ''
	pw_input.value = ''
}
