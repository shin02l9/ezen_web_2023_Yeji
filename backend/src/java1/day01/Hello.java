// 자바 한줄 주석
/* 여러줄 주석 */


package java1.day01; // 패키지/폴더 경로 

public class Hello { // class start 클래스 선언 // 'Hello'는 클래스명 = 숫자시작x, 공백x, 띄어쓰기x, 첫문자대문자o
	//1. 자바의 모든 코드는 클래스 안에서 작성해야 실행된다.
	//2. 모든 실행코드는 메인함수 안에서 작성해야한다. [스레드(=코드를 읽는 흐름이란 뜻) 포함] 
	
	// {} 마다 tab 1번 적용
	public static void main(String[] args) { // m start / 메소드=함수 선언
		// console.log() vs System.out.println(); [syso + 컨트롤 + 스페이스바 자동완성 가능]
		System.out.println("Hello Java");

	}// m end

}// class end
