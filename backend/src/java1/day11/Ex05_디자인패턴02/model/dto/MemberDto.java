package java1.day11.Ex05_디자인패턴02.model.dto;

// 데이터의 모델, 형식, 틀, 폼 ! 
public class MemberDto { // MemberDto s
	
	//1. 필드 : 모든 필드는 private
		private String id;
		private String pw;
		private String name;
		private String phone;
		private int age;
	//2. 생성자 (셋팅을 일단 하고 시작)
		// 빈 생성자
		public MemberDto() {}
		// 풀 생성자
		public MemberDto(String id, String pw, String name, String phone, int age) {
			super();
			this.id = id;
			this.pw = pw;
			this.name = name;
			this.phone = phone;
			this.age = age;
		}
		
	//3. 메소드
		// 1. getter / setter : 외부객체에서 private 필드에 간접 접근할때 사용되는 메소드
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
		// 2. toString : 객체의 주소가 아닌 값의 상태를 확인
		@Override
		public String toString() {
			return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
		}
		
	
}// MemberDto e
