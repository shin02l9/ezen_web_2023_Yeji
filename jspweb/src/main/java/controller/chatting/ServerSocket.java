package controller.chatting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import java.util.Date;

import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDTO;
import model.dto.MsgDTO;

@ServerEndpoint("/serversocket/{mid}")
public class ServerSocket {
	
	// 0. 접속된 클라이언트 소켓들의 저장소
	public static List< ClientDTO > clientList = new Vector<>();
	
	
	// 1. 클라이언트소켓으로부터 접속받았을때. 
	@OnOpen
	public void onOpen( Session session, @PathParam("mid") String mid ) {
		System.out.println("클라이언트 소켓이 입장 했습니다. \n"+session);
		// 1-1. 저장된 클라이언트소켓을 리스트에 저장하기
		ClientDTO clientDTO = new ClientDTO(session, mid );
		clientList.add( clientDTO );
		System.out.println("접속된 클라이언트들 \n"+clientDTO);
	}
	
	
	// 2. 클라이언트 소켓과 오류가 발생했을때
	@OnError
	public void onError(Session session, Throwable throwable ){
		
	}
	
	
	// 3. 클라이언트 소켓과 서버소켓이 연결이 끊겼을때 
	@OnClose
	public void onClose(Session session){
		// 접속목록에서 세션을 제거해야함.
		for( ClientDTO clientDTO : clientList ) {
			if( clientDTO.getSession() == session ) {
				clientList.remove(clientDTO);
				break;
			}
		}
	}
	
	
	// 4. 
	@OnMessage
	public void OnMessage( Session session, String msg ) throws IOException {
		System.out.println("보낸 클라이언트 : "+session);
		System.out.println("보낸 내용 : "+msg);
		
		// new Date() : 현재시간/날짜 제공하는 클래스 [ import java.util.Date; ]
		Date date = new Date(); System.out.println( "현재날짜/시간 : " + date );
			// 2. SimpleDateFormat : 날짜 포멧(형식)
		SimpleDateFormat sdf = new SimpleDateFormat(" aa hh:mm ");
			// y연도 M월 d일 h시m분s초 aa오전오후 
		String datetime = sdf.format( date ); // 현재시간을 정의한형식으로 변환 
		
		
			// 메세지 보낼 내용 구성
		MsgDTO dto = null;
			// 보낸사람 찾기 
			for( ClientDTO clientDTO : clientList ) {
				if( clientDTO.getSession() == session ) {
					// 회원목록중에 보낸세션과 일치하면 보낸사람mid와 내용으로 dto 구성 
					dto = new MsgDTO( clientDTO.getMid(),  msg , datetime); 
					break;
				}
				
			}
			
		// 매핑해주기
		ObjectMapper mapper = new ObjectMapper();
		String jsonmsg= mapper.writeValueAsString(dto);
		
		// 받은 메세지를 접속된 회원들에게 모두 전송해야한다.
		for( ClientDTO clientDTO : clientList ) {
			clientDTO.getSession().getBasicRemote().sendText(jsonmsg); // 예외처리 필수임. 던지기 ~~
		}
	}
		
}







/*

	* WebSocket 서버 소켓 라이브러리 제공
		1. 서버소켓 클래스 생성
			- 클래스 위에 서버소켓의 URL만들기
				@ServerEndpoint("/serversocket")
			- 만약에 서버소켓의 URL 결로상에 매개변수 받을때
				@ServerEndpoint("/serversocket/{매개변수명1}/{매개변수명2}")
		2. 서버소켓 메소드 제공 
				- 메소드 매개변수의 규칙 존재 
				
				1. 클라이언트 소켓이 접속했을때. (자동실행)되는 메소드
				@OnOpen
					1. 
					public void onOpen( Session session ) { }
						- Session : 서버소켓의 접속된 클라이언트소켓 정보
					2. 
					public void onOpen( Session session , @PathParam("매개변수명1") 타입 매개변수명 ) { }
						- @PathParam("매개변수명1") 타입 매개변수명 : 서버소켓(URL)경로상의 매개변수를 호출 
				
				2. 클라이언트 소켓과 오류가 발생했을때 . (자동실행)되는 메소드
				@OnError
					public void onError( Session session , Throwable throwable ) { }
						- Session : 서버소켓과 오류가 발생한 클라이언트소켓 정보 
						- Throwable : 오류 발생한 사유 정보 
				
				3. 클라이언트 소켓과 연결이 끊겼을때. (자동실행)되는 메소드
				@OnClose
					public void OnClose( Session session ) { }
						- Session : 서버소켓과 연결이 끊긴 클라이언트소켓 정보 
				
				4. 클라이언트 소켓으로부터 메시지를 받았을때. (자동실행)되는 메소드
				@OnMessage
					public void onMessage( Session session , String msg ) { } 
						- Session : 서버소켓에게 메시지를 보낸 클라이언트소켓 정보 
						- String 매개변수 : 클라이언트소켓으로 부터 받은 메시지 [문자열타입]
						
				5. 클라이언트소켓에게 메시지 전송 
					클라이언트소켓.getBasicRemote().sendText("내용");


*/