package java1.day11.Ex01;

import java1.day11.Ex02.C;

public class B {

	A a = new A(); // 오류 A와 B클래스는 같은 패키지
	
	public B() {} // B클래스 생성자 
	
	//C c = new C(); // C클래스 호출은 가능하지만 생성자(private)에서 막힘
	
}
