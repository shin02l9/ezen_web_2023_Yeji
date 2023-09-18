package model.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

import model.dto.ProductDTO;

public class ProductDAO extends DAO{
	// 싱글톤
	private static  ProductDAO productDAO = new ProductDAO();
	private ProductDAO() {}
	public static ProductDAO getinstance() { return productDAO; }
	

	// 1. 제품 등록
	public boolean register( ProductDTO dto ) {
		System.out.println("register DAO 입장");
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
			System.out.println( "count :"+count );
			
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
	
		// 0. 이미지 출력하는 함수
	public Map< Integer , String > getProductImg( int pno ){ // * 이미지테이블에서 현재 레코드의 제품 번호에 해당하는 (여러개)이미지 출력해서 map객체 담기 
		try {
			Map< Integer , String > imglist = new HashMap<>(); // 제품별 여러개 이미지 
			String sql = "select * from productimg where pno = "+pno; 
			PreparedStatement ps = conn.prepareStatement(sql);// * 다른 함수에서 먼저 사용중인 rs 인터페이스 객체 가 사용중 이므로 [ while ] 중복 사용불가능  // 해결방안 새로운 rs 만들기 ( PreparedStatement , ResultSet 2개 사용 )
			ResultSet rs =  ps.executeQuery();
			while(rs.next() ) { imglist.put( rs.getInt("pimgno"), rs.getString("pimg") ); } return imglist;
		}catch (Exception e) { System.out.println(e); } return null;
	}
	
	// 3. 선택된 제품번호에 해당하는 제품 출력 함수 
	public ProductDTO findByPno( int pno ){ 
		try { 
			String sql ="select * from product p natural join pcategory pc natural join membertable m where p.pno="+pno;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				ProductDTO productDto = new ProductDTO(
						rs.getInt("pcno") , rs.getString("pcname"),rs.getInt("pno"), rs.getString("pname"),
						rs.getString("pcontent"), rs.getInt("pprice"), rs.getInt("pstate"), rs.getString("pdate"),
						rs.getString("plat"), rs.getString("plng"),  rs.getInt("mno"), getProductImg( rs.getInt("pno") ), 
						rs.getString("mid") );
				return productDto;
			}
		} catch (Exception e) { System.out.println(e);} return null; 
	}
	
		// 2-1. 메인에 상품 10개 출력
	public List<ProductDTO> findByTop( int count ){ 
		System.out.println("findByTop DAO 입장");
		List<ProductDTO> list = new ArrayList<>();
		try { 
			String sql = "select * from product order by pdate desc limit "+count;
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery();
			while( rs.next() ) {  
				list.add( findByPno( rs.getInt("pno") ) ); 	
			} System.out.println("list : " + list); 
			return list;
		} catch (Exception e) { System.out.println(e); } 
		return null; 
	}
	
	
		// 2-2. 카카오 지도로 좌표 범위내 포함된 상품 출력
	public List< ProductDTO > findByLatLng(String e, String w, String s, String n){
		try {// 동 경도보다 작고 서 경도보다 크고 남 위도보다 작고 북 위도보다 크고 
			List<ProductDTO> list = new ArrayList<>();
			String sql = "select * from product where plat <= ? and plat >= ? and plng >= ? and plng <= ?";
			ps = conn.prepareStatement(sql); 
			ps.setString(1, e);
			ps.setString(2, w);
			ps.setString(3, s);
			ps.setString(4, n);
			rs = ps.executeQuery();
			
			while( rs.next() ) {  
				list.add( findByPno( rs.getInt("pno") ) ); 	
			} 
			
			System.out.println("list : "+list);
			
			return list;
		} catch ( Exception ex ) { System.out.println(ex);}
		return null;
	}
		// 2-3. 관리자 입장에서 상품 모두 출력
	public List< ProductDTO > findByAll(){
		try {
			List<ProductDTO> list = new ArrayList<>();
			String sql ="select * from product"; ps = conn.prepareStatement(sql); rs = ps.executeQuery();
			while( rs.next() ) {  
				list.add( findByPno( rs.getInt("pno") ) ); 	
				
			} return list; 
			
		} catch ( Exception e ) { System.out.println(e);}
		return null;
	}

	
	// 4. 제품 수정
	
	// 5. 제품 삭제 
	
	
	
	
}
