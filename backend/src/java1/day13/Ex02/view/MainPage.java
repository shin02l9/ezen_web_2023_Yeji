package java1.day13.Ex02.view;

import java.util.Scanner;

public class MainPage {
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
	public void mainView() { // mainPage s
		while(true) { // while s
			System.out.println("\n\n >>>>>>>>>>>>>> 방문록 글쓰기 <<<<<<<<<<<<<<");
			System.out.println("1. 글등록 | 2. 글보기 | 3. 글삭제 | 4. 글수정 \n >>선택");
			int ch = scanner.nextInt();
			if( ch == 1 ) {}
			if( ch == 2 ) {}
			if( ch == 3 ) {}
			if( ch == 4 ) {}
		} // while e
	}// mainPage e
	
	
	
	// 글 등록 페이지 입출력 함수

	// 글 출력 페이지 입출력 함수
	
	// 글 삭제 페이지 입출력 함수
	
	// 글 수정 입출력 함수
}
