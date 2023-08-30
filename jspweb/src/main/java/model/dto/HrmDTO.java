package model.dto;

public class HrmDTO {

	// 필드
	private int hno;
	private String himg;
	private String hname;
	private String hphone;
	private String hposition;
	private String hdate;
	
	// 생성자
	public HrmDTO() {
		super();
	}
	public HrmDTO(int hno, String himg, String hname, String hphone, String hposition, String hdate) {
		super();
		this.hno = hno;
		this.himg = himg;
		this.hname = hname;
		this.hphone = hphone;
		this.hposition = hposition;
		this.hdate = hdate;
	}
		// 직원등록시 사용될 생성자
	public HrmDTO(String himg, String hname, String hphone, String hposition) {
		super();
		this.himg = himg;
		this.hname = hname;
		this.hphone = hphone;
		this.hposition = hposition;
	}
	
	
	//메소드
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
	}
	public String getHimg() {
		return himg;
	}
	public void setHimg(String himg) {
		this.himg = himg;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	public String getHposition() {
		return hposition;
	}
	public void setHposition(String hposition) {
		this.hposition = hposition;
	}
	public String getHdate() {
		return hdate;
	}
	public void setHdate(String hdate) {
		this.hdate = hdate;
	}
	@Override
	public String toString() {
		return "HrmDTO [hno=" + hno + ", himg=" + himg + ", hname=" + hname + ", hphone=" + hphone + ", hposition="
				+ hposition + ", hdate=" + hdate + "]";
	}
	
}
