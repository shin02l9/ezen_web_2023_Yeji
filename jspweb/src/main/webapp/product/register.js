
console.log('register JS 실행')


// 1. 제품 등록
function onRegister(){
	// 1. form DOM 객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0];
	console.log('registerForm : '+registerForm)
	
	// 2. formData 객체 생성 multipart/form-data 	: 대용량 form 전송타입
	let formData = new FormData( registerForm );
	console.log('formData : '+formData)
	
	// 3. 서블릿과 통신
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method: "post" ,
		data :  formData,
		contentType : false ,
		processData : false ,
		success : r => { 
			console.log("통신성공 : "+r)
		} ,
		error : e => { 
			console.log("통신실패 : "+e)
		}
	})
}

















/*
// form 태그 없는 경우 ----------------------------------------------------
function register1(){
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method: "post" ,
		data : {
			pname1 : document.querySelector('.pname1'),
			pcontent1 : document.querySelector('.pcontent1')
		} ,
		success : r => { 
			console.log("통신성공 : "+r)
		} ,
		error : e => { 
			console.log("통신실패 : "+e)
		}
	})
	
}

// form 태그 있는 경우 ----------------------------------------------------
function register2(){
	
	let registerForm = document.querySelectorAll('.registerForm')[0];
	let formData = new FormData( registerForm );
	
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method: "post" ,
		data :  formData ,
		contentType : false ,
		processData : false ,
		success : r => { 
			console.log("통신성공 : "+r)
		} ,
		error : e => { 
			console.log("통신실패 : "+e)
		}
	})
	
}*/