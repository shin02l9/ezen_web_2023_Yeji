package java2.day24.Ex_03;


public interface Rentable<P> {
	// 추상메소드 : 선언하고 정의 하지않는 메소드
	// [public abstract] P rent();
	P rent();
}