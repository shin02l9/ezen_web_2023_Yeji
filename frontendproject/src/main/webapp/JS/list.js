
console.log (' list JS 실행')




//1. 쿠키에 있는 배열 호출 [ 실행조건 : 게시판 페이지가 열리면 ]
let boardList = JSON.parse(localStorage.getItem('boardList'));
	// 쿠키/세션이 저장된 객체, 배열 호출시 JSON.parse()
	// 쿠키/세션이 저장된 객체, 배열 저장시 JSON.stringify()
	
 if( boardList == null ){ boardList = [] }// 만약에 boardList가 없으면 빈 배열 선언하기 



boardPrint()
//1. 게시물 출력함수
function boardPrint(){
	//1. 어디에
	let tcontent = document.querySelector('.tcontent')
	//2. 무엇을
	let html = ``;
		//html 구성
		for( let i = 0 ; i < boardList.length ; i++ ){
			let board = boardList[i]; // i번째 게시물 호출
			html += `<tr>
						<td> ${ board.no } </td> <td> ${ board.title } </td> <td> ${ board.writer } </td> <td> ${ board.date } </td>
						<td> ${ board.view } </td> <td> ${ board.like } </td> 
					</tr>`
		}
	//3.
	tcontent.innerHTML = html;
}
	
