package model.dao;

import java.time.LocalDateTime;

import model.dto.MemberDTO;

public class MemberDAO extends DAO{

	// 싱글톤
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance(){return dao;}
	private MemberDAO() {}	
	
	// 1. 회원가입
	public boolean signupSQL( MemberDTO dto ) {
		try {
			String sql = "insert into membertable(mid, mpwd, memail, mimg) value(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString( 1, dto.getMid());
			ps.setString( 2, dto.getMpwd());
			ps.setString( 3, dto.getMemail());
			ps.setString( 4, dto.getMimg());
			int row = ps.executeUpdate();
			if( row == 1) { return true; }
		} catch ( Exception e ) {System.err.println(e);}
		return false;

	}
	
	// 2. 로그인
	public boolean loginSQL( String mid,  String mpwd ) {
		try {
			String sql = "select * from membertable where mid = ? and mpwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString( 1, mid);
			ps.setString( 2, mpwd);
			rs = ps.executeQuery();
			if( rs.next() ) { return true; }
		} catch ( Exception e ) {System.err.println(e);}
		return false;
		
	}
	// 3. 아이디찾기
	
	// 4. 비밀번호찾기
	
	// 5. 내정보 호출
	public MemberDTO info( String mid ) {
		try {
			String sql = "select mno, mid, memail, mimg from membertable where mid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString( 1, mid);
			rs = ps.executeQuery();
			if( rs.next() ) {
				MemberDTO dto = new MemberDTO(
						LocalDateTime.now().toString(), // 현재 시간 문자열로 반환 함수
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return dto;
			}
		} catch ( Exception e ) {System.err.println(e);}
		return null;		
		
		
	}
	
	// 6. 아이디 중복검사
	public boolean findIdSQL( String type , String data) {
		try {
			String sql = "select * from member where "+type+" = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			if( rs.next() ) { return true; }
		} catch ( Exception e ) {System.out.println(e);}
		
		return false;
	}
	
	
	// 7. 회원수정
	public boolean updateSQL(int mno, String mimg) {
		try {
			String sql = "update membertable set mimg = ? where mno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(2, mno); ps.setString(1, mimg);
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		} catch ( Exception e ) {System.out.println(e);}
		
		return false;
	}
	
	
	// 8. 회원탈퇴
	public boolean deleteInfoSQL(int mno, String mpwd) {
		try {
			String sql = "delete from membertable where mno = ? and mpwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno); ps.setString(2, mpwd);
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		} catch ( Exception e ) {System.out.println(e);}
		
		return false;
	}
	
	
	
	
	

}
