package java2.day26.Ex_03LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex_03예제 {
	public static void main(String[] args) {
		
		// ArrayList 객체
		List<String> list1 = new ArrayList<>();
			// ArrayList	    vs		 LinkedList
			// 사용방법이 동일하지만 내부구조 설계가 다르다. 속도의 차이???
			// 배열[에 객체저장]	vs 		객체를 체인처럼 연결
			// .add( 객제 ) : 마지막 인덱스에 객체 추가
			// .add( 인덱스, 객체 ) : 해당 인덱스에 객체 추가
			// 리스트 내 중간에 데이터를 삽입/삭제하는 게 많으면 ArrayList은 비효율적이다.
			// 리스트 내 중간에 데이터를 삽입/삭제하는 게 많으면 LinkedList가 효율적이다.

			
		// LinkedList 객체
		List<String> list2 = new LinkedList<>();
		
		
		
		// 두 객체의 저장 속도 차이
		long startTime;		// 시작시간	
		long endTime;		// 끝시간
		
		// 밀리초 (1/1000초)  나노초(1/10억초)
		startTime = System.nanoTime(); // 현재 시간을 나노시간
		for( int i = 0; i<10000; i++) {
			list1.add( 0, i+ "");
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList가 10000개를 저장하는데 걸리는 시간 : "+ (endTime-startTime));
		
		
		// 밀리초 (1/1000초)  나노초(1/10억초)
		startTime = System.nanoTime(); // 현재 시간을 나노시간
		for( int i = 0; i<10000; i++) {
			list2.add( 0, i+ "");
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList가 10000개를 저장하는데 걸리는 시간 : "+ (endTime-startTime));
	}
}
