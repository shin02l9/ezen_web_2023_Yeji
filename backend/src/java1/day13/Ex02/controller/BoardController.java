package java1.day13.Ex02.controller;

import java1.day13.Ex02.model.DAO.BoardDAO;
import java1.day13.Ex02.model.DTO.BoardDTO;

public class BoardController {// BoardController s
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
	// 글 등록 처리 기능 함수 [C]
	public boolean writerLogic( String content, String writer) {
		//1. 매개변수로부터 전달 받은 content, writer 를 하나의 객체로 선언
		BoardDTO boardDTO = new BoardDTO(content,writer);
		//2. 객체를 리스트에 저장
		BoardDAO.getInstance().boardDTOList.add(boardDTO);
		return false;
	}
	// 글 출력 처리 기능 함수 [R]
	public void printLogic() {
		System.out.println("검토용) 출력 컨트롤러까지 도착");
	}
	// 글 수정 처리 기능 함수 [U]
	public void updateLogic() {
		System.out.println("검토용) 수정 컨트롤러까지 도착");
	}
	// 글 삭제 처리 기능 함수 [D]
	public void deleteLogic() {
		System.out.println("검토용) 삭제 컨트롤러까지 도착");
	}
	
}// BoardController e
































