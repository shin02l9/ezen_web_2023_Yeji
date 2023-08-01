package java1.day14.Ex03_부모메소드호출;

public class Airplane {
	//1. 필드
	public String color = "red";
	//2. 생성자
	//3. 메소드
	public Airplane() {
		super();// 부모생성자 호출 -> Object
	}
	public void land() {
		System.out.println("착륙합니다.");
		
	}
	public void fiy() {
		System.out.println("일반 비행합니다.");
		
	}
	public void takeOff() {
		System.out.println("이륙합니다.");
		
	}
}
