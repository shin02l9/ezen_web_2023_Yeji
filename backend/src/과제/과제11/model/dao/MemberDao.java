package 과제.과제11.model.dao;

import 과제.과제11.model.dto.MemberDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao extends Dao {
	
	//싱글톤 
		private static MemberDao  memberDao = new MemberDao();
		public static MemberDao getInstance() {return memberDao;}
		public MemberDao() {}
	

	
	//2. 회원가입 SQL
	public boolean signupSQL( MemberDto member ) {
		try {
			System.out.println("signupSQLDao 도착");
			
			//1. 연동된 DB객체에서 SQL 조작 도구 (prepareStatement) 꺼내기 [ 연동객체명.prepareStatement("조작할 SQL")]
			ps = conn.prepareStatement("insert into member( mid , mpw , mname , mphone ) values( ? , ? , ? , ? )");
			
			
			//2. sql 안에 있는 ?매개변수 값 대입 ps.set타입( ? 순서번호, 값 )
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpw());
			ps.setString(3, member.getMname());
			ps.setString(4, member.getMphone());
			
			//3. sql 실행
			ps.executeUpdate();
	
			//4. 리턴 [회원가입 성공
			return true;
		
		} catch ( Exception e ) { System.out.println(e);}
		return false;
	}
	
	//3. 로그인 SQL
	public boolean loginSQL(String id, String pw) {
		try {	
			System.out.println("loginSQLDao 도착");
			
			//1. SQL 작성한다. [ 추천 : MySQL  워크벤치에서 임의의값으로 테스트 먼저하고서 복붙하기 ]
			String sql = "select *	from member where mid=? and mpw=?;";
			//2. SQL 조작 할수 있는 객체 필요함으로 preparedStatement 반환 받기
			ps = conn.prepareStatement(sql);
			//3. SQL 조작 [ SQL 안에 있는 매개변수 [?]에 값 대입 ]
			ps.setString(1, id );
			ps.setString(2, pw );
			//4. SQL 실행해서 그 결과를 rs객체에 담는다 { 이유!  ps는 결과를 조작 할수 없어서 }
			rs = ps.executeQuery();
			//5. SQL 실행결과 조작 [ rs.next() : 결과중 다음 레코드 객체 호출 ]
			if( rs.next() ) { // 로그인은 레코드가 1개라서 if 사용함 회원정보 모두 불러올때는 while 문 사용해야함.
				return true; //
			}
		} catch ( Exception e ) { System.out.println(e); }
		return false; 
	}
	

}
