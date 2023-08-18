package java2.day23.Ex_02;

public class Ex_02멀티쓰레드yield {

	public static void main(String[] args) {
		
		//1. [ main 스레드 ] 작업스레드A 객체 생성
		WorkThread workThreadA = new WorkThread("workThreadA");
		//1. [ main 스레드 ] 작업스레드B 객체 생성
		WorkThread workThreadB = new WorkThread("workThreadB");
		
		
		//2. [ main 스레드 ] 작업스레드A 실행
		workThreadA.start();
		//2. [ main 스레드 ] 작업스레드B 실행
		workThreadB.start();
		
		
		//3. [ main 스레드 ] 5초 후 A스레드 잠시 일시정지 [A스레드가 다른 스레드 양보]
		try { Thread.sleep(5000); } catch(Exception e) {}
		workThreadA.work = false;
		//3. [ main 스레드 ] 10초 후 A스레드 실행
		try { Thread.sleep(10000); } catch(Exception e) {}
		workThreadA.work = true;
		
		
	}

}
