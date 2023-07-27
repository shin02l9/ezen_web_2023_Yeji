package 과제.과제10;

// 목적 : 데이터의 설계(모델링)
public class Member { // class s

	//1. 필드 : 객체의 데이터를 저장하는 곳 = 인스턴스 vs 정적멤버 static
	String id;
	String pw;
	String name;
	String phone;
	int age;
	//2. 생성자 : 객체의 초기화를 담당하는 역할 = 인스턴스 vs 정적멤버 static
		// 1. 빈 생성자 하나 생성해 두기 
		public Member() {
			// TODO Auto-generated constructor stub
		}
		//2. 모든 필드 저장하는 생성자 자동 완성하기 | 우클릭 후 Source -> Generate Constructor using Fields -> 모든 필드 체크하고 생성
		public Member(String id, String pw, String name, String phone, int age) {
			super();
			this.id = id;
			this.pw = pw;
			this.name = name;
			this.phone = phone;
			this.age = age;
		}

	
	//3. 메소드 : 객체의 행동을 담당하는 역할 = 인스턴스 vs 정적멤버 static
		//1. getter / setter -> 필수★★★★★★★★
		//2. toString  -> 필수★★★★★★★★ 무조건 베이스로 깔고 들어감
			// ㄴ> 객체 호출시 객체의 주소가 아닌 필드의 값을 반환해주는 함수 [*개발자가 코드 검사용으로 사용한다. 고객이 아니라]
			//자동 완성하기 | 우클릭 후 Source -> Generate toString() -> 모든 필드 체크하고 생성
		@Override
		public String toString() { // 객체의 주소값 대신 필드의 문자형식으로 반환해주는 함수.
			return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
		}
	
		
		
}// class e

/*
	JVM : 자바 가상(논리적으로 만들어낸) 메모리
		- 자바는 하드웨어 조작x (직접적으로 메모리 관리 x)
		
		Member.java  ----컴파일:클래스로더---->  Member.class   ------> 메소드 영역
		자바코드 파일 						 	바이트코드파일				클래스 코드, 메소드 코드, 정적멤버 주소
	
		this 	: 인스턴스 멤버 : new 연산자로 힙 생성시 할당되고 힙 초기화 될때 ( GC )
					ㄴ> static 없으면 인스턴스 멤버 ! 
					- 객체를 통해서 사용한다.
					
		static  : 정적 멤버 : 프로그램 시작 할당 되고 프로그램이 종료될대 [전역/공통/공용/공유]
					- 클래스를 통해 사용한다. 
		final	: 수정불가 : 초기화할때 대입만 가능하고 수정 불가능
		static final : 상수 : 프로그램내에서 1개만 저장 (static) 수정불가능 (final) 합친 키워드
		
		
		
*/