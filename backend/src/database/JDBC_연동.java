package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_연동 {
	
	public static void main(String[] args) {
		
		try {
			//1. [p.908] : 현재 프로젝트에 JDBC 파일을 build path add 하기
			//2. [p.909] : DB를 연결하기 위해 JDBC Driver 클래스를 찾아서 메모리 로딩하기
				//class.forName("oracle.jdbc.OracleDriver"); -> 오라클 기준
			Class.forName("com.mysql.cj.jdbc.Driver"); // -> MySQL 기준
				// 만약에 해당 JDBC 드라이버 클래스가 검색이 실패하면 에외발생
			//3. 
			//Connection conn = DriverManager.getConnection("DB주소","계정명","비밀번호");
			
			/* 1. DB주소 - jdbc : mysql :/ /1p주소 : port번호/ d6명
				1. jdbc:oracle:thin:@localhost: 1521/orci
				2. jdbc:mysql://localhost:3306/orci
			*/
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web", "root", "1234");
			System.out.println(" 안내) 연동성공 : " + con);
		} catch ( Exception e ){
			System.out.println(" 안내) 연동실패 사유 : " + e);
		}
	}

}

	/*
		예외처리 : 
			- Exception 클래스
			- 예외[오류] 발생했을때 흐름 제어 [ *만약에 오류 발생 했을때 다른 코드로 흐름 제어 ]
			- try {} catch (){}
				try{ 예외[오류]가 발생 할 것 같은 코드 } 
				catch ( 예외클래스명 객체변수명 ) { 예외가 발생했을대 실행코드 }
			- 예외[오류]가 발생 할 것 같은 코드
				- 일반예외 : 컴파일 과정에서 발생하는 예외	[ 컴파일 과정에서 체크하기 때문에 미리 처리 가능 ]
					- 파일처리, DB연동, 입출력 등등
				- 실행예외 : 실행 도중에 발생하는 예외 		[ *개발자의 경험으로 판단해야한다. ]
					- 실행중 각종 오류 ( 타입에러, 인덱스부족 등등 )
	*/