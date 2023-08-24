package 과제;

import model.dao.DAO;

public class AccountbookDAO extends DAO{
	// 싱글톤
	private static AccountbookDAO dao = new AccountbookDAO();
	private AccountbookDAO() {}
	public static AccountbookDAO getInstance() {return dao;}

	// 등록 function C()
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
	
	
	
	
	
}
