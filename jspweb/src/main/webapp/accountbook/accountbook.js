console.log (' JS 도착')


R()

// 등록 -----------------------------------------------
function C(){
	let content = document.querySelector('.content');
	let price = document.querySelector('.price');
	let date = document.querySelector('.date');
	
	let data = {
		content : content.value ,
		price : price.value ,
		date : date.value	
	}
	
	if( content.value == null || price.value == null || date.value == null){
		alert('[ 값을 모두 입력해 주세요. ]');
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
	
}



// 수정 -----------------------------------------------
function U(){
	
}



// 삭제 -----------------------------------------------
function D(){
	
}