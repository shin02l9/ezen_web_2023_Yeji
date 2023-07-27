package java1.day11.Ex04_디자인패턴01;

public class 고객 {

}

/*
	소프트웨어 디자인 패턴 
		: 역할에 따른 분업을 하기 위한 구분 ! 
			유지보수, 책임전가 등 현업에서 편리하다.
			
		1. MVC 
			M : model 		[ 백 JAVA, FILE, DB ]
			   중간에 C : controller  [ 백 JAVA ]
			V : view  		[ 프론트 HTML, JS, CSS]
			
			[ model ] 
			* DAO : Data Transfer Object 데이터 이동 객체
			* DTO : Data Access Object 데이터에 접근하는 객체 
			
		---	@ 1패턴 ---------------------------
			
		 고객 [ view ] 
		 - 요구/ 응답받는 입장
		 - 입/출력 되는 구역
		 - 프론트 HTML, JS, CSS
		 - 프린트랑 스캐너만 사용
		 
		 		|		▲
		 		▼		|
		 		
		 서빙/요리사 [ controller ]
		 - 요구에 따라 응해주는 입장
		 - 가공, 유효성검사, 전달, 로직 구역
		 - 백 JAVA
		 - 로직짜는건 모두 여기서만
		  
		   *DTO | 		▲
		 		▼		| 		*고객이 직접 냉장고로 올수없음! 정해진 방향으로만 ! 
		 				 
		 냉장고 *DAO
		 - 원본의 순수 데이터가 저장되는 곳 or 접근하는 곳
		 - 실질적인 저장 !
		 - 백 JAVA, DB
		 - 데이터 저장만 
		 
		 

*/