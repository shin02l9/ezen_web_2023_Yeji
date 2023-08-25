package model.dao;

import model.dto.LibraryDTO;

public class LibraryDAO extends DAO{
	
	private static LibraryDAO dao = new LibraryDAO();
	public static LibraryDAO getInstance(){return dao;}
	private LibraryDAO() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 퇴실하기 ------------------------------------------------
	
	public String Ddata(int sno) {
		System.out.println(" 퇴실 Ddata 도착 ");
		try {
			String sql = "select sphone from slibrary where sno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , sno ); 
			rs = ps.executeQuery();
			if( rs.next() ) { return rs.getString(1);}
			else { return null; } 
		} catch (Exception e) { System.out.println(e); }
		return null; 
	}
	
	
	
	public boolean Dsql( LibraryDTO dto) {
		System.out.println(" 퇴실하기 SQL 도착 ");
		try {
			String sql = "update slibrary set sname = 'none', sphone = 'none', sstatus = 0 where sno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , dto.getSno()); 
			int row = ps.executeUpdate();
			System.out.println("row : "+row); // 이게 지금 안찍힘
			if( row == 1 ) { return true ;}
		} catch (Exception e) { System.out.println(e); }
		return false; 
	}
	
}
