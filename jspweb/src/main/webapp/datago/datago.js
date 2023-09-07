/*
공공데이터 포털
https://www.data.go.kr/

원하는 데이터 선택 후 -> 활용신청 -> 인증키확인후 -> 요청 URL 확인
	$.ajax({
		url : "신청한공공데이터 Request URL",
		method : "",
		data : {} ,
		success : function f(r){
			console.log("통신성공 : "+r)
		} ,
		error : function f(e){
			console.log("통신실패 : "+e)
	}


카카오개발자센터
https://developers.kakao.com/

	1. 애플리케이션 추가
	2. 플랫폼 Web -> 사이트 도메인 등록

 */
api();
 // 1. 안산시 착한가격업소 API 호출
 function api(){
	 
	$.ajax({
		url : "https://api.odcloud.kr/api/15036759/v1/uddi:577ba1b9-b79f-4865-b31e-a9dc71ce67bc_201909231019?page=1&perPage=45&serviceKey=Acq1LtfGoUgKPk14%2Bi1%2BdXNATwfVhEJJDdlh1e9OHqLrlx5WOr65qOrIDr2hHsO2YnQDNfG6NDvtDEU4urd1dA%3D%3D",
		method : "get",
		data : {} ,
		success : function f(r){
			//console.log(r)
			let data = r.data
			//console.log(data[0])
			//console.log(data[0].업소명)
			
			// 1. 출력할 DOM 객체 필요
			let apiTable = document.querySelector('.apiTable')
			
			// 2. HTML구성
			let HTML =``;
				// 2-2.
				// 배열명.forEach((반복변수명, 인덱스) => {실행코드})
				data.forEach( ( d, i )=>{
					HTML += `<tr>
								<td> ${i+1} </td>
								<td> ${d.업소명} </td>
								<td> ${d.소재지도로명주소} </td>
								<td> ${d.연락처} </td>				
								<td> ${d.품목1} / ${d.가격1} </td>
								<td> ${d.품목2} / ${d.가격2} </td>
								<td> ${d.품목3} / ${d.가격3} </td>
							</tr>`;
					
					
				})
			
			// 3. 출력할위치레 HTML 대입
			apiTable.innerHTML = HTML;
			
		} ,
		error : function f(e){
			//console.log("통신실패 : "+e)
	}
	})
 }
 
 
 
 // ------------------------------1. 카카오 지도를 출력하는 객체
 var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
    level : 14 // 지도의 확대 레벨
});

 // ------------- 마커 이미지 설정
	// 마커 이미지의 주소
	var markerImageUrl = '/jspweb/img/번개.png', 
	    markerImageSize = new kakao.maps.Size(30, 32), // 마커 이미지의 크기
	    markerImageOptions = { 
	        offset : new kakao.maps.Point(12, 13)// 마커 좌표에 일치시킬 이미지 안의 좌표
	};
    // 마커 이미지를 생성한다
	var markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);
 
 
 // ------------------------------2. 마커 클러스터를 생성
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
    minLevel: 10, // 클러스터 할 최소 지도 레벨
    disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
});

 // ------------------------------3. 마커 클러스터에 추가 할 여러개의 마커를 생성
 // 데이터를 가져오기 위해 jQuery를 사용합니다
 // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
 // $.사용할메소드명("신청한공공데이터 Request URL", function(r) { 카카오APL 코드들})
$.get("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=Acq1LtfGoUgKPk14%2Bi1%2BdXNATwfVhEJJDdlh1e9OHqLrlx5WOr65qOrIDr2hHsO2YnQDNfG6NDvtDEU4urd1dA%3D%3D", 
function(r) {
    console.log(r)
    // 데이터에서 좌표 값을 가지고 마커를 표시합니다
    // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
    var markers = $(r.data).map(function(i, data) { // data는 반복변수명
		//console.log(r.data) : 공공데이터 응답 객체
		//console.log(i)	  : 응답 객체내에 검색된 전지차 충전소 목록/배열/리스트
		//console.log(data)	  : 반복변수명
		
		// 개별 마커 생성 후 
		let marker = new kakao.maps.Marker({
            position : new kakao.maps.LatLng(data['위도(WGS84)'], data['경도(WGS84)']),
		    image : markerImage, // 마커의 이미지
		    map: map // 마커를 표시할 지도 객체
        });
		  // 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
			kakao.maps.event.addListener(marker, 'click', function() {
			    alert('마커를 클릭했습니다!');
			    // innerHTML 삽입하기
			    let HTML = `<div> 충전소명 : ${ data.충전소명 } </div>
			    			<div> 충전기타입명 : ${ data.충전기타입명 } </div>
			    			<div> 운영기관명 : ${ data.운영기관명 } </div>
			    			<div> 소재지도로명주소 : ${ data.소재지도로명주소 } </div>
			    			`;
			    document.querySelector('.detailbox').innerHTML = HTML;
			});
			
		// 생성된 마커를 반환
        return 
    });

    // 클러스터러에 마커들을 추가합니다. 마커들이 아주 많을때 묶어주는 역할을 한다. 축소를 해서보면 마커들이 다닥다닥 붙어있으니까 
    clusterer.addMarkers(markers);
   
    
});
 

 
/*

	객체내 속성 호출
		객체명.속성명
		객체명['속성명'] : 속성명에 특수문자가 들어가는 경우 사용하는 방법
		
	- for 문 
		- 배열명 : arrayList
		
		1. 	인덱스 0부터 배열의 길이만큼 반복  
			for( let i = 0 ; i<arrayList.length ; i++ ){ } 
		
		2.  배열의 첫번재 인덱스 부터 마지막인덱스까지 반복 
			for( let 인덱스변수 in arrayList ){ } 
		
		3.  배열의 첫번째 데이터 부터 마지막 데이터까지 반복 
			for( let 반복변수 of arrayList ){ }
		
		4. 	배열의 반복변수or인덱스를 첫번째부터 마지막 반복 	[ 반환return값 x ]
			arrayList.forEach( (반복변수)=>{ } )
			arrayList.forEach( (반복변수,인덱스변수)=>{ } )
			arrayList.forEach( (반복변수,인덱스변수,배열 )=>{ } )
			
		5.  배열의 반복변수or인덱스를 첫번째부터 마지막 반복 	[ 반환값return o ] => 새로운 배열에 저장할수 있다.! 
			arrayList.map( (반복변수) =>{ } )
			arrayList.map( (반복변수,인덱스변수) =>{ } )
			arrayList.map( (반복변수,인덱스변수, 배열 )=>{ } )
			
			let returnArrays = arrayList.map( (반복변수,인덱스변수)=>{ return } )
			
		6. filter

*/

 
 let arrayList = [ 'a', 'b', 'c', 'd']
console.log('----------------------------')
 for( let i = 0; i<arrayList.length; i++ ){
	 console.log(i + arrayList[i])
 }
console.log('-----------in---------------')
 for( let data2 in arrayList) {
	  console.log(data2)
 }
console.log('-----------of---------------')
 for( let data3 of arrayList) {
	  console.log(data3)
 }
console.log('--------forEach------------')
 arrayList.forEach ( (data4) => { console.log(data4) }) 
console.log('---------forEach--------------')
 arrayList.forEach ( (data5, index ) => { console.log(data5+index) }) 
 
console.log("---------map1-----------");
arrayList.map( (data5) => { console.log( data5 ); } );

console.log("---------map2-----------");
let newArrayList = arrayList.map( (data5) => { return data5+"map"; } );
let newArrayList2 = arrayList.forEach( (data5) => { return data5+"map"; } ); // [ x ] 

console.log( arrayList );
console.log( newArrayList );
console.log( newArrayList2 );
 
 
 
 
 
 
 
 
 /*
 // 1. 접속한 브라우저에 GPS 좌표 얻기 [ geolocation ] ( 스크립트가 제공하는 것임 )
navigator.geolocation.getCurrentPosition( pos => { 
	console.log(pos)
	let lat = pos.coords.latitude;
	let lng = pos.coords.longitude;
	
	// 2. 사용자의 위치를 기준으로 카카오 지도 출력 ------------------------------------------------------
	var container = document.getElementById('map'); // 지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	
	// 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng(lat, lng); 
	
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});
	
	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
})

*/

