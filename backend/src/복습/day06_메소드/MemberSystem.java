package 복습.day06_메소드;

import java.util.Scanner;

//목적 : 실행
public class MemberSystem { // 실행 MemberSystem s
//	주제 : 회원제 시스템 [ 과제10 ]
//			0. 저장
//			    Member 클래스 필드는  아이디 , 비밀번호 , 이름 , 전화번호 , 나이 5개 입니다.
//			   여러개 Member객체를 저장하기 위한 Member[] 객체배열 = new Member[100]; 선언합니다.
//			2. 각 메소드 기능
//			    0. main 메소드 : 초기 메뉴 [ 24시간 ]
//			        1. 입력시 회원가입 메소드 호출 
//			        2. 입력시 로그인 메소드 호출
//			        3. 입력시 아이디찾기​ 메소드호출 
//			        4. 입력시 비밀번호찾기 메소드 호출
//			    1. 회원가입 메소드 
//			        1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이 각 입력받아 저장
//			        2. Member 객체화
//			        3. 객체를 배열 저장
//			    2. 로그인 메소드
//			        1. 아이디 , 비밀번호 입력받아 저장
//			        2. 입력받은 값과 배열내 동일한 값 찾기
//			            - 만약에 동일한 값 있으면 로그인 성공
//			            - 아니면 실패
//			    3. 아이디찾기 메소드
//			        1. 이름 , 전화번호 입력받아 저장
//			        2. 입력받은 값과 배열내 동일한 값 찾기
//			            - 만약에 동일한 값 있으면 찾은 아이디 출력
//			            - 아니면 없다.
//			    4. 비밀번호찾기 메소드
//			        1. 아이디 , 전화번호 입력받아 저장
//			        2. 입력받은 값과 배열내 동일한 값 찾기
//			            - 만약에 동일한 값 있으면 찾은 비밀번호 출력
//			            - 아니면 없다.
	
	static Scanner sc = new Scanner(System.in);
	static Member[] memberlist = new Member[100];
	static boolean login = false;
	
	public static void main(String[] args) { // main s
		
		//Member[] memberlist = new Member[100];

		while (true) { // while s
			System.out.println("----------------- 회원 시스템 -----------------");
			System.out.println("1.회원가입 | 2.로그인 | 3.아이디찾기 | 4.비밀번호찾기");
			System.out.println("--------------------------------------------");
			System.out.print("  선택 >> ");
			int ch = sc.nextInt();
			
			if( ch == 1 ) { 회원가입 (); }
			else if( ch == 2 ) { 로그인 (); }
			else if( ch == 3 ) { 아이디찾기 (); }
			else if( ch == 4 ) { 비밀번호찾기 (); }
			else { System.out.println("올바른 메뉴를 입력해주세요."); }
			
			
			
			
			
		}// while e
	}// main e
	
	// -------------------------회원가입 메소드-------------------------
//    1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이 각 입력받아 저장
//    2. Member 객체화
//    3. 객체를 배열 저장
	static void 회원가입 () {
		System.out.print("아이디 : "); 	String id = sc.next();
		System.out.print("비밀번호 : ");  String pw = sc.next();
		System.out.print("이름 : "); 	String name = sc.next();
		System.out.print("전화번호 : ");  String phone = sc.next();
		System.out.print("나이 : ");		int age = sc.nextInt();
		
		Member member = new Member( id, pw, name, phone, age);
		
		
		for( int i = 0; i< memberlist.length; i++){
			if( memberlist[i] == null) {memberlist[i] = member;}
		}
		System.out.println(member);	
		System.out.println("안내)) 회원가입 완료");	
	}
	// -------------------------로그인 메소드-------------------------
	static void 로그인 () {
		System.out.print("아이디 : "); 	String id = sc.next();
		System.out.print("비밀번호 : ");  String pw = sc.next();
		
		for( int i = 0; i< memberlist.length; i++){
			if( memberlist[i] != null && 
				memberlist[i].getId().equals(id) &&
				memberlist[i].getPw().equals(pw)){
				login = true;
				break;
			}
		}	
		
		if( login ) {System.out.println(" 안내)) 로그인 성공 "); }
		else {System.out.println(" 안내)) 로그인 실패 "); }
	}
	// -------------------------아이디찾기 메소드-------------------------
	static void 아이디찾기 () {
		System.out.print("이름 : "); 	String name = sc.next();
		System.out.print("전화번호 : ");  String phone = sc.next();
		
		for( int i = 0; i< memberlist.length; i++){
			if( memberlist[i] != null && 
				memberlist[i].getName().equals(name) &&
				memberlist[i].getPhone().equals(phone) ){
				System.out.println("회원님의 아이디는 "+memberlist[i].getId()+"입니다.");
				break;
			}
		}	
	}
	// -------------------------비밀번호찾기 메소드-------------------------
	static void 비밀번호찾기 () {
		System.out.print("아이디 : "); 	String id = sc.next();
		System.out.print("전화번호 : ");  String phone = sc.next();
		
		for( int i = 0; i< memberlist.length; i++){
			if( memberlist[i] != null && 
				memberlist[i].getId().equals(id) &&
				memberlist[i].getPhone().equals(phone)){
				System.out.println("회원님의 비밀번호는 "+memberlist[i].getPw()+"입니다.");
				break;
			}
		}	
	}
	
	
	
} // 실행 MemberSystem e
























