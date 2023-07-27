package 과제.과제10;

// 목적 : 실행과 동작(컨트롤)의 설계 -> 추후에는 동작 설계도 데이터 설계처럼 따로 다른 클래스에 하는것을 권장
						// 현재 클래스에서 같은 패키지에 있는 클래스 호출은 생략
						// java.lang 기본 패키지 이므로 생략 (String, System 등)
import java.util.Arrays; // 현재 클래스에서 다른 패키지에 있는 클래스 호출 = import
import java.util.Scanner;
// vs
//import java.util.*;  // 해당 패키지내 모든 클래스 다 호출함

public class MemberSystem { // class s

	
	static Scanner sc = new Scanner(System.in); 	// 프로그램내 전역구역에서 공유 사용되는 메모리(모든 함수에서 사용 가능한 인스턴스 멤버) = 정적멤버
	// Member[] 객체배열 = new Member[100];			// 1. 인스턴스멤버 	= 힙영역		= new 마다 할당 => n개
	static Member[] memberList = new Member[100];	// 2. 정적멤버		= 메소드영역 	= 프로그램 전체 1개 
	static int loginIndex = -1; 					// 3. 정적멤버		= 메소드영역 	= 로그인을 성공한 인덱스(회원위치) 기억 = 웹 쿠키/세션
	
	public static void main(String[] args) { // main s
			
			while(true) { // main s
				// * 확인용
				//System.out.println( Arrays.toString(memberList)); // 주소값이 출력된다.
				
				
				
				System.out.println("\n\n--------- 회원 시스템 ---------"); 
				System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    \n 선택>> ");
				int ch = sc.nextInt(); 
				
				if( ch == 1 ) { MemberSystem.회원가입 (); } // main함수 밖에 있는 다른 함수 호출
				//1. 인스턴스 멤버 (static 없는) 함수는 객체를 생성하고 호출한다.
				//2,. 정적멤버 (static 있는) 함수는 객체없이 클래스를 통해 호출한다.
				else if( ch == 2 ) { MemberSystem.로그인 (); } 
				else if( ch == 3 ) { MemberSystem.아이디찾기 (); } 
				else if( ch == 4 ) { MemberSystem.비밀번호찾기 (); } 
				
			} // w e 
		} // main e
		
		//1. 회원가입 함수 ----------------------------------------------------------------------------
		static void 회원가입 () { // 회원가입 s [ C ]
			//1. 입력받기 -> 각 5개의 값 입력 받기 -> {}묶기
			System.out.print("\n\n--------- 회원가입 ---------\n"); 
			System.out.print("아이디 : "); 		String id = sc.next(); 
			System.out.print("비밀번호 : ");		String pw = sc.next(); 
			System.out.print("이름 : ");			String name = sc.next(); 
			System.out.print("전화번호 :");		String phone = sc.next(); 
			System.out.print("나이 : ");			int age = sc.nextInt(); 
			
			//2. 5개의 변수 하나의 객체로 묶기
				// 1안
				//Member m = new Member();
				//m.id = id; m.pw = pw; m.name = name; m.phone = phone; m.age = age;
				// 2안
				Member m2 = new Member(id, pw, name, phone, age); // 힙주소가 저장되는것
			//3. 회원의 1개의 객체를 배열에 저장
			for ( int i = 0; i < memberList.length; i++) { // for s
				if ( memberList[i] == null ) { memberList[i] = m2; System.out.println("안내)) 회원가입 성공"); break;}
			}// for e
			
			
		} // 회원가입 e
		
		//2. 로그인 함수 ----------------------------------------------------------------------------
		static void 로그인 () { // 로그인 s
			//1. 입력받기 -> 각 2개의 값 입력 받기 -> 기존의 데이터와 일치하는지 비교하기 [ R ]
			System.out.print("\n\n--------- 로그인 ---------\n"); 
			System.out.print("아이디 : "); 		String id = sc.next(); 
			System.out.print("비밀번호 : ");		String pw = sc.next(); 
			//2. for문 돌려서 배열내에서 찾기
			for ( int i = 0 ; i <memberList.length; i++) {
				if(memberList[i] != null && // 비어있는 곳은 비교 x
						memberList[i].id.equals(id) &&
							memberList[i].pw.equals(pw) ) {
					loginIndex = i; // static 전역 정적 멤버 변수에 저장해둠.
				}
			}
			//3. 유효성 검사
			if( loginIndex >= 0 ) { System.out.println("안내)) 로그인 성공");}
			else { System.out.println("안내)) 로그인 실패");}
		} // 로그인 e
		
		//3. 아이디찾기 함수 ----------------------------------------------------------------------------
		static void 아이디찾기 () { // 아이디찾기 s
			//1. 입력받기 -> 각 2개의 값 입력 받기 -> 기존의 데이터와 일치하는지 비교하기 [ R ]
			System.out.print("\n\n--------- 아이디찾기 ---------\n"); 
			System.out.print("이름 : "); 		String name = sc.next(); 
			System.out.print("전화번호 : ");		String phone = sc.next(); 
			//2. for문 돌려서 배열내에서 찾기
			for ( int i = 0 ; i <memberList.length; i++) {
				if(memberList[i] != null && // 비어있는 곳은 비교 x
						memberList[i].name.equals(name) &&
							memberList[i].phone.equals(phone) ) {
					System.out.println("안내)) 회원님의 아이디는 ["+memberList[i].id+"]입니다.");
					return;
				} else { System.out.print("안내)) 일치하는 정보가 없습니다."); }
			}
		} // 아이디찾기 e
		
		//4. 비밀번호찾기 함수 ----------------------------------------------------------------------------
		static void 비밀번호찾기 () { // 비밀번호찾기 s
			//1. 입력받기 -> 각 2개의 값 입력 받기 -> 기존의 데이터와 일치하는지 비교하기 [ R ]
			System.out.print("\n\n--------- 비밀번호찾기 ---------\n"); 
			System.out.print("아이디 : "); 		String id = sc.next(); 
			System.out.print("전화번호 : ");		String phone = sc.next(); 
			//2. for문 돌려서 배열내에서 찾기
			for ( int i = 0 ; i <memberList.length; i++) {
				if(memberList[i] != null && // 비어있는 곳은 비교 x
						memberList[i].id.equals(id) &&
							memberList[i].phone.equals(phone) ) {
					System.out.println("안내)) 회원님의 비밀번호는 ["+memberList[i].pw+"]입니다.");
					return;
				} else { System.out.print("안내)) 일치하는 정보가 없습니다."); }
			}

		} // 비밀번호찾기 e
		
} // class e



/*  -----------------------------------------------------------------------------------------------------------
	주제 : 회원제 시스템 
		0. 회원클래스 설계 = Member
			아이디 , 비밀번호 , 이름 , 전화번호 , 나이
		0. Member 객체를 여러개 저장하는 배열 
			Member[] 객체배열 = new Member[100];
		
		1. 초기 메뉴 [ 24시간 ]
			1. 회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
			
		2. 조건 기능 
			1. 회원가입 메소드 
				1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
				2. Member 객체화
				3. 객체를 배열 저장 
				 
			2. 로그인 메소드
				1. 아이디 , 비밀번호 입력받아 저장 
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공 
					- 아니면 실패
					 
			3. 아이디찾기 메소드
				1. 이름 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 찾은 아이디 출력 
					- 아니면 없다.
					 
			4. 비밀번호찾기 메소드 
				1. 아이디 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 *임시 비밀번호(문자4자리 난수생성 ) 업데이트후 출력 
					- 아니면 없다.
*/