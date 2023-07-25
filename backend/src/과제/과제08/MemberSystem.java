package 과제.과제08;

import java.util.Arrays;
import java.util.Scanner;

// 목적 : 실행
public class MemberSystem { // class s
	public static void main(String[] args) { // main s
		Scanner scanner = new Scanner(System.in);
		
		
		//0. 여러개의 Member 객체를 100개를 저장 예정인 배열 선언
		// 배열선언 : 타입명[] 배열명 = new 타입명[길이];
			// 타입 : 기본타입, 참조타입
		Member[] memberList = new Member[100];

		
		while(true) { // while s
			System.out.println( Arrays.toString(memberList));
			
			//1. 무한출력
			System.out.println("--------- 회원 시스템 ---------");
			System.out.println("1. 회원가입 | 2. 로그인 | 선택 >> ");
			
			//2. 무한입력 (콘솔은 키보드만 가능)
			int ch = scanner.nextInt();
			
			//3. 입력/선택 경우의 수 
			if( ch == 1 ) {
				System.out.println("--------- 회원가입 --------- ");
				//1.  각각 입력받아서 저장
				System.out.println("아이디 : ");		String inputId = scanner.next();
				System.out.println("비밀번호 : ");	String inputPw = scanner.next();
				System.out.println("이름 : ");		String inputName = scanner.next();
				System.out.println("전화번호 : ");	String inputPhone = scanner.next();
				System.out.println("나이 : ");		int inputAge = scanner.nextInt();
				//2. 5가지를 하나로 묶음 = 문자열 vs 객체   ( 객체가 더 편함 )
				// *객체선언 : 클래스명 객체변수명 = new 생성자명();
				Member member = new Member(); // 필드에 기본값이 들어가 있음 
				// *객체내 필드를 수정
				// *.(도트연산자) : 접근연산자 (스택변수가 가지고 있는 객체주소로 가!)				
				member.id = inputId;
				member.pw = inputPw;
				member.name = inputName;
				member.phone = inputPhone;
				member.age = inputAge;
				//3. 여러개의 객체를 저장하기 위해 배열에 저장
					// 비어있는 인덱스를 찾아서 해당 인덱스에 저장하기
				for ( int i = 0; i<memberList.length; i++) { // for s
					// 만약에 i번째 인덱스에 값이 null 이면 객체 대입하고 for문 나가기
					if( memberList[i] == null ) {memberList[i] = member; break;}
				}// for e
				
			} else if ( ch == 2 ) {
				//1. 입력받기
				System.out.println("---------- 로그인 ---------- ");
				System.out.println("아이디 : ");		String inputId = scanner.next();
				System.out.println("비밀번호 : ");	String inputPw = scanner.next();
				
				//2. 입력받은 데이터를 배열내 찾기
				int login = -1; // 로그인여부 저장하기 -1은 못찾았다. 0이상 이면 찾은 인덱스번호 저장
				for (int i = 0; i< memberList.length; i++) {// for s
					if(memberList[i] != null && 
						memberList[i].id.equals(inputId) && 
						memberList[i].pw.equals(inputPw)) { login = i; break; }
				}// for e
				//3. 로그인 성공 여부 판단하기
				if( login >= 0 ) {
					System.out.println("[ 로그인 성공 ]");
				} else {System.out.println("[ 로그인 실패 ]");}
			}
			
			
			
		} //while e
	
	} // main e 
} // class e


/*
	주제 : 회원제 시스템
		0. 저장
			아이디, 비밀번호, 이름, 전화번호
			*5가지(서로다른 타입) 필드/변수/데이터를 하나의 묶음 방법
			--> 문자열 이용 : "아이디,비밀번호,이름,전화번호,나이" 가 저장된 문자열을 ( 문자열객체.split ("분리기준문자")[인덱스] ) 를 이용해 필드를 분리해서 사용함.
			--> 클래스 이용 : 
				1. 클래스 설계 = 새로운 클래스.java 파일을 생성
				2. 클래스 멤버 구성 : 필드, 생성자, 메소드 
			*하나로 묶인 (기준동일=타입동일)여러개를 저장하려면 어떻게 해야할까??
			--> 문자열 배열 : String[] 문자열배열 = new String[100];
			--> 클래스 배열 : Member[] 객체배열 = new Member[100];
			
		1. 초기메뉴
			1. 회원가입
			2. 로그인
			
		2. 조건기능
			1. 회원가입
				1. 아이디, 비밀번호, 이름, 전화번호, 나이 각 입력받아 저장하기
				2. Member 객체화 
				3. 배열에 객체를 저장한다.
				 
			2. 로그인
				1. 아이디, 비밀번호, 입력받아 저장
				2. 배열내 입력받은 값과 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공 
					- 아니면 실패
					

*/