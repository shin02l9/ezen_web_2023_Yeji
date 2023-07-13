package java1.day01;// 현재 클래스가 위치한 패키지명(폴더경로)

public class Ex1_변수 { //class start
	
	//main + 컨트롤 + 스페이스바 + 엔터 [자동완성]
	public static void main(String[] args) { // main start 모든 실행코드는 메인 함수 안에 !!
		
		int value = 10;
		int result = value +10;
		System.out.println(result);
		
//		----------------------------------
		
		int hour =3;
		int minute = 5;
		System.out.println(hour + "시간" + minute + "분");
		
		int totalminute = (hour*60) + minute;
		System.out.println("총"+ totalminute + "분");
		
		
	}// main end

}//class end



/*	
 	변수 	: 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름
 	형태 	:
 				타입 변수명; 			-> 선언
 				타입 변수명 = 초기값;	-> 선언과 동시에 처음값 저장 (초기화)
 	타입 	: 미리 정해진 변수의 크기
 	변수명 	: 메모리 번지 대신에 식별용으로 사용되는 메모리 이름 [카멜표기법 권장]
 	=		: 오른쪽에 데이터를 왼쪽에 대입시킨다.
 	데이터	: 변수에 저장할 데이터
 */