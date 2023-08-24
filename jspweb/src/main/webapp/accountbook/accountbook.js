console.log (' JS 도착')


R()

// 등록 -----------------------------------------------
function C(){
	let content = document.querySelector('.contentInput');
	let price = document.querySelector('.priceInput');
	let date = document.querySelector('.dateInput');
	
	let data = {
		content : content.value ,
		price : price.value ,
		date : date.value	
	}
	
	if( content.value == "" || price.value == "" || date.value == ""){
		alert('[ 공백을 모두 입력해 주세요. ]');
	} else { 
		$.ajax({
		url : "/jspweb/Accountbook",
		data : data,
		method : "post",
		success : function f(r){
			if(r == true){
				alert('[ 등록 성공 ]');
				R();
				content.value = '';
				price.value = '';
				date.value = '';
			}else{
				alert('[ 등록 실패 ]')
			}
		 }
		});	

	}
	
}


// 출력 -----------------------------------------------
function R(){
	$.ajax({
		url : "/jspweb/Accountbook",
		method : "get",
		success : function f(r){
			console.log(r)
				let HTML=`
				<tr class="title"> <!-- 제목 행 --> 
					<th class="title01"> 내용 </th> 
					<th class="title01"> 가격 </th> 
					<th class="title01"> 날짜 </th> 
					<th class="title01">  </th>
				</tr>`;
				for(let i = 0; i < r.length; i++){
					HTML += `
					<tr class="printValue">
						<th class="title02"> ${r[i].content} </th> 
						<th class="title02"> ${r[i].price} </th> 
						<th class="title02"> ${r[i].date} </th> 
						<th class="title02"> 
							<button onclick="U(${r[i].no})" class="btnU" type="button"> 수정 </button> 
							<button onclick="D(${r[i].no})" class="btnD" type="button"> 삭제 </button> 
						</th>
					</tr>`;
				}
			document.querySelector('.printTable').innerHTML = HTML;
		 }
	});	
}


// 수정 -----------------------------------------------
function U( bno ){
	let content = prompt('수정할 내용');
	let price = prompt('수정할 가격');
	let updatedata = {
		'bno': bno ,
		'content' : content ,
		'price' : price
	};
	console.log('수정함수 입장')
	
	$.ajax({
		url : "/jspweb/Accountbook",
		data : updatedata,
		method : "put",
		success : function f(r){
			if(r){
				alert('[ 수정 성공 ]'); 
				R();
			}else{
				alert('[ 수정 실패 ]')
			}
		}
	});	
}


// 삭제 -----------------------------------------------
function D( bno ){
	console.log(bno);
	$.ajax({
		url : "/jspweb/Accountbook",
		data : {bno : bno},
		method : "delete",
		success : function f(r){
			if(r){
				alert('[ 삭제 성공 ]');
				R();
			}else{
				alert('[ 삭제 실패 ]')
			}
		}
	});	
}