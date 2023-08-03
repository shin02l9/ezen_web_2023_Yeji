package 복습.day07_MVC.model.dto;

//데이터의 모델 ( 저장할 필드나 생성자 작성하는 곳 )
//- 필드는  아이디 , 비밀번호 , 이름 , 전화번호 , 나이  저장하는 5개 를 선언합니다.
//- 생성자는 1.기본생성자 2.모든매개변수를 받은 생성자를 2개 선언 합니다. 
//- getter 와 setter , toString() 선언합니다.
public class MemberDto {

	//1. 필드 (입력 받을 값 필드 생성해두기)
	private String id;
	private String pw;
	private String name;
	private String phone;
	private int age;
	
	//2. 생성자 (빈 생성자와 풀 생성자 선언하고 시작하기)
	public MemberDto() {
		super();
	}
	
	public MemberDto(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	
	
	//3. 메소드 (getter | setter | toString 모두 선언하고 시작하기)
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberDao [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}
	
}
