package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.HrmDAO;
import model.dao.MemberDAO;
import model.dto.HrmDTO;
import model.dto.MemberDTO;


@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HrmController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadpath = request.getServletContext().getRealPath("/member/img");
   		System.out.println( "member 폴더 img 폴더 실제(서버) 경로 : " + uploadpath ); 
   		MultipartRequest multi = new MultipartRequest(
					request , 		// 1. HttpServletRequest 요청방식 
					uploadpath , 	// 2. 첨부파일을 저장할 폴더 경로 
					1024*1024*10,	// 3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB
					"UTF-8" , 		// 4. 한글인코딩타입 
					new DefaultFileRenamePolicy()	// 5. [파일명중복제거] 만약에 서버내 첨부파일의 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙이기 
					);
   		String himg =  multi.getParameter("himg");			
   		String hname =  multi.getParameter("hname");		
   		String hphone =  multi.getParameter("hphone");			
   		String hposition =  multi.getFilesystemName("hposition");		
   		
   		System.out.println("himg : "  + himg);
   		System.out.println("hname : "  + hname);
   		System.out.println("hphone : "  + hphone);
   		System.out.println("hposition : "  + hposition);
   		
   		if( himg == null ) {himg = "default.webp";}
   		HrmDTO HrmDto = new HrmDTO(himg, hname, hphone, hposition);
   		boolean result = HrmDAO.getInstance().registerSQL(HrmDto);
   		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
