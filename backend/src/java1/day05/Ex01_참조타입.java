package java1.day05;

public class Ex01_참조타입 { //class s
	
	public static void main(String[] args) { //main s
		
		// [p.148]
		int[] arr1; // int형 타입으로 배열변수 선언
		int[] arr2;
		int[] arr3;
		
	// 스택구역 = 힙구역
		arr1 = new int [] {1,2,3}; // 배열 {1,2,3} 를 생성 [힙 영역에 메모리 할당]하고 [할당된 주소를 대입] 스택영역변수에 대입		
		arr2 = new int [] {1,2,3}; // 101번지를 arr2 스택변수에 저장
		arr3 = arr2; // arr2 스택변수가 가지고 있던 [101번지]를 arr3 스택변수에 대입
		
		System.out.println( arr1 == arr2 ); //100번지 == 101번지 false
		System.out.println( arr2 == arr3 ); //101번지 == 101번지 true
		
		// [p.151] 객체 주소를 참조하고 있지 않은 상태 = null * 객체(필드, 메소드) 사용할수 없는 상태!
		int[] intArray = null;
		// int[] intArray 스택영역에 변수가 메모리 할당, 참조중인 객체번지x  // 힙영역 x
		// intArray[0] = 10; // 배열내 0번재 인젝스에 10대입??? 오류뜰거임! 오류나는 이유는 배열은 힙영역에서 생성되는데 아직 배열이 생성되지 않았기 때문에 인덱스 호출을 할 수 없음.
		String str = null;
		System.out.println( str.length ()); 
		
		// [p.153]
		String hobby = "여행";
			//1.스택영역에 hobby 지역변수 선언
			//2.힙영역에 "여행" 문자열객체 생성
			//3.생성된 힙영역에 "여행"객체의 주소/번지를 스택영역에 hobby 지역변수에 대입
		hobby = null;
			//4.스택영역에 hobby 지역변수에 null 대입 [대입 : 새로운값으로 대체 ]
			//5.아무도 힙영역에 있는 "여행" 문자열 객체를 참조하지 않으면 쓰레기수집기(GC)라는 얘가 자동으로 객체를 삭제한다 .
		String kind1 = "자동차";
		String kind2 = kind1;
		
		kind1 = null; // 아직 힙영역의 "자동차" 객체를 kind2가 참조 중이라서 삭제가 되지 않는다.
		
		
	} // main e

} //class e

/*
	자바 데이터 타입 : 변수를 선언할때 사용되는 타입
		- 기본타입 : boolean, byte, short, chat, int, long, float, double
			- 변수의 값 자체를 저장하는 것!
			- 8가지가 존재하고 소문자로 시작! 
		- 참조타입 : 배열, 열거, 클래스[ String, Scanner, Random, System 등등 ], 인터페이스
			- 변수의 값 자체를 저장하지는 않고 변수의 힙메모리에 생성된 주소/번지를 참조한다.
			
			
		JVM메모리
			스택영역 						            		힙 영역
			- 모든 변수는 여기서 만들어짐							- 객체가 생성되는 영역
			- 스레드마다! 별도구역 main함수 같은걸 말함					- 스택/메소드 영역에 참조 할 수 있다.
			- 함수(프레임)마다 별도 구역								- 객체, 배열, 인터페이스, 메모리 생성
				- 지역변수										- new 연산자가 힙에서 사용함 : 타입/클래스 기반으로 메모시 생성후 주소/번지 반환
				- 함수 호출시 프레임 생성
				- 함수(프레임)종료되면 초기화
				
		------------------------------------------------------------------------------------------------------
		 
		 	int age = 25;
		 	
		 	String name = 100번지 ;							"신용권" : String 클래스 기반으로 만들어진 객체
		 													100번지 
		------------------------------------------------------------------------------------------------------	
		
			스택변수에 저장된 기본타입의 값/주소 비교 
			==
			!=
			
 */
