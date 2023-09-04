package model.dao;

import java.util.ArrayList;

import model.dto.BoardDTO;

public class BoardDAO extends DAO{
	// 싱글톤
	private static BoardDAO dao = new BoardDAO();
	public static BoardDAO getInstance(){return dao;}
	private BoardDAO() {}	
	
	// 1. 글쓰기
	public boolean bwrite( BoardDTO boardDTO )  {
		try {
			String sql = "insert into board( btitle, bcontent, bfile, mno, bcno) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString( 1, boardDTO.getBtitle());
			ps.setString( 2, boardDTO.getBcontent());
			ps.setString( 3, boardDTO.getBfile());
			ps.setInt( 4, boardDTO.getMno());
			ps.setInt( 5, boardDTO.getBcno());
			int row = ps.executeUpdate();
			if( row == 1 ) { return true; }
		} catch ( Exception e ) {System.err.println(e);}
		return false;

	}
	// 2. 모든글 출력
	public ArrayList<BoardDTO> getList(){
		System.out.println("글 출력하기 SQL 입장");
		// 게시물 레코드 정보 담아둘 리스트 선언
		ArrayList<BoardDTO> list = new ArrayList<>();
		
		try {
			String sql = "select b.*, m.mid, m.mimg, bc.bcname"
					+ "	from board b "
					+ "		natural join bcategory bc "
					+ "		natural join membertable m "
					+ "	order by b.bdate desc;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while ( rs.next() ) {
				BoardDTO boardDTO = new BoardDTO(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getString(9), rs.getString(10), rs.getString(11)
						);
				list.add(boardDTO);
				System.out.println( "getList : "+list );
			} return list;
		} catch ( Exception e ) {System.err.println(e);}
		return null;
	}
	
	// 3. 개별글 출력
	public BoardDTO getBoard( int bno ){
		view(bno); // 조회수 증가 함수 호출 
		try {
			String sql = "select b.*, m.mid, m.mimg, bc.bcname "
					+ "from board b "
					+ "natural join membertable m "
					+ "natural join bcategory bc "
					+ "where bno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1, bno );
			rs = ps.executeQuery();
			if( rs.next() ) {
				BoardDTO boardDTO = new BoardDTO(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getString(9), rs.getString(10), rs.getString(11)
						);
				return boardDTO;
			}

			
		}catch (Exception e) {System.err.println(e);}
		
		return null;
	}
	
	
	
	
	
	// 4. 게시물 수정
	public boolean onUpdate( BoardDTO boardDTO ) {
		try {
			String sql = "update board "
					+ "		set btitle = ?, bcontent = ?, bfile = ?,  bcno = ? "
					+ "     where bno = ?;";
			ps = conn.prepareStatement(sql);
			ps.setString( 1, boardDTO.getBtitle() );
			ps.setString( 2, boardDTO.getBcontent() );
			ps.setString( 3, boardDTO.getBfile() );
			ps.setInt( 4, boardDTO.getBcno() );
			ps.setInt( 5, boardDTO.getBno() );
			int row = ps.executeUpdate();
			System.out.println( "row : "+row);
			if( row == 1 ) { return true; }
		} catch (Exception e) {System.err.println(e);}
		return false;

	}
	
	// 5. 게시물 삭제
	public boolean onDelete( int bno ) {
		try {
			String sql = "delete from board where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1, bno );
			int row = ps.executeUpdate();
			System.out.println( "row : "+row);
			if( row == 1 ) { return true; }
		} catch (Exception e) {System.err.println(e);}
		return false;
	}
	
	// 6. 조회수 증가
	public boolean view( int bno ) {
		try {
			String sql = "update board set bview = bview+1 where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1, bno );
			int row = ps.executeUpdate();
			if( row == 1 ) { return true; }
		} catch (Exception e) {System.err.println(e);}
		return false;
	}
	
	

}
