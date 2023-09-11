
// 1. 비 로그인시 입장 불가능..!
if(loginmid == ''){
	alert('회원 전용 페이지입니다.')
	location.href="/jspweb/member/login.jsp";
}
console.log('채팅방에 입장한 아이디 : '+loginmid)

// 2. JS 클라이언트[유저] 소켓 만들기
let clientSocket = new WebSocket(`ws://192.168.17.80/jspweb/serversocket/${loginmid}`)
	// 클라이언트 소켓이 생성되었을때 자동으로 서버소켓에 접속한다.---> 서버 소켓의 @OnOpen
	// 서버소켓 URL에 매개변수 전달하기 [ 주로 식별자 전달 ] 
	// --- 메소드 4가지 메소드 자동으로 실행 
		// 1. (자동실행) 클라이언트소켓이 정상적으로 서버소켓 접속했을때
	clientSocket.onopen = e => { console.log('서버와 접속이 성공'); } ;
		// 2. (자동실행) 클라이언트소켓이 서버소켓과 연결에서 오류가 발생했을때.
	clientSocket.onerror = e => { console.log('서버와 오류발생:'+e ); };
		// 3. (자동실행) 클라이언트소켓이 서버소켓과 연결이 끊겼을때.
	clientSocket.onclose = e => { console.log('서버와 연결 끊김:'+e ); };
		// 4. (자동실행) 클라이언트소켓이 메시지를 받았을때.
	clientSocket.onmessage = e => onMsg( e ); 
		// send 보내기는 없음.

// 3. 서버에게 메세지 전송
function onSend(){
	// 입력값 호출
	let msg = document.querySelector('.inputcontent').value;
	if( msg == '' ){alert('내용을 입력해주세요.'); return;}
	// 메세지 전송 { 소켓에게 전송하기 }
	clientSocket.send( msg );
	// 클라이언트소켓과 연결된 서버소켓에게 메시지 전송 ----> 서버소켓의 @OnMessage 으로 이동 
	
	// 입력된 값 보내고 인풋창에 남은 데이터 초기화하기
	document.querySelector('.inputcontent').value = '';
}
// 3. 인풋창에서 엔터키를 눌렀을때
function enter(){
	if( event.keyCode == 13 ){
		onSend()
		return;
	}
}

// 4. 메세지를 받았을때 
function onMsg( e ){
	console.log( e ); // e : 메시지 받았을때 발생한 이벤트 정보가 들어있는 객체
	console.log( e.data ); // .data 속성에 전달받은 메시지 내용 
	console.log( loginmid ); 
	
	let msg = JSON.parse( e.data );
	
	let chat = document.querySelector('.chatcontent')
	let HTML = ``;
		if( msg.mid == loginmid ){
				HTML = `<div class="Rcont"> 
							<div class="subcont">
								<div class="date"> 오전 10:02 </div>
								<div class="content"> ${ msg.msg } </div>
							</div>
						</div>`;
		}else{ // 2-2 내가 보낸 내용이 아니면
			HTML = `
					<div class="Lcont"> 
						<img class="pimg" src="/jspweb/member/img/default.webp" >
						<div class="tocont">
							<div class="Lname">${ msg.mid }</div>
							<div class="subcont">
								<div class="content"> ${ msg.msg } </div>
								<div class="date"> 오전 10:10 </div>
							</div>
						</div>
					</div>`
		}
	
	chat.innerHTML += HTML;
}





































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
// -----------------------------------------------------------------------
 /*
 // 1. JS 웹 소켓 객체 [webSocket클래스]
 	// new webSocket('서버소켓 URL');
 	// [ 객체생성 => 서버소켓 @OnOpen ]
 let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket');
console.log(클라이언트소켓)
 
 // OnOpen, OnClose, Send, OnMessage
 
 
 	// 내가 만든 함수를 클라이언트소켓 속성에 대입
 	클라이언트소켓.onmessage = (e) => onmsg(e);
 
 
 // 2. 연결된 소켓에게 메세지 보내기 
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
}*/