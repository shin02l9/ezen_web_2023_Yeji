package 복습.day05_필드생성자;

import java.util.Scanner;

//목적 : 실행
public class MemberSystem {// MemberSystem class s

	/*주제 : 회원제 시스템 [ 과제9 ]
			0. 저장
			    Member 클래스 필드는  아이디 , 비밀번호 , 이름 , 전화번호 , 나이 5개 입니다.
			   여러개 Member객체를 저장하기 위한 Member[] 객체배열 = new Member[100]; 선언합니다.
			1. 초기 메뉴 [ 24시간 ]
			    1. 회원가입 2.로그인
			2. 조건 기능
			     1. 회원가입
			         1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이 각 입력받아 저장
			         2. Member 객체화
			          3. 객체를 배열 저장
			     2. 로그인
			          1. 아이디 , 비밀번호 입력받아 저장
			          2. 입력받은 값과 배열내 동일한 값 찾기
			          - 만약에 동일한 값 있으면 로그인 성공
			          - 아니면 실패 */
	
	//public Scanner sc = new Scanner(System.in); 이거 왜 안되는가..
	
	public static void main(String[] args) {// main s
		
		Scanner sc = new Scanner(System.in);
		//여러개 Member객체를 저장하기 위한 Member[] 객체배열 = new Member[100]; 선언
		Member[] memberList = new Member[100];
		
		while(true) {// while s
			
			System.out.println("---- 회원제 시스템 ----");
			System.out.println("1. 회원가입 | 2. 로그인 ");
			System.out.println("--------------------");
			System.out.print(" 선택 >> "); int ch = sc.nextInt();
			
			if( ch==1 ) { // 회원가입 메뉴 선택시
				System.out.println("---- << 회원가입 >> ----");
				// 1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이 각 입력받아 저장
				System.out.print(" 아이디 : ");	String id = sc.next();
				System.out.print(" 비밀번호 : ");	String pw = sc.next();
				System.out.print(" 이름 : ");	String name = sc.next();
				System.out.print(" 전화번호 : ");	String phone = sc.next();
				System.out.print(" 나이 : ");	int age = sc.nextInt();
				
				// 2. Member 객체화
				Member member = new Member( id, pw, name, phone, age );
				// 3. 객체를 배열 저장
				//memberList = member;
				for ( int i = 0; i < memberList.length; i++) {
					memberList[i] = member;
				}
				System.out.println("[ 회원가입 성공 ]\n");
				
			} else if ( ch==2 ) { // 로그인 메뉴 선택시
				System.out.println("---- << 로그인 >> ----");
				// 1. 아이디 , 비밀번호 입력받아 저장
				System.out.print(" 아이디 : ");	String idforLogin = sc.next();
				System.out.print(" 비밀번호 : ");	String pwforLogin = sc.next();
				
				// 2. 입력받은 값과 배열내 동일한 값 찾기
				boolean login = false;
//				for ( int i = 0; i < memberList.length; i++) {
//					if( idforLogin == memberList[i].getId ) {
//						if( pwforLogin == memberList[i].getPw ) {
//							login = true; break;
//						}
//					} 
//				}
				
//				for ( int i = 0; i < memberList.length; i++) {
//					if( memberList[i].getId.equals(idforLogin) ) {
//						if( memberList[i].getPw.equals(pwforLogin) ) {
//							login = true; break;
//						}
//					} 
//				}
				
				for ( int i = 0; i < memberList.length; i++) {
					if( memberList[i].id.equals(idforLogin) ) {
						if( memberList[i].pw.equals(pwforLogin) ) {
							login = true; break;
						}
					} 
				}
				
				
				// - 만약에 동일한 값 있으면 로그인 성공
		        // - 아니면 실패 */
				if( login ) {System.out.println("[ 로그인 성공 ]\n");}
				if( login==false ) { System.out.println("[ 로그인 실패 ]\n");}
				
				
			} else { System.out.println("없는 메뉴 입니다.");}
			
			
			
			
			
		}// while e
	}// main e
}// MemberSystem class e








