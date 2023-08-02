package java1.day15.Ex02_자동타입변환;

public class Ex02_실행 {

	
	public static void main(String[] args) {
		
		//1. 부모 객체 생성
		Parent parent = new Parent(); // -> 힙 : parent객체 1개
		
		//2. 자식 객체 생성 [ 자식 객체는 힙 생성시 부모 객체의 힙도 생성 ]
		Child child = new Child(); // -> 힙 : parent객체 child객체 총2개
		
		//3. (자동 타입변환) 자식객체를 부모객체에 대입? 
		Parent parent2 = child; // 가능 !
		//자식클래스는 부모의 특징과 기능을 상속 받았기 때문에 부모와 동일하게 취급될 수 있다.
		// ㄴ 의 뜻은 자식객체는 부모 객체가 될 수 있다.

		parent2.method1();
		//parent2.method3(); // -> 불가능
		// !! : 자식 객체가 부모 객체로 대입 후에 부모 객체는 자식객체의 멤버를 사용 할 수 있다.
		// 단, 오버라이딩된 메소드는 사용 가능하다, 부모객체가 자식객체의 오버라이딩 아닌 메소드는 사용이 불가능
		
		//4. 부모객체를 자식객체에 대입?
		// Child child2 = parent; // 불가능 !
		// 부모객체는 자식 객체가 될수 없다.
		// 왜냐면 부모 클래스 어디에도 자식이 언급되어있지 않다.
		// 자식은 부모를 알지만 부모는 자식을 모름
		
		//(강제 타입변환)
		
		Parent parent3 = new Child();
		Child child2 = (Child)parent3;
		// 단, 강제 캐스팅을 이용한 형변환가능
		//!! 부모객체가 자식객체로 대입후에 변환된 자식객체는 부모객체의 멤버를 사용할 수 있다.
		child2.method1();
		child2.method2();
		child2.method3();
		
		//Parent parent4 = new Parent(); 순수 부모 객체는 자식 객체가 될 수 없다.
		//Child child2 = (Child)parent4; -> 오류뜨는 예제
	}
}
