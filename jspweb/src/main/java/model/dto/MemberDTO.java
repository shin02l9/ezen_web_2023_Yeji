package model.dto;

public class MemberDTO {
	// 필드
	private int mco;
	private String mid;
	private String mpwd;
	private String memail;
	private String mimg;
	
	// 생성자
	public MemberDTO() {
		super();
	}
	public MemberDTO(int mco, String mid, String mpwd, String memail, String mimg) {
		super();
		this.mco = mco;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}
		// 회원가입용 생성자
	public MemberDTO(String mid, String mpwd, String memail, String mimg) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}
	
	
	// 메소드
	public int getMco() {
		return mco;
	}
	public void setMco(int mco) {
		this.mco = mco;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	@Override
	public String toString() {
		return "MemberDAO [mco=" + mco + ", mid=" + mid + ", mpwd=" + mpwd + ", memail=" + memail + ", mimg=" + mimg
				+ "]";
	}
}
