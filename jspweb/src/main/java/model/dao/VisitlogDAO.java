package model.dao;

import java.util.ArrayList;

import model.dto.VisitlogDTO;

public class VisitlogDAO extends DAO{
	// 싱글톤
	private static VisitlogDAO dao = new VisitlogDAO();
	public static VisitlogDAO getInstance(){return dao;}
	private VisitlogDAO() {}
	
	
	// C (저장) -------------------------------------------------------------------------------
	public boolean vwriteSQL(VisitlogDTO dto) {
		
		try {
			System.out.println("vwriteSQL 도착");
			// SQL 작성
			String sql = "insert into visitlogTable(vwriter, vpwd, vcontent) values(?,?,?)";
			// SQL 연결
			ps = conn.prepareStatement(sql);
			// SQL 매개변수 대입
			ps.setString(1, dto.getVwriter());
			ps.setString(2, dto.getVpwd());
			ps.setString(3, dto.getVcontent());
			// SQL 실행
			ps.executeUpdate();
			// SQL 결과 반환
			return true;
		} catch ( Exception e ) { System.out.println(e);}
		return false;

	}

	// R (호출) -------------------------------------------------------------------------------
	public ArrayList<VisitlogDTO> vreadSQL() {
		ArrayList<VisitlogDTO> list = new ArrayList<>(); // 여러개 dto를 담을 리스트 객체 
		try {
			System.out.println("vreadSQL 도착");
			// SQL 작성
			String sql = " select * from visitlogTable order by vdatetime desc;";
			// SQL 연결
			ps = conn.prepareStatement(sql);
			// SQL 매개변수 대입 할 필요 없음

			// SQL 실행
			rs = ps.executeQuery();
			// SQL 결과 반환
			while( rs.next() ) {// rs.next() : select 검색결과중 다음 레코드로 이동 존재하면 true/ 존재하지 않으면 false
				// * 하나의 레코드가 하나의 행이고 하나의 DTO가 된다.
				// 레코드를 dto로 변환 시켜야함.
				VisitlogDTO dto = new VisitlogDTO( 
							rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
						); 
				// 다른 방법도 있음.
//				VisitlogDTO dto = new VisitlogDTO( 
//						rs.getInt("vno"), rs.getString("vwriter"), rs.getString("vpwd"), rs.getString("vcontent"), rs.getString("vdatetime")
//					); 
				list.add(dto);
			} // while end
			System.out.println( list );
			
		} catch ( Exception e ) { System.out.println(e);}
		return list;
		
	}
	
	
	// U (수정) -------------------------------------------------------------------------------
	public boolean vupdateSQL(int vno, String vcontent, String vpwd) {
		try {
			String sql = "update visitlog set vcontent = ? where vno = ? and vpwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 2 , vno); 
			ps.setString( 1 , vcontent ); 
			ps.setString( 3 , vpwd );
			int row = ps.executeUpdate();
			if( row == 1 ) return true ;
			return false; 
		}catch (Exception e) { System.out.println(e); }
		return false; 
		
	}
	
	// D (삭제) -------------------------------------------------------------------------------
	public boolean vdeleteSQL(int vno, String vpwd) {
		try {
			String sql = "delete from visitlog where vno = ? and vpwd = ?"; // 1. SQL 작성 
			ps = conn.prepareStatement(sql);	
			ps.setInt( 1 , vno ); 
			ps.setString( 2 , vpwd );
			int row = ps.executeUpdate();	
			if( row == 1 ) return true;		
			return false; 
		}catch (Exception e) {System.out.println(e);}
		return false; 
		
	}
}
