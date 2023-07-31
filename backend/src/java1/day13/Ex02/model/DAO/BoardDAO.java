package java1.day13.Ex02.model.DAO;

import java.util.ArrayList;

import java1.day13.Ex02.model.DTO.BoardDTO;

public class BoardDAO {
	// 싱글톤(공유) O !
	// 게시물 마다가 아닌 모든~ 게시물에 동일한 기능을 수행한다 ! 그래서 싱글톤을 사용함
	// 모든 게시물이 하나의 객체를 통해 동일한 기능을 수행하게끔 하기 위함.
	// 싱글톤 생성 ----------------------------------------------------
	private static BoardDAO boardDao = new BoardDAO();
	public static BoardDAO getInstance() { return boardDao; }
	private BoardDAO() {}
	
	// ---------------------------------------------------------------
	// 게시물 여러개 저장하는 곳
		//1. 배열
	//public BoardDTO[] boardDTOArray = new BoardDTO[100];
		//2. 리스트 : 배열의 라이브러리 ! 배열을 쉽게 사용할 수 있도록 *다양한 함수 제공 
	public ArrayList<BoardDTO> boardDTOList = new ArrayList<>();
		// ArrayList : 배열처럼 사용 가능한 클래스 객체 선언
		// <클래스>	 : 클래스 안에 여러개 객체를 저장할 객체의 타입
	

	
}
/*

	- 배열 : 
	boardDTOArray =  [ boardDTO ] [ boardDTO ] [ boardDTO ]
	  	   				  1   			2   		 3   
	  
	  - 베열 선언하는 방법
	  		타입명[]배열변수명 = new 타입명[길이]
	  		( 고정길이 = 선언시 사용할 길이만큼 사용하고 중간에 변경불가능* )
	  - 배열에 값 저장하는 방법
	  	for( int i = 0 ; i<배열명.length ; i++ ) {
				if( 배열명[i] == null ) { 배열명[i] = 객체명; }
			} 
	  - 배열에서 값 삭제하는 방법 | 삭제못함 배열은 고정길이여서 | 대신에 초기값을 만들어서 삭제처럼 보이게 만들 수 있음 !
	  	그리고 한칸씩 당겨서 초기값으로 바꾼 인덱스를 제일 뒤로 옮기기
	- 리스트 : 
		boardDTOList = 
		-----------------
		|	BoardDTO	|
		|	BoardDTO	|
		|	BoardDTO	|
		-----------------
		
		- 리스트 선언하는 방법
			ArrayList<타입명> 리스트객체변수명 = new ArrayList<>();
			(가변길이 = 저장하는 객체의 개수만큼 자동으로 저장개수 커졌다 작아졌다 함 )
		- 리스트에 값 저장하는 방법 
			리스트객체명.add(객체명)  : 해당 객체를 리스트에 저장
		- 리스트의 값 호출하는 방법 
			리스트객체명.get(인덱스)  : 해당 인덱스 객체를 호출  
		- 리스트의 값을 삭제하는 방법
			배열처럼 노가다 할필요없다 도구가 있어서 !
			리스트명.remove(인덱스)  : 해당 인덱스 객체를 삭제 (뒷칸으로 당기는 것도 자동으로 해줌 !)
*/