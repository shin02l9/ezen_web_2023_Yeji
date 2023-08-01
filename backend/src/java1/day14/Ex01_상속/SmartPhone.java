package java1.day14.Ex01_상속;

public class SmartPhone extends Phone{
	//클래스 구성멤버
	//상속을 받아오기 extends[연장하다]  부모클래스명
	// 상속 어렵게 생각하지 말고 그냥 부모 클래스 가져다 쓰는 것이라고 생각하기 !
		// 자식클래스 : SmartPhone / 부모클래스 : Phone
		// SmartPhone 클래스에서 Phone 클래스의 구성 멤버 사용 할 수 있다.
		// Phone 클래스에서 SmartPhone 클래스의 구성 멤버 사용 할 수 없다.
		// 자식은 부모 클래스 사용 가능하지만, 부모는 자식 클래스 사용 불가능
	
		// 자바는 100% 객체 지향언어 = 상속문법 사용

	//1. 필드
	public boolean wifi;
	//2. 생성자
	public SmartPhone( String model, String color) {
		//this.model; // 현재 클래스에 없는 필드라서 당연히 오류난다.
		//상속후에 
		this.model = model;
		this.color = color;
		
	}
	//3. 메소드
	public void setWifi ( boolean wifi ) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	public void internet () {
		System.out.println("인터넷에 연결합니다.");
	}
}
