package java2.day23.Ex_02;

public class WorkThread extends Thread{

	//필드
	public boolean work = true; // 스레드 상태에 사용되는 스위치변수 
	//생성자
	public WorkThread(String name) {
		super.setName(name);
	}
	
	@Override
	public void run() {
		while(true) {
			if( work ) { // super.setName(); : 스레드 이름 호출
				System.out.println( super.getName() );
				// Thread.currentThread().getName()
			} else { Thread.yield(); } // 현재스레드의 양보
		} // 해당 스레드는 무한루프 [ 절대 종료되지 않는 스레드 ]
	}
	
	
	
}
