/*

	함수 [ 함 : 상자 / 수 : 숫자] **본인이 무엇을 하는지 왜 사용하는지 파악을 하고 사용해야 한다.
		프로그래밍에서의 의미는 특정 동작을 수행하는 일정 코드 부분을 의미한다.
			- 상자안에 들어 있는 수/코드
			- 누군가가 미리 상자에 넣어둔 수/코드
			- 미리 정의 된[만들어진] 수/코드
				- 어떤 요리를 할때도 {레시피}
					- 라면 스프 { 고춧가루, 간장분말 등등의 원재료들이 들어간다. }
						만들어진 라면 스프를 써서 라면을 끓인다.
						이 과정에서 라면 스프를 함수로 볼수 있음 !
		1. function = 함수 / 행동 / 이벤트 내용물(실행물)
		2. 하나의 특별한 목적의 작업을 수행하기 위한 독립적인 **코드들의 집합**이다.
		3. 사용 목적 ( 함수의 장점 )
			1. 재활용성/재사용성이 있음 : 한번 만들면(정의하면) 반복적으로 사용 가능하다. / 중복 묶음처리 
			2. 인수[매개변수]/반환[리턴] : 인수에 따른 서로 다른 반환값을 얻을 수 있다.
				- 인수[매개변수] : 정해져 있지 않은 값. 함수 안으로 들어가는 수/코드/매체 등등
						* 생략가능
				- 반환[리턴] 	: 함수 밖으로 나오는 수. 반환되는 수/코드 등등
						* 생략가능
				함수는 인풋이 있으면 아웃풋이 있다.
					ex)
						더하기함수{x+y}		[1. 함수 정의 ]
						더하기함수( 3 , 5)		[2. 함수에 인수전달]
						함수반환 = 8			[3. 함수 실행 결과 ]
					
						인수/매개변수/INPUT
					----	--------------------
					|							|
					|							|
					|		function			|
					|							|
					--------------------	-----
										반환/리턴/OUTPUT
					->
						자판기
							인수 : 돈 , 음료수번호
							 ㄴ>정의{ 입력받은 돈이하의 음료수 번호에 따른 데이터 검사 }
							반환 : 선택된 음료수 [ *돈 과 선택에 따른 서로다른 음료수 ]
						
			3. 메모리의 효율성을 높힐 수 있다.
				- 함수 {} 안에서 '{' 시작 되고 '}' 끝나면 모든 메모리/코드는 다 사라진다.
				- 지역변수 : 중괄호{} 안에서 선언 된 메모리는 중괄호{} 밖으로 못나온다.
				- 전역변수 : { }없는 곳에서 선언된 메모리는 {} 안으로 모든곳으로 자유롭게 호출가능
					* 메모리 : 변수/상수/배열/객제 등등
					* 메모리가 증가하면 속도는 감소하고 개발비가 증가한다. 돈을 많이 번다는 뜻인듯..?
		
 */