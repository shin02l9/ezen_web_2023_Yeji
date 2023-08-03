package 과제.객체과제;

// 목적 : 캐릭터간 상호작용 설계도 (파티)
public class 파티 {

	//1. 필드 
	캐릭터생성 파티1[] = new 캐릭터생성[4];
	//2. 생성자
	파티() {}
	
	void 파티가입 (캐릭터생성 a){
		int count = 0;
		for(int i = 0; i<파티1.length; i++) {
			if(파티1[i]==null) {
				파티1[i] = a;  count++;
				System.out.println("파티가입이되었습니다");
				if(i==파티1.length){System.out.println("파티원모집이 완료되었습니다");}
				break;
			}  
		}if(count==0){System.out.println("파티원모집이 완료되었습니다");}
	}
	//3. 메소드

}
