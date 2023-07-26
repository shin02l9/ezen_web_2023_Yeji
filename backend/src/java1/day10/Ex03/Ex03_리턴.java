package java1.day10.Ex03;

public class Ex03_리턴 { // class s
	public static void main(String[] args) {
		
		
		//1. 자동차 객체 (기본생성자)생성
		Car myCar = new Car();
		
		//2. 메소드를 이용한 필드에 값 대입
		myCar.setGas (5);
		
		//3. 메소드 호출
		if( myCar.isLeftGas()) {
			//만약에 '가스여부확인' 함수가 true 반환해주면 가스가 있다는 뜻
			System.out.println("출발합니다.");
			myCar.run();
		}
		System.out.println("gas 를 주입하세요.");
	}
}  // class e
