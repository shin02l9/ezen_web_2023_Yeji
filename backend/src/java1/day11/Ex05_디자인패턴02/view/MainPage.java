package java1.day11.Ex05_디자인패턴02.view;

import java.util.Scanner;

import java1.day11.Ex05_디자인패턴02.controller.MemberController;

public class MainPage { // MainPage s
	
	
	//0. 싱글톤 생성
		//1. 현재 클래스에 static객체 생성 , 필드는 무조건 잠금
		private static MainPage mainPage = new MainPage();
		//2. 외부객체에서 해당 싱글톤 호출하기 위한 메소드
		public static MainPage getInstance(){return mainPage;}
		//3. 객체 외부에서 해당 클래스로 객체 생성 잠금, 생성자를 private
		private MainPage(){}
	
	//1. 필드
	private Scanner sc = new Scanner(System.in);
	
	//2. 생성자
	//3. 메소드
	public void mainPage() { // mainPage s ----------------------------------------------------------------------------
		while(true) { // while s
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    \n 선택>> ");
			int ch = sc.nextInt(); 
			if( ch == 1 ) { singupPage(); }
			if( ch == 2 ) { loginPage();  } 
			if( ch == 3 ) { findIdPage(); } 
			if( ch == 4 ) { findPwPage(); } 
		} // while e 
	} // mainPage e
	
	void singupPage() { // singupPage s ----------------------------------------------------------------------------
		// 입출력 받고,
		System.out.print("\n\n--------- 회원가입 ---------\n"); 
		System.out.print("아이디 : "); 		String id = sc.next(); 
		System.out.print("비밀번호 : ");		String pw = sc.next(); 
		System.out.print("이름 : ");			String name = sc.next(); 
		System.out.print("전화번호 :");		String phone = sc.next(); 
		System.out.print("나이 : ");			int age = sc.nextInt(); 
		// MemberController에게 전달해야한다.
		// MemberController클래스내에 메소드를 호출
		boolean result = MemberController.getInstance().singupLogic(id, pw, name, phone, age);
		if(result) { System.out.print("안내)) 회원가입 성공"); }
		else { System.out.print("안내)) 회원가입 실패"); }
	}// singupPage e
	
	void loginPage() { // loginPage s ----------------------------------------------------------------------------
		//1. 입력받기 -> 각 2개의 값 입력 받기 -> 기존의 데이터와 일치하는지 비교하기 [ R ]
		System.out.print("\n\n--------- 로그인 ---------\n"); 
		System.out.print("아이디 : "); 		String id = sc.next(); 
		System.out.print("비밀번호 : ");		String pw = sc.next();
		// MemberController에게 전달해야한다.
		// MemberController클래스내에 메소드를 호출
		boolean result = MemberController.getInstance().loginLogic(id, pw);
		if(result) { System.out.print("안내)) 로그인 성공"); }
		else { System.out.print("안내)) 로그인 실패"); }
	}// loginPage e
	
	void findIdPage() { // findIdPage s ----------------------------------------------------------------------------
		//1. 입력받기 -> 각 2개의 값 입력 받기 -> 기존의 데이터와 일치하는지 비교하기 [ R ]
		System.out.print("\n\n--------- 아이디찾기 ---------\n"); 
		System.out.print("이름 : "); 		String name = sc.next(); 
		System.out.print("전화번호 : ");		String phone = sc.next(); 
		// MemberController에게 전달해야한다.
		// MemberController클래스내에 메소드를 호출
		String result = MemberController.getInstance().findIdLogic(name, phone);
		if(result != null) { System.out.print("안내)) 회원님의 아이디는 "+result+"입니다."); }
		else { System.out.print("안내)) 일치하는 회원정보가 없습니다."); }
		
	} // findIdPage e
	
	void findPwPage() { // findPwPage s ----------------------------------------------------------------------------
		//1. 입력받기 -> 각 2개의 값 입력 받기 -> 기존의 데이터와 일치하는지 비교하기 [ R ]
		System.out.print("\n\n--------- 비밀번호찾기 ---------\n"); 
		System.out.print("아이디 : "); 		String id = sc.next(); 
		System.out.print("전화번호 : ");		String phone = sc.next(); 
		// MemberController에게 전달해야한다.
		// MemberController클래스내에 메소드를 호출
		String result = MemberController.getInstance().findPwLogic(id, phone);
		if(result != null) { System.out.print("안내)) 회원님의 비밀번호는 "+result+"입니다."); }
		else { System.out.print("안내)) 일치하는 회원정보가 없습니다."); }
		
		
	} // findPwPage e
	
} // MainPage e
