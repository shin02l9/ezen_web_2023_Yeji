package java1.day04;

import java.util.Scanner;

public class Ex01_반복문 { //class s

	public static void main(String[] args) { // main s
		
		// [p.124] for문 없이 1~10까지 누적합계 구하기
		int sum = 0;
		sum = sum+1; sum+=2; sum+=3; sum+=4; sum+=5; sum+=6; sum+=7; sum+=8; sum+=9; sum+=10;
		
		// 이번에는 for문을 이용!
		int sum2 = 0;
		for (int i = 1; i<=10; i++) {sum2 += i;}
		System.out.println(sum2);
		
		// [p.125] 1~ 10까지 출력
		//1. for문 없이 한다면
		//System.out.println(1); System.out.println(2); System.out.println(3); System.out.println(4); System.out.println(5);
		//System.out.println(6); System.out.println(7); System.out.println(8); System.out.println(9); System.out.println(10);
		//2. for문으로 !
		for ( int i= 1; i<=10; i++) {System.out.println(i);}
		
		// [p.126] 초기값 변수는 for문에서 선언시 지역변수이다.
		int sum3 = 0;
		for( int 반복변수 = 1; 반복변수 <=10; 반복변수++) { sum3 += 반복변수; }
		//System.out.println( 반복변수 ); -> 출력할수 없음 반복변수는 for문 안에서 선언되어있기 때문에
		int sum4 = 0; int j;
		for( j = 1; j <=100; j++) { sum3 += j; }
		System.out.println("1~" + (j-1) + "합 : " + sum4);
		
		// [p.126] 실수 정확히 0.1를 증가하는것을 구현하지 못함 !....
		for ( float x = 0.1f; x<=1.0f; x+=0.1f) {System.out.println( x + ""); }
		System.out.println("--------------------------------------");
		for ( double x = 0.1; x<=1.0; x+=0.1) {System.out.println( x + ""); }
		
		// [p.128] 구구단
		//1. for문 없이
		System.out.println( "2단" );
		System.out.println( "2 x 1 = "+(2*1) );
		System.out.println( "2 x 2 = "+(2*2) );
		System.out.println( "2 x 3 = "+(2*3) );
		System.out.println( "2 x 4 = "+(2*4) );
		System.out.println( "2 x 5 = "+(2*5) );
		System.out.println( "2 x 6 = "+(2*6) );
		System.out.println( "2 x 7 = "+(2*7) );
		System.out.println( "2 x 8 = "+(2*8) );
		System.out.println( "2 x 9 = "+(2*9) );
		System.out.println("--------------------------------------");
		//2. for문 사용하기
		// for ( int i = 2; i<=9; i++) {System.out.println( "2 x " +i +" = "+(2*i) );}
		for ( int i = 2; i<=9; i++) {
			System.out.printf( " \n < %d단 > \n", i );
			for ( int x = 1; x<=9; x++) {
				System.out.printf( " %d x %d = %d \n", i,x,i*x );
			}
		}
		
		
		// [p.129 vs p.124] 1~10 출력
		int a = 1;
		while ( a<=10 ) {System.out.println( a + ""); a++;}
		int b = 1;
		int sum5 = 0;
		while( b <=100) { sum5 += b; System.out.println(sum5); b++;}
		
		// [p.131] 무한루프
		  // 1. while (true) {System.out.println(" 무한반복 ");} ★
		  // 2. for (;;){System.out.println(" 무한반복 ");}
		  // 3. while( run ){System.out.println(" 무한반복 ");}
		Scanner sc = new Scanner(System.in);
		boolean run = true; // while문 true/ false 저장하는 변수 , on/off
		int speed = 0;
		while( run ) { // while s
			// 무한출력
			System.out.println(" ------------------------- ");
			System.out.println(" 1. 증속 | 2. 감속 | 3. 중지 ");
			System.out.println(" ------------------------- ");
			System.out.print("  선택 :  ");
			//무한입력
			String strNum = sc.nextLine();
			
			if ( strNum.equals("1")) {// 만약에 입력이 1이면
				speed++;
			} else if ( strNum.equals("2")) {// 만약에 입력이 2이면
				speed--;
			} else if ( strNum.equals("3")) {// 만약에 입력이 3이면
				run = false;
			}
			
		}// while e
		
		// [p. 135] 
			// 1. for 문에 식별이름 정의 : for 이름: for (){}
			// 2. break; 
			///		가장 가까운 반복문 탈출, continue for이름 
			// 2. break for이름;
			//		해당 이름의 반복문 탈출
			// 3. continue; 
			//		가장 가까운 반복문 증감식/조건식으로 이동
			// 3. continue for이름;
			//		해당하는 이름의 반복문 증감식/조건식으로 이동
			// 이 두가지의 공통점 : 키워드가 발동을 했을때 아래 코드는 실행되지 않는다.
		대문자for : for ( char upper = 'A'; upper <= 'Z'; upper++) {
			System.out.print( upper + "");
			소문자for : for ( char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println( "\t" +lower);
				if( lower == 'g') break 대문자for;
			} // for 2 e
			System.out.println( );
		}// for 1 e
		
		
		// [p. 137] 
		숫자for : for ( int t = 1; t <=10; t++) {
			if ( t % 2 != 0) {
				continue 숫자for;
			} // if end
			System.out.println( t + "");
		}
		
		
		
	} // main e
	
	
} // class e

/*

	for 문
		for ( 1.초기값; 2.조건식; 4.증감식 ) {
					3. 실행문;
		}
		1. 초기값이 실행된다.
		2. 조건식 판단해서 true 이면 {} 들어감 / false {} 건너뜀,종료
		3. true 이면 실행문 실행
		4. 초기값이 들어있는 변수에 증감식
		5. 조건식 판단해서 ~~~~ 2,3,4,2,3,4 반복 !! 
	
	while 문
		1.초기값;
		while (2.조건식;){3.실행문;4.증감식;}
		- 1, 4번이 필수는 아님!
		- 조건식 판단해서 true이면 {} 들어감, false {} 건너뜀/종료
		- true 이면 실행문 실행
		
		
	* 일반적으로 패턴이 있는 경우 for문 사용
	* 무한루프 만들때는 while 
		
		
 */