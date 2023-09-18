
console.log('index JS 실행')


printNewProduct(3)
// 1. 최신 상품 출력하는 함수 
function printNewProduct( count ){
	console.log('printNewProduct() 실행')
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method: "get" ,
		data : { type : 1 , count : count } ,
		success : r => { 
			console.log(r)
			
			let productBox = document.querySelector('.productBox');
			let HTML = ``;
				
				r.forEach( (p) => {
					// 대표 이미지 출력하기 [ 첫번쨰 이미지 ] Object.keys(객체명)
					console.log('p.imgList : ')
					console.log(p.imgList)
					console.log('Object.keys(p.imglist) : ')
					console.log(Object.keys(p.imgList))
					
					let fristimg =  p.imgList[Object.keys(p.imgList)[0]];
					
					console.log('fristimg : ')
					console.log(fristimg)
					
					HTML += ` <div class="col">
							    <div class="card">
							      <img src="/jspweb/img/C1.gif" class="card-img-top" alt="...">
							      <div class="card-body">
							        <h5 class="card-title"> ${p.pname} </h5>
							        <p class="card-text">
								       	<div> ${p.pcontent} </div>
								       	<div> ${p.pprice.toLocaleString()} </div>
							        </p>
							      </div>
							    </div>
							  </div>`;
				});
			productBox.innerHTML = HTML;
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
function printOneProduct(pno){
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method: "get" ,
		data : { type : 3, pno : 1 } ,
		success : r => { console.log(r) 
		console.log(r)
		}
	})
}


// 4. 관리자 모드에서 모든 상품 출력하는 함수
function printAllProduct(){
	$.ajax({
		url : "/jspweb/ProductInfoController" ,
		method: "get" ,
		data : { type : 4 } ,
		success : r => { console.log(r) 
		}
	})
}



