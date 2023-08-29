package java2.day28.Ex04_예제;

import java.util.TreeSet;

public class Ex04_예제 {


	public static void main(String[] args) {
		
		
		//1. Fruit 정렬 객체 생성
		FruitComparator fruitComparator = new FruitComparator();
		//2. TreeSet 객체 생성
		TreeSet<Fruit> treeSet = new TreeSet<>(fruitComparator);
		
		//3. 무작위 Fruit 객체 대입
		treeSet.add( new Fruit("포도",3000) );
		treeSet.add( new Fruit("딸기",2000) );
		treeSet.add( new Fruit("수박",5000) );
		System.out.println(" 이진트리 상태 : "+treeSet);
	}
}
