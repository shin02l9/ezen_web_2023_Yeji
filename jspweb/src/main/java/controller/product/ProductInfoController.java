package controller.product;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.ProductDAO;
import model.dto.MemberDTO;
import model.dto.ProductDTO;


@WebServlet("/ProductInfoController")
public class ProductInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductInfoController() {super();}

    
 // 1. 제품 등록 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       // * commons.jar 이용한 업로드 구현 
       // commons-io.jar ,  commons-fileupload.jar 빌드 필요!!
    	
    	
       
       // 1. 저장경로 [ 첨부파일이 저장될 폴더 위치 ] 
       String uploadPath = request.getServletContext().getRealPath("/product/img");
       
       // 2. 파일아이템저장소 객체 : 업로드할 옵션  [ import org.apache.commons.fileupload.FileItem; ]
       DiskFileItemFactory itemFactory = new DiskFileItemFactory();
       itemFactory.setRepository( new File( uploadPath ) );   //  2.저장위치 [ File타입 ] 
       itemFactory.setSizeThreshold( 1024 * 1024 * 1024 );    //  3.용량
       itemFactory.setDefaultCharset("UTF-8");               // 4.한글인코딩
       
       // 3. 파일 업로드 객체 [ import org.apache.commons.fileupload.servlet.ServletFileUpload; ] 
       ServletFileUpload fileUpload = new ServletFileUpload( itemFactory );
       
       // 4. 파일 업로드 요청[ 요청방식 : request ] 
       try {
          
          Map< Integer , String > imgList = new HashMap<>(); // 업로드된 파일명 들을 저장하기 위한 map컬렉션
          
             // form전송시 input/select/textarea 등 태그의 모든 데이터 한번에 요청해서 결과를 List 반환 
          List< FileItem > fileList = fileUpload.parseRequest( request );
             // FileItem : 각 요청한 데이터 
          // 5. 업로드 실행 
          int i = 0;
          for( FileItem item : fileList ) { // 요청한 input 들의 데이터를 반복문으로 하나씩 꺼내기.
             // 1. 일반 필드 [ isFormField() : 만약에 일반폼필드이면 true / 아니고 첨부파일필드이면 false  ] 
             if( item.isFormField() ) { System.out.println( item.getString() ); } // .getString() : 해당 요청 input의 value 호출 
             else { // 2. file 필드
                // 만약에 파일 필드이면 업로드 진행
                   System.out.println( "업로드할 파일명 : " + item.getName() ); // .getName()
                // 6.업로드 경로 + 파일명 [ 조합 ] 
                   
                   // 파일명에 중복이 있을때 식별을 해줘야함
                   UUID uuid = UUID.randomUUID();
                   // UUID 클래스 : 고유성을 보장하는 ID를 만들기 위한 식별자 표준 규약
                   String filename = uuid+"-"+item.getName().replaceAll("-", "_");
                   													// 만약에 파일명에 하이폰이 존재하면 언더바로 바꿈
                   													// 하이폰으로 식별을 하기 떄문에 사용자가 넣은건 수정해야함
                   
                File fileUploadPath = new File( uploadPath +"/"+filename ) ;
                
                   System.out.println( "업로드경로와 파일명이 조합된 경로 : " + fileUploadPath );
                item.write( fileUploadPath ); // .write("저장할경로[파일명포함]") 파일 업로드할 경로를 file타입으로 제공 
                // 7. 업로드 된 파일명을 Map에 저장 [ -DB에 저장할려고  ]
                i++;
                imgList.put( i , filename ); // 저장시 에는 이미지번호가 필요 없음
             }
          }
          
          
          
       // 제품 등록한 회원번호 [ 서블릿 세션 ] 
		Object object = request.getSession().getAttribute("logindto");
		System.out.println("object : ");
		System.out.println(object);
		MemberDTO memberDto = (MemberDTO)object;
		int mno = memberDto.getMno();
       			
          // FileItem 으로 가져온 데이터들을 각 필드에 맞춰서 제품Dto 에 저장하기 
          ProductDTO productDto = new ProductDTO(
        		  		Integer.parseInt( fileList.get(0).getString() ), 
                		fileList.get(1).getString(),  
                		fileList.get(2).getString(), 
                		Integer.parseInt( fileList.get(3).getString() ), 
                		fileList.get(4).getString(), 
                		fileList.get(5).getString(), 
                		mno, 
                		imgList );
          
          System.out.println( productDto );
          // Dto를 Dao처리 
   			boolean result = ProductDAO.getinstance().register(productDto);
   			
   			//
   			response.setContentType("application/json;charset=utf-8");
   			response.getWriter().print(result);
       }catch (Exception e) { System.out.println(e );}
 		
 		
 	
 		
 		
 		
 		
 		
 		/* MultipartRequest multi = new MultipartRequest(
 				request, 
 				request.getServletContext().getRealPath("/product/img"),
 				1024*1024*1024,
 				"UTF-8",
 				new DefaultFileRenamePolicy()
 				);
 		System.out.println(" [ 저장 파일 경로 확인 하기 ] \n"
 				+ request.getServletContext().getRealPath("/product/img"));
 		
 		String pcno = multi.getParameter("pcno");
 		String pname = multi.getParameter("pname");
 		String pcontent = multi.getParameter("pcontent");
 		String pprice = multi.getParameter("pprice");
 			// 만약에 첨부파일 여러개 이면 여러개 호출하기 
 			// .getFilesystemName 은 하나의 파일만 가져오는게 가능함
 			// .getFileNames를 사용해야함 ! 타입은 Enumeration
 		Enumeration pimg = multi.getFileNames();*/


 		
 	}
 	// 2. 제품 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type"));
		System.out.println("type : "+type);
		String json ="";
		ObjectMapper mapper = new ObjectMapper();
		List< ProductDTO > list = null;
		
		
		if( type == 1 ){ // 메인에 10개의 상품 출력
			int count = Integer.parseInt(request.getParameter("count"));
			list = ProductDAO.getinstance().findByTop(count);
			json = mapper.writeValueAsString(list);
			
		} else if ( type == 2 ){ // 카카오지도로 좌표 범위내 포함된 상품 출력
			String east = request.getParameter("east");
			String west = request.getParameter("west");
			String south = request.getParameter("south");
			String north = request.getParameter("north");
			list = ProductDAO.getinstance().findByLatLng(east, west, south, north);
			json = mapper.writeValueAsString(list);
			
		} else if ( type == 3 ){ // 선택된 상품의 개별출력
			int pno = Integer.parseInt(request.getParameter("pno"));
			ProductDTO dto = ProductDAO.getinstance().findByPno(pno);
			json = mapper.writeValueAsString(dto);
			
		} else if ( type == 4 ){ // 관리자 입장에서 상품 모두 출력
			list = ProductDAO.getinstance().findByAll();
			json = mapper.writeValueAsString(list);
		}
		
		
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(json);
		
	
	}
	// 3. 제품 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	// 4. 제품 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
