package java1.day13.Ex02.model.DTO;

public class BoardDTO {
	// 싱글톤(공유) X !
	// 게시물1개당 DTO도 한개여서 ! 
	
	//1. 필드
		//1. 제목(String), 내용(문자열), 조회수(int)
	private String content;
	private String writer;
	private int view;

	//2. 생성자
		//1. (권장) 빈생성자 -> 컨트롤+스페이스바로 자동완성 가능 
		public BoardDTO(){}
		//2. (권장) 풀 생성자
		public BoardDTO(String content, String writer, int view) {
			super();
			this.content = content;
			this.writer = writer;
			this.view = view;
		}
		//3. (선택) 게시물 등록시 사용되는 생성자
		public BoardDTO(String content, String writer) {
			super();
			this.content = content;
			this.writer = writer;
		}
		
		
	//3. 메소드
		//1. (권장) setter/getter
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public int getView() {
			return view;
		}
		public void setView(int view) {
			this.view = view;
		}
		//2. (권장) toString()
		@Override
		public String toString() {
			return "BoardDTO [content=" + content + ", writer=" + writer + ", view=" + view + "]";
		}

		
}


/*
	DTO : 이동객체
		1. 객체에 저장할 필드 선정
			1. public으로 필드 선언 [권장] : 객체내 필드 직접적인 X
			2. 타입
			3. 필드명
		2. 생성자
			1. 빈생성자 -> 컨트롤+스페이스바로 자동완성 가능 
			2. 풀생성자
			3. 그외 사용에 따라 선언 
		3. 메소드
			1. getter and setter	: 필드가 직접적인 [private] 불가능 하기 떄문에 메소드를 이용한 필드 간접 접근
				get필드명() 			: 필드에 값 대입할때 사용되는 메소드
				set필드명()			: 필드에 값 호출할때 사용되는 메소드
			2. toString()
 */







