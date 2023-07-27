package java1.day11.Ex05_디자인패턴02;

import java1.day11.Ex05_디자인패턴02.view.MainPage;
import 과제.과제10.MemberSystem;

public class AddStart { // class s

	public static void main(String[] args) { // main s
		// 다른 클래스에 있는 메소드를 호출하는 방법 
		//1. 메소드가 인스턴스 멤버이면  		=> 객체를 이용한 메소드 호출  	  => 각각
			// MainPage.mainPage = new MainPage();
			// mainPage.mainPage();
		//2. 메소드가 정적(static)멤버이면 			=> 클래스를 이용한 메소드 호출 	  => 공용
			// MainPage.mainPage();
		//3. 싱글톤 객체 (객체자체가static)이면 		=> 싱글톤 객체 호출해서 메소드 호출  => 프로그램내 1개 객체 (멤버 모두 공용)
			MainPage.getInstance().mainPage();

	}// main e
}// class e
