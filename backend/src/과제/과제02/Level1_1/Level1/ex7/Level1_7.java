package 과제.과제02.Level1_1.Level1.ex7;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_7 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_7 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		String output = "";
		
		/* 문제풀이 위치 */
		System.out.println("회원명:"); String 문자열 = scanner.next(); 
		System.out.println("상태:"); boolean 논리 = scanner.nextBoolean(); 
		System.out.println("회원번호:"); byte 바이트 = scanner.nextByte(); 
		System.out.println("성별:"); char 문자 = scanner.next().charAt(0);
		System.out.println("나이:"); short 쇼트 = scanner.nextShort(); 
		System.out.println("포인트:"); int 인트 = scanner.nextInt(); 
		System.out.println("예금액:"); long 롱 = scanner.nextLong(); 
		System.out.println("키:");float 플롯 = scanner.nextFloat(); 
		System.out.println("몸무게:"); double 더블 = scanner.nextDouble(); 
		
		System.out.println("회원명:" + 문자열);
		System.out.println("상태:" + 논리);
		System.out.println("회원번호:" + 바이트);
		System.out.println("성별:" + 문자);
		System.out.println("나이:" + 쇼트);
		System.out.println("포인트:" + 인트);
		System.out.println("예금액:" + 롱);
		System.out.println("키:" + 플롯);
		System.out.println("몸무게:" + 더블);

		/* ----------- */
	}
}
/* 
	[문제조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 기본 자료형8개 + 문자열클래스 변수 1개 를 이용한 9개변수를 입력 받습니다.
		3. 입력받은 9개 변수를 그림과 같이 출력합니다.
		4. 기존에 미리 작성된 변수를 최대한 활용합니다.
		
*/
