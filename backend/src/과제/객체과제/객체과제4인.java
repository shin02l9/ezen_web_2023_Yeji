package 과제.객체과제;

import java.util.Arrays;

// 목적 : 실행
public class 객체과제4인 { //class s

	public static void main(String[] args) {
		
		캐릭터생성 ch1 = new 캐릭터생성( "용상짱짱맨", "전사","남");
		캐릭터생성 ch2 = new 캐릭터생성( "최강미녀규리", "마법사","여");
		
		
		System.out.println(ch1);
		System.out.println(ch2);
		
		
		파티 파티 = new 파티();
		파티.파티가입(ch1);
		파티.파티가입(ch2);
		System.out.println(파티.파티1[0].닉네임);
		System.out.println(파티.파티1[1].닉네임);


		
	}
	
} //class e
