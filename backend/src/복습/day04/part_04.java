package 복습.day04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class part_04 {


	public static void main(String[] args) {
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
		
		String filePath = "./src/복습/day04/키오스크파일처리.txt";
	    FileOutputStream fileOutputStream = new FileOutputStream( filePath ,true); 
	    FileInputStream fileInputStream = new FileInputStream( filePath ); 
	    // 위에 파일 입출력 선언하는 코드들이 계속 빨간줄 뜨는데 이유를 모르겠어요.
	    
	    File file = new File( filePath );
	    
//	    ### 코드 작성 순서
//	    1. 파일 출력, 입력 객체를 호출해둔다. ㅇ
//	    2. 파일내의 정보를 스트림으로 읽어와서 (불러오기) ㅇ
//	    3. 바이트 배열로 저장 후 ㅇ
//	    4. 받은것을 문자열로 변환 ㅇ
//	    5. 문자열을 배열에 저장한다.ㅇ
//	    6. 배열에 저장된 데이터를 사용하고 
//	    7. 업데이트할 내용이 있다면 배열의 상태를 업데이트 후
//	    8. 배열을 하나의 문자열로 변환하고
//	    9. 또 문자열을 바이트배열로 변환하고
//	    10. 파일을 새로저장하기 (내보내기) : 새로운 업데이트이기에 덮어쓰기를 해야한다. 이어쓰기x!
	    
		
	    Scanner scanner = new Scanner(System.in);
	    
	    while(true) {
	    	
	    	byte[] 재고 = new byte[(int)file.length()]; //파일의 크기?길이 만큼 배열을 만들어둬야함
	    	fileInputStream.read(재고); // 읽어온 내용을 바이트 배열에 저장 
	    	String 재고관리 = new String(재고); // 문자열로 변환
	    	System.out.println(재고관리); // 빨간줄이 계속 떠서 콘솔로 확인을 못해용안엉우미ㅏㅇ루미ㅏㄴㅇ루민ㅇㄹ
	    	
	    	재고관리.
	    	
	    	System.out.println("------------------------------------");
	    	System.out.println("-1: 재고등록  0:결제  1 : 등록된 제품 출력");
	    	System.out.println("------------------------------------");
	    	System.out.print(" 메뉴 선택 >> "); int ch = scanner.nextInt();
	    	
	    	if( ch == -1 ) {
	    		System.out.print("제품명 	>> "); int 제품명 = scanner.nextInt();
	    		System.out.print("초기재고>> "); int 초기재고 = scanner.nextInt();
	    		System.out.print("가격 	>> "); int 가격 = scanner.nextInt();
	    	}
	    	else if( ch == 0 ) {

	    	}
	    	else if( ch == 1 ) {
	    		
	    	}
	    	
	    }
	    
	    
	    
	    
		
		

	} // main e
} // class e
