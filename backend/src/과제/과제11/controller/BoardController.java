package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;

public class BoardController {
	
	//싱글톤
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance(){return boardController;}
	private BoardController() {}

	
	//5. boardWhite  : 게시물 쓰기 페이지 ----------------------------------------------------
	public boolean boardWhite(String title, String content) {
		// 유효성 검사
		if( title.length() == 0 || title.length() >= 50 ) {
			return false;
		}
		//2. Dto 생성자 이용해 객체화 [ 입력받은 제목, 입력받은 내용, 로그인된 회원번호 ]
		BoardDto boardDto = new BoardDto(title,content,MemberController.getInstance().getLoginSession()); 
		//3. Dao 에게 전달하기
		return BoardDao.getInstance().boardWhite(boardDto);

	}
	
	//6. boardPrint  : 모든 게시물 출력 페이지 ------------------------------------------------
	public ArrayList<BoardDto> boardPrint() {
		return BoardDao.getInstance().boardPrint();
		
	}
	
	//7. boardView   : 개별 게시물 출력 페이지 ------------------------------------------------
	public BoardDto boardView( int bno ) {
		
		return BoardDao.getInstance().boardView(bno);
	}
	
	//8. boardUpdate : 게시물 수정 ---------------------------------------------------------
	public void boardUpdate() {}
	//9. boardDelete : 게시물 삭제 ---------------------------------------------------------
	public void boardDelete() {}
}





















