package 과제.과제06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class 과제6_1_주차요금정산프로그램 { // class s

	public static void main(String[] args) {// main s

		
		Scanner scanner = new Scanner( System.in );
		
		String[] carNum = new String[20];
		String[] inTime = new String[20];
		String[] outTime = new String[20];
		int price = 10; // 1분 단위에 10원
		int totalPaid = 0;
		String[] endParking= new String[20]; //출차된 차들 목록
		
		String Date; // 현재 시간 저장는 거쳐가는 변수
		
		String reqDateStr; //결제때 사용한 입차시간
		long minute = 0 ;
	
		//현재시간 Date
		Date curDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmm");
		Date = dateFormat.format(curDate);
		System.out.println("현재시간 : "+dateFormat.format(curDate) );
		
		
		//--------------------------------------------------------------------------------------
		while ( true ) { // while s
			 System.out.println("-------------- <주차요금 관리 프로그램> ------------- ");
			 System.out.println("------------------------------------------------");
			 System.out.println(" 1. 입차 | 2. 출차(요금지불) | 3. 입출차현황 | 4. 매출 ");
			 System.out.println("------------------------------------------------");
			 System.out.print(" 선택 > "); int ch = scanner.nextInt();		
			 
			 
			 if( ch == 1 ) { // 입차 ------------------------------------------------
				 System.out.print(" 차량번호 > "); 
				 String car = scanner.next();
				 for ( int i = 0; i<carNum.length; i++ ) {
					 if ( carNum[i] == null ) { 
						 carNum[i] = car; 
						 inTime[i] = Date;
						 break;
					}
				 }System.out.println(Arrays.toString( carNum ));
				 //입력받은 차량번호를 carNum 저장하기 인덱스는 차례대로 
				 //차량번호 저장되는 시간을 함수로 끌어와서 inTime에 저장
				 
			 } else if ( ch == 2 ) { // 출차 ------------------------------------------------
				 System.out.print(" 차량번호 > "); 
				 String car = scanner.next();
				 int usedTime = 0;
				 int ingCar = 0; // 현재 프로그램 조작중인 차량의 인덱스 번호 저장해두기
				 
				
				 
				 for ( int i = 0; i<carNum.length; i++ ) {
					 if ( carNum[i] == car ) { 
						//outTime[i] = outDate;
						// 입차 출차 시간 계산기
						    reqDateStr= inTime[i];
							Date reqDate;
							try {
								
								reqDate = dateFormat.parse(reqDateStr);
								long reqDateTime = reqDate.getTime();
								
								//현재시간을 요청시간의 형태로 format 후 time 가져오기
								
								curDate = dateFormat.parse(dateFormat.format(curDate));
								long curDateTime = curDate.getTime();
								//분으로 표현
								
								minute = (curDateTime - reqDateTime) / 60000;
								
								System.out.println("요청시간 : " + reqDate);
								System.out.println("현재시간 : " + curDate);
								System.out.println(minute+"분 차이"); 
								
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("minute" +minute);
							 
						usedTime += (Integer.parseInt(outTime[i]) - Integer.parseInt(inTime[i]));
						totalPaid += (usedTime*price);
						ingCar = i;
					 }
					 
					 
				 }
				 System.out.print(" 1. 결제 | 2. 취소 "); int payCh = scanner.nextInt();
				 if( payCh == 1 ) {
					 
					 System.out.print(" 주차요금은 "+usedTime*price+"원 입니다.");
					 System.out.print(" 결제하실금액을 입력해주세요. > "); int payInput = scanner.nextInt();
					 String endCar;
					 if( payInput == usedTime*price ) {
						 System.out.print(" 결제가 완료되었습니다. \n 안녕히 가십시오.\n");
						 outTime[ingCar] = Date;
						 endCar =carNum[ingCar]+","+inTime[ingCar]+","+ outTime[ingCar];

						 for ( int i = 0; i<endParking.length; i++ ) {
							 if ( endParking[i] == null ) { 
							 endParking[i] = endCar; 
							 break;
						}
					 }System.out.println(Arrays.toString( endParking ));		 
								 
					 } else if ( payInput > usedTime*price ){
						 System.out.print(" 결제가 완료되었습니다. \n거스름돈은 "+ (payInput-(usedTime*price)) +"원 입니다.\n안녕히 가십시오.\n");
						 outTime[ingCar] = Date;
						 endCar =carNum[ingCar]+","+inTime[ingCar]+","+ outTime[ingCar];

						 for ( int i = 0; i<endParking.length; i++ ) {
							 if ( endParking[i] == null ) { 
							 endParking[i] = endCar; 
							 break;
						}
					 }System.out.println(Arrays.toString( endParking ));
 
					 } else if ( payInput < usedTime*price ) {
						 System.out.print(" 금액 부족으로 결제가 취소되었습니다. ");
					 }
				 } if( payCh == 2 ) {
					 System.out.print(" 결제가 취소되었습니다.\n ");
				 }
				 
				 // 출차된 차량의 데이터를 배열에서 삭제하기
				 carNum[ingCar] = null;
				 inTime[ingCar] = null;
				 outTime[ingCar] = null;
				 
				 //입력받은 차량번호를 carNum 넘버에서 찾아서 인덱스번호 알아내고
				 // 그 인덱스 번호로 inTime을 호출 하고 현재 시간을 outTime에 저장하기
				 // 그리고 outTime - inTime 해서 10분단위로 200원 부과해서 결제할 금액 출력하고 
				 // 1.결제 2.취소
				 // 결제금액 입력하고 결제금액보다 미만이면 추가 입력 받고 
				 // 많이 입력하면 거스름돈
				 // 결제 금액이 매출액에 합산
				 // 출차된 내역을 endParking 배열에 저장하기 
				 // 그리고 해당 인덱스에 잇는 데이터 삭제 하기
				 // 출차된 차량이 있으면 삭제되어서 빈 공간이된 자리에 뒷 인덱스 값 당겨오기
			 } else if ( ch == 3 ) { // 현황 ------------------------------------------------
				 System.out.println(" 차량번호 |   입차시간   |   출차시간   |   상태 ");
				 System.out.println("-----------------------------------------------");
				 for ( int i = 0; i<carNum.length; i++ ) {
					 if( carNum[i] !=  null ){
						 System.out.println( "  " + carNum[i] + "  |" + inTime[i] +"|" + "     ------     " + "|  주차중" );
					 }
				 }
				 //System.out.println( " " + carNum[i] + " |" + inTime[i] +"|" + "-------" + "|  정산완료 " );
				 // 현재 배열에 있는 차량번호를 찾아서 배열내에 값이 있는 인덱스를 
				 // 현재 주차중인 차, 이미 출차된 차 따로 출력
			  }else if ( ch == 4 ) { // 매출 ------------------------------------------------
				  System.out.println(" 총매출 > " + totalPaid);
			 } else { System.out.print("없는 메뉴입니다."); }
			

			  
		
		} //while e	
	}// main e
} // class e




// 해결해야할 오류
// 1. 사용시간 계산이 아직 안됨
// 2. 
