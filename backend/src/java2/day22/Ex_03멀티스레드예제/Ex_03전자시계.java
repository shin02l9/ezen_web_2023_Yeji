package java2.day22.Ex_03멀티스레드예제;

import java.time.LocalTime;
import java.util.Scanner;

public class Ex_03전자시계 {
	public static void main(String[] args) {
		
		// [현재시간 스레드] 구역
		// 자동으로 현재시간 실행
		현재시간 현재시간 = new 현재시간();
		Thread thread = new Thread( 현재시간 );
		thread.start();
		
		
		// [main 스레드] 구역
		// 타이머 실행여부 선택받아서 실행 
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1.타이머시작 | 2.타이머종료 \n 선택>>");
			int ch = scanner.nextInt();
			if( ch == 1 ) { 
				// [타이머기능 스레드] main 스레드에서 1번 입력하면 타이머스레드 실행
				System.out.println("타이머시작");
				타이머기능 타이머기능 = new 타이머기능();
				Thread thread2 = new Thread(타이머기능);
				thread2.start();
			}
			else if( ch == 2 ) { System.out.println("타이머종료");}
		}
	}
}
