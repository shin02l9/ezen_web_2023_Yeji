package java1.day18.Ex01;

public class Ex01_실행 {

	
	public static void main(String[] args) {
		//1. 인터페이스 타입의 객체를 생성하지만 깡통 ! 
		RemoreControl rc; // 주소값이 없는 상태이다.
			//* 인터페이스만으로 객체 생성이 불가능하다 ( 객체 생성하려면 추상메소드 구현후 가능함 )
			//RemoreControl rc2 = new RemoreControl(); --> 이런게 불가능 ! 
			// rc.turnOn(); // 추상메소드 객체 없이 실행 x
		//2. 객체에 Television 객체를 대입한다. (Television의 주소를 대입한다.)
		rc = new Television(); // 구현 객체 : 해당 추상메소드가 존재한 인터페이스를 구현해준 클래스로 객체 생성
		//3. 인터페이스로 메소드 실행
		rc.turnOn();
		//4. 리모콘을 오디오로 변경하고 싶어!
		rc = new Audio();
		rc.turnOn();
		
		//5. RemoreControl의 상수 필드 호출
		System.out.println(" 리모콘의 최대 볼륨 : "+ rc.MAX_VOLUME);
		System.out.println(" 리모콘의 최소 볼륨 : "+ rc.MIN_VOLUME);
		
		//6. 메소드 실행
		System.out.println(" 볼륨을 100 입력했다! 하지만? ");
		rc.setVolume(100);
		
		//7. 리모콘 교체
		rc = new Television();
		System.out.println(" 볼륨을 -10 입력했다! 하지만? ");
		rc.setVolume(-10);
		
		
	}
}

/*
	인터페이스 		 						상속
	implements  			vs  			extends
	구현하다									연장하다.
	여러개 구현								1개 상속
	추상메소드									메소드
	*버전에 따라 다양한 메소드 제공
	목적 : 메소드 통합							목적 : 빠른 개발 / 설계 모듈화 [쪼개서]
	ex) 게임패드 등 							ex) 직급별사원 등
 */
