package java2.day25.Ex_02;

public class Course {

	// 1.  모든 사람이면 등록가능 [ 매개변수 모든 타입 가능 ] Applicant<?> applicant
	public static void registerCourse1(Applicant<?> applicant) {
		//1. 타입 확인
		System.out.println(applicant.kind.getClass().getSimpleName());
		
	}
	
	
	// 2. 학생만 등록가능 [ 매개변수에 Student 클래스와 자손 클래스의 타입 가능 ]
	public static void registerCourse2(Applicant<? extends Student > applicant ) {
		System.out.println(applicant.kind.getClass().getSimpleName());
	}
	
	
	// 3. 직장인 및 일반인 만 등록가능 [ 매개변수에 Worker 클래스와 자손 클래스의 타입 가능 ]
	public static void registerCourse3(Applicant< ? super Worker > applicant ) {
		System.out.println(applicant.kind.getClass().getSimpleName());
	}
}
