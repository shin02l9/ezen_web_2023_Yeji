package java2.day26.Ex_02Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java2.day26.Board;

public class Ex_02예제 {

	public static void main(String[] args) {
		//1. Vector 리스트 객체 생성
			// ArrayList vs Vector
			// 내부구조 동일하고 함수도 동일하다.
			// 동기화x vs 동기화o 의 차이이다.
		List<Board> list = new Vector<>(); 			// 안전하게 2천개 모두 저장
		//List<Board> list = new ArrayList<>();		// 2천개를 모두 저장을 못함! 
		
		//2. 작업스레드 A 추가
		Thread threadA = new Thread() {
			@Override
			public void run() {
				for( int i = 1; i<=1000; i++ ) {
					list.add( new Board("제목","내용","글쓴이") );
				}
			}
		};
		
		//2. 작업스레드 B 추가
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for( int i = 1001; i<=2000; i++ ) {
					list.add( new Board("제목","내용","글쓴이") );
				}
			}
		};
		
		//3. 스레드 실행
		threadA.start();
		threadB.start();
		
		//4. main 대기 상태 만들기
		try { // 두 스레드의 작업이 모두 끝날때 까지 main 스레드 기다림 -> 작업결과를 확인하려고
			threadA.join(); threadB.join();
		}catch( Exception e ) {System.out.println(e);}
		
		//5.
		System.out.println("두 스레드가 리스트에 추가한 객체 수 : "+list.size()+"개");
	}
}
