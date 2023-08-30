package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

/**
 * Servlet implementation class MemberInfo
 */
@WebServlet("/MemberInfo")
public class MemberInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// 첨부파일 있을때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 첨부파일을 전송 했을때
			
		// 첨부파일 저장할 폴더의 절대경로
   		// 1. 개발자 pc 경로 업로드 [ 문제발생 : 개발자pc에 업로드하면 업로드파일을 서버로 빌드 ]
   		//String uploadpath ="C:\\Users\\504-t\\git\\ezen_web_2023_A\\jspweb\\src\\main\\webapp\\member\\img"; // 첨부파일 저장할 경로
   		// 2. 서버 pc 경로 업로드  [ 사용자는 바로 서버pc 업로드 ]
   		//String uploadpath ="C:\\Users\\504-t\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jspweb\\member\\img";
   		// 3. 서버 pc 경로 ( 상대경로 = 서버경로 찾아주는 함수 )
   			// 서버에 build(배포)된 파일/폴더 의 경로 찾기
   			// request.getServletContext().getRealPath("프로젝트명이하 경로");
   		String uploadpath = request.getServletContext().getRealPath("/member/img");
   			// RealPath : C:\\Users\\504-t\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jspweb\\member\\img
   			// HttpPath : http://localhost/jspweb/member/img/
   		System.out.println( "member 폴더 img 폴더 실제(서버) 경로 : " + uploadpath ); 
   		// 첨부파일 전송 했을때.
   			// 1. 첨부파일 서버PC에 업로드( COS.jar 라이브러리 ) 
   				// MultipartRequest : 파일 업로드 클래스 
   			MultipartRequest multi = new MultipartRequest(
   					request , 		// 1. HttpServletRequest 요청방식 
   					uploadpath , 	// 2. 첨부파일을 저장할 폴더 경로 
   					1024*1024*10,	// 3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB
   					"UTF-8" , 		// 4. 한글인코딩타입 
   					new DefaultFileRenamePolicy()	// 5. [파일명중복제거] 만약에 서버내 첨부파일의 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙이기 
   					);
		//---------------------------DB처리------------------------------
			// 2. form 안에 있는 각 데이터 호출
		// 일반 input : multi.getParameter("form 객체 전송시 input의 name");
		// 첨부파일 input : multi.getFilesystemName("form 객체 전송시 input의 name");
			
			
		
		// 요청하기
		// form 전송 받을 때는 input의 name 이 필요하다.
		// .getParameter("form 객체 전송시 input의 name");
		String mid = multi.getParameter("mid");
		String mpw = multi.getParameter("mpw");
		String memail = multi.getParameter("memail");
		// .getFilesystemName("form 객체 전송시 input의 name");
		String mimg = multi.getFilesystemName("mimg");
		
			System.out.println(mid);
			System.out.println(mpw);
			System.out.println(memail);
			System.out.println(mimg);
			
		// *만약에 사진업로드 안했으면 기본프로필 사용하도록 변경 = default.webp
   		if( mimg == null ) {mimg = "default.webp";}
   		
		// 받은 값 객체로 만들어서 DAO 에게 전달하고 결과 반환 받기 
		MemberDTO dto = new MemberDTO(mid,mpw,memail,mimg);
		boolean r = MemberDAO.getInstance().signupSQL(dto);
		
		// 응답하기
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(r);
		
	}
	
	/* 첨부파일 없을 때 
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { 
	 * // 요청하기 String mid =
	 * request.getParameter("mid"); String mpw = request.getParameter("mpw"); String
	 * memail = request.getParameter("memail"); String mimg =
	 * request.getParameter("mimg"); System.out.println(mid);
	 * System.out.println(mpw); System.out.println(memail);
	 * System.out.println(mimg);
	 * 
	 * // 받은 값 객체로 만들어서 DAO 에게 전달하고 결과 반환 받기 MemberDTO dto = new
	 * MemberDTO(mid,mpw,memail,mimg); boolean r =
	 * MemberDAO.getInstance().signupSQL(dto);
	 * 
	 * // 응답하기 response.setContentType("application/json;charset=UTF-8");
	 * response.getWriter().print(r);
	 * 
	 * }
	 */
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
