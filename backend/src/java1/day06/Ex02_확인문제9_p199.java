package java1.day06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02_확인문제9_p199 {// class s

	 public static void main(String[] args) { // main s
		
		 Scanner scanner = new Scanner( System.in );
		 
		 // 필요한 배열 공란으로 미리 선언하기
		 int[] 학생수 = null;
		 String[] scores = null;
		 int maxScores = 0;
		 int sum = 0;
		 
		 while ( true ) { // while s
		 System.out.println("---------------- <성적관리 프로그램> --------------------");
		 System.out.println("-----------------------------------------------------");
		 System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
		 System.out.println("-----------------------------------------------------");
		 System.out.print(" 선택 > "); int ch = scanner.nextInt();		
		 
		 if( ch == 1 ){ // 학생수 입력받기 -------------------------------------------------------
			 System.out.print(" 학생수 > "); 
			 int n = scanner.nextInt();
			 학생수 = new int[n];
			 scores = new String[n];
			 System.out.println(Arrays.toString( 학생수 )); // 참고용 임시 출력
			 
		 } else if ( ch == 2 ){ // 점수 입력받기 -------------------------------------------------------
			 for ( int i = 0; i<학생수.length ; i++) {
				 System.out.print("scores["+i+"] >"); 
				 scores[i] = scanner.next();	
			 }
			 
		 } else if ( ch == 3 ){ // 점수리스트 출력하기 -------------------------------------------------------
			 for ( int i = 0; i<scores.length ; i++) {
				 System.out.print("scores["+i+"] : "); System.out.println(scores[i]); 
			 } 
			 
		 } else if ( ch == 4 ){ // 분석하기 -------------------------------------------------------
			 for( int i = 0; i < 학생수.length ; i++) {
//				 <최고점수구하기>
//				 문자열로 받은 점수를 
//				 포문 돌려서 인트(정수)로 바꾼후에 임시변수(scoresInt)에 저장하고 
//				 포문 계속 돌리면서 임시변수(scoresInt)에 있는 숫자가 (maxScores)변수에있는 값보다 크면 값을 대입하고 아니면 넘어가기
//				 <평균점수구하기>
//				 우선 총 점수가 필요해서 포문 돌리면서 (sum) 변수에 인트 정수로 변환한 수들을 다 더하기, 그리고 학생수만큼 나누기
				 int scoresInt = Integer.parseInt(scores[i]); 
				 sum += scoresInt;
				 if(scoresInt > maxScores ) {
					 maxScores = scoresInt;
				 }
			 }
			 System.out.println("최고점수 : " + maxScores);
			 System.out.println("평균점수 : " + sum/학생수.length);
			 
		 } else if ( ch == 5 ){ // 종료하기 -------------------------------------------------------
			 System.out.println("\n 프로그램 종료합니다.\n ");
			 학생수 = null; scores = null; sum = 0; 
			 
		 } else { System.out.println("\n 없는 메뉴입니다.\n "); }
		 

		  
		 } //while e
	} // main e
}// class e
