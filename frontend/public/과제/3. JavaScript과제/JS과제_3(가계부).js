/* 배열 선언하기 */
let 날짜 = [];
let 항목 = [];
let 금액 = [];

function 추가함수(){ // 추가 버튼 함수 시작
	console.log('추가함수 실행');
	/* 입력값 받아오기 */
	let dateInput = document.querySelector(".date")
	let itemInput = document.querySelector(".item")
	let priceInput = document.querySelector(".price")
	/* 입력값 배열에 저장하기 */
	날짜.push(dateInput.value)
	항목.push(itemInput.value)
	금액.push(priceInput.value)

	/* 배열에 추가 되었는지 확인하기 */
	console.log(날짜);
	console.log(항목);
	console.log(금액);
	
	/* 현재 입력된 값 초기화 */
	dateInput.value = ''
	itemInput.value = ''
	priceInput.value = ''
	
	// 이제 추가된 배열의 데이터를 테이블에 출력 해야함...감이 안잡힌다...
	
	let tableHTML =	list_table.innerHTML
		
	for ( let i = 0; i < 날짜.length ;  i++ ){
			tableHTML += `<tr><td>${날짜[i]}</td><td></td><td></td><td></td></tr>`
	}
	for ( let i = 0; i < 항목.length ;  i++ ){
			tableHTML += `<tr><td></td><td>${항목[i]}</td><td></td><td></td></tr>`
	}
	for ( let i = 0; i < 금액.length ;  i++ ){
			tableHTML += `<tr><td></td><td></td><td>${금액[i]}</td><td></td></tr>`
	}
	
		console.log ( tableHTML );

} // 추가 버튼 함수 끝



function 삭제함수(){ // 삭제 버튼 함수 시작
	

}



		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 