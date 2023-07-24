package java1.day08.Ex04;

//현 클래스의 사용 목적 : 실행 
public class Ex04_예제 {// class s
	public static void main(String[] args) {// main s
		
		//1. Car 객체 선언 : 클래스명 변수명 = new 생성자명();
		Car myCar = new Car();
		
		//2. 객체를 이용한 필드 호출 [.접근연산자]
		System.out.println( "제작회사 : "+myCar.company );
		System.out.println( "모델명 : "+myCar.model );
		System.out.println( "색깔 : "+myCar.color );
		System.out.println( "최고속도 : "+myCar.maxSpeed );
		System.out.println( "현재속도 : "+myCar.speed );
		
		//3. 필드의 값 변경
		myCar.speed = 60;
		System.out.println ("수정된 속도 : "+ myCar.speed );
		
		// --
		Car yourCar = new Car();
		System.out.println ("수정된 속도 : "+ yourCar.speed );

		
	} // main e
}// class e
