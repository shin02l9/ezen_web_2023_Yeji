package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

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
				if( ch == 2 ) { info();}
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
	public void info(  ) {
		if( MemberController.getInstance().getLoginSession() != 0  ) {
			// 1. 컨트롤에게 회원정보 요청해서 반환 받기
			MemberDto info = MemberController.getInstance().info( );
			System.out.println(" >>> 회원정보 <<<");
			// 2. 출력하기
			System.out.println(" 아이디 : "+info.getMid());
			System.out.println(" 이름 : "+info.getMname());
			System.out.println(" 전화번호 : "+info.getMphone());
			// 3. 서브메뉴
			System.out.println("1. 비밀번호수정 | 2. 회원탈퇴 | 3. 뒤로가기 \n 메뉴선택 >>");
			int ch = sc.nextInt();
			if( ch == 1 ) { infoUpdate();}
			if( ch == 2 ) { infoDelete();}
			if( ch == 3 ) { return; }
		}
	}
	
	//3. infoUpdate  : 비밀번호 수정 페이지 -----------------------------
	public void infoUpdate() {
		System.out.println(" >>> 비밀번호 변경 <<<");
		System.out.println(" 새로운 비밀번호 : ");
		String newPw = sc.next();
		
		boolean r = MemberController.getInstance().infoUpdate(newPw);
		if( r ) {
			System.out.println(" [비밀번호 수정완료] 로그아웃 됩니다.");
			MemberController.getInstance().logout();
		}
		else {System.out.println(" [비밀번호 수정실패]");}
	
	}
	
	//4. infoDelete  : 회원탈퇴 페이지 -----------------------------
	public void infoDelete() {
		System.out.println(" >>> 회원탈퇴 <<<");
		System.out.println(" 정말 탈퇴 하시겠습니까? ");
		System.out.println(" 1. 예 | 2. 아니오  선택>");
		int ch = sc.nextInt();
		if( ch == 1 ) {
			boolean r = MemberController.getInstance().infoDelete();
			if( r ) {
				System.out.println("[회원탈퇴 완료] 로그아웃 됩니다. ");
				MemberController.getInstance().logout();
			} else {
				System.out.println(" [회원탈퇴 실패]");
			}
		}
		
	}
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
