package java1.day14.Ex01_상속;

public class Ex01_실행 {
	
	 public static void main(String[] args) {
		
		 //1. Phone 부모객체
		 Phone phone = new Phone();
		 System.out.println(phone.color);
		 System.out.println(phone.model);
		 //System.out.println(phone.wifi); 사용 불가
		 
		 phone.bell();
		 phone.sendVoice("여보세요");
		 phone.receiveVoice("안녕하세요! 저는 신예지입니다.");
		 phone.hangUp();
		 // phone.setWifi( true );
		 // 오류 발생 : 해당 객체는 부모 객체이고 해당 메소드는 자식클래스의 멤버이므로 사용 불가능
		 // phone.internet( );
		 
		 //2. SmartPhone 자식객체
		 SmartPhone myPhone = new SmartPhone("갤럭시","은색");
		 System.out.println( myPhone.color );
		 System.out.println( myPhone.model );
		 System.out.println( myPhone.wifi );
		 
		 myPhone.bell();
		 myPhone.sendVoice("여보세요");
		 myPhone.receiveVoice("안녕하세요! 저는 신예지입니다.");
		 myPhone.hangUp();
		 // 오류 발생 없는 이유 : 해당 객체는 자식객체이므로 부모 객체의 멤버 사용 가능
		 myPhone.setWifi( true );
		 myPhone.internet( );

	}

}
