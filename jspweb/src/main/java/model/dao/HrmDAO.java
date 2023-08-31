package model.dao;

import java.util.ArrayList;

import model.dto.HrmDTO;

public class HrmDAO extends DAO{

	// 싱글톤
	private static HrmDAO dao = new HrmDAO();
	public static HrmDAO getInstance(){return dao;}
	private HrmDAO() {}	

	// 직원 등록 SQL ------------------------------------------------------------
	public boolean registerSQL( HrmDTO dto ) {
		try {
			String sql = "insert into hrm(himg, hname, hphone, hposition) value(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString( 1, dto.getHimg());
			ps.setString( 2, dto.getHname());
			ps.setString( 3, dto.getHphone());
			ps.setString( 4, dto.getHposition());
			int row = ps.executeUpdate();
			if( row == 1) { return true; }
		} catch ( Exception e ) {System.err.println(e);}
		return false;
	}
	
	// 직원 정보 호출 SQL ------------------------------------------------------------
	public ArrayList<HrmDTO> printTable() {
		ArrayList<HrmDTO> list = new ArrayList<>();
		try {
			String sql ="select * from hrm";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				HrmDTO dto = new HrmDTO(
						rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(dto);
				System.out.println(list);
			}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
