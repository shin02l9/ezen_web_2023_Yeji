package 과제;

public class AccountbookDTO {
	// 필드
	private int no; 
    private String content;
    private String price ;
    private String date ;
    
    //생성자
	public AccountbookDTO() {
		super();
	}
	public AccountbookDTO(int no, String content, String price, String date) {
		super();
		this.no = no;
		this.content = content;
		this.price = price;
		this.date = date;	
	}
	
		// 등록할때 사용할 생성자
	public AccountbookDTO(String content, String price, String date) {
		super();
		this.content = content;
		this.price = price;
		this.date = date;
	}
	
	
	public AccountbookDTO(int bno, String content2, String price2) {
		// TODO Auto-generated constructor stub
	}
	//메소드
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "AccountbookDTO [no=" + no + ", content=" + content + ", price=" + price + ", date=" + date + "]";
	}
    
    


    




}
