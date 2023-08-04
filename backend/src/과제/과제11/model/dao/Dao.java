package 과제.과제11.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao { // 각종 Dao의 클래스를 대표하는 부모클래스
	
	//1. 필드
	// [ 모두 상단에 import java.sql 이어야함 ]
	public Connection conn;		 // DB연동객체
	public PreparedStatement ps; // 연도된 DB 조작 객체
	public ResultSet rs;		 // SQL 조작 결과를 가져오는 객체
	//2. 생성자 : 객체 생성시 초기화 담당 
		// 기본생성자에 DB연동 코드 작성 *DAO객체 생성시 바로 DB연동
	public Dao() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web", "root", "1234");
		System.out.println("안내] DB 연동 성공");
		
		} catch ( Exception e ) {
			System.out.println("경고] DB 연동 실패" + e );
		}
		
	}
	
	
	//3. 메소드
	
}
