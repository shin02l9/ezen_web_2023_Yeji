package java1.day16.Ex02_매개변수의다형성;

public class Ex02_실행 {

	
	public static void main(String[] args) {
		//0. 
		Driver driver = new Driver();
		
		//1. 부모객체
		Vehicle vehicle = new Vehicle(); 	// 객체타입[vehicle] 매개변수타입[vehicle] 일치해서 가능 ! 
			System.out.println("-----------> 1. 차량대입");
		 	driver.driver(3, vehicle);
		
		//2. 자식객체
		Bus bus = new Bus();				// 객체타입[Bus] 매개변수타입[Bus] 일치해서 가능 !
			System.out.println("-----------> 2. 버스대입");
			driver.driver(5, bus);
		//2. 자식객체 
		Texi texi = new Texi(); 
			System.out.println("-----------> 3. 택시대입");
			//driver.driver('안녕', texi);	// 매개변수의 타입 불일치 불가능
			driver.driver(0, texi); 
			
			
			
	// 
	}
}
