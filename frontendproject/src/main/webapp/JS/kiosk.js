console.log ('kiosk JS 열림')

//1. 광고 이미지 변경 --------------------------------------------------------------------

	//1. 광고 이미지를 저장하고 있는 = 배열
let bimgList = ['himg1.png','himg2.png','himg3.jpg','himg4.png','himg5.png']
	//2. 특정 시간마다 이미지의 src 변경하기
		// -setInterval ( 함수, 밀리초 ) : 1/1000초
		//1. function 함수(){}   2. function (){}   3. ()=>{}
			//setInterval(()=>{ 실행코드 }, 2000); // 2초마다 실행코드 추기적으로 실행 ! 
			
let viewimg = 0; // 현재 보고 있는 광고 이미지 인덱스 저장하고 있는 변수
setInterval(()=>{ 
	//1. 어디에
	let himg = document.querySelector('.himg');
	//2. 호출된 객체에서 src 라는 속성 대입/ 바꿔치기
		// 배열내 이미지 하나씩 바꿔 가면서 대입하기 
		viewimg++; // 인덱스 증가 시켜서 다음 이미지로 변경 
	// 마지막 인덱스 다음이면 처음으로 돌아가기 
	if( viewimg >= bimgList.length) { viewimg = 0; }
	himg.src = `../img/${bimgList[viewimg]}`;
 }, 2000);

//2. 카테고리 출력 함수 --------------------------------------------------------------------

	//1. 카테고리 여러개 저장하는 배열
let categoryList = ['신제품(new)','프리미엄','와퍼&주니어','치킨&슈림프버거','올데이킹&킹모닝']

	//2. 카테고리 출력하는 함수 정의 [실행 조건 : 페이지 열렸을 때]
categoryPrint(0); // 0 넣어줘야만 첫 실행 가능 !!!!!!!!!!!!
function categoryPrint( selectNo ){
	
	//1. 어디에
	let categorymenu = document.querySelector('.categorymenu')
	//2. 무엇을
	let html = ``;
		//HTML 구성 : 배열내 모든 데이터(for문 사용)를 li형식으로 출력
	for ( let i = 0; i<categoryList.length; i++){
		if( i == selectNo ){ html += `<li onclick="categoryselect(${i})" class="categoryselect"> ${categoryList[i]} </li>`;} // += 누적으로 출력 
		else { html += `<li onclick="categoryselect(${i})"> ${categoryList[i]} </li>`;}
	}
	
	//3. 구성된 HTML 출력
	categorymenu.innerHTML = html;
}

//3. 카테고리 선택 클릭 함수 --------------------------------------------------------------------
	// 실행 조건 li에서 클릭 했을때
function categoryselect( selectNo ){
	// li가 여러개 존재 하는데 무엇 선택했는지 식별
	console.log (selectNo);
	
	//0. 카테고리에 모든 li 호출 [querySelectorAll 은 여러개를 배열로 가지고 온다.]
	let categoryli = document.querySelectorAll('.categorymenu li'); // 해당 클래스의 모든 li 호출
	console.log (categoryli);
	
	//1. 해당 선택된 인덱스의 class 추가 // !!!!! JS 에서 class 추가,삭제 가능 ! 
	for( let i = 0 ; i< categoryList.length; i++){
		//2. 선택된 카테고리[selectNo] 의 i번째 카테고리 찾기
		if( selectNo == i){
			// 해당 li 에 class 추가 DOM객체명.classList.add('새로운클래스명')
			categoryli[i].classList.add('categoryselect')
		}else {
			// 해당 li 에 class 삭제 DOM객체명.classList.remove('새로운클래스명')
			categoryli[i].classList.remove('categoryselect')
		}
	}
}










//4. 제품 출력 --------------------------------------------------------------------


//5. 제품 선택 --------------------------------------------------------------------