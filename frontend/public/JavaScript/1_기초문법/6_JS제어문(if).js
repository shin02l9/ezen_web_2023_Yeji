/*

 - 제어문 = if = 만약에
		ex) 어린동생에게 집앞에 있는 A,B,C 편의점에서 1000원을 주고 콜라사오기 심부름을 시킴
			동생이 A편의점을 간다 -> 콜라가 1000원 이하이면 -> 구매하고 집으로 간다.
			아니면
			동생이 B편의점을 간다 -> 콜라가 1000원 이하이면 -> 구매하고 집으로 간다.
			아니면
			동생이 C편의점을 간다 -> 콜라가 1000원 이하이면 -> 구매하고 집으로 간다.
			아니면
			그냥 집에 간다.
			-----------------------------
		ex) if( A편의점_콜라 <= 1000){ 구매하고 집으로 간다. }
			else if( B편의점_콜라 <= 1000){ 구매하고 집으로 간다. }
			else if( C편의점_콜라 <= 1000){ 구매하고 집으로 간다. }
			else { 그냥 집에 간다. }
		
	1. 제어문 : 흐름(위에서 아래로 왼쪽에서 오른쪽으로)에 대한 논리적인 제어.
	2. if[*중요] , switch 문법
	3. if 형태
		* 조건 : ture or false 결과를 갖는 변수 혹은 연산
		* 조건과 참/거짓 코드가 이어거야 한다. 중간에 세미콜론(;) 넣으면 안된다는 뜻.
		1. if (조건) 참일경우코드
		2. if (조건) {참1일경우코드; 참2일경우코드}
		3. if (조건) {참일경우코드}
	 	   else (조건) {거짓일경우코드}
	 	   						ㄴ------> vs [삼항연산자] 조건 ? 참 : 거짓
	 	4. if (조건1){참1일경우코드}
	 	   else if (조건2){참2일경우코드}
	 	   else if (조건3){참3일경우코드}
	 	   else if (조건4){참4일경우코드}
	 	   else {거짓일경우코드}
	 	   		ㄴ------> vs ---	 if	(조건1){참1일경우코드}
	 	 						 if (조건2){참2일경우코드}
	 						 	 if (조건3){참3일경우코드}
	 	 					 	 if (조건4){참4일경우코드}
	 	5. if 중첩
	 		if (조건1){
				 if(조건2){}
				 else if(조건3){}
			 } else{
				 if(조건4){}
				 else if(조건4){}
			 }
*/

//1. if 형태
if ( 10 > 3) console.log ('참[1] 10이 3보다 크다.') //조건 참이라서 콘솔 코드 실행 o
if ( 10 > 20 ) console.log ('참[2] 10이 30보다 크다.') // 조건 거짓이라서 콘솔 코드가 실행 x
if ( 10 > 20 ); console.log ('참[3] 10이 20보다 크다.') // ; 이 있으면 문제가 생김.

//2. if 형태2
if ( 10 > 3 ) console.log ('참1'); console.log('참2');
if ( 10 > 20 ) console.log ('참3'); console.log('참4'); // 거짓임에도 불구하고 참4가 출력이 되었다. (의도와 다름)
if ( 10 > 20 ) {console.log ('참5'); console.log('참6');} // 의도에 맞게 거짓이면 둘다 출력이 안된다.

//3. if 형태3
if ( 10 > 3 ) { console.log ('[참] 10 더 크다');}
else { console.log ('[거짓] 10 더 작다');}
		// ㄴ------ vs---------ㄱ
		10 > 3 ? console.log('[참] 10 더 크다') : console.log ('[거짓] 10 더 작다') // 삼항연산자
	
//4. if 형태4
if (10 >= 20 ) {console.log('[참1] 10이 20보다 이상이다.');}
else if ( 10 >= 15 ) {console.log('[참2] 10이 15보다 이상이다.');}
else if ( 10 >= 10 ) {console.log('[참2] 10이 10보다 이상이다.');} // 참이면 실행 후 전체 if 종료
else {console.log('[거짓] 10이 10미만이다.');}
		// ㄴ------ vs---------ㄱ
		10 >= 20 ? console.log('[참1] 10이 20보다 이상이다.')
			: 10 >= 15 ? console.log('[참2] 10이 15보다 이상이다.')
				: 10 >= 10 ? console.log('[참2] 10이 10보다 이상이다.')
					: console.log('[거짓] 10이 10미만이다.')



















