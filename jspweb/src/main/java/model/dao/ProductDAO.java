package model.dao;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import model.dto.ProductDTO;

public class ProductDAO extends DAO{
	// 싱글톤
	private static  ProductDAO productDAO = new ProductDAO();
	private ProductDAO() {}
	public static ProductDAO getinstance() { return productDAO; }
	

	// 1. 제품 등록
	public boolean register( ProductDTO dto ) {
		
		// 1-1 [제품 등록] 
		try {
			
			String sql = "insert into product( pcno , pname , pcontent , pprice , plat , plng , mno  ) "
					+ "	values( ? , ? , ? , ? , ? , ? , ?  );";
			// * sql insert 후 자동생성[auto_increment]된 pk번호를 반환하는 방법 
				// conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS ) 	: 생성된 식별키를 반환
				// ps.getGeneratedKeys() 											: 식별키 반환하는 함수.
			ps = conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS ); 
			
			ps.setInt( 1 , dto.getPcno()  );		ps.setString( 2 , dto.getPname() );
			ps.setString( 3 , dto.getPcontent() );	ps.setInt( 4 , dto.getPprice() );
			ps.setString( 5 , dto.getPlat() );		ps.setString( 6 , dto.getPlng() );
			ps.setInt( 7 , dto.getMno() );
			
			int count = ps.executeUpdate();	// 제품 등록 
			
			rs = ps.getGeneratedKeys(); // 제품 등록시 생성된 식별키[pk -> pno] 반환해서 resultset[ps]에 대입
			if( rs.next() ) {	// resultset  null ---next()--> 결과레코드1 --next()--> 결과레코드2 
							// 반환된 결과레코드로 1번 이동 [ 하나의 제품 식별키 필요 ]
				if( count == 1 ) { // 만약에 제품등록 1개 등록했으면 
					// 1-2 제품 등록후 생성된 제품pk를 가지고 [이미지 등록] 
						// 1. dto 에 저장된 이미지 개수만큼 insert 실행 
					for( String img : dto.getImgList().values() ) {
						sql = "insert into productimg( pimg , pno ) values( ? , ? )";
						ps = conn.prepareStatement(sql);
						ps.setString( 1 , img  );
						ps.setInt( 2 , rs.getInt( 1 ) ); //위에서 insert 된 제품번호 
						ps.executeUpdate();
					} 
					return true; // 제품등록과 이미지 등록 성공 했을때. 
				}
			}
			
		}catch (Exception e) { System.out.println( e ); } return false;
	}
	
	
	// 2. 제품 전체 출력
		// 2-1. 메인에 상품 10개 출력
	public ArrayList< ProductDTO > printNewProduct( int count ){
		
		return null;
	}
		// 2-2. 카카오 지도로 좌표 범위내 포함된 상품 출력
	public ArrayList< ProductDTO > printNearbyProduct(String e, String w, String s, String n){
		
		return null;
	}
		// 2-3. 관리자 입장에서 상품 모두 출력
	public ArrayList< ProductDTO > printAllProduct( int pno ){
		
		return null;
	}
	
	// 3. 제품 개별 출력
	public ProductDTO printOneProduct(){
		
		return null;
	}
	
	
	
	
	
	// 4. 제품 수정
	
	// 5. 제품 삭제 
	
	
	
	
}
