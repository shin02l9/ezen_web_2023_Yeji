package java2.day23.Ex_03;

public class User1Thread extends Thread {
	
	private Calculator calculator;
	
	public User1Thread() { setName("User1");}
	
	public void setCalculator ( Calculator calculator ) {
		this.calculator = calculator;
	} // setter 메소드
	
	@Override
	public void run() {
		calculator.setMomory1(100);
	}
	
}
