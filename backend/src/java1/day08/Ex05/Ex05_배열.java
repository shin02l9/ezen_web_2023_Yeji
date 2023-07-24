package java1.day08.Ex05;

import java.util.Arrays;
import java.util.Scanner;

public class Ex05_배열 { // class s

	public static void main(String[] args) {// main s
		
		String[] memberList = new String[100]; // 100개의 문자열을 저장할 수 있는 배열 선언
		
		while(true) {// 무한루프 s
			System.out.println( Arrays.toString(memberList) ); //*배열내 데이터 테스트용
			
			//1. 무한출력
			System.out.println( "1. 회원가입 : ");
			//2. 무한입력
				//1. Scanner 객체 : Scanner 객체변수명 = new Scanner (System.in);
				Scanner sc = new Scanner( System.in );
				//2. 객체를 통한 메소드 호출
				int ch = sc.nextInt();
			
			if ( ch == 1 ) { // 만약에 ch가 1이면
				System.out.println("아이디 : "); String id = sc.next();
				System.out.println("비밀번호 : "); String pw = sc.next();
				// 입력받은 것을 ★배열로 저장하기
					//1. 하나의 문자열로 합치기
					String m = id+","+pw; // 쉼표(CSV)로 필드 구분 
					//2. 배열내 비어있는 인덱스 찾아서 대입
					for ( int i = 0; i<memberList.length; i++) {
						if( memberList[i] == null ) { // 해당 인덱스에 비어있으면!
							memberList[i] = m;
							break; // 하나만 추가해야하니까 반복문 빠져나가기
						}
					}
			}

		}// 무한루프 e
	}// main e
} // class e
