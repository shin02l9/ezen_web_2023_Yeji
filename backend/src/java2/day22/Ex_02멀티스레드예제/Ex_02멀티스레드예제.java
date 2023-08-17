package java2.day22.Ex_02멀티스레드예제;

public class Ex_02멀티스레드예제 {

	public static void main(String[] args) {
		// 스레드 현황 : [main] -싱글스레드
		System.out.println("main출력중");
		
		//1. main스레드가 작업스레드 객체 생성
		Ex_02작업스레드01 작업스레드01 = new Ex_02작업스레드01(); // 구현객체 생성
		Thread thread = new Thread(작업스레드01); // 구현 객체를 Thread 객체에게 전달 
		//1. 작업스레드01 객체에서 작업스레드 시작 
		thread.start();
		
		
		//2. main스레드가 작업스레드 객체 생성
		Ex_02작업스레드02 작업스레드02 = new Ex_02작업스레드02();
		//2. 작업스레드02 객체에서 작업스레드 시작
		작업스레드02.start();
		
		
		
		//3. main스레드가 1초에 1번씩 출력
		try {
			int count = 1;
			while(true) {
				System.out.println(Thread.currentThread().getName()+" [ main Thread ] output : "+count);
				// Thread.currentThread().getName() : 현재 쓰레드의 이름 호출
				// Thread.currentThread().setName("새로운이름");
				Thread.sleep(1000); // 1초간 정지 **예외처리 필수 ! 
				count++;
			}
		}
		catch( Exception e ) {System.out.println(e);};
		
		
	}
}
