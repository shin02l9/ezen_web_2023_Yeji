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
				//System.out.println("제품분리 :" + (Arrays.toString(재고관리)) );

			
			// ------ 키오스크 프로그램 실행-----------------------------------------------------
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.print("-1: 제품등록 | 0: 결제 \n");
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
			
			// ------------------------ 제품 등록하기 ------------------------
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
			// ------------------------ 제품 주문하기 ------------------------
			else if ( ch > 0 && ch <= 재고관리.length ) {
				// 1. 선택한 제품번호의 각 정보 호출 : ch-1 : 선택한 제품의 인덱스 
				String name = (재고관리[ch-1].split(",")[0]); // 제품명
				int stock = Integer.parseInt(재고관리[ch-1].split(",")[1]); // 재고
				int price = Integer.parseInt(재고관리[ch-1].split(",")[2]); // 가격
				int basket = Integer.parseInt(재고관리[ch-1].split(",")[3]); // 바구니
				
				// 2. 재고가 0보다 크면 재고/바구니 증감, 재고없으면 안내만하고 행동x
				if( stock > 0 ) {	stock--; basket++; System.out.println( name + "제품을 담았습니다.");
				} else { System.out.println( "재고가 부족합니다."); }
				
				// 3. 배열의 상태 업데이트 하기
				재고관리[ch-1] = name+","+stock+","+price+","+basket;
				
				// 4. 파일 내보내기 또해야함.. // 파일내 제품들의 변화가 있으므로 업데이트
				// 현재 재고관리배열의 상태를 파일에 저장한다.
				String outstr = "";
				for ( int i = 0; i < 재고관리.length; i++) { // 배열내 모든 데이터를 하나의 문자열에 변환
					outstr += 재고관리[i].split(",")[0]+","+재고관리[i].split(",")[1]+","+재고관리[i].split(",")[2]+","+재고관리[i].split(",")[3]+"\n";
				}
				// 5. 재고관리 배열을 하나의 문자열로 변환된 문자열을 바이트배열로 변환 후 내보내기 한다.
				// 이어쓰기가 아니라 덮어쓰기를 해야한다.
				FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
				fileOutputStream2.write( outstr.getBytes() );
			
			// ------------------------ 결제하기 ------------------------
			} else if ( ch == 0 ) {

			}
		
		} // while e
	} // main e
} // class e

