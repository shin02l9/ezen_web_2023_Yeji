package java1.day09.Ex02;

public class Korean {
	//1. 필드 : *객체의 데이터를 저장하는 곳!!!!!!!!!
		String nation = "대한민국";		//1. 객체마다 동일한 값을 갖고있다면 / 객체에 필드값을 미리 대입해 초기화 해두기 
		String name;					//2. 객체마다 다른 값을 가져야 한다면 / 객체의 필드값을 기본값으로 -> 생성자 이용 권장
		String ssn;
		
	//2. 생성자 : *객체 생성시 초기화 역할 담당
		//0. 기본생성자
		public Korean() {}
		//1. 매개변수 2개인 생성자를 만듬
		public Korean(String name, String ssn) { // 읽기좋게 하기위해서 매개변수명과 필드명을 동일하게 사용하길 권장한다. 
												 // 그랬더니 식별 불가능이라 아래의 this를 활용함 !
			//String n = "신예지"
			//String s = "960219-1234567"
			//this : 현재 클래스란 뜻, 함수 안에서 사용한다.
				//this.필드명 | this.메소드명() | this() <- 이건 생성자
				//this : 해당 함수/메소드/생성자 호출한 객체 = 주체
			this.name = name; this.ssn = ssn;
		}
		//3. 오버로딩
		//public Korean (String ssn, String name) {}  <-- 컴파일 오류뜸
		public Korean(String name, String ssn, String nation) {
			this(name,ssn); this.nation = nation;
		} // 이건 가능. 매개변수 타입 같지만 개수다름
		public Korean(String name, int ssn) {}  // 이것도 가능. 매개변수 개수 같지만 타입이 다름
		public Korean(int ssn, String name) {} // 이것도 가능. 매개변수 개수 같지만 타입과 순서가 다름
		
	//3. 메소드
}
