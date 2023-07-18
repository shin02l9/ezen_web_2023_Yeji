package 과제.과제03.Level2;

import java.util.Scanner;

public class 조건문풀이과제 { // class s
	public static void main(String[] args) { // main s
		
		Scanner sc = new Scanner( System.in ); 
		
		// 문제1 : 2개의 정수를 입력받아서 더 큰수 출력 [ 경우의수 : 3개(크다,작다,같다=그외) ]
		/* -------문제1 풀이 ----- */
		System.out.println( "-------------- 문제1 풀이 --------------" );
		System.out.println( "정수1 입력 :" ); int 정수1 = sc.nextInt();
		System.out.println( "정수2 입력 :" ); int 정수2 = sc.nextInt();
		if( 정수1>정수2 ) {
			System.out.println( "더 큰수 : " + 정수1);
		} else if ( 정수1<정수2 ) { 
			System.out.println( "더 큰수 : " + 정수2);
		} else {
			System.out.println( "같은 수 입니다.");
		}

		
		
		// 문제2 : 3개의 정수를 입력받아서 더 큰수 출력 [ 경우의수 : 3개(크다,작다,같다=그외) ]
		/* -------문제2 풀이 ----- */
		System.out.println( "-------------- 문제2 풀이 --------------" );
		System.out.println( "정수3 입력 :" ); int 정수3 = sc.nextInt();
		System.out.println( "정수4 입력 :" ); int 정수4 = sc.nextInt();
		System.out.println( "정수5 입력 :" ); int 정수5 = sc.nextInt();
		if (정수3 > 정수4 ) { // 첫번째 값이 두번째 값보다 클때
			if(정수3 > 정수5 ) { System.out.println( "가장큰수 : " + 정수3);
			}else  {System.out.println( "가장큰수 : " + 정수5);}
		}else if(정수4 > 정수5 ) {
			System.out.println( "가장큰수 : " + 정수4);
		}
		

		
		// 문제3 : 3개의 정수를 입력받아서 오름차순[>] / 내림차순[<] [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ]
		/* -------문제3 풀이 ----- */
		System.out.println( "-------------- 문제3 풀이 --------------" );
		System.out.println( "비교정수1 입력 :" ); int 비교정수1 = sc.nextInt();
		System.out.println( "비교정수2 입력 :" ); int 비교정수2 = sc.nextInt();
		System.out.println( "비교정수3 입력 :" ); int 비교정수3 = sc.nextInt();
		
		if(비교정수1 > 비교정수2){
			int temp = 비교정수1; 
			비교정수1 = 비교정수2;
			비교정수2 = temp;
		}
		if(비교정수1 > 비교정수3){ 
			int temp = 비교정수1;
			비교정수1 = 비교정수3;
			비교정수3 = temp;
		}
		if(비교정수2 > 비교정수3){ 
			int temp = 비교정수2;
			비교정수2 = 비교정수3;
			비교정수3 = temp;
		}
		
		System.out.printf( " %3d > %3d > %3d \n", 비교정수1, 비교정수2, 비교정수3);
		
		
		
		// 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 [ 경우의수 : 2개 ]
		/* -------문제4 풀이 ----- */
		System.out.println( "-------------- 문제4 풀이 --------------" );
		System.out.println( "점수 입력 :" ); int 점수 = sc.nextInt();
		if( 점수 >= 90 ) {
			System.out.println( " < 합격 > " );
		} else System.out.println( " < 불합격 > " );
		
		
		
		// 문제5 : 
		// 점수를 입력받아 점수가 90점 이상이면 A등급
		//				점수가 80점 이상이면 B등급
		//				점수가 70점 이상이면 C등급
		//				그외 재시험
		/* -------문제5 풀이 ----- */
		System.out.println( "-------------- 문제5 풀이 --------------" );
		System.out.println( "점수5 입력 :" ); int 점수5 = sc.nextInt();
		if( 점수5 >= 90 ) {
			System.out.println( " < A등급 > " );
		} else if ( 점수5 >= 80 ) {
			System.out.println( " < B등급 > " );
		} else if ( 점수5 >= 70 ) {
			System.out.println( " < C등급 > " );
		} else {System.out.println( " < 재시험 > " );}
		
		
		
		// 문제6	[ 경우의수 3개 , 첫번째 경우의수 : 3개 , 두번째 경우의수 : 3개 ] 총 9개  
		//[ 입력 ] : 국어,영어,수학 입력받기
		//[ 조건 ]
		//	평균이 90점 이상이면서 
		//		국어점수 100점 이면 '국어우수' 출력
		//		영어점수 100점 이면 '영어우수' 출력
		//		수학점수 100점 이면 '수학우수' 출력
		//	평균이 80점 이상이면서 
		//		국어점수 90점이상 이면 '국어장려' 출력
		//		영어점수 90점이상 이면 '영어정려' 출력
		//		수학점수 90점이상 이면 '수학장려' 출력
		//		그외 재시험 
		/* -------문제6 풀이 ----- */
		System.out.println( "-------------- 문제6 풀이 --------------" );
		System.out.println( "국어점수 입력 :" ); int 국어점수 = sc.nextInt();
		System.out.println( "영어점수 입력 :" ); int 영어점수 = sc.nextInt();
		System.out.println( "수학점수 입력 :" ); int 수학점수 = sc.nextInt();
		
		int 평균 = (국어점수+영어점수+수학점수)/3;
		 
		if( 평균 >= 90 ) {
			if( 국어점수 == 100 ) {
				System.out.println( "★ 국어우수 ★" );
			} else if ( 영어점수 == 100 ) {
				System.out.println( "★ 영어우수 ★" );
			} else if ( 수학점수 == 100 ) {
				System.out.println( "★ 수학우수 ★" );
			}
		} else if ( 평균 >= 80 ) {
			if( 국어점수 >= 90 ) {
				System.out.println( "★ 국어장려 ★" );
			} else if ( 영어점수 >= 90 ) {
				System.out.println( "★ 영어정려 ★" );
			} else if ( 수학점수 >= 90 ) {
				System.out.println( "★ 수학장려 ★" );
			}
		} else { System.out.println( " 재시험 " ); }
		 
		
		
		
		// 문제7 로그인페이지
 		//[ 입력 ] : 아이디와 비밀번호를 입력받기
 		//[ 조건 ] : 회원아이디가 admin 이고 
        //  			비밀번호가 1234 일 경우에는 
        //  			로그인 성공 아니면 로그인 실패 출력
		// * 비교/산술 연산자는 객체에서 사용 불가능 [기본타입vs객체 메모리 구조가 다르다.]
				 // 문자열은 ==으로 비교할 수 없다. 그래서 .equals() 를 사용해야함.
				 // 기본타입은 데이터 비교시 [ 3 == 3 ]이 가능하다.
				 // 문자열은 [ "안녕".equals("안녕") ] 이렇게 비교해야함. 스크립트는 위처럼 문자열도 비교가능.
		/* -------문제7 풀이 ----- */
		System.out.println( "-------------- 문제7 풀이 --------------" );
		System.out.println( "아이디 입력 :" ); 	String 아이디 = sc.next();
		System.out.println( "비밀번호 입력 :" ); 	String 비밀번호 = sc.next();
		if( 아이디.equals("admin") && 비밀번호.equals("1234")) {
			System.out.println( "[로그인 성공]" );
		} else {System.out.println( "[로그인 실패]" );}
		
		
	} // main e

} // class e
