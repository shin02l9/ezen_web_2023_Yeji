package java1.day04;

import java.util.Scanner;

public class Ex02_확인문제7_p139 { // class s
	
	public static void main(String[] args) { // main s
		
		Scanner sc = new Scanner(System.in);
	
		boolean run = true;
		int 잔고 = 0;
		while ( run ) { // while s
			//무한출력
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");
			System.out.print(" 선  택 > "); 
			//무한입력
			int num = sc.nextInt();
			// 실행 조건
			if( num == 1 ) {
				System.out.print(" 예금액 > "); int 예금액 = sc.nextInt();
				잔고 += 예금액;
			} else if( num == 2 ) {
				System.out.print(" 출금액 > "); int 출금액 = sc.nextInt();
				잔고 -= 출금액;
			} else if( num == 3 ) {
				System.out.println(" 잔  고 > " + 잔고);
			} else if( num == 4 ) {
				System.out.println(" 프로그램 종료 "); run = false;}
		} // while e 
		
		
		
		
		
	}// main e
}// class e
