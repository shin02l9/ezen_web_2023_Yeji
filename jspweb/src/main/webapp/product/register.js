
console.log('register JS 실행')

// 6. 카카오 지도 표시하기 ---------------------------------------------------
// 현재 접속한 사용자의 위치 좌표 구하기 
navigator.geolocation.getCurrentPosition( e =>{
	console.log(e);
	console.log(e.coords);
	console.log(e.coords.latitude);		// 위도
	console.log(e.coords.longitude);	// 경도
	let lat = e.coords.latitude
	let lon = e.coords.longitude

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(lat, lon), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 지도를 클릭한 위치에 표출할 마커입니다
	var marker = new kakao.maps.Marker({ 
	    // 지도 중심좌표에 마커를 생성합니다 
	    position: map.getCenter() 
	}); 
	// 지도에 마커를 표시합니다
	marker.setMap(map);
	
	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
	    
	    // 클릭한 위도, 경도 정보를 가져옵니다 
	    var latlng = mouseEvent.latLng; 
	    
	    // 마커 위치를 클릭한 위치로 옮깁니다
	    marker.setPosition(latlng);
	    
	    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
	    message += '경도는 ' + latlng.getLng() + ' 입니다';
	    
	    var resultDiv = document.getElementById('clickLatlng'); 
	    resultDiv.innerHTML = message;
	    
	    현재위도 = latlng.getLat();
	    현재경도 = latlng.getLng();
	    
	});

})

// 현재 지도에서 선택한 좌표
let 현재위도 = 0;	
let 현재경도 = 0;



// 1. 제품 등록
function onRegister(){
	// 1. form DOM 객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0];
	console.log('registerForm : '+registerForm)
	
	// 2. formData 객체 생성 multipart/form-data 	: 대용량 form 전송타입
	let formData = new FormData( registerForm );
	console.log('formData : '+formData)
	
		//**** 카카오 지도에서 선택된 자표 사용 했을때 
		if( 현재위도 == 0 || 현재경도 == 0){alert('제품 위치를 선택해주세요.'); return;}
		console.log(현재위도)
		console.log(현재경도)
			formData.set( 'plat', 현재위도 )
			formData.set( 'plng', 현재경도 )
	
	
	// 만약 드래그엔 드랍을 사용 했을때
	// 드랍된 파일들을 form 같이 추가하기 [ 왜? 드랍된 파일은 imput태그로 올라온 파일이 아니기 때문 ]
		if( fileList.length >= 1 ){
			fileList.forEach( f =>{
				// formData.set( 'fileList ', f );
				// 폼데이터객체.set( '키/필드명/속성명', 값 ); 	: 만약에 동일한 키가 있으면 중복이 안되서 덮어씌우기로 들어간다. 그래서 기존꺼가 사라짐.
				formData.append( 'fileList ', f )
				// 폼데이터객체.append( '키/필드명/속성명', 값 );	: 만약에 동일한 키가 있어도 덮어쓰기가 아니라 기존 데이터에 추가로 들어감 ! LIST 로 들어가는 것임.
				// formData.delete(' 키 ');					: 폼데이터 객체 내에 데이터 삭제
			
			})
			
		}

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

// 2. 드래그 엔 드랍
	// 1. 드래그엔 드랍할 DOM 객체 호출
let fileDropBox = document.querySelector('.fileDropBox');
	// 2. 드래그가 들어왔을때
fileDropBox.addEventListener( "dragenter", (e) =>{
	console.log(e)
	console.log('드래그가 들어왔어.')	
	e.preventDefault();
})
	// 3. 드래그가 올라왔을때
fileDropBox.addEventListener( "dragover", (e) =>{
	console.log(e)
	console.log('드래그가 올라와서 위치중이야.')	
	fileDropBox.style.backgroundColor = '#e8e8e8';
	e.preventDefault();
})
	// 4. 드래그가 나갔을때
fileDropBox.addEventListener( "dragleave", (e) =>{
	console.log(e)
	console.log('드래그가 나갔어.')	
	fileDropBox.style.backgroundColor = '#ffffff';
	e.preventDefault();
})
	// 5. 드랍했을때
fileDropBox.addEventListener( "drop", (e) =>{
	console.log(e)
	console.log('드랍했어.')	
	fileDropBox.style.backgroundColor = '#ffffff';
	// *** 브라우저에 있는 드랍 이벤트가 우선적으로 실행되므로 이 이벤트가 실행되지 않는다.
	// 그래서 막아야함 !@!!!
	e.preventDefault(); //상위 이벤트를 무시하고 현 이벤트를 우선 점유 해줌
	
	
	//----------- 드랍된 파일의 정보 ------------//
	// 1. 드랍된 데이터의 정보를 이벤트 결과에서 찾기
	console.log( e.dataTransfer )
	console.log( e.dataTransfer.files )

	let files = e.dataTransfer.files;
	
	for( let i = 0; i < files.length; i++){
		// 드랍된 파일의 정보가 존재하면 !!!!
		if( files[i] != null && i< files[i] != undefined ){
			fileList.push( files[i] );
		}
	}
	
	fileListPrint();
	
})


let fileList  = []; // 현재 드래그앤드랍으로 등록된 파일들
// 3. 현재 드랍된 파일들의 정보를 구역에 표시하는 함수
function fileListPrint(){
   // 1. [어디에] fileDropBox에 [ fileDropBox dom 객체가 함수밖에 존재하므로 재호출 X]
   
   // 2. [무엇을] HTML 구성
   let html = ``;
      fileList.forEach(( f, i ) => {
		  let fname = f.name; // 파일의 이름
		  let fsize = ( f.size/1024 ).toFixed(1) // 파일의 용량
		  							// .toFixed(소수점단위) : 소수점 자르기							
		  html += `<div>
					<span> ${fname} </span>
					<span> ${fsize} </span>
					<span> <button onclick="fileDelete(${i})" type="button"> 삭제 </button></span>
				  </div>`;					
		  							
	  })
   // 3. [대입]
   fileDropBox.innerHTML = html;
}


function fileDelete( i ){
	fileList.splice(i, 1);
	fileListPrint() // 새로고침
}

/*

	DOM 객체에 이벤트를 추가하는 방법은 2가지가 있다.
		 특정 구역에 onclick 이벤트 주기
		1. <button onclick="onRegister()" > 
		 클래스명을 이용해서 DOM객체를 가져오고 
		2. let button = document.querySelector('.button');
		   button.addEventListener("onclick", 함수);

	이벤트 
		종류 : click, keyup, keydown, drop 등등등
		- 정의 특정 조건을 충족하면 


	드래그엔 드랍 관련 이벤트
		1. dragenter
		2. dragover
		3. dragleave
		4. drop

*/









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