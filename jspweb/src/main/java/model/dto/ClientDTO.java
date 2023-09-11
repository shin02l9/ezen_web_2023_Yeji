package model.dto;

import javax.websocket.Session;

public class ClientDTO {
	
	private Session session;
	private String mid;
	
	public ClientDTO() {}

	public ClientDTO(Session session, String mid) {
		super();
		this.session = session;
		this.mid = mid;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	
	

}
