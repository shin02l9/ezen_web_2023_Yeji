package 과제.과제11.model.dto;

public class BoardDto {
	
	//1. 필드 : DB table 필드명과 순서 일치화 + 추가
	private int bno;
	private String btitle;		
	private String bcontent;
	private String bdate;		
	private int bview; 
	private int mno; 
	private String mname;
	
	// 화면에는 회원 번호가 아니라 회원명으로 출력 
	private String mid;
	
	private int msgno;
	private String toM;
	private String msgtitle;
	private String msgcontent; 		
	private String msgdate; 

	
	
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
	
	
	public BoardDto(int mno, String toM, String msgtitle, String msgcontent) {
		super();
		this.mno = mno;
		this.toM = toM;
		this.msgtitle = msgtitle;
		this.msgcontent = msgcontent;
	}

	
	public BoardDto(int msgno, String toM, String msgtitle, String msgcontent, String msgdate, int mno, String mname) {
		super();
		this.msgno = msgno;
		this.toM = toM;
		this.msgtitle = msgtitle;
		this.msgcontent = msgcontent;
		this.msgdate = msgdate;
		this.mno = mno;
		this.mname = mname;
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

	
	public BoardDto(String mname) {
		super();
		this.mname = mname;
	}
	public String getToM() {
		return toM;
	}
	public void setToM(String toM) {
		this.toM = toM;
	}
	public int getMsgno() {
		return msgno;
	}
	public void setMsgno(int msgno) {
		this.msgno = msgno;
	}
	public String getMsgtitle() {
		return msgtitle;
	}
	public void setMsgtitle(String msgtitle) {
		this.msgtitle = msgtitle;
	}
	public String getMsgcontent() {
		return msgcontent;
	}
	public void setMsgcontent(String msgcontent) {
		this.msgcontent = msgcontent;
	}
	public String getMsgdate() {
		return msgdate;
	}
	public void setMsgdate(String msgdate) {
		this.msgdate = msgdate;
	}
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bdate=" + bdate
				+ ", bview=" + bview + ", mno=" + mno + ", mid=" + mid + ", msgno=" + msgno + ", toM=" + toM
				+ ", msgtitle=" + msgtitle + ", msgcontent=" + msgcontent + ", msgdate=" + msgdate + "]";
	}
	

	
	

	
	
	
	
	
	
}
