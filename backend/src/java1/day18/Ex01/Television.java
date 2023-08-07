package java1.day18.Ex01;

// 이 클래스에서 인터페이스를 구현한다.
public class Television implements RemoreControl{
		//    클래스명 	implements	인터페이스명
	// 인터페이스가 선언한 추방 메소드를 해당 클래스가 구현을 대신한다.
	// 인터페이스는 선언만 하고 구현은 각 클래스가 하는 것 !!!
	// 해당 추상 메소드를 구현하기 전까지는 오류가 뜸 ! (빨간줄)
	// 상속보다 인터페이스를 더 많이 사용하는 이유는 확장성이 좋기 때문이다. 
	// extends 는 다중이 안되는데 implements은 가능하다.
	
	//필드
	private int volume; // 인스턴스 필드
	
	// 추상메소드 구현 : implements 인터페이스명을 하게되면 해당 인터페이스안에 모든 추상메소드를 꼭! 구현해야한다. (강제)
	@Override
	public void turnOn() {
		System.out.println(" TV를 켭니다. ");	
	}
	@Override
	public void turnOff() {
		System.out.println(" TV를 끕니다. ");
	}
	@Override
	public void setVolume(int Volume) {
		// 만약에 볼륨이 최대 볼륨보다 크면 해당 객체의 소음을 최대 볼륨으로 대입/설정
		if( Volume > RemoreControl.MAX_VOLUME ) { // 왜 그대로 사용하지!? 객체를 만들수 없는것들은 이렇게 사용이 가능한건가 !!
			this.volume = RemoreControl.MAX_VOLUME;
		// 만약에 볼륨이 최소 볼륨보다 작으면 해당 객체의 소음을 최소 볼륨으로 대입/설정
		}else if( Volume < RemoreControl.MIN_VOLUME ) {
			this.volume = RemoreControl.MIN_VOLUME;
		}else { this.volume = Volume; }
		System.out.println(" 현재 TV의 볼륨 : "+this.volume);
	}
	
}
