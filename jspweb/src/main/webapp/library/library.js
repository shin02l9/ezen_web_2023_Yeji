

let sno = 0;



function seat(i){
	sno = i;
}

function changeStyle(button) {
  button.classList.toggle("changed");
}

function D(){
	console.log('퇴실하기 로직 입장')
	
	 $.ajax({
	   url : "/jspweb/Library",
	   method : "get",
	   data : {sno : sno} ,
	   success : function f(r){
		   console.log('퇴실하기 로직 JAVA와 통신성공01')
		   console.log(r)
	   }
	});
	
	
	let nameInput = document.querySelector('.nameInput').value;
	let phoneInput = document.querySelector('.phoneInput').value;
		let data = {
		sno : sno,
		sname : nameInput,
		sphone : phoneInput
		}
	if( phoneInput == r){
		$.ajax({
			url : "/jspweb/Library",
			method : "put",
			data : data ,
			success : function f(r){
				console.log('퇴실하기 로직 JAVA와 통신성공02')
				console.log(r)
			} ,
			error : function f(r){}
		})
	}
	
	sno = 0;
}




