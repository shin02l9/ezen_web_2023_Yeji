
console.log(' visitlog JS 실행')

// C (저장)
function vwrite(){ //-----------------------------------------------
	//1. HTML input 태그 호출
	let vwriterInput = document.querySelector('.vwriter');
	let vpwdInput = document.querySelector('.vpwd');
	let vcontentInput = document.querySelector('.vcontent');
/*	console.log('vwriterInput : '+ vwriterInput)
	console.log('vpwdInput : '+ vpwdInput)
	console.log('vcontentInput : '+ vcontentInput)
	console.log('vwriterInput value : '+ vwriterInput.value)
	console.log('vpwdInput value : '+ vpwdInput.value)
	console.log('vcontentInput value : '+ vcontentInput.value)*/
	
	//2. 객체화
	let vdata = {
		vwriter : vwriterInput.value,
		vpwd : vpwdInput.value,
		vcontent : vcontentInput.value
	};
	console.log('vdata : '+ vdata);
	
	//3. 유효성 검사
	if( vwriterInput.value == null || 
		vpwdInput.value == null || 
		vcontentInput.value == null){
		alert('[ 공백을 모두 입력해 주세요. ]');
	} else {
		//4. AJAX (HTML에 JQUERY 라이브러리 필수로 호출 해야한다.)
		$.ajax({
			url :"/jspweb/VisitlogController",
			method : "post",
			data : vdata,
			success : function f(r){ 
				//5. 결과에 따른 코드
				console.log("ajax통신성공! post 결과 : "+r)
				if( r == true ){
					alert('[ 등록 성공 ]');
					vread();
					// 공백 초기화
					vwriterInput.value = '';
					vpwdInput.value = '';
					vcontentInput.value = '';
				} else {
					alert('[ 등록 실패 ]');
				}
			}				
		});

	}


}// vwrite e

// R (호출)
vread();
function vread(){ //-----------------------------------------------
	$.ajax({
		url :"/jspweb/VisitlogController",
		method : "get",
		data : "",
		success : function f(r){ 
			console.log("ajax통신성공! get 결과 : "+r)
			//1. 응답 받은 객체를 html에 출력
      		//1. [어디에] 출력할 구역의 객체 호출
      		let output = document.querySelector('.visit_bottom')
      		
      		//2. [무엇을] 반복문 이용한 데이터를 html 형식으로 만들기
      		let html = ``; /*백틱 안에서 ;js문법 사용 ${} */
      			//리스트 내 모든 데이터를 
      			for(let i = 0; i<r.length; i++){
					  //객체를 html형식으로 누적더하기
					  html += `<div class=visitbox><!-- 방문록1개의 표시구역 -->
									<div class="visitbox_top">
										<div>${r[i].vwriter}</div>
										<div class="visitdate">${r[i].vdatetime} </div>
									</div>
									<div class="visitbox_center">${r[i].vcontent}</div>
									<div class="visitbox_bottom">
										<button onclick="vupdate()" >수정</button>
										<button onclick="vdelete()" >삭제</button>
									</div>
								</div>`
				  }
      		//3. [대입]출력객체 html형식 대입
      		output.innerHTML=html;
      
		}	
	});
}// vread e


// U (수정)
function vupdate( vno ){ //-----------------------------------------------
	// 1. 수정할 내용 입력 
	let vcontent =	prompt('수정할 방문록내용 : ');					// alert() : 확인알림창  confirm(); : 확인/취소알림창 prompt() : 알림창에서 입력받기 ;
	// 2. 비밀번호가 일치할 경우에 수정하므로 확인용 비밀번호 입력받기
	let vpwd = prompt("방문록비밀번호 : ");
	// 수정 준비물 : vno(누구를) , vcontent(어떤내용으로) , vpwd(조건용:비밀번호일치여부)
	$.ajax({
		url : "/jspweb/VisitLogController" , // 통신할 백엔드(컨트롤러 서블릿 주소)
		method : "put" ,
		data : { vno : vno , vcontent : vcontent ,  vpwd : vpwd } ,
		success : function f(r){ console.log("doPut통신성공"); 
			if( r == true ){ alert('수정성공'); vread(); }
			else{ alert('[수정실패] 비밀번호가 일치하지 않습니다. '); }
		} ,
		error  : function f(r){ console.log(r); } 
	})
}// vupdate e

// D (삭제)
function vdelete( vno ){ //-----------------------------------------------
	// 1. 비밀번호가 일치할 경우에 수정하므로 확인용 비밀번호 입력받기
	let vpwd = prompt("방문록비밀번호 : ");
	// 삭제 준비물 : vno(누구를) , vpwd(조건용:비밀번호일치여부)
	$.ajax({
		url : "/jspweb/VisitLogController" , 
		method : "delete" ,
		data : { vno : vno ,  vpwd : vpwd } ,
		success : function f(r){ console.log("doDelete통신성공"); 
			if( r == true ){ alert('삭제성공'); vread(); }
			else{ alert('[삭제실패] 비밀번호가 일치하지 않습니다. '); }
		} ,
		error  : function f(r){ console.log(r); } 
	})
}// vdelete e