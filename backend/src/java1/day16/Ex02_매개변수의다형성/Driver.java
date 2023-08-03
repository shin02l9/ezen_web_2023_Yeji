package java1.day16.Ex02_매개변수의다형성;

public class Driver {
	public void driver(int value, Vehicle vehicle) {
		// 매개변수에 부모객체와 다향한 자식객체들이 자동타입변환해서 들어온 상태
		// 타입확인 : 객체명 instanceof 클래스명 : 해당객체가 해당 클래스의 타입이면 true/false
		System.out.println( "vehicle 타입확인 : "+ (vehicle instanceof Bus) );
		System.out.println( "vehicle 타입확인 : "+ (vehicle instanceof Texi) );
			// * 강제 타입변환 : 1.태생 자식객체 | 2. 캐스팅
			if( vehicle instanceof Bus ) { System.out.println("버스전진");}
			if( vehicle instanceof Texi ) { System.out.println("택시전진");}
		vehicle.run();
	}
}
