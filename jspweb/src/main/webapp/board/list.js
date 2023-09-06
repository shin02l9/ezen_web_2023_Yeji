console.log('list JS 실행')

// 1. 글쓰기 버튼을 클릭하면
function onWrite(){
	keywordDelete();
	if(loginstate){
		location.href="write.jsp";
	} else {
		alert('로그인 후 사용 가능합니다.')
		location.href="/jspweb/member/login.jsp";
	}
}


/* 게시물 조회 조건을 담았다 뻈다 하며 사용할 객체 */
let pageObject = { 
		type : 1, 
		bcno : 0, 
		listsize : 10, 
		page : 1,
		key : '',
		keyword : ''
		}
	 // type 1 : 전체 , type 2 : 개별조회
	 // bcno 	 : 조회할 카테고리 번호 [ 기본값은 전체보기 ]
	 // listsize : 하나의 페이지에 게시물 최대 표시할 수 
	 // page	 : 조회할 페이지 번호 

// 5. 검색버튼을 클릭 했을때
function onSearch (){
	pageObject.key = document.querySelector('.key').value;
	pageObject.keyword = document.querySelector('.keyword').value;
	console.log('검색 클릭시 key : '+pageObject.key)
	console.log('검색 클릭시 keyword : '+pageObject.keyword)
	getlist(1);
	// 검색 끝난 후에 검색창 공백으로 바꾸기
	document.querySelector('.keyword').value = '';
}

// 5-1. 검색창에서 엔터키를 눌렀을때
function enter(){
	if( event.keyCode == 13 ){
		onSearch();
		return;
	}
}

// 5-2. 검색된 값 초기화하기
function keywordDelete(){
	pageObject.key = '';
	pageObject.keyword = '';
}


// 3. 카테고리 버튼을 클릭했을때
function oncategory( bcno ){
	keywordDelete();
	console.log('클릭된 카테고리 넘버 : '+bcno)
	pageObject.bcno = bcno; // 조회 조건객체내 카테고리번호를 선택한 번호로 변경하기
	getlist(1); // 조건에 변경되었기 때문에 다시 출력
}


// 4. 한 페이지에 최대 표시 갯수 변경했을때
function onlistsize(){
	// 조회 조건객체내 게시물 최대 표시할 수 선택한 값으로 변경하기
	pageObject.listsize = document.querySelector('.listsize').value;
	getlist(1); // 조건에 변경되었기 때문에 다시 출력
}



// 2. 모든글 조회
getlist(1);
function getlist( page ){
	
	pageObject.page = page; // 조회 조건객체내 페이지번호를 선택한 번호로 변경하기
	 
	$.ajax({
		url : "/jspweb/BoardInfoController",
		method : "get",
		data : pageObject ,
		success : function f(r){
			// console.log("getlist() 통신성공"+r) 
			
			// -------------- 게시물 출력 --------------
			if ( r != null ){
				// 출력할 내용 구성
				let boardTable = document.querySelector('.boardTable');
				let HTML = `<tr>
								<th> 번호 </th>
								<th> 카테고리 </th>
								<th> 제목 </th>
								<th> 작성자 </th>
								<th> 조회수 </th>
								<th> 작성일 </th>
							</tr>`;
				// 반복해서 HTML 출력하기
				// 배열명.forEach( 변수명아무거나 => { 실행 코드 }) 

				r.boardlist.forEach( b => {
					HTML += `<tr>
								<td> ${b.bno} </td>
								<td> ${b.bcno} </td>
								<td> <a href="/jspweb/board/view.jsp?bno=${b.bno}" > ${b.btitle} </a> </td>
								<td> ${b.mid} <img class="blistimg hmimg" src="/jspweb/member/img/${b.mimg}"/></td> 
								<td> ${b.bview} </td>
								<td> ${b.bdate} </td>
							</tr>`;
				})
				boardTable.innerHTML = HTML;
				
				
				// -------------- 페이징버튼 출력 --------------
				HTML = ``;
				// 페이지 개수만큼 구성해야함
					// 이전 버튼 : 만약에 1페이지이면 1페이지로 고정해야함 ! 
				HTML += `<button class="" onclick="getlist(${page <= 1 ? page : page-1})" type="button"> ◀ </button>`;
					// 페이징 버튼
					
				for( let i = r.startbtn; i <= r.endbtn; i++ ){
					// 만약에 현재 페이지와 i번째 페이지와 일치하면 class="selectpage" 추가해주기
					/*if( page == i ){
						HTML += `<button onclick="getlist(${i})" class="selectpage" type="button"> ${i} </button>`;
					} else {
						HTML += `<button onclick="getlist(${i})" type="button"> ${i} </button>`;
					}*/
					// 삼항 연산자 사용하면 더 간결함 !!
					HTML += `<button onclick="getlist(${i})" class="${page == i ? 'selectpage' : ''}" type="button"> ${i} </button>`;
				}
					// 다음버튼 : 만약에 마지막 페이지이면 마지막 페이지로 고정해야함 ! 
				HTML += `<button class="" onclick="getlist(${page >= r.totalpage ? page : page+1})" type="button"> ▶ </button>`;
				
				document.querySelector('.pagebox').innerHTML = HTML;
				
				
				// -------------- 총 게시물 수 출력 --------------
				let totalsize = document.querySelector('.totalsize');
				if( pageObject.key != '' && pageObject.keyword != '' ){
					totalsize.innerHTML = `검색된 게시물 수 : ${r.totalsize}`;
				} else {
					totalsize.innerHTML = `총 게시물 수 : ${r.totalsize}`;
				}
				
			} 
		}
	})
}


/*
	< 쿼리스트링 방식 >
	HTTP URL에 매개변수(파라미터) 전달
		- 정의 : 페이지 전환시 매개변수(PK, 식별키) 전달
		- 형태
		URL?변수명=데이터 
		URL?변수명=데이터&변수명=데이터
		http://localhost/jspweb/board/view.jsp?bno=3

		
*/



// ------------------------------------------------------------------
