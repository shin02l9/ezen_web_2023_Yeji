package java2.day28.Ex03_사용자정의정렬;

import java.util.TreeSet;

public class Ex03_예제 {

	public static void main(String[] args) {

		
		// Integer, String, Double 정렬 기준이 명확하다. ( 숫자, 문자 이므로)
		// 사용자정의 클래스인 Member ( 여러개 필드 ) 정렬기준이 명확하지 않음 ! 
		
		// compareTo 메소드[Comparable 인터페이스로부터 구현]를 이용한 정렬 기준 만들기
		
		// 1. Tree 
		TreeSet<Person> treeSet = new TreeSet<>();
			// TreeSet<>의 제네릭에는 Comparable 로부터 구현된 클래스의 객체만 저장 가능하다.
			// import하는 클래스에 implements Comparable<Person>가 안되어 있으면 오류 뜸 ! 
		
		// 2. 무작위 Person 객체 대입
		treeSet.add( new Person("홍길동", 40) );
		treeSet.add( new Person("김자바", 35) );
		treeSet.add( new Person("신예지", 28) );
		treeSet.add( new Person("이도규", 29) );
		System.out.println("이진트리 상태 : "+treeSet);
		
		
		
		
	}	
}
