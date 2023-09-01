package model.dao;

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
	

}
