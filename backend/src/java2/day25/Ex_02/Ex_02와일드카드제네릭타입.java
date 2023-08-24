package java2.day25.Ex_02;

public class Ex_02와일드카드제네릭타입 {

	public static void main(String[] args) {
		

		// 1. 사람 객체
		Person person = new Person();
		// 2. 지원자 객체 [ 지원자 객체를 사람 객체에 대입 ]
		Applicant<Person> applicant = new Applicant<>(person);
		
		
		// 3. 모든 객체가 지원 가능한 코스 등록 함수
		Course.registerCourse1(applicant);
		
		// --- 코스 1 : 모든 지원서 가능
		Course.registerCourse1(new Applicant<Person>( new Person() ));
		Course.registerCourse1(new Applicant<Worker>( new Worker() ));
		Course.registerCourse1(new Applicant<Student>( new Student() ));
		Course.registerCourse1(new Applicant<HighStudent>( new HighStudent() ));
		Course.registerCourse1(new Applicant<MiddleStudent>( new MiddleStudent() ));

		// --- 코스 2 : 학생만 지원 가능
		//Course.registerCourse2(new Applicant<Person>( new Person() )); 오류뜸
		//Course.registerCourse2(new Applicant<Worker>( new Worker() )); 오류뜸
		Course.registerCourse2(new Applicant<Student>( new Student() ));
		Course.registerCourse2(new Applicant<HighStudent>( new HighStudent() ));
		Course.registerCourse2(new Applicant<MiddleStudent>( new MiddleStudent() ));
		
		
		// --- 코스 3 : 직장인과 일반인만 지원 가능
		Course.registerCourse3(new Applicant<Person>( new Person() ));
		Course.registerCourse3(new Applicant<Worker>( new Worker() ));
		//Course.registerCourse3(new Applicant<Student>( new Student() )); 오류뜸
		//Course.registerCourse3(new Applicant<HighStudent>( new HighStudent() )); 오류뜸
		//Course.registerCourse3(new Applicant<MiddleStudent>( new MiddleStudent() )); 오류뜸
	}
		
}
