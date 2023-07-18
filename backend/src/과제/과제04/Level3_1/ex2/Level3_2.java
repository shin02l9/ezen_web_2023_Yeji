package 과제.과제04.Level3_1.ex2;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_2 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_2 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		
		/* 문제풀이 위치 */
		for( int i = 1; true; i++) { // for s
			// 무한출력
			System.out.print(i+"회 입력 : ");
			//무한입력
			String str = scanner.nextLine();
			if ( str.equals("end")) {// 만약에 입력이 end이면
				System.out.printf("안내) 프로그램 종료 합니다. [총 %d회 입력]", i-1);
				
				break;
			}
			
		}// for e
		/* ----------- */

	}
}
/* 
	[문제] 
		그림과 같이 무한적으로 문자열을 입력 받다가 end 입력시 
		입력받은 횟수와 문구를 출력후 종료되는 반복문을 구현하시오.
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.

*/
