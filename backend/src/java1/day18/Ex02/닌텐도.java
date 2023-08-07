package java1.day18.Ex02;

import java.util.Scanner;

// 실행
public class 닌텐도{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. 게임 패드 생성 
		게임패드 신예지패드 = null;
		
		while (true) {
			System.out.println("1. 동물의 숲 | 2. 커비 ");
			int ch = sc.nextInt();
			
			if( ch == 1 ) {
				신예지패드 = new 동물의숲칩();
				System.out.println(" 동물의 숲 실행 ");
			} else if( ch == 2 ) {
				신예지패드 = new 커비칩();
				System.out.println(" 커비 실행 ");
			} 
			
			while (true){
				System.out.println("  ");
				String btn = sc.next();
				if( btn.equals('A') ) { 신예지패드.A버튼(); }
				if( btn.equals('B') ) { 신예지패드.B버튼(); }
				if( btn.equals('X') ) { 신예지패드.X버튼(); }
				if( btn.equals('Y') ) { 신예지패드.Y버튼(); }
				if( btn.equals('Q') ) { break; }
				
				
				
			}
		}

	}
}
