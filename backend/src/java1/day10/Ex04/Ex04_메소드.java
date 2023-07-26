package java1.day10.Ex04;

import java.util.Scanner;

public class Ex04_메소드 {
	
	public static void main(String[] args) {
		
		// ------------- 메소드의 사용 또는 호출 ---------------------------------------------
		//1.  객체 필요 ! ! ! 
		Member m = new Member();
		//2. 객체 내 .도트연산자 이용한 필드/메소드 호출
			//1. 리턴x 매개변수x 함수의 사용
			m.signUp();
			
			//2. 리턴x 매개변수o 함수의 사용
			//m.login("qwe","1234"); ---> 오류 뜨는 코드! 문자,숫자 하나씩 받는걸로 선언했는데 문자 2개를 넣어서 오류뜸
			m.login("qwe",1234);
			
			//3. 리턴o 매개변수x 함수의 사용
			m.findId(); 				 // 리턴된 값을 받았지만 추후[다음코드]에 그 값을 사용할 목적이 없어서 변수에 저장X
			String result2 = m.findId(); // 리턴된 값을 받았지만 추후[다음코드]에 그 값을 사용할 목적이 있어서 변수에 저장O
			// int result1 = m.findId(); // 리턴된 값을 받았지만 저장하는데 있어서 타입 일치하지 않는 경우
			
			//4. 리턴o 매개변수o 함수의 사용
			String[] result3 = m.findPw( "qwe","qwe");
			
			//5. 가변길이
			m.delete ("안녕","하세요");
			m.delete ("안녕","하세요","!");
			
			//6. 오버로딩
			m.delete (1, "안녕","하세요","!");
		
		
	}

}
