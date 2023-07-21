package 과제.과제06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class 과제6_3_키오스크파일처리 { // class s

	public static void main(String[] args) throws IOException {
		
		while(true) { // 프로그램 무한 루프 while s
			Scanner scanner = new Scanner(System.in); // 입력객체
			String filePath = "./src/과제/과제06/재고파일.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, true); // 파일 출력 객체 1단계
			FileInputStream fileInputStream = new FileInputStream(filePath);	// 파일 입력 객체
			File file = new File (filePath);
			
			// 파일내 제품 정보 ---> 스트림으로 읽어와서 ---> 바이트 배열로 저장후 ----> 받은것을 문자열로 변환
			byte[] inByteArray = new byte[(int)file.length()]; // 파일의 용량 만큼의 배열 선언
			fileInputStream.read(inByteArray); // 읽어온 바이트를 바이트 배열에 저장
			String fileInfo = new String(inByteArray); // 바이트배열 -> 문자열 변환 
				System.out.println(fileInfo);
			// ------파일내 제품정보 문자열 ---> 배열에 저장 -----------------------------------------------------
				// 1. 하나의 문자열로 모든 제품의 문자열을 각 제품별로 분리
				String[] 재고관리 = fileInfo.split("\n"); 
				System.out.println("제품분리 :" + (Arrays.toString(재고관리)) );

			
			// ------ 키오스크 프로그램 실행-----------------------------------------------------
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.print("-1: 제품등록 0: 결제 \n");
				//재고관리 배열에 있는 제품만 선택가능하도록 출력
				for( int i=0; i<재고관리.length; i++) { // for s
					String product = 재고관리[i];
					String name = (product.split(",")[0]); // 제품명
					int stock = Integer.parseInt(product.split(",")[1]); // 재고
					int price = Integer.parseInt(product.split(",")[2]); // 가격
					int basket = Integer.parseInt(product.split(",")[3]); // 바구니
							
					if ( stock == 0 ) { // 재고가 없으면
						System.out.println((i+1) + ": " + name + " [재고없음]" );
					} else { // 재고가 있으면 
						System.out.println((i+1) + ": " + name + " ["+price+"]" );
						}
					} // for e
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			// ------ 제품등록하기 ------
			if ( ch == -1 ) { // 만약에 -1번을 입력하면 제품등록 가능
				//1. 추가할 제품의 정보를 입력받아 각 변수에 저장
				System.out.print("제품명 : "); String name = scanner.next();
				System.out.print("초기재고 : "); int stock = scanner.nextInt();
				System.out.print("가격 : ");	int price = scanner.nextInt();
												int basket = 0; // 바구니는 0부터 시작
				//2. 해당 변수들을 하나의 데이터로 구성 [제품구별 \n | 제품내정보구분 ,]
				String outstr = name+","+stock+","+price+","+basket+"\n";
				
				//3. 파일에 내보내기
					//1. 파일출력스트림 객체 2. 문자열->바이트배열 3.바이트배열 내보내기 | 이렇게 3단계
				fileOutputStream.write( outstr.getBytes() ); //2,3단계 1단계는 위에 !

				System.out.println("안내) 제품이 등록되었습니다.");
			}
			
		
		} // while e
	} // main e
} // class e


//// 주문 선택 
//if ( ch == 1 || ch == 2 || ch == 3 ) {
//	//배열 호출
//	//1. 배열변수명호출	
//	// System.out.println("배열의 변수명 호출 : "+ 재고관리 );
//	// System.out.println("배열의 데이터 호출 : "+ Arrays.toString(재고관리));
//	// System.out.println("배열의 데이터 개수 : "+ 재고관리.length);
//	// System.out.println("배열내 특정 데이터[인덱스] 호출 : "+ 재고관리[0]);
//	String 선택된제품정보 = 재고관리[ch-1];
//	//2. 배열내 데이터{문자열) 분리
//	int 선택된제품재고 = Integer.parseInt(선택된제품정보.split(",")[0]);
//	int 선택된제품바구니 = Integer.parseInt(선택된제품정보.split(",")[1]);
//	int 선택된제품가격 = Integer.parseInt(선택된제품정보.split(",")[2]);
//	String 선택된제품이름 = 재고관리[ch-1].split(",")[3];
//	//3. 유효성 검사를 통한 상태 변경
//	if( 선택된제품재고 > 0 ) {
//		선택된제품재고--; 선택된제품바구니++; System.out.println(선택된제품이름+"장바구니에 담았습니다.");
//	} else {System.out.println("재고가 부족합니다.");}
//	//4. 재고관리 업데이트
//	재고관리[ch-1] = 선택된제품재고+","+선택된제품바구니+","+선택된제품가격;
//
//} else if ( ch == 0 ) {
//	System.out.println(Arrays.toString(재고관리)); 
//	System.out.printf( "%10s %10s \n", "수량","가격");
//	
//	
//	for( int i =0; i< 재고관리.length; i++) {
//		int basket = Integer.parseInt( 재고관리[i].split(",")[1] );
//		int price = Integer.parseInt( 재고관리[i].split(",")[2] );
//		String name = 재고관리[i].split(",")[3];
//		if( basket > 0 ) {
//			System.out.printf( "%10s %10s %10s \n ", name, basket, basket*price);
//			System.out.printf( "%10s %10s %10s \n ", name, basket, basket*price);
//		}
//	}
//}