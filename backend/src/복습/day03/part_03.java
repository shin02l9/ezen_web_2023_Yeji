package 복습.day03;

import java.util.Scanner;

public class part_03 {

//	주제 : 키오스크(배열버전) 
//
//	1. 공통 조건
//	    1. main 함수만 사용
//	    2. Class 파일은 하나만 사용
//
//	2. 변수 초기값 
//	    String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};
//	    - 제품은 콜라 -> 환타 -> 사이다 순으로 작성되어 있으며 각 제품별 필드는 재고 -> 바구니 -> 가격->제품명 순 으로 작성한 문자열 입니다.
//
//	3. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ]
//	    1. 콜라 2.사이다 3.환타 4.결제
//	            [ 1~3 선택시 ]
//	                - 재고가 있을경우 바구니 담기 / 없으면 '재고부족' 출력
//
//	            [ 4 선택시 ]
//	                - 현재 바구니 현황 표시 목록[ * 바구니가 0보다 컸을경우에만 출력합니다 ]
//	                    ----------------------------------
//	                        제품명 수량 가격
//	                        사이다 1 400
//	                        환타 2 1000
//	                        총가격 : 1400
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};

		int 총가격 = 0;
		
		while (true) {
			
			System.out.println(" --------------------- 메뉴 --------------------- ");
			System.out.println("1. 콜라(300) | 2. 환타(200) | 3. 사이다(100) | 4.결제");
			System.out.println("------------------------------------------------");
			System.out.println("선택 >> "); int ch = scanner.nextInt();
			
			if ( ch == 1 ||  ch == 2 || ch == 3 ) {
				int 선택재고 = Integer.parseInt(재고관리[ch-1].split(",")[0]);
				int 선택바구니 = Integer.parseInt(재고관리[ch-1].split(",")[1]);
				int 선택제품가격 = Integer.parseInt(재고관리[ch-1].split(",")[2]);
				String 선택제품명 = 재고관리[ch-1].split(",")[3];
				if( 선택재고 > 0 ) {	
				선택재고 --; 선택바구니++; 총가격 += 선택제품가격;
				System.out.println(선택제품명+"가 장바구니에 담겼습니다.");
				}
				재고관리[ch-1] = 선택재고+","+선택바구니+","+선택제품가격+","+선택제품명;
			} else if ( ch == 4 ) {
				System.out.println(" ----------- 장바구니 ----------- ");
				System.out.println("  ");
				System.out.println("  "); // 모르겠어영..
				
				System.out.println( "결제하실 금액은 "+총가격+"원 입니다.");
				System.out.println("1. 결제 | 2. 취소  >> "); int ch2 = scanner.nextInt();
				if( ch2 == 1 ) {
					System.out.println( "결제금액을 입력해주세요."); 
					int 결제금액 = scanner.nextInt();
					System.out.println( "감사합니다.");
				} else if( ch2 == 1 ) {
					System.out.println( "주문이 취소되었습니다."); 
				}
			}
			
			
			
			
		} //while e
		
	} // main e
} // class e
