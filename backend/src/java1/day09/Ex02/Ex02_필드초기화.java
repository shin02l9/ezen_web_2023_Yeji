package java1.day09.Ex02;

public class Ex02_필드초기화 {
	public static void main(String[] args) {
		//1. 필드의 초기화 -------------------------------------------------------------
			//1. 객체생성
				//1. 기본생성자를 이용한다. : 객체 생성시 초기화 x
			Korean k = new Korean();
			System.out.println(k.nation); // 대한민국이 출력된다. ㄷㄷㄷ 자동으로 들어있네
			System.out.println(k.name); // 값이 없음 ! 
			
				//2. 정의한 생성자를 사용한다. : 객체 생성시 해당 매개변수를 초기화 o
			Korean k1 = new Korean("신예지", "960219-1234567");
			System.out.println(k1.nation); // 여기도 대한민국이 출력된다. 공통으로 미리 nation값을 선언해둬서 그럼 ! 
			System.out.println(k1.name); // 값이 있음 ! 
			
				//3. 정의한 생성자 2번쨰 사용
			Korean k2 = new Korean("이도규", "950924-1234567");
			System.out.println(k2.nation);
			System.out.println(k2.name);
			
		//2. 생성자 오버로딩 -------------------------------------------------------------
			// 오버로딩 : 동일한 메소드명을 여러개 선언 불가능 -> 왜냐 식별이 불가능하니까 
				//해결책 : 매개변수의 개수/타입/순서 이용한 메소드식별
			
			
			
			
			
	}
}
