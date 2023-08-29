package java2.day28.Ex03_사용자정의정렬;

public class Person implements Comparable<Person>{

	// 필드
	public String name;
	public int age;
	
	// 생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int compareTo(Person o) {
		if( age < o.age ) {return -1;}
		else if ( age == o.age ) {return 0;}
		else {return 1;}
	}
	
}
