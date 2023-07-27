package java1.day06;

import java.util.Arrays; 

public class Ex01_배열 { //class s
	public static void main(String[] args) { // main s
		
		//[p.168]
		//1.선언
		String[] season = { "spring" , "summer" , "fall" , "winter" };
			//String[] : String 클래스(타입)으로 배열선언 = String 데이터만 저장가능	
			// {값1, 값2, 값3, 값4} : 배열에 저장할 데이터 순서대로 작성
		//2. 호출 Arrays.toString( 변수명 ) / System.out.println( 변수명[인덱스] );
		System.out.println( season ); // season이라는 변수는 배열의 주소값을 가지고 있는 스택영역이라서 값들이 출력되는게 아니다.
		System.out.println( Arrays.toString( season )); // 주소를 찾아서 그 안에 무엇이 있는지 출력
		System.out.println( season[0] ); // 인덱스 0에 있는 값을 호출
		System.out.println( season[1] ); // 인덱스 1에 있는 값을 호출
		System.out.println( season[2] ); // 인덱스 2에 있는 값을 호출
		System.out.println( season[3] ); // 인덱스 3에 있는 값을 호출
		//3. 변경 ( 새로운값 대입 : = ) 
		season[1] = "여름";  // 인덱스 1 자리에 있는 문자열을 변경하기위해 새로 대입
		System.out.println( Arrays.toString( season ));
		System.out.println( season[1] );
		//4. 삭제 ( 삭제는 없음! 배열은 선언될때 고정이다. )
		// 어차피 삭제는 안되지만 그 자리를 의미없는 것으로 만들 순 있다. 이빨 빠진 것 처럼...
		season[1] = null;
		System.out.println( Arrays.toString( season ));
		System.out.println( season[1] );
		//5. 추가 ( 추가도 없음! 배열은 선언될때 고정이다. )
		// 만약에 해당 배열내 인덱스에 빈공간이 있다면 거기에 값을 대입해서 넣는건 가능.. ! 그런데 공간이 없으면 추가할수 없다. 고정 길이라서ㅠㅠ
		if (season[1] == null ) {
			season[1] = "초여름";
			System.out.println( season[1] );
		} else {System.out.println("공간이 부족합니다.");}
		
		//
		int[] scores = { 83 , 90 , 87 }; // int 형 배열 선언하고 3개의 정수를 초기화
		
		// 총합/평균
		int sum = 0;
		for ( int i = 0 ; i<3 ; i++) { //i는 0부터 3미만까지 1씩 증가 [0~2] // scores배열은 인덱스 : 0~2
			sum += scores[i];
			//1회전 : sum +=83 //2회전 : sum +=90 //3회전 : sum +=87
		}
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + sum/3.0);
		
		
		
		//[p.173] 값을 저장하기 전에 배열부터 빈공간으로 선언해둘수 있다. 
		// < int 형 >
			//1, new 연산자를 이용한 배열 선언
			int[] arr1 = new int[3]; // int 3개를 저장할 수 잇는 배열 선언  [ 0, 0, 0 ]
				System.out.println( Arrays.toString( arr1 ) );
			//2. 배열내 모든 데이터 호출. 0들이 나올것임
			for(int i = 0; i<3; i++) {
				System.out.println( arr1[i] );
			}
			//3. 배열내 값 변경
			arr1[0] = 10; arr1[1] = 20; arr1[2] = 30;
			System.out.println( Arrays.toString( arr1 ) );
		// < double 형 >
			//1. new 연산자를 이용한 배열 선언
			double[] arr2 = new double[3];  // double 3개를 저장할 수 잇는 배열 선언  [ 0.0, 0.0, 0.0 ]
			//2. 배열내 모든 데이터 호출 // 길이를 모르는 경우 -> 배열명.length 사용하기 // *문자열에 사용할때는 소괄호도 서야함 함수라서 -> 문자열.length()
			for(int i = 0; i<arr2.length; i++) {
				System.out.println( arr2[i] );
			}
			//3. 배열내 값 변경
			arr2[0] = 1.1; arr2[1] = 2.2; arr2[2] = 3.3;
			// arr2.push() : 이건 JS에서 사용하는거라 JAVA에서는 사용 불가능함 ! 
 			System.out.println( Arrays.toString( arr2 ) );
			
 		// < String 형 >
 			//1. new 연산자를 이용한 배열 선언
 			String[] arr3 = new String[3];  // String 3개를 저장할 수 잇는 배열 선언  [ null, null, null ]	
 			//2. 배열내 모든 데이터 호출. null이 나올것임
 			for(int i = 0; i<arr3.length; i++) {
				System.out.println( arr3[i] );
			}
 			//3. 배열내 값 변경
 			arr3[0] = "1월"; arr3[1] = "2월"; arr3[2] = "3월";
 			System.out.println( Arrays.toString( arr3 ) );
 			//* 만약에 값 삭제를 하고 싶어 ( 값은 삭제 하지만 공간은 남음, 궁극적인 삭제는 아니고 초기값으로 돌리는 것 )
 			arr3[1] = null;
 				//삭제된 인덱스 뒤로 한칸 당기기
 				for(int i = 1; i <arr3.length; i++ ){
 					if( i == arr3.length-1 ) { arr3[i] = null; break; }
 					arr3[i] = arr3[i+1];
 				}
 			
 				
 			System.out.println( Arrays.toString( arr3 ) );
 			// 추가를 하고 싶어 ( 배열 선언시에 길이가 고정이라서 길이가 늘어나는 추가는 할 수 없고 빈공간이 있다면 그곳에 값을 넣어주는 추가는 가능함.)
 			for(int i = 0; i<arr3.length; i++) {
	 			if (arr3[i] == null ) {
	 				arr3[i] = "12월"; 
	 				System.out.println( Arrays.toString( arr3 ) );
	 				break;
	 			} 
 			}
	}// main e
}// class e


/*
	변수: 하나의 데이터를 저장
	배열 : 여러개의 더이터를 저장
		1. 연속적인 공간에 데이터 저장하고 나열
		2. 각 데이터 공간에 인덱스를 부여해서 사용하는 자료구조
		3. 특징
			1. 배열은 선언된 타입의 값만 저장할 수 있다.
				int[] intArray = { 1, "dd" }  <- 이렇게 저장할수 없음
				* int로 선언된 배열은 int형 데이터만 저장가능하다. JS는 데이터유형 상관없이 저장이 가능했지만 JAVA는 안됨!
			2. 배열의 길이는 선언될때 고정되므로 수정하거나 늘리거나 줄일 수 없다.
				int[] intArray = new int[길이];
				int[] intArray = new int[3];
				intArray[0]; intArray[1]; intArray[2];
				* 추가하거나 줄일수 없다... 고정길이 ! 
				
		4. 배열의 선언 
			1. 타입[] 변수명;    ex) int[] intArray;
			2. 선언과 동시에 값을 대입을 하면 
				타입[] 변수명= {값1, 값2, 값3, 값4}; 
				ex) int[] intArray = {1, 2, 3, 4};
			3. new 연산자로 배열 생성
				타입[] 변수명 = new 타입[길이];			 * 길이: 배열에 저장할 데이터 개수 
				
*/
