package java1.day13.Ex02.view;

import java.util.Scanner;

import java1.day13.Ex02.controller.BoardController;
import java1.day13.Ex02.model.DAO.BoardDAO;
import java1.day13.Ex02.model.DTO.BoardDTO;

public class MainPage { // MainPage s
	// 싱글톤(공유) O !
	// 게시물 마다가 아닌 모든~ 게시물에 동일한 기능을 수행한다 ! 그래서 싱글톤을 사용함
	// 모든 게시물이 하나의 객체를 통해 동일한 기능을 수행하게끔 하기 위함.
	// 싱글톤 생성 ----------------------------------------------------
	//1. 현재 클래스안에 현재클래스로! private static객체 생성, 필드는 무조건 잠금
	private static MainPage mainPage = new MainPage();
	//2. 외부객체에서 해당 싱글톤을 호출하기 위한 메소드 getInstance
	public static MainPage getInstance(){return mainPage;}
	//3. 외부에서 객체 생성 차단하는 생성자 선언
	private MainPage() {}
	
	// ---------------------------------------------------------------
	
	
	private Scanner scanner = new Scanner( System.in );
	
	// 메인페이지 입출력 함수
	public void mainView() { // mainView s
		while(true) { // while s
			System.out.println("안내)) " + BoardDAO.getInstance().boardDTOList);
			System.out.println("\n\n >>>>>>>>>>>>>> 방문록 글쓰기 <<<<<<<<<<<<<<");
			System.out.print("1. 글등록 | 2. 글보기 | 3. 글수정 | 4. 글삭제 \n >>선택");
			int ch = scanner.nextInt();
			if( ch == 1 ) { writerView(); }
			if( ch == 2 ) { printView();  }
			if( ch == 3 ) { updateView(); }
			if( ch == 4 ) { deleteView(); }
		} // while e
	}// mainView e
	
	
	
	// 글 등록 페이지 입출력 함수 ----------------------------------------------
	public void writerView() {
		//1. 작성자와 내용을 입력 받아서 변수에 저장하기
		System.out.print("작성자 : "); String writer = scanner.next(); 
		scanner.nextLine(); // .nextLine(); 앞에 nextInt()가 잇어서 오류가 발생하는 것을 방지함
		// nextLine 함수 앞뒤로는 다른 next가 있을때 하나의 입력으로 인식이 된다. 그래서 오류처럼 보임. 그럴떄는 의미 없는 nextLine를 한번 더 적어야함.
		System.out.print("방문록 : "); String content = scanner.nextLine();
		//2. 입력받은 변수를 controller에게 전달해야함 !
		// 현재 모두 JAVA 에서 이루어지고 있으니 메소드 이용한다.
		// 전달 보내기 == 매개변수 | 전달받기 == 리턴
		// view에서 controller를 호출할거임 ! 
		boolean result = BoardController.getInstance().writerLogic( writer, content); // 문자열2개를 매개변수로 전달하고 boolean 값 하나 리턴 받음
		//3. controller에게 전달받은 반환값 제어하기
		if( result ) { System.out.println("안내)) 글 등록 성공");}
		else {System.out.println("안내)) 글 등록 실패");}
	}
	// 글 출력 페이지 입출력 함수 ----------------------------------------------
	public void printView() {
		// 1. 보고자하는 게시물의 인덱스 입력받아서 저장
		System.out.print("출력할 방문록의 인덱스 : "); int index = scanner.nextInt();
		// 2. view에서 컨트롤에게 입력받은 인덱스 전달보내고 선택한 인덱스의 게시물1개 리턴 받음
		BoardDTO boardDto= BoardController.getInstance().printLogic(index);
		BoardDTO result = BoardController.getInstance().printLogic( index );
		// 3. 전달받은 결과를 출력
		System.out.println("안내] 검색한 방문록 정보 ");
		System.out.println( 	"[작성자] : " + result.getWriter() + 
								" [내용] : "+result.getContent() );	
	}
	// 글 수정 페이지 입출력 함수 ----------------------------------------------
	public void updateView() {
		//1. 입출력
		System.out.print("수정할 방문록의 인덱스 : "); int index = scanner.nextInt();
		scanner.nextLine();
		System.out.print("수정할 내용 : ");		  String content = scanner.next();
		System.out.print("수정할 작성자 : "); 		  String writer = scanner.next();
		//2. 입력받은 변수를 컨트롤에게 전달 보내고 결과를 리턴
		boolean result = BoardController.getInstance().updateLogic(index, content, writer);
		//3. 결과에 따른 제어
		if( result ) { System.out.println("안내] 수정 성공 ");}
		else { System.out.println("안내] 수정 실패 ");}
	}
	// 글 삭제 입출력 함수 ----------------------------------------------
	public void deleteView() {
		
		// 1. 삭제하는 게시물의 인덱스 입력받아서 저장
		System.out.print("삭제할 방문록의 인덱스 : "); int index = scanner.nextInt();
		// 2. view에서 컨트롤에게 입력받은 인덱스 전달보내고 삭제결과 여부 리턴 받음
		boolean result = BoardController.getInstance().deleteLogic( index );
		// 3. 리턴 결과에 따른 제어
		if( result ) { System.out.println("안내] 삭제 성공 ");}
		else { System.out.println("안내] 삭제 실패 ");}
		
	}
	
	
}// MainPage e




















