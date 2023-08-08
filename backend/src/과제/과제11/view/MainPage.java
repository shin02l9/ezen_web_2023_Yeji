package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;


public class MainPage {
	
	
	
	//싱글톤
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance(){return mainPage;}
	private MainPage() {}
	
	//0. 입력객체
	private Scanner sc = new Scanner ( System.in );
	
	//1. 메인메뉴 -------------------------------------------------------------------------------
	public void mainView() {
		while(true) {
			
			System.out.println("\n ----------------- 회원제 커뮤니티 -----------------");
			System.out.print("1. 회원가입 | 2. 로그인 | 3. 아이디찾기 | 4. 비밀번호찾기 \n 메뉴선택 >>"); 
			try {
				int ch = sc.nextInt();
				if( ch == 1 ) { signupView(); } 
				if( ch == 2 ) { loginView();}
				if( ch == 3 ) { findById();}
				if( ch == 4 ) { findByPw();}
				
			}
			catch ( Exception e ) { 
				System.out.println("경고] 잘못된 메뉴입니다.");
				sc = new Scanner (System.in); // 입력객체의 메모리를 새롭게 만들어주기
				// 왜? 초기화 안하면 입력된 값이 객체 내 계속 있기 때문에 오류가 계속 발생된다.
			}			
		}
		
		
	}
	
	//2. 회원가입 -------------------------------------------------------------------------------
	public void signupView() {
		System.out.println("\n\n ----- 회원가입 페이지 -----");
		System.out.print("아이디 : "); 			String id = sc.next();
		System.out.print("비밀번호 : ");			String pw = sc.next();
		System.out.print("이름 : ");				String name = sc.next();
		System.out.print("전화번호[-포함] : ");	String phone = sc.next();
		
		// 입력값을 컨트롤에게 전달하고 결과 받기
		boolean result =  MemberController.getInstance().signupLogic(id, pw, name, phone);
		
		//결과를 출력
		if( result ) { System.out.println("안내] 회원가입 성공");}
		else { System.out.println("경고] 회원가입 실패");}
	
	}
	
	//3. 로그인 -------------------------------------------------------------------------------
	public void loginView() {
		System.out.println("\n\n ----- 로그인 페이지 -----");
		System.out.print("아이디 : "); 	String id = sc.next();
		System.out.print("비밀번호 : ");	String pw = sc.next();	
		
		boolean result =  MemberController.getInstance().loginLogic(id, pw);
		if( result ) { System.out.println("안내] 로그인 성공");}
		else { System.out.println("경고] 로그인 실패");}
	}
	
	//4. 아이디찾기 -------------------------------------------------------------------------------
	public void findById() {
		System.out.println("\n\n ----- 아이디찾기 -----");
		System.out.print("이름 : "); 	String name = sc.next();
		System.out.print("전화번호 : ");	String phone = sc.next();	
		
		String r = MemberController.getInstance().findById(name, phone);
				
		if( r != null ) { System.out.println("안내] 회원님의 아이디는 "+r+"입니다.");}
		else { System.out.println("경고] 해당 정보가 없습니다.");}
	}
	
	//5. 비밀번호찾기 -------------------------------------------------------------------------------
	public void findByPw() {
		System.out.println("\n\n ----- 비밀번호찾기 -----");
		System.out.print("아이디 : "); 	String id = sc.next();
		System.out.print("전화번호 : ");	String phone = sc.next();
		
		String r = MemberController.getInstance().findByPw(id, phone);
		
		if( r != null ) { System.out.println("안내] 회원님의 비밀번호는 "+r+"입니다.");}
		else { System.out.println("경고] 해당 정보가 없습니다.");}
	}


}


















