package java1.day03;

import java.util.Random;

public class Ex01_조건문 { //class s
	public static void main(String[] args) { // main s
		
		//1. [p.111] 
		int score = 93;
		if( score >= 90 ) System.out.println("합격");
		
		//2. 
		if( score >= 90 ){
			System.out.println("2. 점수가 90점 보다 높습니다.");
			System.out.println("2. A 등급입니다.");
		}
		//2. 
		if( score < 90 ){
			System.out.println("2. 점수가 90점 보다 낮습니다.");
			System.out.println("2. B 등급입니다.");
		}
		
		//3. [p.113] 
		if( score >= 90 ){
			System.out.println("3. 점수가 90점 보다 높습니다.");
			System.out.println("3. A 등급입니다.");
		}else {
			System.out.println("3. 점수가 90점 보다 낮습니다.");
			System.out.println("3. B 등급입니다.");
		}
		
		// 4. [p.114] 
		if ( score >= 90 ) {
			System.out.println("4. 점수가 100~90 입니다.");
			System.out.println("4. A 등급입니다.");
		}else if ( score >= 80 ) {
			System.out.println("4. 점수가 90~80 입니다.");
			System.out.println("4. B 등급입니다.");
		}else if ( score >= 70 ) {
			System.out.println("4. 점수가 80~70 입니다.");
			System.out.println("4. C 등급입니다.");
		}else {
			System.out.println("4. 점수가 70 미만 입니다.");
			System.out.println("4. D 등급입니다.");
		}
			
		
		// 5. [p.115] 난수를 생성할대 사용하는 함수  [Math.random()]
		System.out.println( Math.random() ); // 0<= ~  < 1.0
		System.out.println( Math.random()*6 ); // 0<= ~  < 6.0
		System.out.println( (int)(Math.random()*6) ); // 0<= ~  < 6 [ int로 강제형변환을 해서 소수점 삭제 ]
		System.out.println( (int)(Math.random()*6) +1 ); // 1<= ~  < 7
		// 정수의 난수를 만드는 공식 
		// System.out.println( (int)(Math.random()*n) + s )
			// n은 난수의 개수, s는 시작숫자
		//-----------------------------------------vs-----------------------------------------
		// 난수를 만들때 클래스가 하나더 있음 [Random]
			//1. Random 객체 생성하고
		Random random = new Random();
			//2. 호출한다.  random.next타입명(); : 타입의 허용범위 내 난수 생성 
		System.out.println( random.nextBoolean());
		System.out.println( random.nextDouble());
			// random.nextInt(개수) + 시작번호
		System.out.println( random.nextInt(45)+1);  // 1~45
			// 문자로 예시들면
		System.out.println( (char)(random.nextInt(26)+97));  // 97~122

		
		// 6. 주사위 [p.116]
		int num = (int)(Math.random()*6)+ 1; //1~6
		// int num = random.nextInt(6)+1);
		
		if( num == 1) {System.out.println("1 나왔습니다.");}
		else if( num == 2) {System.out.println("2 나왔습니다.");}
		else if( num == 3) {System.out.println("3 나왔습니다.");}
		else if( num == 4) {System.out.println("4 나왔습니다.");}
		else if( num == 5) {System.out.println("5 나왔습니다.");}
		else {System.out.println("6 나왔습니다.");}
		//-----------------------------------------vs-----------------------------------------
		// switch를 이용한 예제
		switch (num) { // num 변수를 연결해서 제어 하겠다는 뜻
		case 1: {System.out.println("1 나왔습니다.");} break;
		case 2: {System.out.println("2 나왔습니다.");} break;
		case 3: {System.out.println("3 나왔습니다.");} break;
		case 4: {System.out.println("4 나왔습니다.");} break;
		case 5: {System.out.println("5 나왔습니다.");} break;
		default: {System.out.println("6 나왔습니다.");} 
		}
		
		
		
		// 7. if 의 충접 [p.117]
		int score3 = (int)( Math.random() *20) + 81;
		String grade;
		
		if ( score3 >= 90) {
			if(score3 >= 95) { grade = "A+"; }  // [100~95]이면서 95 이상이면 A+ 대입
			else { grade = "A"; }				// [94~90]이면서 95 미만이면 A 대입
		}else { 
			if(score3 >= 85) { grade = "B+"; }  // [89~85]이면서 85 이상이면 B+ 대입
			else {grade = "B";}					// [84~]이면서 85 미만이면 B 대입
		}
		
		// 8. [p.121]
		char grade2 = 'B';
		switch (grade2) {
		case 'A': 
		case 'a': 
			System.out.println("A등급 우수 회원입니다."); break;
		case 'B': 
		case 'b': 
			System.out.println("B등급 우수 회원입니다."); break;
		default: System.out.println("일반 회원입니다.");
		}
		
	} // main e

} // class e



/*

	if : 만약에 조건이 충족하면true 이면 충족하지 않으면false 
		 -> 조건에 따른 흐름제어 ! 
		- 형태
			1. if ( 조건식 ) 실행문;
			2. if ( 조건식 ){ 실행문; 실행문; }
				* 만약에 참/거짓 실행문이 2개 이상일 경우 {} 묶음! 헷갈리면 그냥 다 묶어버리기
			3. if ( 조건식 ){참일 경우 실행문}
				else {거짓일 경우 실행문}
			4. if ( 조건식 ) [ 참1일 경우 실행문 }
				else if ( 조건식2 ) { 참2일 경우 실행문 }
				else if ( 조건식3 ) { 참3일 경우 실행문 }
				else {거짓일 경우 실행문}
					* {다수조건의 하나의 결과}조건이 하나라도 충족할 경우 참 실행문 실행 후 전체 if 종료 ! 
			4. if ( 조건식1 ) [ 참1일 경우 실행문 }
			   if ( 조건식2 ) [ 참2일 경우 실행문 }
			   if ( 조건식3 ) [ 참3일 경우 실행문 }
			   if ( 조건식4 ) [ 참4일 경우 실행문 }
			   		* {다수 조건의 다수의 실행문 처리}
			5. if 의 충접
				if (){
					if(){}
				} else {
					if(){}
				}
				
	switch (변수){          // 비교 연산은 불가능하다.
		case 값1 :          break;
		case 값2 :          break;
		case 값3 :          break;
		default : 
		}
		* if는 조건에 따른 참과 거짓을 실행 / 범위 논리 o
		* switch는 변수 값에 따른 실행
		 	- 경우의 수의 값이 정해져 있을때 / 범위 논리 x 속도가 빠름 
		 	- break; 써줘야 함 ! 
 */