package java1.day13.Ex02.model.DAO;

public class BoardDAO {
	// 싱글톤(공유) O !
	// 게시물 마다가 아닌 모든~ 게시물에 동일한 기능을 수행한다 ! 그래서 싱글톤을 사용함
	// 모든 게시물이 하나의 객체를 통해 동일한 기능을 수행하게끔 하기 위함.
	// 싱글톤 생성 ----------------------------------------------------
	private static BoardDAO boardDao = new BoardDAO();
	public static BoardDAO getInstance() { return boardDao; }
	private BoardDAO() {}
	
	// ---------------------------------------------------------------

}
