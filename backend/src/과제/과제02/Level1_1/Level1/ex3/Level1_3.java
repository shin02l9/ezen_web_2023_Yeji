package 과제.과제02.Level1_1.Level1.ex3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_3 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		/* 문제풀이 위치 */
		System.out.println("char:"); char 문자 = scanner.next().charAt(0);
		System.out.println("boolean:"); boolean 논리 = scanner.nextBoolean(); 
		System.out.println("byte:"); byte 바이트 = scanner.nextByte(); 
		System.out.println("short:"); short 쇼트 = scanner.nextShort(); 
		System.out.println("int:"); int 인트 = scanner.nextInt(); 
		System.out.println("long:"); long 롱 = scanner.nextLong(); 
		System.out.println("float:");float 플롯 = scanner.nextFloat(); 
		System.out.println("double:"); double 더블 = scanner.nextDouble(); 
		
		System.out.println("char:" + 문자);
		System.out.println("boolean:" + 논리);
		System.out.println("byte:" + 바이트);
		System.out.println("short:" + 쇼트);
		System.out.println("int:" + 인트);
		System.out.println("long:" + 롱);
		System.out.println("float:" + 플롯);
		System.out.println("double:" + 더블);
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개를 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. print() 메소드 사용
		3. scanner 객체 사용하여 입력받기
*/
