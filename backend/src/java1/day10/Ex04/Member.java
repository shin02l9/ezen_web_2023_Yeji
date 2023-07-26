package java1.day10.Ex04;

public class Member {
	
	//1. 필드
	//2. 생성자
	//3. 메소드
		// 리턴타입 : 메소드 실행한 후 호출했던 곳으로 전달하는 값의 타입
	    // 메소드명 : 소문자시작, 카멜표기법
	    // 매개변수 : 메소드 호출 할때 전달한 매개값
	    // {} : 메소드 호출시 실행되는 구역/부분

	// ------------- 메소드 선언 ---------------------------------------------
		//1. 리턴x 매개변수x 함수의 선언
	void signUp () {}
		//2. 리턴x 매개변수o 함수의 선언
	void login ( String id , int pw ) {}
		//3. 리턴o 매개변수x 함수의 선언
	String findId () { return "찾은아이디"; }
		//4. 리턴o 매개변수o 함수의 선언
	String[] findPw ( String s1, String s2 ) { 
		String[] array = { "qwe", "asd"}; return array;}
		//5. 매개변수가 가변길이 일때 함수 
	// ... : 여러 매개변수들을 하나의 힙에 저장해서 힙주소 반환
	// 			 vs
	// new : 클래스 기반으로 힙에 객체 생성해서 힙의 객체주소 반환
	void delete ( String ...strArray) {}
	void delete ( int num , String ...strArray) {}
		//6. 오버로딩 : 메소드명이 같되 매개변수 이름[x]타입[o]순서[o]개수[o]구분 식별

}

/*
	메소드 : 객체의 동작, 객체의 상호 작용, 서로다른 클래스/객체 간에 데이터 이동 [MVC패턴]
		선언 : 리턴타입 메소드명 (매개변수1, 매개변수2 ~ ){ 실행코드 return; }


*/