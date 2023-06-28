console.log ('JS 실행')

let 글 = []

// 글 등록 함수 만들기 
function 등록(){
	console.log (' 등록 함수 실행 ')
	// 입력값 받아오기
	let user = document.querySelector('.write_user').value
	let pw = document.querySelector('.write_pw').value
	let title = document.querySelector('.write_title').value
	let body = document.querySelector('.write_body').value
	
		//유효성 검사 1
 		if( user == '' || pw == ''){
			alert('[등록실패] 작성자명과 비밀번호를 모두 입력해주세요.')
			return;
		 }
		//유효성 검사 2
		if( pw.length < 4 ){
			alert('[등록실패] 비밀번호를 4글자 이상 입력해주세요.')
			return;
		 }
	
	// 객체에 저장하기
	let content = { 작성자 : user, 비밀번호 : pw, 제목 : title, 내용 : body }
	
	// 글 배열에 저장하기
	글.push(content); 
	
	// 입력칸에 값 초기화하기 
	document.querySelector('.write_user').value = ''
	document.querySelector('.write_pw').value = ''
	document.querySelector('.write_title').value = ''
	document.querySelector('.write_body').value = ''
	
	출력()
	
}


// 저장된 글 정보를 목록 페이지(HTML)에 출력
function 출력(){
	
	console.log ('출력함수 실행')
	// 어디에 출력 할것인지
	let list_table = document.querySelector('.list_table')
	
	let HTML = `<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>`;
				
		// 글 배열안에 있는 객체에서 데이터 찾아오기
		for ( let i = 0; i < 글.length ;  i++ ){
		HTML += `<tr>
					<td> 번호 </td>
					<td> ${글[i].제목} </td>
					<td> ${글[i].작성자} </td>
					<td> 날짜 </td>
					<td> 조회수 </td>
				</tr>`;
		}
		
	// table 에 HTML 넣어주기 <table> </table>의 안에 !!
	list_table.innerHTML = HTML;
 }
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 