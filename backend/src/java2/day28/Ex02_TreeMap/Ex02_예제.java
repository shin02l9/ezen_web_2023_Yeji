package java2.day28.Ex02_TreeMap;

import java.util.TreeMap;

public class Ex02_예제 {

	public static void main(String[] args) {
		
		//1. TreeMap 객체 생성
		TreeMap< String, Integer > treeMap = new TreeMap<>();
		
		//2. 무작위 엔트리 <키,값> 저장
		treeMap.put("apple", 10);
		treeMap.put("forever", 60);
		treeMap.put("description", 40);
		treeMap.put("ever", 50);
		treeMap.put("zoo", 80);
		treeMap.put("base", 20);
		treeMap.put("guess", 70);
		treeMap.put("cherry", 30);
		System.out.println(" 이진트리 Map 상태 : " + treeMap);
		// 키(String) 기준으로 자동 오름차순 : 낮은 것 -> 끝 것 ( 1 2 3, a b c, ㄱ ㄴ ㄷ)
		
		//3. 
		System.out.println(" 가장 왼쪽 노드/엔트리 : " + treeMap.firstEntry().getKey());
		System.out.println(" 가장 오른쪽 노드/엔트리 : " + treeMap.lastEntry().getKey());
		System.out.println(" ever 노드 왼쪽에 노드/엔트리 : " + treeMap.lowerEntry("ever").getKey());
		System.out.println(" ever 노드 오른쪽에 노드/엔트리 : " + treeMap.higherEntry("ever").getKey());
		System.out.println(" ever 노드 이거나 왼쪽에 노드/엔트리 : " + treeMap.floorEntry("ever").getKey());
		System.out.println(" ever 노드 이거나 오른쪽에 노드/엔트리 : " + treeMap.ceilingEntry("ever").getKey());
		
		//4. 키(String) 기준으로 내림차순
		System.out.println(" 이진트리 Map 내림차순 : "+treeMap.descendingMap());
		
		//5. 범위 검색
		System.out.println(" 시작 a ~ c 사이의 단어 검색 : "+treeMap.headMap("c", true ));
		System.out.println(" c ~ 끝까지 사이의 단어 검색 : "+treeMap.tailMap("c", true ));
		System.out.println(" c ~ h 사이의 단어 검색 : "+treeMap.subMap("c", true, "h", false));
		
		
		
		
		
		
	}
}
