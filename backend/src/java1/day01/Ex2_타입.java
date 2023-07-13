package java1.day01;// 현재 클래스가 위치한 패키지명(폴더경로)

public class Ex2_타입 {//class start
	
	public static void main(String[] args) {// main start 
		
		
		// 1. [p.41] 진수를 포함하는 방법
			// 진수 : 테이터를 표현하는 수의 형식
			// 0, 1 : 2진수 , 0~ 7 : 8진수 , 0~9 : 10진수, 0~9ABCDEF : 16진수
		
		int var1 = 0b1011; // (2진수) 데이터 앞에 0b       1011[2] -> 11[10]
		System.out.println( "var1:" + var1);
		
		int var2 = 0206; // (8진수) 데이터 앞에 0          206[8]  -> 134[10]
		System.out.println( "var2:" + var2);
		
		int var3 = 365; // (10진수) x        		   
		System.out.println( "var3:" + var3);
		
		int var4 = 0xB3; // (16진수) 데이터 앞에 0x  	   
		System.out.println( "var4:" + var4);
		
		
		// 2. [p.42] byte 타입 : 대략 +- 100 정도
		byte b1 = -128; System.out.println("b1:"+b1);
		byte b2 = 127;  System.out.println("b2:"+b2);
		//byte b3 = 200; System.out.println("b3:"+b3); -> 오류뜨는 코드
		
		
		// 3. [p.44] short 타입 : 대략 +- 3만 정도
		short s1 = 3200; System.out.println("s1:"+s1);
		//short s2 = 50000; System.out.println("s2:"+s2); -> 오류뜨는 코드
		
		
		// 4. [p.] int 타입 : 대략 +- 21억 정도 ★ 정수의 기본 타입 ! 우리가 직접 작성한 정수
		int i1 = 200000000; System.out.println("i1:"+i1);
		//int i2 = 300000000; System.out.println("i2:"+i2); -> 오류뜨는 코드
		
		
		// 5. [p.] long 타입 : 대략 +- 21억 이상 / 조 이상 넘어가면 사실상 문자 처리 ..!~
		long l1 = 10;			System.out.println("l1:"+l1);
		//long l2 = 3000000000;	System.out.println("l2:"+l2); -> 오류뜨는 코드
		long l3 = 3000000000L;	System.out.println("l3:"+l3); 
		
	}// main end

}//class end



/*
	타입/자료형 : 자바는 다양한 기본타입을 저장 할 수 없다.
		JS : let, const
		JAVA :
		1. 장점
			- 메모리의 효율성을 높일 수 있다.
			- 가독성이 높다.
		2. 타입 종류				메모리크기			허용범위
			- 논리타입
			- 문자타입
			- 문자열타입
			- 정수형타입
			- 실수형타입
		ex)
			선물상자 = 변수
			사탕 = 데이터
			500상자 엄마꺼 = 지갑선물
			500상자 아빠꺼 = 시계선물
			
			
			
			//선생님 깃 확인
*/