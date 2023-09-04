package model.dto;

public class BoardDTO {
	// 필드 
	private int bno;
    private String btitle;
    private String bcontent;
    private String bfile;
    private String bdate;
    private int bview;
    private int mno	;
    private int bcno;
    // - 게시물에 추가적으로 표시할 필드들 
    private String mid; // 작성자 회원아이디 [ 사용자는 게시물 조회시 작성자회원번호 보단 작성자아이디 원하는 경우 다수 ]
    private String bcname; // 카테고리명 [ 사용자는 게시물 조회시 카테고리번호 보단 카테고리이름 원하는 경우 다수 ]
    private String mimg; // 작성자의 프로필
    
    // 본인 글 여부 체크할 변수 ( 조회대상자와 작성대상자가 일치하는지 여부 ! )
    private boolean ishost;
    
    
    
    
    // 생성자
	public BoardDTO(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int mno, int bcno,
			String mid, String bcname) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
		this.bcno = bcno;
		this.mid = mid;
		this.bcname = bcname;
	}
	public BoardDTO() {
		super();
	}
	public BoardDTO(String btitle, String bcontent, String bfile, int mno, int bcno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.bcno = bcno;
	}
	
	// 글생성시에 사용하는 생성자
	public BoardDTO(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int mno, int bcno,
			String mid, String mimg, String bcname) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
		this.bcno = bcno;
		this.mid = mid;
		this.mimg = mimg;
		this.bcname = bcname;
	}
	
	
	//메소드
	public int getBno() {
		return bno;
	}
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
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
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
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
	public int getBcno() {
		return bcno;
	}
	public void setBcno(int bcno) {
		this.bcno = bcno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getBcname() {
		return bcname;
	}
	public void setBcname(String bcname) {
		this.bcname = bcname;
	}
	
	public boolean isHost() {
		return ishost;
	}
	public void setHost(boolean ishost) {
		this.ishost = ishost;
	}
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bdate=" + bdate + ", bview=" + bview + ", mno=" + mno + ", bcno=" + bcno + ", mid=" + mid
				+ ", bcname=" + bcname + ", mimg=" + mimg + "]";
	}

	
	
	
   
	
	
}
