package java2.day22.Ex_01;

import java.awt.Toolkit;

public class 비프음 implements Runnable {// implements 인터페이스!

	@Override
	public void run() { // 추상메소드 구현
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for( int i = 0; i<5; i++) {
			toolkit.beep();
			try { Thread.sleep(500);}
			catch(Exception e) {System.out.println(e);}
		}
	}
}
