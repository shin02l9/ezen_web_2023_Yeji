package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class LoginPage {
	//싱글톤
	private static LoginPage loginPage = new LoginPage();
	public static LoginPage getInstance(){return loginPage;}
	private LoginPage() {}
	
	//입력객체
	Scanner sc = new Scanner(System.in);
	
	
	//1. loginMenu	 : 로그인 했을때 메뉴 페이지 ---------------------
	public void loginMenu() {
		while (MemberController.getInstance().getLoginSession() != 0 ) {
			System.out.println("\n ---------- 회원제 커뮤니티 ----------");
			System.out.print("1. 로그아웃 | 2. 회원정보 | 3. 글쓰기 \n 메뉴선택 >>"); 
			try {
				int ch = sc.nextInt();
				if( ch == 1 ) { // 로그아웃
					MemberController.getInstance().logout();
					// 현재 코드에서는 break; 는 필요 없다.
				} 
				if( ch == 2 ) { infoUpdate();}
				if( ch == 3 ) { boardWhite();}
			}
			catch ( Exception e ) { 
				System.out.println("경고] 잘못된 메뉴입니다.");
				sc = new Scanner (System.in); // 입력객체의 메모리를 새롭게 만들어주기
				// 왜? 초기화 안하면 입력된 값이 객체 내 계속 있기 때문에 오류가 계속 발생된다.
			}			
		}
		
		
	} 
	//2. info		 : 회원정보 페이지 -----------------------------
	public void info() {}
	//3. infoUpdate  : 회원정보 페이지 -----------------------------
	public void infoUpdate() {}
	//4. infoDelete  : 회원탈퇴 페이지 -----------------------------
	public void infoDelete() {}
	//5. boardWhite  : 게시물 쓰기 페이지 --------------------------
	public void boardWhite() {}
	//6. boardPrint  : 모든 게시물 출력 페이지 ----------------------
	public void boardPrint() {}
	//7. boardView   : 개별 게시물 출력 페이지 ----------------------
	public void boardView() {}
	//8. boardUpdate : 게시물 수정 -------------------------------
	public void boardUpdate() {}
	//9. boardDelete : 게시물 삭제 -------------------------------
	public void boardDelete() {}
	
	
}
