package java1.day13.Ex02;

import java1.day13.Ex02.view.MainPage;

// 목적 : 실행 
public class AppStart {

	public static void main(String[] args) { // main s
		
		// 다른 클래스에 있는 메소드를 호출하는 방법 3가지
		// 1. 호출할 메소드가 있는 클래스의 객체를 만들어서 객체를 이용한 메소드 호출 -> 싱글톤 생성되어 있을때는 불가능
		// MainPage mainPage = new AppStart (); 
		// mainPage.mainView();
		// 2. 호출할 메소드가 정적[static] 메소드이면 객체 없이 메소드 호출 
		// MainPage.mainView();
		// 3. 호출할 메소드의 클래스가 싱글톤(객체)가 존재하면 실긍톤 호출 후 메소드 호출
		MainPage.getInstance().mainView();
			// MainPage : 클래스명 
				// MainPage.getInstance() : 클래스 안에 정적멤버 호출 후 
				// 반환 : 싱글톤을 반환 받는다.
					// MainPage.getInstance().mainView(); : 싱글톤 객체을 이용한 
					// mainPage.mainView()
		
		
	} // main e
	
}
