package 복습.day04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class part_04 {


	public static void main(String[] args) throws IOException {
//		1. 공통 조건
//	    1. main 함수만 사용
//	    2. Class 파일은 하나만 사용
//	2. 파일처리 클래스/메소드 사용
//	    String filePath = "./src/폴더명/파일명.txt";
//	    FileOutputStream fileOutputStream = new FileOutputStream( filePath ,true); 
//	    FileInputStream fileInputStream = new FileInputStream( filePath ); 
//	    File file = new File( filePath );

//	3. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ]
//	    -1: 재고등록  0:결제  1 ~ 등록된 제품들이 순서대로 출력됩니다. [ * 파일 호출]
//	            [ -1 선택시 ]
//	                - 제품명 , 초기재고 , 가격을 입력받아 파일에 저장합니다. [ * 파일 저장 ]
//	            [ 0 선택시 ]
//	                - 현재 바구니 현황 표시 목록[ * 바구니가 0보다 컸을경우에만 출력합니다 ]
//	                    ----------------------------------
//	                        제품명 수량 가격
//	                        사이다 1 400
//	                        환타 2 1000
//	            [ 1 이상 선택시 ] : 
//	                - 선택된 번호의 재고가 있을경우 바구니 담기 / 없으면 '재고부족' 출력후 [ * 파일 업데이트 ]
		

//	    ### 코드 작성 순서
//	    1. 파일 출력, 입력 객체를 호출해둔다. 
//	    2. 파일내의 정보를 스트림으로 읽어와서 (불러오기) 
//	    3. 바이트 배열로 저장 후 
//	    4. 받은것을 문자열로 변환 
//	    5. 문자열을 배열에 저장한다.
//	    6. 배열에 저장된 데이터를 사용하고 
//	    7. 업데이트할 내용이 있다면 배열의 상태를 업데이트 후
//	    8. 배열을 하나의 문자열로 변환하고
//	    9. 또 문자열을 바이트배열로 변환하고
//	    10. 파일을 새로저장하기 (내보내기) : 새로운 업데이트이기에 덮어쓰기를 해야한다. 이어쓰기x!
	    
		
	    Scanner scanner = new Scanner(System.in);
	    
	    while(true) {
	    	String filePath = "./src/복습/day04/키오스크파일처리.txt";
		    FileOutputStream fileOutputStream = new FileOutputStream( filePath ,true); 
		    FileInputStream fileInputStream = new FileInputStream( filePath ); 
		    File file = new File( filePath );
	    	
	    	byte[] 재고 = new byte[(int)file.length()]; //파일의 크기?길이 만큼 배열을 만들어둬야함
	    	fileInputStream.read(재고); // 읽어온 내용을 바이트 배열에 저장 
	    	String 재고문자열 = new String(재고); // 문자열로 변환
	    	//System.out.println(재고문자열);
	    	String[] 재고배열 = 재고문자열.split ("\n"); // 문자열 쪼개서 배열에 넣기
	    	//System.out.println(재고배열);
	    	
	    	for (int i = 0; i < 재고배열.length; i++) {
	    	    System.out.println("재고배열[" + i + "]: " + 재고배열[i]);    
//	    	    재고배열[0]: 아이스크림,9,1000,1
//	    	    재고배열[1]: 
//	    	    재고배열[2]: 샌드위치,10,1500,0
//	    	    재고배열[3]: 음료수,10,500,0
//	    	    인덱스 1 왜 비어있는거지....
	    	    
	    	}
	    	// 프로그램 실행 -------------------------------------------------------------------
	    	
	    	System.out.println("---------- 키오스크 메뉴 --------------");
	    	System.out.println("-1: 재고등록 | 0: 바구니 현황  ");
	    	
	    	for( int i = 0; i <재고배열.length; i++) {
	    		String[] 상품정보 = 재고배열[i].split(",");
	    		String 상품명 = 상품정보[0];
		    	int 상품재고 = Integer.parseInt(상품정보[1]);
		    	int 상품가격 = Integer.parseInt(상품정보[2]);
		    	int 장바구니 = Integer.parseInt(상품정보[3]);
		    	if( 상품재고 > 0 ) {
		    		System.out.printf("[%1s] %6s %4d %4d \n", i+1 ,상품명, 상품재고, 상품가격);
		    	}else {System.out.printf("[%1s] %6s %4s %4d \n", i+1 ,상품명, "재고없음", 상품가격);}
    		}
	    	System.out.println("------------------------------------");
	    	System.out.print(" 메뉴 선택 >> "); int ch = scanner.nextInt();
	    	
	    	if( ch == -1 ) {
	    		System.out.print("제품명 	>> "); 
	    		String 제품명 = scanner.next();
	    		System.out.print("초기재고>> "); 
	    		int 초기재고 = scanner.nextInt();
	    		System.out.print("가격 	>> "); 
	    		int 가격 = scanner.nextInt();
	    		int 바구니 = 0;
	    		String 등록할상품 = 제품명+","+초기재고+","+가격+","+바구니+"\n"; // 변수들 하나의 문자열로 모으기
	    		fileOutputStream.write(등록할상품.getBytes()); // 바이트 배열로 변환해서 파일에 저장하기.
	    		System.out.println("제품 등록이 완료되었습니다.");
	    	}
	    	else if( ch == 0 ) {
	    		System.out.println("-------------------------");
		    	System.out.println("--- 현재 바구니 현황 목록 ---");
		    	System.out.printf("%6s %4s %4s \n", "상품명","개수","가격");
	    		for( int i = 0; i <재고배열.length; i++) {
		    		String 상품명 = (재고배열[i]).split(",")[0];
			    	int 상품가격 = Integer.parseInt((재고배열[i]).split(",")[2]);
			    	int 장바구니 = Integer.parseInt((재고배열[i]).split(",")[3]);
			    	System.out.printf("%6s %4d %4d \n", 상품명, 장바구니, 상품가격*장바구니);
	    		}
		    	System.out.println("-------------------------");
	    	}
	    	else if( ch >0 &&  ch <= 재고배열.length) {
	    		// ch-1 = 선택된 상품 인덱스
	    		String 상품명 = (재고배열[ch-1]).split(",")[0];
		    	int 상품재고 = Integer.parseInt((재고배열[ch-1]).split(",")[1])-1;
		    	int 상품가격 = Integer.parseInt((재고배열[ch-1]).split(",")[2]);
		    	int 장바구니 = Integer.parseInt((재고배열[ch-1]).split(",")[3])+1;
		    	
		    	재고배열[ch-1] = 상품명+","+상품재고+","+상품가격+","+장바구니+"\n";
		    	
		    	String 재고문자열업데이트 = "";
				for ( int i = 0; i < 재고배열.length; i++) {
					재고문자열업데이트 += 재고배열[i].split(",")[0]+","+재고배열[i].split(",")[1]+","+재고배열[i].split(",")[2]+","+재고배열[i].split(",")[3]+"\n";
				}
				FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
				fileOutputStream2.write( 재고문자열업데이트.getBytes() );
	    	}
	    	
	    }
	    
	    
	    
	    
		
		

	} // main e
} // class e
