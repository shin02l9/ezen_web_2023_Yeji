package model.dto;

public class LibraryDTO {
	
	
    private int sno;
    private String sname;
    private String sphone;
    private  int sstatus;
	
    
    public LibraryDTO(int sno, String sname, String sphone, int sstatus) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
		this.sstatus = sstatus;
	}
	

    public LibraryDTO(int sno, String sname, String sphone) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
	}


	public LibraryDTO() {
		super();
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public int getSstatus() {
		return sstatus;
	}

	public void setSstatus(int sstatus) {
		this.sstatus = sstatus;
	}

	@Override
	public String toString() {
		return "LibraryDTO [sno=" + sno + ", sname=" + sname + ", sphone=" + sphone + ", sstatus=" + sstatus + "]";
	}

	
    

}
