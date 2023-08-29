package java2.day28.Ex05_스택;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex05_스택예제 {

	
	public static void main(String[] args) {
		
		//1. stack 객체 (동전케이스) 선언
		Stack<Coin> coinBox = new Stack<>();
		
		//2. 무작위로 동전 넣기
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		System.out.println(" 스택 상태 : "+coinBox);
		
		//3. 후입선출(LIFO)이므로 나중에 들어온값이 먼저 삭제된다.
		coinBox.pop(); System.out.println(" 스택 상태 : "+coinBox);
		
		// ------------------------------------------------
		
		//1. Queue 구현체[LinkedList와 함께 사용] (동전케이스) 선언
		Queue<Coin> coinBox2 = new LinkedList<>();
		
		//2. 무작위로 동전 넣기
		coinBox2.offer(new Coin(100));
		coinBox2.offer(new Coin(50));
		coinBox2.offer(new Coin(500));
		coinBox2.offer(new Coin(10));
		System.out.println(" 큐 상태 : "+coinBox2);
		
		//3. Queue 객체에서 동전 객체 꺼내기 
		// 선입선출(FIFO)이라서 먼저 저장된 값 부터 삭제된다.
		coinBox2.poll();
		System.out.println(" 큐 상태 : "+coinBox2);
		

	}
}
