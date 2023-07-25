package 복습.day02;

import java.util.Scanner;

import javax.swing.SpinnerDateModel;

public class part_02 {//class s

	public static void main(String[] args) {// main s
		
//		3. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ]
//		    1. 콜라 2.사이다 3.환타 4.결제
//		            [ 1~3 선택시 ]
//		                - 재고가 있을경우 바구니 담기 / 없으면 '재고부족' 출력
//
//		            [ 4 선택시 ]
//		                - 현재 바구니 현황 표시 목록[ * 바구니가 0보다 컸을경우에만 출력합니다 ]
//		                    ----------------------------------
//		                        제품명 수량 가격
//		                        사이다 1 400
//		                        환타 2 1000
//		                        총가격 : 1400
//		                - 결제메뉴 표시
//		                    1. 결제 2.취소
//		                        [결제 선택시]
//		                        - 금액을 입력받아 바구니의 총가격에 뺀 잔액 출력 -> 결제 성공시 바구니 초기화 하기
//		                        - 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
//		                        [취소 선택시]
//		                        - 장바구니 초기화 / 재고 다시 되돌리기
		
		String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";
				//		제품은 콜라 -> 환타 -> 사이다 순 (재고 -> 바구니 -> 가격)
		
		String 콜라 = 재고관리.split("\n")[0];
			int 콜라재고 =  Integer.parseInt(콜라.split(",")[0]); 
			int 콜라장바구니 = Integer.parseInt(콜라.split(",")[1]);
			int 콜라가격 = Integer.parseInt(콜라.split(",")[2]);
			
		String 환타 = 재고관리.split("\n")[1];
			int 환타재고 =  Integer.parseInt(환타.split(",")[0]); 
			int 환타장바구니 = Integer.parseInt(환타.split(",")[1]);
			int 환타가격 = Integer.parseInt(환타.split(",")[2]);
		
		String 사이다 = 재고관리.split("\n")[2];
			int 사이다재고 =  Integer.parseInt(사이다.split(",")[0]); 
			int 사이다장바구니 = Integer.parseInt(사이다.split(",")[1]);
			int 사이다가격 = Integer.parseInt(사이다.split(",")[2]);
		
		int 총가격 = 0;
			
		Scanner scanner = new Scanner( System.in );

		
		while (true) {
			
			System.out.println("----------------------- 메뉴 -----------------------");
			System.out.println("1. 콜라(300) | 2. 환타(200) | 3. 사이다(100) | 4. 결제");
			System.out.println("---------------------------------------------------");
			System.out.println("선택 >> "); int ch = scanner.nextInt();
			
			
			if( ch == 1 ) {
				System.out.println("콜라를 담았습니다.");
				콜라재고--; 콜라장바구니++; 총가격+=콜라가격;
			} else if ( ch == 2 ) {
				System.out.println("환타를 담았습니다.");
				환타재고--; 환타장바구니++; 총가격+=환타가격;
			} else if ( ch == 3 ) {
				System.out.println("사이다를 담았습니다.");
				사이다재고--; 사이다장바구니++; 총가격+=사이다가격;
			} else if ( ch == 4 ) {
				System.out.println("--------------------------");
				System.out.printf(" %5s %5s %5s \n", "제품명", "수량", "가격");
				System.out.printf(" %5s %5d %5d \n", "콜라", 콜라장바구니, 콜라장바구니*콜라가격);
				System.out.printf(" %5s %5d %5d \n", "환타", 환타장바구니, 환타장바구니*환타가격);
				System.out.printf(" %5s %5d %5d \n", "사이다", 사이다장바구니, 사이다장바구니*사이다가격);
				System.out.println("--------------------------");
				System.out.printf(" 총 금액 >> %5d \n", "사이다", 총가격);
				System.out.println("1. 결제 | 2. 취소 "); int ch2 = scanner.nextInt();
				
				if( ch2 == 1 ) {
					System.out.println("결제금액을 입력해주세요."); int 결제금액 = scanner.nextInt();
					if( 결제금액 == 총가격 ) {
						System.out.println("결제가 완료되었습니다."); 
						총가격 = 0;
						콜라장바구니 = 0;
						환타장바구니 = 0;
						사이다장바구니 = 0;
					} else if ( 결제금액 > 총가격 ){
						System.out.printf(" 결제가 완료되었습니다. \n 거스름돈은 %5d원입니다.\n", 결제금액-총가격);
						총가격 = 0;
						콜라장바구니 = 0;
						환타장바구니 = 0;
						사이다장바구니 = 0;
					} else { System.out.println("결제금액이 부족해 주문이 취소됩니다.");  
						총가격 = 0;
						콜라장바구니 = 0;
						환타장바구니 = 0;
						사이다장바구니 = 0;
						콜라재고 =  Integer.parseInt(콜라.split(",")[0]); 
						환타재고 =  Integer.parseInt(환타.split(",")[0]);
						사이다재고 =  Integer.parseInt(사이다.split(",")[0]); 
					}
				} else if( ch2 == 2 ){
					System.out.println("주문이 취소됩니다."); 
					총가격 = 0;
					콜라장바구니 = 0;
					환타장바구니 = 0;
					사이다장바구니 = 0;
					콜라재고 =  Integer.parseInt(콜라.split(",")[0]); 
					환타재고 =  Integer.parseInt(환타.split(",")[0]);
					사이다재고 =  Integer.parseInt(사이다.split(",")[0]); 
				}else { System.out.println( "올바른 메뉴를 선택해주세요.");}
			} else { System.out.println( "올바른 메뉴를 선택해주세요.");}
			
			
		}
			
			
			
		
	}// main e
}// class e






