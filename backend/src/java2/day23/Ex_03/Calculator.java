package java2.day23.Ex_03;

public class Calculator { // 계산기 
	//필드
	private int memory;
	//생성자
	//메소드
	public int getMomory() {
		return memory;
	}
	// 1. "메소드" 자체를 동기화 하는 방법 : 메소드 선언부에 synchronized 키워드 사용
	//public void setMomory1(int memory) {
	public synchronized void setMomory1(int memory) { 
		// synchronized 동기화메소드 : 해당메소드를 여럿 스레드가 호출시에 대기상태
		// 1. 매개변수로 들어온 값을 필드에 저장
		this.memory = memory;
		// 2. 현재 스레드를 2초간 일시정지
		try { Thread.sleep(2000); } catch (Exception e) {} 
		// 3. 2초 후 메모리 필드 확인
		System.out.println(Thread.currentThread().getName() 
				+ " 요청한 2초 후 저장된 메모리 : "+this.memory);
	}
	// 2. 메소드내 특정 "블록"에서만 동기화 하는 방법 : synchronized(this){}
	public void setMomory2(int memory) {
		System.out.println(Thread.currentThread().getName()+"비동기화 구역");
		synchronized(this) {
			System.out.println(Thread.currentThread().getName()+"동기화 구역");
			this.memory = memory;
			try { Thread.sleep(2000); } catch (Exception e) {} 
			System.out.println(Thread.currentThread().getName() 
					+ " 요청한 2초 후 저장된 메모리 : "+this.memory);
		}
	}
	

}
