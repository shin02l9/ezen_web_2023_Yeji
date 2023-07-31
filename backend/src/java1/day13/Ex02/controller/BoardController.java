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
	// 글 등록 처리 기능 함수 [C] ----------------------------------------------
	public boolean writerLogic( String writer, String content) {
		//1. 매개변수로부터 전달 받은 content, writer 를 하나의 객체로 선언
		BoardDTO boardDTO = new BoardDTO(writer,content);
		//2. 객체를 리스트에 저장
		BoardDAO.getInstance().boardDTOList.add(boardDTO);
		return true;
	}
	// 글 출력 처리 기능 함수 [R] ----------------------------------------------
	public BoardDTO printLogic(int index) {
		// 1. 리스트 안에 있는 객체 호출 .get( 인덱스 ) : 해당 인덱스의 객체 호출
		BoardDTO boardDTO = BoardDAO.getInstance().boardDTOList.get(index);
		// 2. 호출된 DTO를 리턴하기 
		return boardDTO;
	}
	// 글 수정 처리 기능 함수 [U] ----------------------------------------------
	public boolean updateLogic(int index, String content, String writer ) {
		//1. 입력받은 인덱스의 게시물을 호출해서 새로운 입력받은 값으로 대입/저장/수정 set , 호출/불러오기 get
		BoardDAO.getInstance().boardDTOList.get(index).setContent(content); //DTO 필드에 직접 접근 x | 간접 접근 set ,get o
		BoardDAO.getInstance().boardDTOList.get(index).setWriter(writer);
		return true;
	}
	// 글 삭제 처리 기능 함수 [D] ----------------------------------------------
	public boolean deleteLogic(int index) {
		// 1. 리스트 안에 있는 객체 삭제 .get( 인덱스 ) : 해당 인덱스의 객체 호출
		BoardDAO.getInstance().boardDTOList.remove(index);
		// 2. 삭제 여부 반환
		return true;
	}
	
}// BoardController e
































