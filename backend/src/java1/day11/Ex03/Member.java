package java1.day11.Ex03;

public class Member {

	
	// 싱글톤 : 프로그램내 객체가 1개만 존재하는 객체 [MVC 패턴]
		
	//1. 자신의 타입으로 객체를 생성한다.
	private static Member member = new Member();  // --> private 제한한다.
	
	//2. 싱글톤 객체를 반환하는 함수 생성
	public static Member getInstance() { 
		return member; 
		}
	
	//3. 외부에서 사용 목하게 생성자를 잠금 
	private Member() {};

}
 