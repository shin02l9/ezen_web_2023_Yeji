package 과제.과제04.Level3_1.ex3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_3 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		
		int july1 = 3532100; 
		int july2 = 9123700;
		int july3 = 5183400;
		int july4 = 11738700;
		
		/* 문제풀이 위치 */
		System.out.println("-------- 7월 매출액 --------");
		for ( int i = 1; i<=4; i++) {
			System.out.printf("%d주차 :", i);
			int j1 = july1/1000000;
			for( int j = 1; j <= j1; j++) {
				System.out.printf("■");
			}
		}
		

			
		
		//모르겠음 못 풀었음
		
		
		
//		System.out.println("1주차 : ■■ 353만원");
//		System.out.println("2주차 : ■■ 353만원");
//		System.out.println("3주차 : ■■ 353만원");
//		System.out.println("4주차 : ■■ 353만원");

		/* ----------- */
	}
}
/* 
	[문제] 
		다음과 같이 july1,july2,july3,july4 변수는 7월의 1주차,2주차,3주차,4주차 의 매출액이 저장된 변수 입니다.
		1. 주차별로 100만원당 도형 '■' 출력하시오.
		2. 도형 뒤로는 그림과 같이 만원대 까지만 출력하시오.
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.

*/
