package 과제.과제11.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제11.controller.BoardController;
import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.BoardDto;
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
			
			System.out.println("\n -------------------------- 회원제 커뮤니티 --------------------------");
			System.out.print("1. 로그아웃 | 2. 회원정보 | 3. 게시글쓰기 | 4. 게시글조회 | 5. 쪽지함\n 메뉴선택 >>"); 
			try {
				int ch = sc.nextInt();
				if( ch == 1 ) { // 로그아웃
					MemberController.getInstance().logout();
					// 현재 코드에서는 break; 는 필요 없다.
				} 
				if( ch == 2 ) { info();}
				if( ch == 3 ) { boardWhite();}
				if( ch == 4 ) { boardView();}
				if( ch == 5 ) { message();}
			}
			catch ( Exception e ) { 
				System.err.println("경고] 잘못된 메뉴입니다.");
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
	public void boardWhite() {
		sc.nextLine();
		System.out.println("------ 게시물작성 -------");
		System.out.print("제목 : "); 	String title = sc.nextLine();
		System.out.print("내용 : ");	String content = sc.nextLine();
		
		boolean r =
		BoardController.getInstance().boardWhite( title, content );
		if (r) { System.out.println(" 안내) 게시물 등록 성공");}
		else {System.out.println(" 안내) 게시물 등록 실패");}
		
		
	}
	//6. boardPrint  : 모든 게시물 출력 페이지 ----------------------
	public void boardPrint() {
		System.out.println("------ 게시물출력 -------");
		//1. 여러개의 게시물을 요청해서 반환된 결과
		ArrayList<BoardDto> r = BoardController.getInstance().boardPrint();
		//2. 출력 
	
		System.out.printf("%-3s %-4s %-19s %-10s %s \n" , "no" , "view" , "date" , "mid" , "title");
		for ( int i = 0; i <r.size(); i++) {
			BoardDto dto = r.get(i);
			
			System.out.printf("%-3s %-4s %-15s %-10s %s \n",
					dto.getBno() , dto.getBview() , dto.getBdate(),
					dto.getMid() , dto.getBtitle()
					);
		}
		
	}
	//7. boardView   : 개별 게시물 출력 페이지 ----------------------
	// 회원 정보 출력과 비슷함 ! 
	public void boardView() {
		System.out.println("------ 게시물 상세보기 -------");
		// 1. 보고자 하는 게시물의 식별번호인 게시물 번호 입력 받기 
		System.out.print("게시물번호 : "); int bno = sc.nextInt();
		// 2. 전달하기
		BoardDto r = BoardController.getInstance().boardView(bno);
		// 3. 출력하기
		System.out.printf("bno : %3s | view : %3s | mid : %5s | date : %19s \n", 
							r.getBno(), r.getBview(), r.getMid(), r.getBdate());
		System.out.println("title : " + r.getBtitle());
		System.out.println("content : " + r.getBcontent());
		
		// 4. 추가메뉴
		System.out.print("1. 뒤로가기 | 2. 수정하기 | 3. 삭제하기  \n 선택 >>");
		int ch = sc.nextInt();
		if( ch == 1 ) { loginMenu(); }
		if( ch == 2 ) { boardUpdate(bno, r.getMno()); }
		if( ch == 3 ) { boardDelete(bno, r.getMno()); }
		
	}
	
	
	//8. boardUpdate : 게시물 수정 -------------------------------
	// 로그인 된 사람과 작성자가 일치할 경우 가능하도록 하기
	public void boardUpdate( int bno, int mno ) {
		System.out.println("------ 게시물 수정하기 -------");
		sc.nextInt();
		// 1. 수정하고자 하는 게시물의 번호와 제목 내용 입력 받기
		System.out.print("수정할제목 : "); String btitle = sc.next();
		System.out.print("수정할내용 : "); String bcontent = sc.next();
		// 2. 전달하기 
		int r = BoardController.getInstance().boardUpdate(bno,mno,btitle,bcontent);
		if( r == 1 ) {System.out.println(" 안내) 글 수정 성공");}
		else if( r == 2 ) {System.out.println(" 안내) 글 수정 실패 : 관리자 오류 ");}
		else if( r == 3 ) {System.err.println(" 경고] 본인 글만 수정 가능합니다.");}
		else if( r == 4 ) {System.err.println(" 경고] 수정할 제목을 1~50글자 사이로 입력해 주세요.");}

		
//		// 3. 추가메뉴
//		System.out.print("1. 취소하기 | 2. 수정하기   \n 선택 >>");
//		int ch = sc.nextInt();
//		if( ch == 1 ) { loginMenu(); }
//		if( ch == 2 ) {  }
		
	}
	//9. boardDelete : 게시물 삭제 -------------------------------
	// 로그인 된 사람과 작성자가 일치할 경우 가능하도록 하기
	public void boardDelete( int bno, int mno) {
		
		int r = BoardController.getInstance().boardDelete(bno,mno);
		if( r == 1 ) {System.out.println(" 안내) 글 삭제 성공");}
		else if( r == 2 ) {System.out.println(" 안내) 글 삭제 실패 : 관리자 오류 ");}
		else if( r == 3 ) {System.err.println(" 경고] 본인 글만 삭제 가능합니다.");}
	}
	
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	// 쪽지함 추가
	public void message() {
		System.out.println("------ [쪽지] -------");
		System.out.print("1. 확인하기 | 2. 쪽지보내기 \n  메뉴선택 >>"); int ch = sc.nextInt();
		messagePrint();
		if( ch == 1 ) {
			System.out.print("확인할쪽지번호입력 : ");
			int msgNo = sc.nextInt();
			messageView(msgNo);
			
		} else if( ch == 2 ) {
			System.out.print("받는사람 : "); 	String to = sc.next();
			System.out.print("제목 : "); 	String msgTitle = sc.next();
			System.out.print("내용 : "); 	String msgCon = sc.next();
			boolean r = BoardController.getInstance().message(to,msgTitle,msgCon);
			
			if (r) { System.out.println(" 안내) 쪽지 보내기 성공");}
			else {System.err.println(" 안내) 쪽지 보내기 실패");}
		}
	}
	public void messagePrint() {

		//1. 여러개의 게시물을 요청해서 반환된 결과
		ArrayList<BoardDto> r = BoardController.getInstance().messagePrint();
		//2. 출력 
		System.out.println("---------------------------------------------");
		System.out.printf("%-3s %-10s %-5s %-11s \n" , "번호" , "제목" , "보낸사람" , "보낸일시");
		System.out.println("---------------------------------------------");
		for ( int i = 0; i <r.size(); i++) {
			BoardDto dto = r.get(i);
			System.out.printf("%-3s %-10s %-5s %-11s \n",
					dto.getMsgno() , dto.getMsgtitle() , dto.getMno(), dto.getMsgdate());
			System.out.println("---------------------------------------------");
		}
	}
	
	
	public void messageView( int msgNo ) {
		// 상세보기 아직 못함
		
		
	}
	
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	
	
}


/* 
		ArrayList<리스트저장할타입>	리스트객체명 = new ArrayList<>();
			1. .size()			: 리스트내 객체 수
			2. .get(인덱스)		: 리스트내 인덱스번째의 객체 호출
			3. .add()			: 리스트내 객체 추가


	
 */


















