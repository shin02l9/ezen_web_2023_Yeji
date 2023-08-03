package java1.day16.Ex01_필드의다형성;

public class KumhoTire extends Tire{
	//상속	자식클래스		extends  부모클래스
	// 상속을 받으면 자식클래스에서 부모클래스의 멤버(필드,생성자,메소드)를 사용할 수 있다.
	
	
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		//super.roll();
		System.out.println("금호 Tire 회전");
	}
}
