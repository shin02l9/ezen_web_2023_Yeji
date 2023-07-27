package java1.day11.Ex02;

import java1.day11.Ex01.B;

public class C {

	//1. 오류 A와 C클래스는 다른 패키지니까.
	// A a = new A();
	
	//2. 오류 B와 C클래스는 다른 패키지 이지만 B클래스가 public 이라서 가능 
	B b = new B();
	
	private C() {}; // C클래스 생성자
	
}

