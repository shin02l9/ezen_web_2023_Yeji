package java1.day16.Ex01_필드의다형성;

public class Ex01_실행 {
	public static void main(String[] args) {
		
		//1. Car 객체 생성
		Car myCar = new Car(); // tire필드에 객체가 없는 상태 
		System.out.println( myCar.tire );
			// -> null 이 나올것임 ! 필드에 초기화가 없으면 기본값이 들어간다. 
		//2. Cat 객체의 타이어 장착 = Car객체의 타이어 필드에 초기화
		myCar.tire = new Tire(); // 기본타이어 객체 대입
		System.out.println( myCar.tire );
		
		//3. 타이어객체 장착된 Car객체가 전진
		myCar.run(); // 기본 타이어 객체가 roll 메소드 실행 
		
		//4. 타이어 교체하기 위해 카센터에서 한국타이어 교체
		myCar.tire = new HankookTire();
		System.out.println( myCar.tire );
				
		//5. 타이어 교체 장착된 Car 객체가 전진
		myCar.run(); // 한국타이어 객체가 roll 메소드 실행 
		
		//6. 타이어 교체하기 위해 카센터에서 금호타이어 교체
		myCar.tire = new KumhoTire();
		System.out.println( myCar.tire );
		
		//7. 타이어 교체 장착된 Car 객체가 전진
		myCar.run(); // 금호타이어 객체가 roll 메소드 실행 
	}
}
