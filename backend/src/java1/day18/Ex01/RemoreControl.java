package java1.day18.Ex01;

/*
	JVM 실행 메모리
	1. 메소드 영역 		2. 스택영역 			3. 힙영역
	 - 클래스정보			 - 함수{} 내 변수들	 - 객체(인스턴스)
	 - 메소드 정보			 - 					 - 필드
	 - static 정적	
	 - 인터페이스정보
	 
	 class 사람 {		 사람 유재석 = 102번지	 유재석객체( 나이 = 30 )
	 	int 나이;		 사람 강호동 = 103번지	 강호독객체( 나이 = 4 )
	 	void 밥먹기 (){
	 	}
	 }
	 
	 * 결론 인터페이스는 힙영역에 만들어질 수 없다
	 * 객체를 만들수 없다 !
 */


// 인터페이스 선언
public interface RemoreControl {
	// 대표 멤버 구성 
		//1. 상수필드 (그냥 필드 아님, 상수 필드임 ! 인터페이스는 상수 필드만 가능하다.)
		// 프로그램내 수정 불가능한 데이터
		// 앞에 public static final 생략되어 있다. 작성하지 않아도 자동적으로 컴파일 과정에서 붙음 ! 
		// int MAX_VOLUME; -> xx
		int MAX_VOLUME = 10; // -> oo
		int MIN_VOLUME = 0;
		//2. 추상메소드 : 선언만 하고 {실행문}구현은 안하는 함수 , 구현은 클래스가 한다.
			// 형태 : public abstract 리턴타입 메소드명 (매개변수)
		public abstract void turnOn(); // public abstract은 생략 가능
		void turnOff(); // 선언만 !!!!!!!!!!!!! 실행문 없음 !!!!!!!!! 
		void setVolume( int Volume );
		
}
