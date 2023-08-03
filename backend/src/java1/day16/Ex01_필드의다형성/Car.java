package java1.day16.Ex01_필드의다형성;

public class Car {
	//1. 필드
	public Tire tire; // Tire 클래스 타입의 필드 선언 한거지 객체를 만든건 아니다.
	//2. 생성자
	//3. 메소드
	public void run() {
		tire.roll();
	}

}
