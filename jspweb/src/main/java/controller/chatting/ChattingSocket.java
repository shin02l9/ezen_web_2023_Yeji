package controller.chatting;



import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

	/* 서버 소켓 만들기
		 1. 클래스 선언
		 2. 클래스 위에  @ServerEndpoint("/서버소켓의 URL정의") : 클라이언스 소켓들이 접속하는 위치, 도착점
		 3. 서버 웹소켓의 필수 메소드
			@OnOpen		: 클라이언트 소켓이 서버 소켓이 접속 했을때
			@OnClose	: 클라이언트 소켓이 서버와 연결이 끊겼을때
			@OnMessage	: 클라이언트 소켓이 메세지를 보냈을때
			@OnError	: 클라이언트 소켓이 서버 소켓과 연결에 에러가 발생 했을때 
			

*/

@ServerEndpoint("/ChattingSocket")
public class ChattingSocket {

		static ArrayList< Session > 접속명단 = new ArrayList<>();
	
	// 1.
		@OnOpen // 클라이언트가 서버소켓에 접속 했을때 매핑/연결
		public void onOpen( Session session ){
			System.out.println("클라이언트소켓 접속 : "+ session);
			System.out.println("클라이언트소켓 접속 : "+ session.getId());
			System.out.println("클라이언트소켓 접속 : "+ session.getRequestURI());
			System.out.println("클라이언트소켓 접속 : "+ session.getContainer());
			// * 들어온 클라이언트 소켓들을 서버 소켓에 저장
			접속명단.add(session);
			System.out.println("접속명단 : "+접속명단);
		}
	// 2. 클라이언트가 서버소켓과 연결이 닫혔을때 [ js에서 웹 소켓 객체를 초기화 = 새로고침 ]
	
		@OnClose
		public void onClose( Session session ){
			접속명단.remove(session); // 접속명단 리스트에서 삭제 
		}
			
	// 3. 클라이언트가 메세지 보냈을때 연결/매핑
		
		@OnMessage
		public void onMessage( Session session, String message ){
			System.out.println("받은 메세지 : "+message); // 클라이언트소켓으로 부터 메세지를 받았을때
			// 현재 접속된 명단(소켓)들에게 돌려줄것
			for(int i = 0; i<접속명단.size(); i++) {
				Session s = 접속명단.get(i);
			}
			for( Session s : 접속명단 ) {
				
			}
			접속명단.forEach( s -> {
				try {
					s.getBasicRemote().sendText(message);
				} catch (IOException e) {
					System.out.println(e);
				}
				// s : 접속명단에 있는 클라이언트 소켓중 하나 
					// .getBasicRemote() : 메세지 전송의 메소드 제공
						// .sendText() : 메세지를 String 타입으로 전송 [ ! 예외처리 필수 ]
			});
		}
	
	// 4. 
	
	
	
	
	
	
	
}
