package java2.day22.Ex_03멀티스레드예제;

import java.time.LocalTime;

public class 현재시간 implements Runnable {

	@Override
	public void run() {
		while(true) {
			// LocalTime.now() : 현재시간 함수 
			System.out.println( LocalTime.now());
			try {
				Thread.sleep(1000); // 1초 일시정지
			} catch( Exception e ) { System.out.println(e); }
		}	
	}
}
