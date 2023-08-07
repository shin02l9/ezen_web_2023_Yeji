package java1.day18.Ex02;

public class 커비칩 implements 게임패드{
	@Override
	public void A버튼() {
		System.out.println(" 일반공격 ");
	}
	@Override
	public void B버튼() {
		System.out.println(" 방어 ");
	}
	@Override
	public void X버튼() {
		System.out.println(" 무기교체 ");
	}
	@Override
	public void Y버튼() {
		System.out.println(" 궁극기사용 ");
	}
}
