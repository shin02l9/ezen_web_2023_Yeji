package model.dto;

public class MsgDTO {

	private String mid; // 보낸사람
	private String msg; // 보낸내용
	private String datetinme; // 보낸시간
	
	
	public MsgDTO() {
		super();
	}
	public MsgDTO(String mid, String msg) {
		super();
		this.mid = mid;
		this.msg = msg;
	}

	public MsgDTO(String mid, String msg, String datetinme) {
		super();
		this.mid = mid;
		this.msg = msg;
		this.datetinme = datetinme;
	}
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDatetinme() {
		return datetinme;
	}
	public void setDatetinme(String datetinme) {
		this.datetinme = datetinme;
	}

	
	
	
}
