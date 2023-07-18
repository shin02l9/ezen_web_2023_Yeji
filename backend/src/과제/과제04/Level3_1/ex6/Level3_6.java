package 과제.과제04.Level3_1.ex6;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Level3_6 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_6 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		/* 문제풀이 위치 */
		boolean run = true;
		int 좌석1 = 0; int 좌석2 = 0; int 좌석3 = 0;
		int 좌석4 = 0; int 좌석5 = 0; int 좌석6 = 0;
		while ( run ) { // while s
			//무한출력
			System.out.println("------------------------------");
			System.out.println("1.예약하기 | 2.예약취소 | 3.예약현황");
			System.out.println("------------------------------");
			System.out.print(" 선  택 > "); 
			//무한입력
			int num = scanner.nextInt();
			// 실행 조건
			if( num == 1 ) {
				System.out.printf("  좌석1  좌석2  좌석3 \n [ %d ] [ %d ] [ %d ]\n\n  좌석4  좌석5  좌석6 \n [ %d ] [ %d ] [ %d ] \n\n", 좌석1, 좌석2, 좌석3, 좌석4, 좌석5, 좌석6);
				System.out.print(" 좌석을 선택해주세요. : "); 
				int 선택좌석 = scanner.nextInt();
				if ( 선택좌석 <= 6) {
					if( 선택좌석 == 1) { 
						if ( 좌석1 == 0) {
						System.out.print(" 예약 성공 "); 
						좌석1 = 1; 
						}
						else {System.out.print(" 이미선택된 좌석입니다. "); }
					} 
					if( 선택좌석 == 2) { 
						if ( 좌석2 == 0) {
						System.out.print(" 예약 성공 "); 
						좌석2 = 1; 
						}
						else {System.out.print(" 이미선택된 좌석입니다. "); }
					} 
					if( 선택좌석 == 3) { 
						if ( 좌석3 == 0) {
						System.out.print(" 예약 성공 "); 
						좌석3 = 1; 
						}
						else {System.out.print(" 이미선택된 좌석입니다. "); }
					} 
					if( 선택좌석 == 4) { 
						if ( 좌석4 == 0) {
						System.out.print(" 예약 성공 "); 
						좌석4 = 1; 
						}
						else {System.out.print(" 이미선택된 좌석입니다. "); }
					} 
					if( 선택좌석 == 5) { 
						if ( 좌석5 == 0) {
						System.out.print(" 예약 성공 "); 
						좌석5 = 1; 
						}
						else {System.out.print(" 이미선택된 좌석입니다. "); }
					} 
					if( 선택좌석 == 6) { 
						if ( 좌석6 == 0) {
						System.out.print(" 예약 성공 "); 
						좌석6 = 1; 
						}
						else {System.out.print(" 이미선택된 좌석입니다. "); }
					} 
				} else { System.out.print(" 없는 좌석입니다. ");  }
			} else if ( num == 2 ) {
				System.out.print(" 취소할 좌석을 선택해주세요. : "); 
				int 선택좌석 = scanner.nextInt();
				if( 선택좌석 == 1) { 좌석1 = 0; }
				else if ( 선택좌석 == 2) { 좌석2 = 0; }
				else if ( 선택좌석 == 3) { 좌석3 = 0; }
				else if ( 선택좌석 == 4) { 좌석4 = 0; }
				else if ( 선택좌석 == 5) { 좌석5 = 0; }
				else if ( 선택좌석 == 6) { 좌석6 = 0; }
				else {System.out.print(" 없는 좌석입니다. "); }
				System.out.print(" 좌석이 취소되었습니다. ");
			} else if ( num == 3 ) {
				//모르겠습니다!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
			
			
			
		} // while e 
		/* ----------- */
		
	}
}

/* 
	주제 : 예약 좌석 시스템
	실행결과는 제공하지 않습니다.
	
	- 변수 조건 
		1. 변수 : 6개의 좌석 은 변수를 이용합니다. [ 배열X ]
		2. 그외 자유롭게 사용. 배열/리스트 사용 금지 [ day1~day4 문법 이용 ]
	- 메뉴 조건
		0. 메뉴 : 1.예약하기 2.예약취소 3.예약현황 
	- 기능 조건 
	 	예약하기 출력예시 )
	 		1. 예약할 좌석을 선택한다.
	 		2. 만약에 비어 있으면 예약성공 아니면 예약 실패 
	 	예약취소 출력예시 )
	 		1. 예약할 취소할 좌석을 선택한다.
	 	예약현황 출력예시 )
	 		* 3개씩 2줄로 출력합니다.
			[ 예약 ]	[ ]	[ ]
			[ ] [예약] [ ]  
			- 예약이 되어 있는 좌석은 [예약] 예약이 없으면 [ ] 공란으로 출력합니다.
			
*/
