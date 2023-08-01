package 복습.day05_필드생성자;

//목적 : 설계도
public class Member {// Member class s
	
	//1. 필드 ( 입력 받을 것들 선언해두기 )
	String id;
	String pw;
	String name;
	String phone;
	int age;
	
	//2. 생성자 ( 일단 빈생성자랑, 풀생성자 둘다 만들고 시작해야함 )
	public Member() {
		super();
	}
	public Member(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	
	
	//3. 메소드
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}



}// Member class e
