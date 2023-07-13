package java1.day01;// 현재 클래스가 위치한 패키지명(폴더경로)

public class Ex02_타입 {//class start
	
	public static void main(String[] args) {// main start 
		
		
		// 0. [p.41] 진수를 포함하는 방법
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
		
		
		// 1. [p.42] byte 타입 : 대략 +- 100 정도
		byte b1 = -128; System.out.println("b1:"+b1);
		byte b2 = 127;  System.out.println("b2:"+b2);
		//byte b3 = 200; System.out.println("b3:"+b3); -> 오류뜨는 코드
		
		
		// 2. [p.44] short 타입 : 대략 +- 3만 정도
		short s1 = 3200; System.out.println("s1:"+s1);
		//short s2 = 50000; System.out.println("s2:"+s2); -> 오류뜨는 코드
		
		
		// 3. int 타입 : 대략 +- 21억 정도 ★ 정수의 기본 타입 ! 우리가 직접 작성한 정수
		int i1 = 200000000; System.out.println("i1:"+i1);
		//int i2 = 300000000; System.out.println("i2:"+i2); -> 오류뜨는 코드
		
		
		// 4. long 타입 : 대략 +- 21억 이상 / 조 이상 넘어가면 사실상 문자 처리 ..!~
		long l1 = 10;			System.out.println("l1:"+l1);
		//long l2 = 3000000000;	System.out.println("l2:"+l2); -> 오류뜨는 코드
		long l3 = 3000000000L;	System.out.println("l3:"+l3); 
		
		
		// 5. [p.43] char 타입 : 문자1개 저장 ''
		char c1 = 'A'; // 문자 1개는 작은따옴표''  /  문자열은 큼따옴표 ""  를 사용한다.
		System.out.println("c1:"+c1);
		char c2 = 65;
		System.out.println("c2:"+c2);       //   => 두 코드 모두 'A'가 출력된다. 
		char c3 ='가'; 
		System.out.println("c3:"+c3);
		char c4 = 44032;
		System.out.println("c4:"+c4);		//   => 두 코드 모두 '가'가 출력된다. 
		
		
		// 6. [p.49] String 클래스 : 문자열 저장 ""
		String strl = "안녕하세요"; System.out.println("strl:"+strl);
		
		
		// 7. [p.45] float 타입  : 실수 소수 8자리까지 표현이 가능
		//			 **double 타입 : 실수 소수 16자리까지 표현이 가능 ★ 실수의 기본 타입 
		//float f1 = 0.123456789123456789; System.out.println("f1:"+f1); -> 오류뜨는 코드
		float f1 = 0.123456789123456789f; System.out.println("f1:"+f1); // 반올림된다.
		double d1 = 0.123456789123456789; System.out.println("d1:"+d1);
		
		
		// 8. [p.48] boolean 타입 : 논리형으로 참 true[1] 거짓 false[0] 을 저장
		boolean bool1 = true; 	System.out.println("bool1:"+bool1); 
		
		
		// 9. [p.50] 제어/이스케이프문자
		System.out.println(" \" "); // -> 출력되는 문자 "
		System.out.println(" \' "); // -> 출력되는 문자 '
		System.out.println(" \\ "); // -> 출력되는 문자 \
		System.out.println(" \t "); // -> 출력 시 탭만큼 띄움
		System.out.println(" \n "); // -> 출력 시 줄바꿈 처리
		System.out.println(" \r "); // -> 출력 시 캐리지 리턴 ( 커서를 제일 앞으로 ! )
		
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
			
			
		표현단위 : 진수 : 데이터 표현하는 수의 형식 // 기계어[2진수/이진코드] 표현하는데 한계 극복
			0,1 : 2진수  , 0~7 : 8진수 , 0~9 : 10진수 , 0~9ABCDEF : 16진수 
	
		용량단위 : 
		 	(처리최소단위)비트 : 0,1 -> 1bit		-> 01010101 -> 8자리 -> 8bit -> 1byte
		 	(저장최소단위)바이트 : 1byte -> 1024byte -> 1Kbyte
		 	킬로바이트 : 1kb -> 1024kb -> 1mb
		 	메가바이트 : 1mb -> 1024mb -> 1gb
			
		인코딩 : 2진수를 문자로 표현하는 방법
			아스키코드 	: 7비트 (확장 8비트) -> 128문자 표현 가능 			1바이트 = 특수문자/숫자/영문
			유니코드(JAVA): 전세계의 공용어 문자를 표현 할 수 있는 산업 표준이다.  	2바이트 = 특수문자/숫자/영문/한글
						  다양한 장점이 있지만 용량이 큰 단점도 있다.
			
			 
*/