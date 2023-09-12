
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
	clientSocket.onopen = e => { console.log('서버와 접속성공'); } ;
		// 2. (자동실행) 클라이언트소켓이 서버소켓과 연결에서 오류가 발생했을때.
	clientSocket.onerror = e => { console.log('서버와 오류발생:'+e ); };
		// 3. (자동실행) 클라이언트소켓이 서버소켓과 연결이 끊겼을때.
	clientSocket.onclose = e => { console.log('서버와 연결끊김:'+e ); };
		// 4. (자동실행) 클라이언트소켓이 메시지를 받았을때.
	clientSocket.onmessage = e => onMsg( e ); 
		// send 보내기는 없음.

// 3. 서버에게 메세지 전송
function onSend(){
	// 입력값 호출
	let msgValue = document.querySelector('.inputcontent').value;
	if( msgValue == '' || msgValue == '\n'){
		alert('내용을 입력해주세요.'); 
		document.querySelector('.inputcontent').value = ''; 
		return;
	}
	// 메세지 전송 { 소켓에게 전송하기 }
	
	let msg = { type : 'msg' , content : msgValue }
	
	clientSocket.send( JSON.stringify(msg) );
	// 클라이언트소켓과 연결된 서버소켓에게 메시지 전송 ----> 서버소켓의 @OnMessage 으로 이동 
	
	// 입력된 값 보내고 인풋창에 남은 데이터 초기화하기
	document.querySelector('.inputcontent').value = '';
}
/*// 3. 인풋창에서 엔터키를 눌렀을때
function enter(){
	if( event.keyCode == 13 ){
		onSend()
		return;
	}
}*/

// 4. 메세지를 받았을때 
function onMsg( e ){
	console.log( e ); // e : 메시지 받았을때 발생한 이벤트 정보가 들어있는 객체
	console.log( e.data ); // .data 속성에 전달받은 메시지 내용 
	console.log( loginmid ); 
	
	let msgBox = JSON.parse( e.data );
	
	console.log('msgBox : ')
	console.log(msgBox)
	
	// 1. 특정 문자열 찾아서 1개 치환/바꾸기/교체 
	let content = msgBox.msg.replace( '\n' , '<br>' );	// replace( '변경할문자열|정규표현식' , '새로운문자' );
	console.log( content );
	// 2. 특정 문자열 찾아서 찾은 문자열 모두 치환/바꾸기/교체 => java : .replaceAll();   js : 정규표현식 
	content  = msgBox.msg.replace( /\n/g , '<br>');	// /g : 동일한 패턴의 모든 문자찾기[전체]
	
	console.log( 'content : '+content );
	
	msgBox.msg = JSON.parse( content );
	console.log('msgBox.msg : ')
	console.log(msgBox.msg)
	
	let chat = document.querySelector('.chatcontent')
	let HTML = ``;
		if( msgBox.mid == loginmid ){
				HTML = `<div class="Rcont"> 
							<div class="subcont">
								<div class="date"> ${ msgBox.datetinme } </div>
								${typeHTML(msgBox.msg)}
							</div>
						</div>`;
		}else{ // 2-2 내가 보낸 내용이 아니면
			HTML = `
					<div class="Lcont"> 
						<img class="pimg" src="/jspweb/member/img/default.webp" >
						<div class="tocont">
							<div class="Lname">${ msgBox.mid }</div>
							<div class="subcont">
								${typeHTML(msgBox.msg)}
								<div class="date"> ${ msgBox.datetinme } </div>
							</div>
						</div>
					</div>`
		}
	
	chat.innerHTML += HTML;
	// ------------------- 스크롤 최하단으로 내리기 ( 스크롤 이벤트 ) --------------- // 
	// 1. 현재 스크롤의 상단 위치 .
	//let topHeight = chatcont.scrollTop;	// dom객체.scrollTop : 해당 div의 스크롤 상단위치
	//	console.log( topHeight );	// 30px; 
	// 2. 현재 dom객체의 전체 높이 
	//let scrollHeight = chatcont.scrollHeight; // dom객체.scrollHeight : 해당 div의 스크롤 전체 높이 
	//	console.log( scrollHeight )	// 600px;
	// 3. 전체 높이 값을 현재 스크롤 상단 위치에 대입 
	chat.scrollTop = chat.scrollHeight;
}


// 5. textarea 입력창에서 입력할때마다 이벤트 발생 함수 
function onEnterKey(){	
	// 2. 만약에 ctrl + 엔터 이면 줄바꿈.
	if( window.event.keyCode == 13 && window.event.ctrlKey ){ // 조합키 : 한번에 두개 이상 입력 가능한 키 [ ctrl.shift+alt 등]
		document.querySelector('.inputcontent').value += `\n`; return;
	}
	// 1. 만약에 입력한 키 가 [엔터] 이면 메시지 전송
	if( window.event.keyCode == 13 ){ onSend(); return; }
	
}

// 6. 이모티콘 출력하기 
getEmo();
function getEmo(){
	for( let i = 1; i <= 43; i++ ){
		document.querySelector('.emolistbox').innerHTML 
		+= `<img onclick="onEmoSend(${i})" src="/jspweb/img/emo${i}.gif">`;
	}
}

// 7. 클릭한 이모티콘 서버로 보내기
function onEmoSend( i ){
	// 1. 객체 구성
	let msg = { type : 'emo' , content : i }
	
	// 2. 보내기
	clientSocket.send( JSON.stringify(msg) );
		// JSON 타입을 String 타입으로 변환해준 것임.
	
}



// 8. msg 타입에 따른 HTML 반환 함수
function typeHTML( msg ){
	let HTML = ``;
	
	console.log(' typeHTML() 입장 ')
	console.log(msg.content)
	
	// 1. 메세지 타입
	if( msg.type == 'msg' ){ HTML += `<div class="content"> ${ msg.content } </div>`; }
	// 2. 이모티콘 타입
	else if( msg.type == 'emo'){ 
		HTML += `<img src="/jspweb/img/emo${msg.content}.gif">`; 
		
		console.log('emo HTML')
		console.log(HTML)
		
		}
	
	return HTML;
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