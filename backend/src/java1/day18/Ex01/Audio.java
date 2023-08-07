package java1.day18.Ex01;

public class Audio implements RemoreControl{
	
	//필드
	private int volume; // 인스턴스 필드
		
	@Override
	public void turnOn() {
		System.out.println(" Audio를 켭니다. ");	
	}
	@Override
	public void turnOff() {
		System.out.println(" Audio를 끕니다. ");
	}
	@Override
	public void setVolume(int Volume) {
		if( Volume > RemoreControl.MAX_VOLUME ) { // RemoreControl를 왜 그대로 사용하지!? 객체를 만들수 없는것들은 이렇게 사용이 가능한건가 !!
			this.volume = RemoreControl.MAX_VOLUME;
		}else if( Volume < RemoreControl.MIN_VOLUME ) {
			this.volume = RemoreControl.MIN_VOLUME;
		}else { this.volume = Volume; }
		System.out.println(" 현재 Audio의 볼륨 : "+this.volume);
	}
	
}
