/*

	반복문 : 어디서부터 어디까지 반복하나!!!
		1. 	
			for( 1.초기값 ; 2.조건문 ; 4.증감식 ){
				3. 실행코드;
			}
			1. 초기값 : 반복의 처음값 
 				; : 구역부분
			2. 조건문 : 조건이 true이면 {}실행 아니면 {}실행 안함
				; 
			3. 실행문 : 반복시 실행될 코드
			4. 증감식 : 반복변수 증가/감소 단위 
			
		ex) 1부터 10까지 1씩증가 반복 
			for( let i = 1 ; i<=10 ; i++ ){ }
		ex) 1부터 100까지 홀수만 반복
			for( let i = 1 ; i<=100 ; i+=2 ){ }
*/

// 1. 
	// let i = 0 ;	// 1. 초기값 ( i는 반복시 사용되는 증감변수 = 임의변수명 )
	// i<10		;	// 2. 조건문 ( 조건결과가 true이면 {} 실행되는 조건  )
	// i++			// 3. 증감식 ( {} 실행후 다음으로 증감변수 계산식 )
for( let i = 0 ; i<3 ; i++ ){ // for 시작
	// i는 0부터 10미만까지 1씩증가 반복
	console.log('반복횟수 : ' + i );
	/* 
		순서도 = 알고리즘 != 자료구조
			// * 1.생활속 순서도 2.백준 3.프로그램개발 순서
		1. let i = 0			=> i = 0
		2. i<3					=> true => { }
		3. console.log( );		=> 0 출력 
		--------
		4. i++					=> i = 1		
		5. i<3					=> true => { }
		6. console.log( );		=> 1 출력 
		--------
		7. i++					=> i = 2
		8. i<3					=> true => { }
		9. console.log( );		=> 2 출력 
		--------
		10. i++					=> i = 3 
		11. i<3					=> false => 못 들어감
		12. 반복문 종료 
	*/
} // for 끝

// 2. 배열( 인덱스 )과 반복문
let 상자 = ['사과','포도','딸기']
	// 1.반복문 없을때 [ 인덱스 다수일때 힘듬 ]
console.log( 상자[0] );
console.log( 상자[1] );
console.log( 상자[2] );

	// 2.반복문 사용할때 [ i반복변수를 인덱스 대신 사용 ]
for( let i = 0 ; i<상자.length ; i++ ){ // for s
	console.log( 상자[i] )
} // for end 

// 예제1) i는 1부터 10이하까지 1씩 증가 반복 [ 한줄씩 표시 ]
console.log('---------- ex1 ------------- ');
for( let i = 1 ; i<=10 ; i++ ){
	console.log( i )
} // for end 

// 예제2) i는 1부터 10이하까지 1씩 증가 반복 [ 한줄에 표시 ]
console.log('---------- ex2 ------------- ');
let output = ``	// 문자열을 누적으로 저장할 output변수 선언  
for( let i = 1 ; i<=10 ; i++ ){ // for s
	output += `${i}  `	// (+=) i변수를 output변수에 추가 
} // for end
console.log( output )	

// 예제3) i는 1부터 10이하까지 1씩 증가 반복 [ HTML 표시 ]
console.log('---------- ex3 ------------- ');
output = `` // 위에서 선언된 output변수를 재선언하지 않고 공백으로 대입(초기화)
for( let i = 1 ; i<=10 ; i++ ){
	output += `<p> ${i} </p>`
} // for end 
document.write( output )
