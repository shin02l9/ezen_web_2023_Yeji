
// 1. 최신 상품 출력하는 함수 
function printNewProduct( count ){
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method: "get" ,
		data : { type : 1 , count : count} ,
		success : r => { console.log(r)
		}
	})
}

// 2. 현재 좌표 근처 상품 출력하는 함수
function printNearbyProduct(e, w, s, n){
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method: "get" ,
		data : { type : 2, east : e, west : w, south : s, north : n } ,
		success : r => { console.log(r)
		} 
	})
}

// 3. 선택된 상품의 상세 정보 출력하는 함수
function printOneProduct(){
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method: "get" ,
		data : { type : 3, ProductNo : 1 } ,
		success : r => { console.log(r) 
		}
	})
}

// 4. 관리자 모드에서 모든 상품 출력하는 함수
function printAllProduct(){
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method: "get" ,
		data : { type : 4, } ,
		success : r => { console.log(r) 
		}
	})
}



