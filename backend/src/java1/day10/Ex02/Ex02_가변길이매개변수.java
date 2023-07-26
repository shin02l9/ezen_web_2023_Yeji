package java1.day10.Ex02;

//목적 : 실행
public class Ex02_가변길이매개변수 {// class c

	public static void main(String[] args) {
		
		//1. 다른 클래스에 있는 메소드를 호출하기 위한 객체가 필요
		Computer myCom = new Computer();
		
		//2. 길이가 가변인거지 타입까지 가변은 아니기 때문에 타입을 꼭 지켜서 인수를 넣어야 한다.
		// 인수 3개
		System.out.println(myCom.sum(1,2,3));
		// 인수 5개
		System.out.println(myCom.sum(1,2,3,4,5));
		// 배열 자체를 전달하기
		int[] values = {1,2,3,4,5};
		System.out.println(myCom.sum(values));
		// 배열 자체를 전달하기 두번째 방법 ( 잘 사용되는 방법은 아님 ! )
		System.out.println(myCom.sum(new int[] {1,2,3,4,5}));
		
		// System.out.println( myCom.sum2( "유재석" , 1 , 2 , 3) );
		// System.out.println( myCom.sum2( "유재석" , 1 , 2 , 3 , 4 , 5) );

		// 배열 전달
		int[] values2 = { 1 , 2 , 3 , 4 , 5 };
		System.out.println( myCom.sum2( "유재석" , values2 ) );

		// 배열 전달
		System.out.println( myCom.sum2( "유재석" , new int[]{ 1 , 2 , 3 , 4 , 5 } ) );
		
		
	}
	
	
	
}// class e
