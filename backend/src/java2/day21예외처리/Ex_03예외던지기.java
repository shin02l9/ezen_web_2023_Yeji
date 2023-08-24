package java2.day21예외처리;

public class Ex_03예외던지기 {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		try {
		//p.478 : 예외던지기 : 메소드안에서 예외가 발생 하면 해당 메소드를 호출했던곳으로 예외가 이동
		findClass(); // 해당클래스가 예외던지기 하기전에는 예외 안뜬다 하지만 던지면 뜸....그래서 또 던져서 메인까지 가면 나중에 어떤 예외가 난건지 찾기 힘들다.
		//그래서 main 에서는 try{} catch(){}를 사용하는 것이 이상적 ! 
		} catch (Exception e) {System.out.println(e);}
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
		// 예외처리방법 2가지 
			// 1. try{} catch(){}	: 해당 메소드에 직접 처리하는 방법
			// 2. throws			: 해당 메소드에 직접 처리 하지 않고 해당 메소드를 호출했던 곳으로 예외 이동
				// 웹에서는 자동 예외처리가 가능하다. [ 서블릿이라는 클래스가 해줌 ! ]
	}
	
}
