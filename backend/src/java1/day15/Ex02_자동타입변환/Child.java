package java1.day15.Ex02_자동타입변환;

public class Child extends Parent{
	 // 상속 자식클래스	extends 부모클래스
	//1. 필드
	//2. 생성자
	//3. 메소드
	@Override
	public void method1() {
		System.out.println("자식클래스메소드1");
	}
	@Override
	public void method2() {
		System.out.println("자식클래스메소드2");
	}
	
	public void method3() {
		System.out.println("자식클래스메소드3");
	}
}
