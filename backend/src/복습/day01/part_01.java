package 복습.day01;

import java.util.Scanner;

public class part_01 { // class s
	public static void main(String[] args) { // main s

		int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
	    int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
	    int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
		int 총가격 = 0;
	    Scanner scanner = new Scanner( System.in );
	    
		while( true ) { // while s
			System.out.println("----------------------- 메뉴 -----------------------");
			System.out.println("1. 콜라(300) | 2. 환타(200) | 3. 사이다(100) | 4. 결제");
			System.out.println("---------------------------------------------------");
			System.out.println(" 선택 >> "); int ch = scanner.nextInt();
			
			if( ch == 1 ) {
				if ( 콜라재고 != 0 ) {
				System.out.println("안내) 콜라를 선택 하셨습니다.");
				콜라재고--; 콜라바구니++;  총가격+=콜라가격;
				} else { System.out.println("안내) 콜라 재고가 부족합니다."); }
			} else if ( ch == 2 ) {
				if ( 환타재고 != 0 ) {
				System.out.println("안내) 환타를 선택 하셨습니다.");
				환타재고--; 환타바구니++;  총가격+=환타가격;
				} else { System.out.println("안내) 환타 재고가 부족합니다."); }
			} else if ( ch == 3 ) {
				if ( 사이다재고 != 0 ) {
				System.out.println("안내) 사이다를 선택 하셨습니다.");
				사이다재고--; 사이다바구니++;  총가격+=사이다가격;
				} else { System.out.println("안내) 사이다 재고가 부족합니다."); }
			} else if ( ch == 4 ) {
				System.out.println("---------- 장바구니 ----------");
				System.out.printf(" %5s  %5d  %5d \n" , "콜라", 콜라바구니, 콜라바구니*콜라가격);
				System.out.printf(" %5s  %5d  %5d \n", "환타", 환타바구니, 환타바구니*환타가격);
				System.out.printf(" %5s  %5d  %5d \n", "사이다", 사이다바구니, 사이다바구니*사이다가격);
				System.out.println("안내) 결제 하실 금액은"+ 총가격 + "원 입니다.");
				System.out.println("1. 결제 | 2. 취소"); int ch2 = scanner.nextInt();
				if ( ch2 == 1 ) {
					System.out.println("안내) 결제 금액 투여 >>"); int 결제금액 = scanner.nextInt();
					if ( 결제금액 == 총가격) {
						System.out.println("감사합니다. 결제가 완료되었습니다.");
						콜라재고 = 10 ; 환타재고 = 3; 사이다재고 = 2;
					    콜라바구니 = 0 ; 환타바구니 = 0 ; 사이다바구니 = 0;
					    콜라가격 = 300 ; 환타가격 = 200 ; 사이다가격 = 100 ;
						총가격 = 0;
					} else if ( 결제금액 < 총가격 ){
						System.out.println(" 결제 금액이 모자라서 주문이 취소됩니다.");
						콜라재고 = 10 ; 환타재고 = 3; 사이다재고 = 2;
					    콜라바구니 = 0 ; 환타바구니 = 0 ; 사이다바구니 = 0;
					    콜라가격 = 300 ; 환타가격 = 200 ; 사이다가격 = 100 ;
						총가격 = 0;
					} else if ( 결제금액 > 총가격 ){
						System.out.println("감사합니다. 결제가 완료되었습니다. \n 거스름돈은 "+-(총가격-결제금액)+"원 입니다.");
						콜라재고 = 10 ; 환타재고 = 3; 사이다재고 = 2;
					    콜라바구니 = 0 ; 환타바구니 = 0 ; 사이다바구니 = 0;
					    콜라가격 = 300 ; 환타가격 = 200 ; 사이다가격 = 100 ;
						총가격 = 0;
					}
				} else if ( ch2 == 2 ) {
					System.out.println("주문이 취소되었습니다.");
				} else { System.out.println("올바른 메뉴를 선택해주세요."); }
			} else { System.out.println("올바른 메뉴를 선택해주세요."); }
		}// while e
    
	}// main e
} // class e
