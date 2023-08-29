package java2.day28.Ex01_TreeSet;

import java.util.TreeSet;

/*
	검색기능을 강화시킨 컬렉션
		- 컬렉션 안에 있는 데이터를 검색할때 효율성 제공 [필수x]
		- 1 2 3 4 5 6 7 8 9 -> 7을 찾고 싶어 ( 더 빠르게 찾음 )
		- 9 5 3 6 4 2 1 8 7	-> 7을 찾고 싶어
		
	이진트리
		- 각 노드는 최대 2개의 노드를 연결
		- 부모 노드보다 작으면 왼쪽 노드 / 크면 오른쪽 노드
		
		- 6 8 10 이진트리 표현
				부모노드가 (8)이면
				/			\
		자식노드(6)		  	자식노드(10) 이렇게 배치
			
 */




public class Ex01_예제 {

	public static void main(String[] args) {
		
		//1. TreeSet 객체 생성
		TreeSet<Integer> scores = new TreeSet<>();
		
		//2. 무작위로 숫자 저장
		scores.add( 87 );
		scores.add( 98 );
		scores.add( 75 );
		scores.add( 95 );
		scores.add( 80 );
		scores.add( 69 );
		scores.add( 81 ); // 일반적으로는 저장 순서대로 출력인데
		System.out.println("이진트리 상태 : " + scores); // 이진트리는 정렬이 자동으로 된다. [오름차순]
		
		
		//3. 
		System.out.println("가장 왼쪽 노드 : "+scores.first());
		System.out.println("가장 오른쪽 노드 : "+scores.last());
		System.out.println("95점 아래 노드 : "+scores.lower(95));
		System.out.println("95점 위 노드 : "+scores.higher(95));
		System.out.println("95점 이거나 아래 노드 : "+scores.floor(95));
		System.out.println("95점 이거나 위 노드 : "+scores.ceiling(95));
		
		
		//4. 내림차순
		System.out.println(" 이진트리 뒤집기 ( 내림차순 ) : "+scores.descendingSet());
		
		//5. 범위검색
			//scores.tailSet(숫자, 옵션[true,false])
		System.out.println(" 이진트리 80이상 : "+scores.tailSet(80,true));
			//scores.subSet(숫자, 옵션[true,false], 숫자, 옵션[true,false])
		System.out.println(" 이진트리 80이상 90미만: "+scores.subSet(80,true,90,false));
		
	}
	
	
}
