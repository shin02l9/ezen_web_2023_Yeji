package java2.day23.Ex_01;

public class Ex_01멀티쓰레드join {

	
	public static void main(String[] args) {
		//main 스레드가 main 함수 호출 
		System.out.println( "현재스레드 : "+Thread.currentThread().getName() );
		
		//1. [main 스레드] 스레드 객체 생성 [ main외 추가적으로 작업스레드 생성 ]
		SumThread sumThread = new SumThread();
		//2. [main 스레드] 스레드 실행-> 대기상태 -> 실행 -> 대기상태 -> 대기 -> 실행
		sumThread.start();
		//3. [main 스레드] 작업스레드 객체의 필드 확인 
		
		// 작업스레드가 1~100까지 계산이 끝나기전에 main스레드가 결과 먼저 출력하게 된다. 
		System.out.println(" [join 하기 전] 1 ~ 100 합 : "+sumThread.getSum() );
		
		// join을 한 후 
		try {
			sumThread.join(); // 합친다. [ join() : 작업스레드를 호출한 스레드는 일시정지 상태]
			// main 스레드가 sumThread 스레드의 join메소드를 호출 했기 때문에 main 스레드 일시정지 
			// sumThread 스레드가 종료되면 main 스레드 일시정지 풀림
		} catch( Exception e ) {System.out.println(e);}
		System.out.println(" [join 한 후] 1 ~ 100 합 : "+sumThread.getSum() );
		
	}
	
	
}
