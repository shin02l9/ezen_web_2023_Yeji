console.log(' hrm JS 연결')


printTable();

// 첨부파일에 등록된 사진을 HTML 표시하기 < 등록 사진을 미리보기 기능 >
function preimg( o ){
	let file = new FileReader(); 
	file.readAsDataURL( o.files[0] ); 
	file.onload = e => { 
		document.querySelector('.preimg').src = e.target.result; 
	} 
} // f end 


// 유효성 검사 하직 안해서 true값 넣어두기
let checkList = [ true , true , true ]
function register(){
	// 1. checkList 에 저장된 논리가 모두 true 이면 
	if( checkList[0] && checkList[1] && checkList[2] ){  
		console.log('직원등록 진행가능');
		
		
		// 2. 입력받은 데이터를 한번에 가져오기 form 태그 이용 
			// <form> 각종 input/button </from>
			// 1. form 객체 호출  document.querySelectorAll( 폼태그식별자 )
			let registerEmployeeForm = document.querySelectorAll('.registerEmployeeForm')[0];
				console.log( registerEmployeeForm );
			// 2. form 데이터 객체화
				// 일반객체로 첨부파일 전송X -> FormData객체 이용시 첨부파일 전송 가능 
			let registerData = new FormData( registerEmployeeForm ); // 첨부파일 [ 대용량 ] 시 필수..
				console.log( registerData );
			// 3. AJAX 에게 첨부파일[대용량] 전송 하기 
				// 2. 첨부파일 있을때. [ 기존 json형식의 전송x form객체 전송 타입으로 변환 ]
				$.ajax({
					url : "/jspweb/HrmController" , 
					method: "post" ,			// 첨부파일 form 전송은 무조건 post 방식 
					data : registerData ,		// FormData 객체를 전송 
					contentType : false ,
					processData : false ,
					success : r => { 
						if(r){
							alert('직원등록 성공')
							printTable();
						} else { 
							alert('직원등록 실패')
						}
					 } ,
					error : e => { console.log(e) } ,
				})
	}else{
		console.log('정상적으로 입력 안된 내용이 있습니다.');
	}
} // f end 

function printTable(){
	console.log('printTable() 실행')
	$.ajax( { 
       url : "/jspweb/HrmController",
       data : {},  
       method : "get",
       success : r =>{
      		let html = ``;
      		for(let i =0; i < r.length; i++){
				  html += 
				  `<tr>
						<td><img class="employeeImg" src="/jspweb/hrm/img/${r[i].himg}"></td>
						<td>${r[i].hname}</td>
						<td>${r[i].hphone}</td>
						<td>${r[i].hposition}</td>
						<td>${r[i].hdate}</td>
				  </tr>`;
			  }
			  document.querySelector('.tableB').innerHTML = html;	
		},
       	error : e=>{console.log(e)}
     });
}