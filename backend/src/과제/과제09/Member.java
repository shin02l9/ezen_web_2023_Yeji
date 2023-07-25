package 과제.과제09;

// 목적 : 설계도, 객체의 모델
public class Member { // class s
	
	//1. 필드 : 객체의 데이터를 저장하는 곳 (객체가 아니다. 설계도이다.)
	// 초기값이 없을때는 기본값이 들어간다. [정수는 0, 실수는 0.0, 논리는 false, 참조는 Null]
	String id;
	String pw;
	String name;
	String phone;
	int age;
	
	//2. 생성자
		//0. 빈 생성자 ( 기본생성자 )
	public Member() {}
		//1. 매개변수 5개 정의 
	public Member(String id, String pw, String name, String phone, int age) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	
//		//2. 매개변수 4개 정의 (오버로딩)
//	public Member(String id, String pw, String name, String phone) {}
//		//3. 매개변수 3개 정의 (오버로딩)
//	public Member(String id, String pw, String name) {}
//		//4. 매개변수 2개 정의 (오버로딩)
//	public Member(String id, String pw) {}
//		//5. 매개변수 1개 정의 (오버로딩)
//	public Member(String id) {}
//		//6. 매개변수 1개 정의 (오버로딩)
//	public Member(int age) {}
	
	//3. 메소드

} // class e
