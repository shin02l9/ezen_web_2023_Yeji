package java2.day26.Ex_01Arraylist;

import java.util.ArrayList;
import java.util.List;

import java2.day26.Board;

public class Ex_01예제 {

	public static void main(String[] args) {
		
		//1. ArrayList 컬렉션객체 생성
		List<Board> list = new ArrayList<>();
			//ArrayList<Board> list2 = new ArrayList<>();
		System.out.println("---------1 : " + list);
		
		//2. ArrayList 객체 안에 객체 추가
		list.add( new Board("제목1","내용1","글쓴이1"));
		list.add( new Board("제목2","내용2","글쓴이2"));
		list.add( new Board("제목3","내용3","글쓴이3"));
		list.add( new Board("제목4","내용4","글쓴이4"));
		list.add( new Board("제목5","내용5","글쓴이5"));
		list.add( 0, new Board("제목6","내용6","글쓴이6")); // 0번 인덱스 자리에 넣고 원래 있는 값들은 뒤로 한칸씩 밀려남
		list.set( 1, new Board("제목7","내용7","글쓴이7")); // 1번 인덱스 자리에 있는 객체를 수정
		
		Board board = new Board("제목8","내용8","글쓴이8"); list.add(board);	// 보드 객체 생성후 리스트 객체에 추가O
		Board board2 = new Board("제목9","내용9","글쓴이9"); 					// 보드 객체 생성후 리스트 객체에 추가X
		
		System.out.println("---------2 : " + list);
		
		//3. ArrayList 객체안에 객체의 총 갯수 | 객체명.size()
		System.out.println("---------3 : " + list.size() +"개");
		
		//4. ArrayList 객체안에 특정 객체 검색 | 객체명.get(인덱스)
		System.out.println("---------4 : " + list.get(2)); 			// 2번 인덱스에 있는값 불러오기
		System.out.println("---------4 : " + list.contains(board)); 
		System.out.println("---------4 : " + list.contains(board2)); 
		System.out.println("---------4 : " + list.isEmpty()); 		// 여기 비어있니? 라고 묻는 함수
		
		//리스트와 반복문의 활용 : 여러개의 데이터를 순차적으로 순회하는 방법 ----------------------------------------------
		System.out.println("=================for문==================\n");
			//1. for문
			for( int i = 0; i<list.size(); i++ ) {
				System.out.println("인덱스 : "+i+" | for문 : "+list.get(i));
			}
				
		System.out.println("=============향상된 for문================\n");
			//2. 향상된 for문 : 인덱스를 사용하지 않는다. 그래서 필요하다면 직접 적어야함
			int index = 0;
			for( Board b : list ) { // 리스트내 객체를 자동으로 처음부터 끝까지 반복변수에 대입
				System.out.println("인덱스 : "+index+" | 향상된 for문 : "+b);
				index++;
			}

		System.out.println("=============forEach() 함수=============\n");
			//3. forEach(반복변수명 -> {실행코드}) 함수 | 화살표함수 : JAVA[매개변수 -> {실행코드}] , JS[매개변수 => {실행코드}] 언어가 다름 !!!!!!!!!
				// 리스트내 객체를 자동으로처음부터 끝까지 매개변수 b에 대입하고 중괄호를 실행하는 것 !!
			list.forEach( b -> {System.out.println(b);});
			
		
		System.out.println("=======================================");
		// ---------------------------------------------------------------------------------------------------
		//5. ArrayList 객체안에 특정 객체 삭제 | 객체명.remove(인덱스)
		list.remove(2);			// 2번 인덱스의 객체 삭제
		list.remove(board);		// board라는 이름의 객체가 존재하면 삭제
		System.out.println("---------5 : " + list);
		
		//6. ArrayList 객체 내 모든 객체 지우기 -> 깡통 만들기
		list.clear();
		System.out.println("---------6 : " + list);

	}
}
