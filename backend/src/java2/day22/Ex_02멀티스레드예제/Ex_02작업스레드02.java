package java2.day22.Ex_02멀티스레드예제;

public class Ex_02작업스레드02 extends Thread{
	@Override
	public void run() {

		try {
			int count = 1;
			while(true) {
				System.out.println(Thread.currentThread().getName()+" [ 작업 02 Thread ] output : "+count);
				Thread.sleep(10000); // 10초간 정지 **예외처리 필수 ! 
				count++;
			}
		}
		catch( Exception e ) {System.out.println(e);};
		
	}
}
