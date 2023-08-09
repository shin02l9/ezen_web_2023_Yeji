package java1.day20.Ex01;

public interface RemoteControl { // 인터페이스 선언
	// 인터페이스 : 두 장치를 연결하는 접속키
	// 구성멤버
		//1. public	상수 필드		[ public static final ]
		int MAX_VOLLME = 10;
		public static final int MIN_VOLLME = 0;
		
		//2. public	추상 메소드
		void turnOn();
		public abstract void turnOff();
		void setVolume( int volume );
		
		//3. public	디폴트 메소드
		default void setMute( boolean mute ) {
			if( mute ) { System.out.println("무음 처리합니다."); setVolume( MIN_VOLUME ); }
			else { System.out.println("무음 해제합니다."); }
		}
		public default void getMute() { System.out.println(); }
		
		
		//4. public	정적 메소드
		static void changeBattery() { System.out.println("리모콘 건전지를 교환합니다.");}
		public static void chackBattery() { System.out.println("건전지 확인합니다.");}
		
		
		// JAVA 9 이상부터 지원하느 메소드 ~
		//5. private 메소드 		: 디폴트메소드 안에서만 호출가능
		private void defaltCommon() {
			System.out.println("디폴트메소드");
		}
		//6. private 정적메소드	: 디폴트메소드, 정적메소드 호출가능
		private static void staticCommon() {
			System.out.println("정적메소드");
		}
}
