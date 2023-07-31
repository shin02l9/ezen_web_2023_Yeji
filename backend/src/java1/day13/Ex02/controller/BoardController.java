package java1.day13.Ex02.controller;

public class BoardController {
	// 싱글톤(공유) O !
	// 게시물 마다가 아닌 모든~ 게시물에 동일한 기능을 수행한다 ! 그래서 싱글톤을 사용함
	// 모든 게시물이 하나의 객체를 통해 동일한 기능을 수행하게끔 하기 위함.
	// 싱글톤 생성 ----------------------------------------------------
	//1. 현재 클래스안에 현재클래스로! private static객체 생성, 필드는 무조건 잠금
	private static BoardController boardController = new BoardController();
	//2. 외부객체에서 해당 싱글톤을 호출하기 위한 메소드 getInstance
	public static BoardController getInstance() {return boardController;}
	//3. 외부에서 객체 생성 차단하는 생성자 선언
	private BoardController() {}
	
	// ---------------------------------------------------------------
	// 글 등록 처리 기능 함수
	
	// 글 출력 처리 기능 함수
	
	// 글 삭제 처리 기능 함수
	
	// 글 수정 처리 기능 함수
}
