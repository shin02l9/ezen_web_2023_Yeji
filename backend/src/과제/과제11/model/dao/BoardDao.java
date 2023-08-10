package 과제.과제11.model.dao;

import java.util.ArrayList;

import 과제.과제11.model.dto.BoardDto;

public class BoardDao extends Dao {

	
	//싱글톤
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance(){return boardDao;}
	private BoardDao() {}
	
	//5. boardWhite  : 게시물 쓰기 페이지 --------------------------
	public boolean boardWhite(BoardDto boardDto) {
		try {
			//1. SQL 을 작성한다.
			String sql = "insert into board( btitle , bcontent , mno ) values( ? , ? , ? )";
			//2. 작성한 SQL을 조작할 인터페이스 PS객체 반환한다.
			ps = conn.prepareStatement(sql);
			//3. SQL에 매개변수 대입 (조작)
			ps.setString( 1, boardDto.getBtitle());
			ps.setString( 2, boardDto.getBcontent());
			ps.setInt( 3, boardDto.getMno());
			//4. SQL 실행 / 실행 후 저장된 레코드 개수 반환
			int row = ps.executeUpdate();
			//5. 만약에 저장된 레코드 수가 1개이면 
			if( row == 1 ) return true;
		}catch ( Exception e) {System.out.println(e);}
		
		return false;
	}
	//6. boardPrint  : 모든 게시물 출력 페이지 ----------------------
	public ArrayList<BoardDto> boardPrint(){
	//public BoardDto[] boardPrint() {
		
		ArrayList<BoardDto> list = new ArrayList<>();
	// 선택해서 사용하기
		try {
			// 1.
			String sql = "select b.* , m.mid from member m natural join board b order by b.bdate desc;"; // 최신순으로 모든 레코드 호출
			// 2.
			ps = conn.prepareStatement(sql);
			// 3. SQL 매개변수 없어서 생략
			// 4. 검색결과의 레코드를 여러개 조작하기 위해 result
			rs = ps.executeQuery();
			// 5. 여러개 레코드 조회
			while( rs.next() ){ // 마지막 레코드까지 하나씩 이동
				// rs.next() 다음 레코드로 이동한다는 뜻 다음 레코드가 존재하면 true
				// 다음 레코드가 존재하지 않을때까지 무한루프 한다.
				// 결론 레코드 개수만큼 반복문이 돌 것.
				// 레코드 1개마다 1개의 DTO 변환
//				System.out.println(rs);
//				System.out.println(); // 띄어쓰기 하려고 적음
//				
//				// 필드 순서에 따른 필드 값 호출
//				System.out.println(rs.getString(1)); // bno
//				System.out.println(rs.getString(2)); // btitle
//				System.out.println(rs.getString(3)); // bcontent
//				System.out.println(rs.getString(4)); // bdate
//				System.out.println(rs.getString(5)); // bview
//				System.out.println(rs.getString(6)); // mno
//				System.out.println();  // 띄어쓰기 하려고 적음
				
				BoardDto dto = new BoardDto(
						rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7));
				list.add(dto);
			} // while e

		} catch ( Exception e ) {}
		
		return list;
		
		
	}
	//7. boardView   : 개별 게시물 출력 페이지 ----------------------
	public BoardDto boardView( int bno ) {
		
		try {
			String sql = "";
			sql = "select b.*, m.mid from board b natural join member m where b.bno = ?;";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1,  bno );
			rs = ps.executeQuery();
			if( rs.next() ) {
				// 레코드 하나만 DTO 하나로 변환이라 무한루프 필요 없다. 
				BoardDto dto = new BoardDto(
				rs.getInt(1),rs.getString(2),rs.getString(3),
				rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7));	
				return dto;
			}
		}catch ( Exception e ) {System.out.println(e);}

		return null;	
	}
	//8. boardUpdate : 게시물 수정 -------------------------------
	public void boardUpdate() {}
	//9. boardDelete : 게시물 삭제 -------------------------------
	public void boardDelete() {}
	
}


/*
	 테이블
	 	레코드/행/가로  -> DTO 하나 
	 	레코드/행/가로  -> DTO 하나 
	 	레코드/행/가로  -> DTO 하나 
	
 	예)
 		로그인 한 회원정보 조회 = DTO
 		관리자가 모든 회원의 정보를 여러개 조회 할떄는 = ArrayList<DTO>
 		
 		개별 게시물1개를 클릭해서 들어가는 것은 = DTO
 		모든 게시물을 출력을 할때는 = ArrayList<DTO>
 
 */















