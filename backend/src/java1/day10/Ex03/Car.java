package java1.day10.Ex03;

public class Car { // class s
	
	//1. 필드
	int gas; // 현재 객체의 gas 데이터 저장하는 곳
	//2. 생성자
	//3. 메소드 // 관례적으로 메소드명은 
					//1. 필드에 저장하는 용도의 함수는 'set필드명' 이렇게 작성한다.
					//2. 필드에 값을 호출하는 용도의 함수는 'get필드명' 이렇게 작성한다.
					//  setter/getter 자동완성 기능 제공됨
					//3. 필드에 값의 존재여부(boolean)를 확인하는 함수 'is필드명' 이렇게 작성한다.
		//1. 리턴x 매개 1개 : 매개변수로 부터 전달 받은 gas값을 필드gas에 저장하는 함수
	void setGas(int gas) {
		if ( gas >= 0 ) {// 유효성 검사 ! 값을 바로바로 필드에 저장하는게 아니라 이렇게 인수를 거치는(간접 접근) 이유가 유효성 검사를 하기 위해서이다. 
		this.gas = gas;
		} // this : 현재 객체란 뜻 !  [매개변수랑 필드가 이름이 동일 할때 식별용]
	}
		//2. 리턴o 매개x
	boolean isLeftGas() {
		if( this.gas == 0) {
			System.out.println("gas 가 없습니다.");
			return false;
		}
		System.out.println("gas 가 있습니다.");
		return true;
	}
	
		//3. 리턴x 매개x : 필드에 gas가 0이 될때까지 gas 1씩 차감하는 무한루프 함수, 0이되면 종료
	void run () {
		while(true) {
			if( this.gas > 0) {
				System.out.println("달립니다. 가스잔량 :" +this.gas);
				this.gas--;
			}else {
				System.out.println("멈춥니다. 가스잔량 :" +this.gas);
				return;
			}
		}
	}	
	
} // class e
