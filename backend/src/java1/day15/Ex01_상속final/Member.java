package java1.day15.Ex01_상속final;

public class Member {
	//	final은 상속을 막는다.
	/*
		final 키워드 : 최종적이라는 뜻으로 수정 불가능한 상태를 사용하는 키워드
			- 필드
				final int 나이 = 30;  : 초기화한 이후에 변경 불가능
			- 클래스
				final class Member{} : 해당 클래스는 상속불가능
			- 메소드
				final void stop(){}  : 해당 메소드는 자식클래스가 오버라이딩 불가능
		
		
		접근제한자
			public				vs			private
			- 모든 클래스범위					- 현 클래스범위
			- 프로젝트내 모든곳 호출				- 현재 클래스에서만 호출
			
			(default)			vs			protected
			- 현재클래스 패키지 내				- 현재클래스 패키지 내
			- 무조건 동일 패키지 내/하위패키지		- 동일 패키지내/하위패키지
											- 단*) 자식클래스가 다른패키지에 있는 부모클래스 호출가능
	 */
	final int 나이 = 30;
	public final void stop1(){}
	public void stop2(){}
}
