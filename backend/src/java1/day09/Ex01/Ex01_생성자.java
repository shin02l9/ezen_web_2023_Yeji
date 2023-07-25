package java1.day09.Ex01;

//목적 : 
public class Ex01_생성자 { // class s

	public static void main(String[] args) {// main s
		
		//1. 객체 생성 : 클래스명 객체변수명 = new 생성자명();
		//Car myCar = new Car(); // 오류뜸 -> 1개 이상의 생정자를 선언했을때 기본 생정자가 자동으로 생성되지 않아서 사용불가
		Car myCar = new Car("그랜저","검정", 20);
		
		
	}// main e
} // class e
