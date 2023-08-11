package 과제.과제11.model.dto;

public class BoardDto {
	
	//1. 필드 : DB table 필드명과 순서 일치화 + 추가
	private int bno;
	private String btitle;		
	private String bcontent;
	private String bdate;		
	private int bview; 
	private int mno; 
	
	// 화면에는 회원 번호가 아니라 회원명으로 출력 
	private String mid;
	
	
	
	
	//2. 생성자 : 빈생성자와 풀생성자 모두 꺼내기
	public BoardDto(int bno, String btitle, String bcontent, String bdate, int bview, int mno, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
		this.mid = mid;
	}
	public BoardDto() {
		super();
	}
	
	public BoardDto(String btitle, String bcontent, int mno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
	}

	public BoardDto(int bno, String btitle, String bcontent) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
	}
	public BoardDto(String string, String string2, String string3, String string4, int int1, int int2, Object mid2) {
		// TODO Auto-generated constructor stub
	}
	//3. 메소드 : getter, setter, toString
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBview() {
		return bview;
	}
	public void setBview(int bview) {
		this.bview = bview;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bdate=" + bdate
				+ ", bview=" + bview + ", mno=" + mno + ", mid=" + mid + "]";
	}
	

	
	
	
	
	
	
}
