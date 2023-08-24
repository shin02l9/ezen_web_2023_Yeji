package java2.day21예외처리;

public class Ex_01예외처리 {

	public static void printLength( String data ) {
		try { // 예외 발생 할 것 같은 코드
			int r = data.length(); 
			System.out.println(" 문자수 : "+ r);
		} catch ( NullPointerException e ) {// 예외 발생하면 이곳으로 이동하고 *예외정보를 객체에 저장해둔다. 
			System.out.println( e.getMessage() ); // e 에는 예외 발생에 관련된 정보들이 들어 있다.
			//Cannot invoke "String.length()" because "data" is null
		} finally { //예외가 발생 하던 안하던 실행되는 코드이다. 
			System.out.println(" 마무리 ");
		}
	}
	
	public static void main(String[] args) {
		
		//p.466 : 실행예외 [ 실행후 예외가 발생하기 때문에 예외처리는 경험/테스트 후에 처리 ]
		System.out.println(" 프로그램 시작 ");
		printLength("ThisisJava");	// 정상 실행 
		printLength(null); 			// NullPointerException 정말 많이 뜨는 예외 !!!
		System.out.println(" 프로그램 종료 ");
		
		//p.468 : 일반 예외 [ 실행전부터 컴파일러가 예외검사를 하기 때문에 (빨간줄이 뜸) ]
		try {
			Class.forName("java.lang.String"); // Class.forName()  : 클래스 찾기
			System.out.println(" java.lang.String 존재 ");
			//ClassNotFoundException : 만약에 클래스를 못찾았을때 예외 처리 미리 해야한다 ! 
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		try {
			Class.forName("java.lang.String2"); 
			System.out.println(" java.lang.String2 존재 ");
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}

	}
}

/* 
	에러 : 컴퓨터의 하드웨어 고장으로 인해 실행 오류가 발생
	예외 : 에러 이외 
		1. 일반 예외 : 컴파일러가 예외 처리 코드여부를 검사하는 예외
			- 파일처리, JDBC(DAO), 네트워크, 입출력
		2. 실행 예외 : 컴파일러가 예외 처리 코드여부를 검사하지 않는 예외
			- 개발자의 경험에 의존해서 사용하는게 일반적
			- 실행 도중에 오류가 발생 하는 것 
			- 타입 오류, 배열의 인덱스가 부족, null로 객체가 없는데 메소드 사용
	예외 처리 : 
		try{ 예외가 발생 할 것 같은 코드 }
		catch (예외클래스 변수객체) { 예외가 발생 했을때 코드 }
		finally{ 예외와 상관 없이 항상 실행되는 코드 }
*/