package java1.day04;

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

 */