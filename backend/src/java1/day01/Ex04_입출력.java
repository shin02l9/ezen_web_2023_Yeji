package java1.day01;

import java.util.Scanner;

public class Ex04_입출력 { // class s
	public static void main(String[] args) {// main s
		
		
		// 1. 출력 (콘솔에 출력하는 방법이 딱 3가지 있음)
			// 1. System.out.print("출력하고 싶은 말" or 변수명);    : 출력만
			System.out.print("출력문구1");
			System.out.print("출력문구2");
			// 2. System.out.println("출력하고 싶은 말" or 변수명);  : 출력 후 줄바꿈
			System.out.println("출력문구3");
			System.out.println("출력문구4");
			// 3. [p.69] System.out.printf("형식/포멧/모양", 값/변수 ); 	   : 형식 문자열에 맞춰 값을 출력
			// d: 정수 , f: 실수 , s: 문자열
			int value = 2500;
			// d: 정수
			System.out.printf("상품의 가격: %d원 \n", value);	 		// %d 위치에 value를 출력한다.
			System.out.printf("상품의 가격: %6d원 \n", value);  		// %6d 는 6칸의 정수자리수를 확보한 후에 출력한다. 자리수가 비어있으면 공백처리.
			System.out.printf("상품의 가격: %-6d원 \n", value); 		// 왼쪽 정렬 (-를 안넣으면 오른쪽 정렬이 기본값이다.)
			System.out.printf("상품의 가격: %06d원 \n", value); 		// 만약에 비어있는 자리수가 있다면 공백이 아니라 0으로 채운다.
			// f: 실수
			System.out.printf("반지름 파이: %f \n", 3.14);
			System.out.printf("반지름 파이: %.1f \n", 3.14); 	 		// .소수점자릿수f 
			// s: 문자열
			System.out.printf("회원 아이디 : %s \n", "yeji199602"); 	// 문자열 출력
			
		// 2. 입력
			// 1. 입력 객체를 생성한다. { } 마다 하나씩 필요 
			// Scan + 컨트롤 + 스페이스바  /자동완성 가능
			// new 연산자 : 객체에 메모리 할당/생성
			// Scanner() : 클래스 생성자 ( 객체 생성시 초기값 대입하는 메소드 )  = 클래스명과 무조건 동일
			Scanner scanner = new Scanner( System.in ); //System.in : 시스템 입력 = 키보드 . System.out : 시스템 출력 = 콘솔창
			// └>붕어빵틀 └>붕어빵1 =   └>굽기	  └>(밀가루, 팥/크림)
			// 2. 입력 객체를 이용한 입력값 호출
				// 1. 입력받은 문자열 가져오기 scanner.next();
				// 2. 변수에 저장하기 
				String 문자열 = scanner.next(); 
					//scanner.next(); 띄어쓰기 불가능     vs     scanner.nextLine(); 띄어쓰기 입력가능
				// 3. 출력하기
				System.out.println("입력된 문자열:" + 문자열);
				boolean 논리 = scanner.nextBoolean(); System.out.println("입력된 논리:" + 논리);
				byte 바이트 = scanner.nextByte(); System.out.println("입력된 바이트:" + 바이트);
				short 쇼트 = scanner.nextShort(); System.out.println("입력된 쇼트:" + 쇼트);
				int 인트 = scanner.nextInt(); System.out.println("입력된 인트:" + 인트);
				long 롱 = scanner.nextLong(); System.out.println("입력된 롱:" + 롱);
				float 플롯 = scanner.nextFloat(); System.out.println("입력된 플롯:" + 플롯);
				double 더블 = scanner.nextDouble(); System.out.println("입력된 더블:" + 더블);

				
	}// main e
 
}// class e
