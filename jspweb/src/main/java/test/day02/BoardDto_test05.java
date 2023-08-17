package test.day02;

public class BoardDto_test05 {
	
	//필드
	private String title;
	private String content;
	
	
	// 생성자
	public BoardDto_test05() {
		super();
	}
	public BoardDto_test05(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BoardDto_test05 [title=" + title + ", content=" + content + "]";
	}
	
	
	
}
