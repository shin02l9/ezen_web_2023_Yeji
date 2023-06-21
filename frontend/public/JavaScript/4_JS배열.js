/*
	변수 : 데이커 1개를 저장할 수 있는 공간/메모리/상자
		변수의 선언 : let 변수명 = 저장할 데이터
		let 밥그릇 = '밥'
		
		
	상수 : 데이터 1개를 저장할 수 있는 공간/메모리/상자
		변수는 변경이 가능하고 상수는 변경이 불가능함.
		상수의 선언 : const 상수명 = 저장할 데이터
		
	배열 : 데이터를 여러개 한곳에 저장할 수 있는 공간/메모리/상자
		- 저장된 순서대로 번호를 붙힌 데이터들이 연속적인 형태
		- 순서대로 번호 = '인덱스' ***
		- 인덱스 순으로 데이터들을 연속적으로 저장
		1. 배열 : [] 대괄호 사용
		2. 식별번호 : 인덱스사용 [0번부터 시작 ~ 0 1 2 3 4 ~] 왜냐면 배열 안에 데이터들로는 식별이 어렵기 때문 !!  동명이인 같은...?
		3. 배열의 선언
			let 배열명 = [데이터1, 데이터2, 데이터3]
			const 배열명 = [데이터1, 데이터2, 데이터3]
	 		 ex)
			let 청소부 = '하하'
			 =>> '청소부' 이라는 변수명에 1명/1개의 데이터를 저장 했다. (변수)
			let 무궁화반 = ['유재석', '강호동', '신동엽', '서장훈']
			 =>> '무궁화반' 이라는 변수명에 4명/4개의 데이터를 저장 했다. (배열)
			 		인덱스  유재석0,  강호동1,  신동엽2,  서장훈3
			 		마지막 인덱스  : 3
			 		학생수/길이 	: 4
		4. 배열길이
			배열명 .length 	: 배열내 데이터의 개수
		5. 배열 호출
			배열명		: 배열 전체 호출
			배열명[인덱스]	: 배열내 인덱스 번호에 해당하는 데이터 1개 호출
		6. 배열내 데이터 수정
			배열명[인덱스] = 새로운값
		7. 배열내 데이터 추가
			배열명.push( 새로운값 )  : 배열내 마지막 위치에 저장
				- 마지막 위치/인덱스에 데이터 추가. 
			배열명.splice(추가할 위치 인덱스, 0, 새로운 값) : 해당 위치 인덱스에 새로운 값을 저장
				- 특정위치/특정인덱스에 데이터 추가가 가능.
				[ *추가된 요소 뒤로 한칸씩 자동 밀려남 ]
		8. 배열내 데이터 삭제
			배열명.pop		: 배열내 마지막 위치 데이터 삭제
			배열명.splice( 제거할 인덱스, 제거갯수 )
			ex)
				배열명.splice(0) 		: 0번 인덱스부터 마지막 인덱스까지 삭제
				배열명.splice(0, 1) 	: 0번 인덱스 1개 삭제
				배열명.splice(3, 1)	: 3번 인덱스 1개 삭제
				배열명.splice(2, 3)	: 2 3 4 인덱스 3개 삭제
				[ *삭제된 요소 뒤로 한칸씩 자동 당겨짐 ]
		9. 데이터를 이용한 데이터 삭제**
			- 배열명.indexOF('찾을데이터')	: 찾을 데이터가 존재하면 찾은인덱스번호 아니면 -1 
			ex) 배열명.splice(배열명.indexOF('바나나'), 1) : '바나나'가 배열에 존재하면 삭제
			
 */

 //예제1 : 배열의 선언
 let 배열명 = ['바나나', '사과', '딸기', '포도'] 	// - 데이터 4개를 저장하는 배열 선언
 
 
 //예제2 : 배열의 호출 *
 console.log( 배열명 )
  /*
  F12 개발자도구 console
  array = 배열
  	인덱스 : 데이터
  */
 document.write( 배열명 ) // HTML 문서에 작성됨
 
 
 //예제3 : 인덱스 사용
 console.log( 배열명[0] )
 document.write( '<h3> 과일개수: ' + 배열명.length + '</h3>' )
 document.write( '<ol>' )
 document.write( 	'<li>' + 배열명[0]+'</li>' ) // 변수와 배열 문자처리 xxx
 document.write( 	'<li>' + 배열명[1]+'</li>' )
 document.write( 	'<li>' + 배열명[2]+'</li>' )
 document.write( 	'<li>' + 배열명[3]+'</li>' )
 document.write( '</ol>' )
   
   
 //예제4 : 인덱스를 이용한 데이터 수정
 console.log(배열명[0])  // 수정전 '바나나'
 배열명[0] ='수박'			// 수정
 console.log(배열명[0])  // 수정후 '수박'
 
   
 //예제5 : 배열에 요소/데이터 추가
 배열명.push('체리') /// push 는 마지막 인덱스 뒤에 '체리'란 데이터 추가
 console.log( 배열명 )
 배열명.splice(0, 1, '복숭아') // 0번째 인덱스에 있는 데이터를 1개 자르고 '복숭아'란 데이터 추가
 console.log(배열명) // 데이터를 자르지 않을 거면 현재 1 적혀있는 자리를 0으로 바꿔야함 (두번째 자리)

 
//예제6 : 배열에 특정 요소/데이터 삭제
배열명.splice( 0, 1 ) // 1번 인덱스부터 1개 삭제
console.log ( 배열명 )

배열명.splice ( 배열명.inderOF('딸기'), 1) // '딸기' 삭제해야하는데 인덱스 번호 모르는 상태
console.log ( 배열명 )   

   
   
   
   
  
   
   
   
   
 