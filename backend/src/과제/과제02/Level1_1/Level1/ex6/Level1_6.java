package 과제.과제02.Level1_1.Level1.ex6;

public class Level1_6 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_6 answer >> \n");
		
		
		short value1 = 30000;			
		int value2 = 2000000000;		
		long value3 = 40000000000L;		
		float value4 = 3.123123123F;	
		double value5 = 3.123123123;	
		
		/* 문제풀이 위치 */
		
		byte value01 = (byte)value1; System.out.println("byte <- short :" + value01);
		short value02 = (short)value2; 	System.out.println("short <- int :" + value02);
		int value03 = (int)value3;  System.out.println("int <- long :" + value03);
		long value04 = (long)value4; System.out.println("long <- float :" + value04);
		float value05 = (float)value5;  System.out.println("float <- double :" + value05);
		

		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 5개 선언되어 있습니다. 그림과 같이 강제 형변환을 하여 출력하시오.
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 강제 형변환 만 사용하여 그림과 같이 출력합니다.
		
*/
