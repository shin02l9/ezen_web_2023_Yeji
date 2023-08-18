package java2.day23.Ex_01;

/*
	멀티쓰레드 구현하는 방법
		1. Thread 클래스로부터 extends (extends Thread)
		2. Runnable 인터페이스로부터 implements (implements Runnable)
 			
 		-> 두 방법 모두 run메소드 재정의 ! 
 			1. new 이용한 스레드 객체 생성 
 			2. start() 메소드 이용한 run() 작업코드 실행
 				- start() 한다고해서 바로 실행 xxx
 					* 실행대기(Runnable): 실행 대기표 받고 기다리는 중 (운영체제가 [CPU]를 사용할 수 있는 권한 줄때까지) = CPU 스케쥴링
 						반복 ↑↓
 					* 실행(Running)	: 해당 스레드 순서가 되면 CPU 사용할 수 있는 권한 [ 명령어 전달 ]
 						일시정지 : 스레드가 실행대기가 아닌 잠시 정지된 상태
 					* 종료(Terminated)	: 스레드 종료
 				
 			**
 			병렬(여러단위의 흐름=다차선도로) vs 직렬(하나단위의 흐름=1차선도로)
 				- 단일직렬스레드 : main 함수만
 				- 멀티병렬스레드 : main에서 thread 추가 하는 경우
 		
 				- 컴퓨터 병렬 처리 방법
 					- 소프트웨어 (손x, 논리)[자바]는 직접적인 하드웨어 (손o, 물리)[cpu, 메모리] 조작 x
 
 			
 			
 			
 			
 */
public class SumThread extends Thread {
	
	//필드
	private long sum;
	//생성자
	public SumThread(long sum) {
		super();
		this.sum = sum;
	}
	public SumThread() {
		super();
	}
	//메소드
	public long getSum() {
		return sum;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
	
	
	@Override
	public void run() {

		for( int i = 1; i <=100 ; i++ ) { sum += i;}
	}
	
	
}
