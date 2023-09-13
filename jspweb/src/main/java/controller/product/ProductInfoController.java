package controller.product;


import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dto.ProductDTO;


@WebServlet("/ProductInfoController")
public class ProductInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductInfoController() {super();}

    
    // 1. 제품 등록 
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		System.out.println(" doPost 통신 ");
 		
 		// commons-io.jar 이용한 업로드 구현
 		// commons-io.jar , commons-fileupload.jar 빌드 필요
 		
 		// 1. 저장 경로 
 		String uploadPath = request.getServletContext().getRealPath("/product/img");
 		
 		// 2. 파일 아이템 저장소 객체
 		DiskFileItemFactory factory = new DiskFileItemFactory();
 		factory.setRepository( new File(uploadPath) );				// 2. 저장위치
 		factory.setSizeThreshold( 1024*1024*1024 );					// 3. 용량
 		factory.setDefaultCharset("UTF-8");							// 4. 한글인코딩
 		
 		
 		// 옵션 : 1. 요청방식, 2. 저장위치, 3. 용량, 4. 한글인코딩, 5. 파일명중복일때
 		
 		// 3. 파일 업로드 객체
 		ServletFileUpload fileUpload = new ServletFileUpload(factory);
 		
 		// 4. 파일 업로드 요청 [ 요청 방식 : request ]
 		try {
 		
			List<FileItem> filelist = fileUpload.parseRequest(request);
			// 5. 업로드 실행
			int i = 0;
			for( FileItem item : filelist ) { 
				
				// 1. 일반 필드 [isFormField() : 만약에 일반 폼필드이면 true / 첨부파일 필드이면 false 반환 ]
				if( item.isFormField() ) {
					System.out.println( item.getString() );
				}
				// 2. file 필드
				else{
					// 6. 
					// 파일 업로드할 경로를 file 타입으로 제공
					System.out.println( "업로드할 파일명 : " + item.getName());
					item.write( new File(uploadPath + item.getName()) );
					i++;
					
				}
				
				
//				System.out.println( item.getString() );
//				item.write( new File(uploadPath+"/업로드파일명"));
			}
			
			ProductDTO dto = new ProductDTO
					(   Integer.parseInt(filelist.get(0).getString()), 
						filelist.get(1).getString(), 
						filelist.get(2).getString(), 
						Integer.parseInt(filelist.get(3).getString()), 
						null, null, 
						0, 
						null);
 			
		} catch (Exception e) { e.printStackTrace(); }
 		
 		
 	
 		
 		
 		
 		
 		
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

	}
	// 3. 제품 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	// 4. 제품 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
