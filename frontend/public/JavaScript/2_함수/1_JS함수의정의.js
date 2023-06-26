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
					
			4. 함수 선언
				function 함수명 (인수1, 인수2, 인수3){
				
					***코드 정의 ***
					return 반환값;
				}
					
					1. function : 함수 선언 키워드 작성하기
					2. 함수명 		: 서로 다른 함수간의 식별용 이름 [* 같은 JS 내 동일한 이름 불가/ 미리 만들어진 키워드(let, for 등등) 불가]
					3. ( ) 			: 인수 [함수 안으로 들어가는 데이터, 값, 코드, 변수, 배열 등등] ,로 구분한다.
					4. { } 			: '{' 함수의 시작 / '}' 함수의 끝
					5. return 		: 함수 종료/ 리턴 [* 해당 함수를 호출했던 곳으로 반환/리턴]
										return 3; 	함수를 호출 했던 곳으로 '3' 을 반환
										return;		반환값이 없으므로 반환값 없이 단순 함수 종료!
							ex) 
							
								1. 유재석이 휴대폰이 고장나서 서비스 센터에 간다.
								
											고장한 휴대폰을 준다. (인수/매개변수)	
									유재석 --------------------------------->  삼성 서비스 센터 (함수)
										 <---------------------------------- 함수를 실행하고 리턴을 한다.
											수리된 휴대폰을 돌려준다. (반환/리턴)
									
								2. 유재석이 망가진 휴대폰을 폐휴대폰 수거함에 넣었다.		
											
											고장한 휴대폰 (인수/매개변수)	
									유재석 --------------------------------->  폐휴대폰 수거함 (함수)
										 <---------------------------------- 
											 (반환/리턴이 없다.)
			5. 함수 호출/사용
				1. 함수명(인수, 인수, 인수); 인수 있으면 넣고 없으면 말고.
				
			
		
 */

 
 //1. 함수의 정의
 function 함수1(){} 					 //1. 인수 없다. / 반환 없다.
 function 함수2(x){} 				 //2. 인수(x = 임의의 변수명) / 반환 없다.
 function 함수3(x, y, z){}			 //3. 인수가 다수 일때 (, 로 구분한다.) / 반환 없다.
 function 함수4(x, y, z){ return 3; } //4. 인수 있다. 반환값 있다.
 function 함수5(){ return 3; } 		 //5. 인수 없다. / 반환값 있다. 
 function 함수6(){ return; } 		 //6. 인수 없다. / 반환값 없다. = 단순 함수 종료
 	// * 함수가 종료되는 조건 1. 중괄호가 끝났을때 2. return 키워드를 만났을때 (아래에 코드가 있어도 강제 종료이다.)

//2. 함수의 호출
 console.log ('안녕 !!')  			//1. 미리 정의된 (JS 만든사람) log(매개변수 = 출력하고 싶은 문자열)함수
 배열명.splice( 0, 1)    				//2. 미리 정의된 (JS 만든사람) splice(인수1, 인수2) 함수
 document.querySelector('')			//3. 미리 정의된 (JS 만든사람) document.querySelector(인수1 = ????) 함수 
 									// ------> 다른 사람이 만든 (API, 프레임워크, 라이브러리) 코드는 한눈이 봐서는 모른다.
 									// 			설계를 모르기 때문!! 암기하기 말고 찾아서 쓰기, 공문 찾기 구글링 등등
 함수1();							//4. JS 에서 내가 만든 함수 호출
 함수2(3);							//5. 함수 호출과 동시에 해당 함수에 3 전달.
 함수2(3, 5, 20);					//6. 함수 호출과 동시에 해당 함수에게 데이터 3개 전달.
 let 함수결과1 = 함수4(3, 5, 20);		//7. 함수 종료 후 리턴/반환 값을 변수에 저장 (리턴값이 있을때는 저장을 해야한다.)
 let 함수결과2 = 함수5()				//8. 인수없음, 함수가 종료된 후 리턴/반환값을 변수에 저장
 함수6()								//9. 단순 함수 종료 후 반환 값이 없음
 
 
 //3. 함수 호출2
 	//1. HTML 이벤트 함수호출
 	// <input type = "button" onclick = "함수6()">
 	// <button type = "button" onclick = "함수6()">
 	//2. 함수내에서 다른 함수 호출
 	function 함수7 () { console.log('함수안에서 함수 호출');}
 	function 함수8 () { 함수7(); }
 	
 //4. 함수의 연산
 let 연산결과 = 함수4() + 10;  		// 함수4의 반환값이 3이므로 [3+10] 이 된다.
 		//함수4() 호출이 일순위 그다음 더하고 그다음 대입 !!
 		
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 