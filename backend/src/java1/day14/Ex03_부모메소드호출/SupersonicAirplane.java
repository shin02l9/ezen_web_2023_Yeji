package java1.day14.Ex03_부모메소드호출;

public class SupersonicAirplane extends Airplane{
			// ㄴ자식클래스명 		ㄴ extends	ㄴ부모클래스명
		//!  : 자식클래스에서 부모클래스의 구성멤버를 사용할 수 있다.
		//!! : 부모클래스는 자식클래스의 구성멤버를 사용할 수 없다.
	//1. 필드
	//상수
	public static final int NORMAL = 1; 
	public static final int SUPERSONIC = 2; 
	//인스턴스
	public int flyMode = NORMAL;
	//2. 생성자
	public SupersonicAirplane() {
		super(); // 부모생성자 호출 -> Airplane
	}
	//3. 메소드
	@Override
	public void fiy() {
		if(flyMode == SUPERSONIC) { 
			System.out.println("초음속 비행합니다.");
		}else {
			super.fiy(); //부모 메소드 호출 
		}
	}
	@Override
	public String toString() { //Object 메소드를 오버라이딩
		return "SupersonicAirplane [flyMode=" + flyMode + "]";
	}
	
	
	
	
}


/*
		this 		vs 		super
		현재클래스				부모클래스
필드		this.필드명;			super.필드명;
생성자	this();				super();
메소드	this.메소드명;		super.메소드명;

		오버로딩		: 동일한 메소드명일떄 배개변수에 따른 식별가능
		오버라이딩		: 부모클래스로 상속받은 메소드를 재정의 할때


*/