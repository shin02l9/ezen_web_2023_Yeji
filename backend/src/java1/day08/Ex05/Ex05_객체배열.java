package java1.day08.Ex05;

import java.util.Scanner;

public class Ex05_객체배열 { // class s

	public static void main(String[] args) {// main s
		
		Member[] memberList = new Member[100]; // member 객체 100개 저장 가능
		
		while(true) {// while 무한루프 s
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
				System.out.println("이름 : "); String name = sc.next();
				// 입력받은 것을 ★객체로 저장하기
					//1. 객체선언 : 클래스명 객체변수명 + new 생성자명();
					Member m = new Member(); // 1. 객체 생성
					m.id = id; m.pw = pw; m.name = name;	 // 2. 생성된 객체로부터 .접근연산자를 이용한 각 필드에 입력값 대입
					//2. 배열에 저장
					for( int i=0; i<memberList.length; i++) {
						if (memberList[i] == null){
							memberList[i] = m;
							break;
						}
					}
			}
				
	
		} // while 무한루프 e
	}// main e
} // class e
