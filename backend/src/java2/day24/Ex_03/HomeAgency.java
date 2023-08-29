package java2.day24.Ex_03;

//HomeAgency : 홈 렌탈 해주는 대리점 
public class HomeAgency implements Rentable<Home> {
	@Override
	public Home rent() { return new Home(); }
}