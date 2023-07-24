package java1.day08;

public class Ex02_선언 {

	public static void main(String[] args) {
		
		//1. 객체 만들기/선언 : 글래스명 변수명 = new 생성자명();
		Student s1 = new Student();
			//1. Student : Student클래스를 가져와서 설계도로 사용
				//2. s1 : Student객체의 주소값을 저장할 스택영역의 지역 변수 
					//3. new : 객체 생성하고 생성된 주소값을 스택영역의 지역변수에게 반환
						//필수아님//4. Student(); : 객체 생성시 초기/처음값을 넣어서 필드에 저장할 수 있는 메소드
		System.out.println(" s1 변수가 Student 객체의 주소를 가지고 있다.");
		//. (도트연산자) : 변수명.메소드()  / 변수명.필드명 : 변수가 가지고 있는 주소로 이동
		
		int 정수 = 10; // 정수.메소드()  이렇게 주소가 아니라 값 자체를 저장한 변수에는 도트연산자 사용 불가능하다. ( 기본자료형은 안된다는 말! ) 
 		Integer 정수객체 = 10; // 정수객체.메소드() 이건 가능 !!!!!!!
 		
 		//2. 하나 더 객체 만들기
 		Student s2 = new Student();
 		
 		//3. Student 설계도/클래스는 같지만 서로 다른 객체가 생성 [ * new 연산자는 항상 새로운 힙주소 할당 ]
 		System.out.println(" s2 변수가 또 다른 Student 객체의 주소를 가지고 있다.");
	}
}
