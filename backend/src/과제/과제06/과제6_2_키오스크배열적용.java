package 과제.과제06;

import java.util.Arrays;
import java.util.Scanner;
public class 과제6_2_키오스크배열적용 { // class s

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
						//  콜라[0]      환타[1]      사이다[2]
		String[] 재고관리 = {"10,0,300,콜라","10,0,200,환타","10,0,100,사이다"};
		// 배열 선언하는 방법 : 선언시 크기/길이 줄이거나 늘릴 수 없다. 
			//1. 타입[] 변수명 = { 값1, 값2, 값3, 값3 };
				// 배열선언시 배열에 저장할 값을 할고 있는 상태 
			//2. 타입 변수명 = new 타입[길이];
				// 배열선언시 배열에 저장할 값을 모르고 있는 상태 / 저장할 개수[길이] 알고 있는 상태
		
		
			// 변수 : 하나의 값을 저장하는 공간 (스택 영역에 하나의 데이터저장)
				// 데이터 종류 : 1.기본타입 데이터     2. 참조주소
				//            8가지 자료형 			  클래스, 배열, 인터페이스, 열거형 
			
			// 스택영역                 	|    힙영역                         |     메소드영역 (영구적으로 저장이 필요한 전역 변수 느낌)
			// 모든 변수는 스택이다.          |   
			// String[] 재고관리 = 주소		|	101번지 {"10,0,300","10,0,200","10,0,100"};
			// int 정수 = 10;  < 이 10은 주소가 아니라 그냥 값 10 자체이다.
		
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
				// 주문 선택 
				if ( ch == 1 || ch == 2 || ch == 3 ) {
					//배열 호출
					//1. 배열변수명호출	
					// System.out.println("배열의 변수명 호출 : "+ 재고관리 );
					// System.out.println("배열의 데이터 호출 : "+ Arrays.toString(재고관리));
					// System.out.println("배열의 데이터 개수 : "+ 재고관리.length);
					// System.out.println("배열내 특정 데이터[인덱스] 호출 : "+ 재고관리[0]);
					String 선택된제품정보 = 재고관리[ch-1];
					//2. 배열내 데이터{문자열) 분리
					int 선택된제품재고 = Integer.parseInt(선택된제품정보.split(",")[0]);
					int 선택된제품바구니 = Integer.parseInt(선택된제품정보.split(",")[1]);
					int 선택된제품가격 = Integer.parseInt(선택된제품정보.split(",")[2]);
					String 선택된제품이름 = 재고관리[ch-1].split(",")[3];
					//3. 유효성 검사를 통한 상태 변경
					if( 선택된제품재고 > 0 ) {
						선택된제품재고--; 선택된제품바구니++; System.out.println(선택된제품이름+"장바구니에 담았습니다.");
					} else {System.out.println("재고가 부족합니다.");}
					//4. 재고관리 업데이트
					재고관리[ch-1] = 선택된제품재고+","+선택된제품바구니+","+선택된제품가격;
				
				} else if ( ch == 4 ) {
					System.out.println(Arrays.toString(재고관리)); 
					System.out.printf( "%10s %10s \n", "수량","가격");
					
					
					for( int i =0; i< 재고관리.length; i++) {
						int basket = Integer.parseInt( 재고관리[i].split(",")[1] );
						int price = Integer.parseInt( 재고관리[i].split(",")[2] );
						String name = 재고관리[i].split(",")[3];
						if( basket > 0 ) {
							System.out.printf( "%10s %10s %10s \n ", name, basket, basket*price);
							System.out.printf( "%10s %10s %10s \n ", name, basket, basket*price);
						}
					}
				}
			
		} // while end 
	} // main end 
} // class e



						/* 주제 : 키오스크(변수버전)
							- 실행예시 사진은 없습니다.
							조건 
							1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
								// 샘플 : 
										이름 : 콜라 , 환타 , 사이다
										가격 : 300 , 200 , 100
										바구니 : 0 , 0 , 0
								
							2. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
								1. 콜라 2.사이다 3.환타 4.결제
								[ 1~3 선택시 ]
									- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
									 
								[ 4 선택시 ] 
									- 현재 장바구니 현황 표시 목록 
									----------------------------------
									제품명	수량	가격
									사이다	1	400
									환타		2	1000
									총가격 : 1400
									- 결제메뉴 표시
										1. 결제 2.취소 
										[결제]
											- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
											- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
										[취소]
											- [ 장바구니 초기화 / 재고 다시 되돌리기 ]  */

