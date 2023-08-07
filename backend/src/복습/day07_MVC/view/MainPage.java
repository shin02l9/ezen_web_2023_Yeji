package 복습.day07_MVC.view;

import java.util.Scanner;

import 복습.day07_MVC.controller.MemberController;

// 보여지는 곳 (프론트)
public class MainPage {
	
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance(){return mainPage;}
	private MainPage() {}
	
	Scanner sc = new Scanner(System.in);
	
	// 메인 ------------------------------------------------------------------------
	public void mainPageView() {
		while (true) {
			System.out.println("--------------- 회원제 시스템 ---------------");
			System.out.println("1. 가입 | 2. 로그인 | 3. ID 찾기 | 4. PW 찾기");
			System.out.println("------------------------------------------");
			System.out.print(" 선택 >> "); int ch = sc.nextInt();
			if( ch == 1 ) { joinView(); }
			if( ch == 2 ) { loginView(); }
			if( ch == 3 ) { FindIdView(); }
			if( ch == 4 ) { FindPasswordView(); }	
		}	
	}
	// 회원가입 ------------------------------------------------------------------------
	public void joinView() {
		// 입력받고 저장하기
		System.out.println("--------------- 회원가입 ---------------");
		System.out.print("아이디 : ");	String id = sc.next();
		System.out.print("비밀번호 : ");	String pw = sc.next();
		System.out.print("이름 : ");		String name = sc.next();
		System.out.print("전화번호 : ");	String phone = sc.next();
		System.out.print("나이 : ");		int age = sc.nextInt();
		// 저장한것을 컨트롤에게 전달하고 반환값 받기
		boolean b = MemberController.getInstance().joinLogic(id, pw, name, phone, age);
		if( b ) { System.out.println(" 안내)) 회원가입 완료 ");}
		else { System.out.println(" 안내)) 회원가입 실패 ");}
		
	}
	// 로그인 ------------------------------------------------------------------------
	public void loginView() {
		System.out.println("--------------- 로그인 ---------------");
		System.out.print("아이디 : ");	String id = sc.next();
		System.out.print("비밀번호 : ");	String pw = sc.next();
		boolean b =  MemberController.getInstance().loginLogic(id, pw);
		if( b ) { System.out.println(" 안내)) 로그인 완료 ");}
		else { System.out.println(" 안내)) 로그인 실패 ");}
		
	}
	// 아이디 찾기 ------------------------------------------------------------------------
	public void FindIdView() {
		System.out.println("--------------- 아이디 찾기 ---------------");
		System.out.print("이름 : ");	String name = sc.next();
		System.out.print("전화번호 : ");	String phone = sc.next();
		String b =  MemberController.getInstance().FindIdLogic(name, phone);
		if( b != null ) { System.out.println(" 안내)) 회원님의 아이디는 "+ b +"입니다.");}
		else { System.out.println(" 안내)) 알맞은 정보가 아닙니다. ");}
	}
	// 비밀번호 찾기 ------------------------------------------------------------------------
	public void FindPasswordView() {
		System.out.println("--------------- 비밀번호 찾기 ---------------");
		System.out.print("아이디 : ");	String id = sc.next();
		System.out.print("전화번호 : ");	String phone = sc.next();
		String b =  MemberController.getInstance().FindPasswordLogic(id, phone);
		if( b != null ) { System.out.println(" 안내)) 회원님의 비밀번호는 "+ b +"입니다.");}
		else { System.out.println(" 안내)) 알맞은 정보가 아닙니다. ");}
	}

}
