package java1.day14.Ex03_부모메소드호출;

public class Ex03_실행 {
	public static void main(String[] args) {
		//1. 자식객체
		SupersonicAirplane sa = new SupersonicAirplane();
		
		//2. 
		sa.takeOff();
		sa.hashCode();
		sa.fiy();
		sa.land();
		sa.toString();
	}
}
