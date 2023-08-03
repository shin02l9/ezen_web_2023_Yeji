package java1.day16.Ex01_필드의다형성;

public class HankookTire extends Tire{
	//상속	자식클래스		extends  부모클래스
	//오버라이딩 : 부모클래스의 메소드를 물려받았지만 리모델링 하는것(재정의)
	
	@Override
	public void roll() { // 메소드 선언부 그대로 사용 
		// TODO Auto-generated method stub
		//super.roll(); 부모클래스의 메소드 호출
		//새로운 코드 (재정의)
		System.out.println("한국 Tire 회전");
	}
}
