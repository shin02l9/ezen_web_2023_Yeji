package 과제;

import java.util.ArrayList;

import model.dao.DAO;
import model.dto.VisitlogDTO;

public class AccountbookDAO extends DAO{
	// 싱글톤
	private static AccountbookDAO dao = new AccountbookDAO();
	private AccountbookDAO() {}
	public static AccountbookDAO getInstance() {return dao;}

	// 등록 function C() -----------------------------------------------
	public boolean C( AccountbookDTO dto ) {
		try {
			String sql = "insert into accountbook(bcontent , bprice , bdate) values( ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getContent());
			ps.setString(2, dto.getPrice());
			ps.setString(3, dto.getDate());
			int row = ps.executeUpdate();
			if(row == 1){
				return true;
			}
		}catch(Exception e){ System.out.println(e); }
		return false;
	}
	
	// 출력 function R() -----------------------------------------------
	public ArrayList<AccountbookDTO> R(){
		ArrayList<AccountbookDTO> list = new ArrayList<>();
		try {
			String sql = " select * from accountbook order by bdate desc;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				AccountbookDTO dto = new AccountbookDTO(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4) );
				list.add(dto);
			}
			System.out.println(list);
		} catch ( Exception e ) {System.out.println(e);}
		return list;
	}
	
	// 수정 function U() -----------------------------------------------
	public boolean U( AccountbookDTO dto) {
		try {
			String sql = "update accountbook set bcontent = ? , bprice = ? where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getContent());
			ps.setString(2, dto.getPrice());
			ps.setInt(3, dto.getNo());
			int row = ps.executeUpdate();
			if(row == 1) {return true;}
		}catch(Exception e) {System.out.println(e);}
		
		return false;	
	}
	
	// 삭제 function D() -----------------------------------------------
	public boolean D(int bno) {
		try {
			String sql ="delete from accountbook where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int row = ps.executeUpdate();
			if(row == 1) {return true;}
		}catch(Exception e) {System.out.println(e);}
		
		return false;
	}
	
	
	
}
