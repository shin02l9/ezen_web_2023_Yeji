package java1.day05;

public class Ex02_문자열 { //class s

	public static void main(String[] args) { // main s
		
		//[p.153]
		String name1 = "홍길동";
		String name2 = "홍길동";
			// 두 스택영역의 지역변수가 참조하는 주소는 같을까?
		System.out.println( name1 == name2 ); // 같다 true
		
		//[p.155]
		String name3 = new String("홍길동");
		String name4 = new String("홍길동");
			// 문자열 리터럴이 아닌 new 연산자를 이용해서 객체를 생성했을때는 같을까?
		System.out.println( name3 == name4 ); // 다르다 false
		
		//[p.156]
		if ( name1 == name2 ) {
			System.out.println("두 문자열이 같습니다.");
		} else { System.out.println("두 문자열이 다릅니다.");}
		
		if ( name3 == name4 ) {
			System.out.println("두 문자열이 같습니다.");
		} else { System.out.println("두 문자열이 다릅니다.");}
		
		//[p.157] 문자열 내에서 특정 문자 추출/꺼내기
		String ssn = "6506241230123";
		char sex = ssn.charAt(6);
		
		if( sex == '1' || sex == '3' ) System.out.println("남자입니다.");
		else System.out.println("여자입니다.");
		
		//[p.158] .length()	문자열의 길이구하기
		System.out.println("주민등록번호 길이 : " + ssn.length());
		
		//[p.159] .replace() 문자열내 특정 문자열 교체/치환/대체 된 문자열 반환
		String oldStr = "자바 문자열은 불변입니다. 자바문자열은 String 입니다.";
		System.out.println(oldStr);
			// 문자열내 "자바" --> "JAVA"로 교체후 교체된 문자열 반환
		String newStr = oldStr.replace("자바", "JAVA"); // 자바 두개가 한번에 다 바뀜.
		System.out.println(newStr);
		
		//[p.160~161] .substring()	 : 문자열 자르기
		String ssn2 = "880815-1234567";
		String secondNum = ssn2.substring(7); System.out.println(secondNum); // 7자리 까지 잘라버려서 나머지 뒤에 숫자만 반환된다.
		String firstNum = ssn2.substring(0,6); System.out.println(firstNum); // 인수들 두개 넣으면 기능이 달라짐 (0~5까지 추출)
		
		//[p.164] .split() 	 : 문자열 분리 
			//ssn2.split("-") - 하이폰 기준으로 분리를 함 !!
			// 880815-1234567 --> {880815 , 1234567}
		System.out.println(ssn2.split("-")[0]); //[0] -> 880815
		System.out.println(ssn2.split("-")[1]); //[1] -> 1234567
		
		//[p.163] .indexOf 	: 문자 찾기
		String subject = "자바 프로그래밍";
		int location = subject.indexOf("프로그래밍");
		if (location == -1) { // 못찾았다.
			System.out.println("프로그래밍 책이 아닙니다.");
		}else { // -1 아니면 찾았다.
			System.out.println("프로그래밍 책입니다.");
		}
		
	} // main e
	
} // class e


/*
 	자바 문자열 사용하는 방법 
 		1. String 변수명 = "문자열";
 		2. String 변수명 = new String("문자열");
 		
 	자바 문자열에서 제공해 주는 라이브러리 = 미리 만들어진 함수들 
 		문자열 객체.메소드명()
 		1. 문자열 객체1.equals ( 문자열객체2 )   : 두 문자열 객체내 문자열이 동일하면 true 아니면 false 반환 [주소x]
 		2. 문자열객체.charAt (인덱스)			: 문자열내 해당 인덱스의 문자1개 추출 [첫번째 글자 인덱스0]
 		3. 문자열객체.length()					: 문자열내 문자의 개수 반환
 			vs 배열명.length
 		4. 문자열객체.replace("기존문자열","새로운문자열")  : 문자열내 기존문자열이 존재하면 새로운문자열로 치환해서 반환
 		5. 문자열객체.substring(인덱스)	 				: 해당 인덱스부터 마지막 인덱스까지 추출 [문자열 자르기]
 				  .substring(시작인덱스,마지막인덱스)	 		인수들 두개 넣으면 기능이 달라짐, 시작 인덱스부터 끝 인덱스전까지 추출해서 반환
 		6. 문자열객체.split ("분리기준문자")				: 문자열내에 분리기준문자로 분리해서 배열로 반환 [문자열 분리] 
 			문자열객체.split ("분리기준문자")[인덱스]		: 문자열내 분리후 분리된 인덱스 하나를 호출 
 		7. 문자열객체.indexOf ("찾을문자열") 			: 문자열내 찾을 문자열이 존재하면 찾은 문자열 인덱스 반환 / 없으면 -1
 */





