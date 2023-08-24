package model.dto;

public class VisitlogDTO {
	// 필드
	private int vno;			// 식별번호
	private String vwriter;		// 작성자
	private String vpwd;		// 비밀번호
	private String vcontent;	// 내용
	private String vdatetime;	// 날짜
	
	
	// 생성자
	public VisitlogDTO() {
		super();
	}
	public VisitlogDTO(int vno, String vwriter, String vpwd, String vcontent, String vdatetime) {
		super();
		this.vno = vno;
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
		this.vdatetime = vdatetime;
	}
	// 저장할때 사용하는 매개변수 3개 생성
	public VisitlogDTO(String vwriter, String vpwd, String vcontent) {
		super();
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
	}

	
	public VisitlogDTO(int vno, String vpwd, String vcontent) {
		super();
		this.vno = vno;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
	}
	
	
	
	// 메소드
	public int getVno() {
		return vno;
	}
	public void setVno(int vno) {
		this.vno = vno;
	}
	public String getVwriter() {
		return vwriter;
	}
	public void setVwriter(String vwriter) {
		this.vwriter = vwriter;
	}
	public String getVpwd() {
		return vpwd;
	}
	public void setVpwd(String vpwd) {
		this.vpwd = vpwd;
	}
	public String getVcontent() {
		return vcontent;
	}
	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}
	public String getVdatetime() {
		return vdatetime;
	}
	public void setVdatetime(String vdatetime) {
		this.vdatetime = vdatetime;
	}
	@Override
	public String toString() {
		return "DTO [vno=" + vno + ", vwriter=" + vwriter + ", vpwd=" + vpwd + ", vcontent=" + vcontent + ", vdatetime="
				+ vdatetime + "]";
	}
	
	

}
