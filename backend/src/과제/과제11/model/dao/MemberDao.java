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
	

	
	//2. 회원가입 SQL -------------------------------------------------------------------------------
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
	
	//3. 로그인 SQL -------------------------------------------------------------------------------
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
	
	//4. 아이디찾기 SQL -------------------------------------------------------------------------------
	public String findById(String name, String phone) {
		System.out.println("findById 도착");
		try {	
			// 1. SQL 작성한다.
			String sql = "select mid from member where mname=? and mphone=?;";
			// 2. 작성된 SQL을 조작할 객체를 연동객체를 통해 반환 한다.
			conn.prepareStatement(sql);
			// 3. SQL 조작한다.
			ps.setString(1, name );
			ps.setString(2, phone );
				// select mid from member where mname = 입력된name and mphone = 입력된phone;
			// 4. 실행
				// SQL 실행할때 주로 사용하는 
				// select : executeQuery()
				// insert,update,delete = executeUpdate()
			// 5. SQL 결과를 조작할 ResultSet 객체를 executeQuery 메소드부터 반환
			rs = ps.executeQuery();
			// 6. SQL 결과 조작 
				// rs.next() : 검색된 여럿 레코드중 다음레코드 위치 이동 ]
				// rs.get타입( 검색필드순서번호 )
					// rs.getString(검색필드순서번호) : 현재 위치한 레코드의 필드값 문자열 호출 
					// rs.getInt(검색필드순서번호) 		: 현재 위치한 레코드의 필드값 정수 호출 
			if( rs.next() ) {
				return rs.getString(1); // ()안에는 검색된 필드의 순서 번호 ! 
			}

		} catch ( Exception e ) { System.out.println(e); }

		return null;
	}
	
	//5. 비밀번호찾기 SQL -------------------------------------------------------------------------------
	public String findByPw(String id, String phone) {
		System.out.println("findByPw 도착");
		try {
			String sql = "select mpw from member where mid = ? and mphone = ?";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , id ); 
			ps.setString( 2 , phone );
			rs = ps.executeQuery();
			if( rs.next() ) { 
				return rs.getString( 1 ); 
			} 
		}catch (Exception e) { System.out.println(e); }
		return null;
	}
	

}























