package 과제.객체과제4인;

import java.util.Arrays;

// 목적 : 설계도 
public class 캐릭터생성 { //class s

	//1. 필드
//	String 유저리스트[];
	String 닉네임;
	String 직업;
	String 성별;
	boolean 생존여부 = true;
	int 레벨 = 1;
	int 경험치;
	int 힘;
	int 지력;
	int hp;
	int mp;
	int max레벨 = 100;
	
	
	//2. 생성자
	캐릭터생성( String 닉네임, String 직업, String 성별){
		this.닉네임 = 닉네임;
		this.직업 = 직업;
		this.성별 = 성별;
		if( 직업.equals("마법사") ) {
			힘 = 5;
			지력 = 50;
			hp = 50; mp = 150;
		} else if ( 직업.equals("전사") ) {
			힘 = 50;
			지력 = 5;
			hp = 150; mp = 50;
		}
	}	
	
	
	//3. 메소드
	void 사냥 ( String 몬스터 ) { 
		if(몬스터.equals("다람쥐")) {
			경험치 += 50;
			} else if(몬스터.equals("최종보스기면수")) {
				경험치 += 2000000;
				}
		}

	@Override
	public String toString() {
		return"닉네임 : "+닉네임+"\n직업 : "+직업+"\n성별 : "+성별+"\n생존여부 : "+생존여부
				+"\n레벨 : "+레벨+"\n경험치 : "+경험치+"\n힘 : "+힘+"\n지력 : "+지력
				+"\nhp : "+hp+"\nmp : "+mp+"\nmax레벨 : "+max레벨;
	}
	
}//class e
