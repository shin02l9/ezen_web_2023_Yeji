
console.log(' P list JS 실행')




 var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
        level : 14 // 지도의 확대 레벨
    });

    // 마커 클러스터러를 생성합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
    // 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
    // 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
    // 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });


    // 마커 클러스터러에 클릭이벤트를 등록합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;

        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });
    


// 1. 현재 보고 있는 지도에 동서남북 좌표 얻기 ---------------------------------------------------------------
getInfo();
function getInfo() {

    // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds(); // 남 서 북 동 순으로 저장
    console.log('bounds' + bounds);
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    console.log('swLatLng' + swLatLng);
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    console.log('neLatLng' + neLatLng);
    // 영역정보를 문자열로 얻어옵니다. ((남,서), (북,동)) 형식입니다
    var boundsStr = bounds.toString();
    console.log('boundsStr' + boundsStr);
    
    
    let 동 = map.getBounds().pa; // 동
    let 서 = map.getBounds().qa; // 서
    let 남 = map.getBounds().ha; // 남 
    let 북 = map.getBounds().oa; // 북 
    
    console.log( '동 : '+동)
    console.log( '서 : '+서)
    console.log( '남 : '+남)
    console.log( '북 : '+북)
    
    findByLatLng(동, 서 , 남, 북)
}

// 2. 현재 좌표에 해당하는 제품을 좌표 범위내출력하기 ---------------------------------------------------------------

function findByLatLng(e,w,s,n) {
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method: "get" ,
		async : false, 
		data : { type : 2, east : e, west : w, south : s, north : n } ,
		success : jsonArray => { console.log( jsonArray ); 
		var markers = jsonArray.map( (p) => {
	        return new kakao.maps.Marker({
	            position : new kakao.maps.LatLng( p.plat, p.plng )
	        });
	    });
		clusterer.addMarkers(markers);
		}
	})
}

// 3. 카카오 지도에서 드래그를하고 끝났을때 다시 동서남북 구하기
kakao.maps.event.addListener(map, 'dragend', function() {
	getInfo();
	
    // do something
});















