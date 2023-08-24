package java2.day21예외처리;

public class Ex_02예외다중 {

	
	
	public static void main(String[] args) {
		//p.470 : 다중 catch
		String[] array = { "100","1oo"};
		
			System.out.println("7");  // 문자 7은 숫자 7로 형변환이 된다.
			System.out.println("ㄱ"); // 문자 ㄱ은 숫자로 형변환이 되지 않는다. NumberFormatException 예외뜸 !
			
			
		for ( int i = 0 ; i<=array.length; i++ ) {
			try {
				//ArrayIndexOutOfBoundsException 예외 뜸 [인덱스길이가부족!]
				int value = Integer.parseInt(array[i]);
			} 
				// 다중 예외처리시 예외 클래스 catch 작성 순서: 하위 예외 클래스 블록 먼저 작성!!!!
				// 이유 : 예외 상위 클래스가 앞에있으면 아래있는 하위 클래스들은 실행되지 않기 때문에!
			  catch (NumberFormatException e) {System.out.println(" 숫자로 변환 할수 없는 데이터 : "+e);}
			  catch (ArrayIndexOutOfBoundsException e) {System.out.println(" 배열 인덱스 초과 : "+e);}
			  catch (Exception e ) {System.out.println(e);}
		}
	}

}
