package java1.day14.Ex02_오버라이딩;

public class Ex02_실행 {

	
	public static void main(String[] args) {
		
		int r = 10;
		
		//1. 부모객체 생성 
		Calculator calculator = new Calculator();
		//2. 부모객체가 부모클래스 멤버 메소드 호출
		System.out.println("원 면적 :" + calculator.areCircle(r));
		
		//3. 자식객체 선언
		Computer computer = new Computer();
		System.out.println("원 면적 :" + computer.areCircle(r));
		
	}
}
