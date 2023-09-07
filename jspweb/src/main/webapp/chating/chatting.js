
/*
	1. AJAX
		발신자(보내는사람) 	: AJAX		
		수신자(받는사람) 	: 서블릿		
	
		JS					JAVA[서블릿]
							
		AJAX	
				rest		get
							post	
							put
							delete
	2. (웹)소켓
		소켓 : 통신의 종착점[도착위치]
		- 전체조건 : 서버가 클라이언트소켓의 정보를 가지고 있어야한다.
		
		JS					JAVA
		[클라이언트소켓]		[서버소켓]
		websocket
		1. 서버소켓 접속		2. 서버소켓 24시간 상시 클라이언트 소켓 명단 저장
		3. 데이터 전송			4. 데이터 받는다.
*/
/*
				클라언트[사용자]						서버[서비스회사]
			
		강호동카카오톡		
						'안녕'
				-------------------------------->
				1. 강호동 메시지(안녕) 보낸다.
				
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
				
		유재석카카오톡 
													카카오서버[제주도]
													- 전제조건 : 클라이언트의 정보들 보관
													접속된명단 : [ 강호동,유재석,신동엽,하하 ]
													2. '안녕' 메시지 받는다.
				<--------------------------------		
				3. 서버가 '안녕' 메시지 보낸다.			
		신동엽카카오톡 
		
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
		하하카카오톡 
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
		
*/

 
 // 1. JS 웹 소켓 객체 [webSocket클래스]
 	// new webSocket('서버소켓 URL');
 	// [ 객체생성 => 서버소켓 @OnOpen ]
 let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket');
console.log(클라이언트소켓)
 
 // OnOpen, OnClose, Send, OnMessage
 
 
 	// 내가 만든 함수를 클라이언트소켓 속성에 대입
 	클라이언트소켓.onmessage = (e) => onmsg(e);
 
 
 // 2. 연결된 소켓에세 메세지 보내기 
function msgsend(){
	// 1. input 값 가져오기 
	let msg = document.querySelector('.inputcontent').value;
	// 2. 클라이언트 소켓 .send();
	클라이언트소켓.send( msg ); // 입력받은 데이터 보내기 
	//[ 클라이언트소켓.send( msg ); => 서버소켓 @OnMessage ]
}

// 3. 연결된 서버소켓으로 부터 메세지를 받았을때 
function onmsg(e){
	console.log(e)
	console.log(e.data)
	
	document.querySelector('.contentbox').innerHTML += ` <div> ${e.data} </div> `;
}