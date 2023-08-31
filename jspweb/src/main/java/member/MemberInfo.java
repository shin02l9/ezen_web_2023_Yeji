package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

/**
 * Servlet implementation class MemberInfoController
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
    // 1. [C] (첨부파일 있을때 form )회원가입
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
   	// ----------------------------------------------- 파일 업로드 : 서버폴더에 --------------------------------------------- //	
   		// 첨부파일 저장할 폴더의 절대경로
   			// 서버에 build(배포)된 파일/폴더 의 경로 찾기
   			// request.getServletContext().getRealPath("프로젝트명이하 경로");
   		String uploadpath = request.getServletContext().getRealPath("/member/img");
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
   			
   		// ----------------------------------------------- DB처리 : 업로드된 파일명  --------------------------------------------- //	
   			// 2. form 안에 있는 각 데이터 호출 
   		// 일반input : multi.getParameter("form객체전송시input name");		
   		// 첨부파일input : multi.getFilesystemName( );
   		String mid =  multi.getParameter("mid");			System.out.println("mid : "  + mid);
   		String mpwd =  multi.getParameter("mpwd");		System.out.println("mpwd : "  + mpwd);
   		String memail =  multi.getParameter("memail");	System.out.println("memail : "  + memail);
   		//String mimg =  multi.getParameter("mimg");		System.out.println("mimg : "  + mimg);
   		String mimg =  multi.getFilesystemName("mimg");		System.out.println("mimg : "  + mimg);
   		
   		// *만약에 사진업로드 안했으면 기본프로필 사용하도록 변경 = default.webp
   		if( mimg == null ) {mimg = "default.webp";}
   		
   		// 2. (선택) 객체화.
   		MemberDTO memberDto = new MemberDTO(mid, mpwd, memail, mimg);
   		// 2. (선택) 유효성검사.
   		
   		// 3. Dao 에게 전달하고 결과 받는다.
   		boolean result = MemberDAO.getInstance().signupSQL(memberDto);
   		
   		// 4. AJAX 통신으로 결과 데이터를 응답을 보낸다. [ response ]
   		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(result);
   		
   	}
   	/*
    // 1. [C] (첨부파일 없을때)회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. AJAX 통신받은 data객체의 '속성명' 요청한다. [ request ] 
		String mid =  request.getParameter("mid");			System.out.println("mid : "  + mid);
		String mpwd =  request.getParameter("mpwd");		System.out.println("mpwd : "  + mpwd);
		String memail =  request.getParameter("memail");	System.out.println("memail : "  + memail);
		String mimg =  request.getParameter("mimg");		System.out.println("mimg : "  + mimg);
		
		// 2. (선택) 객체화.
		MemberDto memberDto = new MemberDto(mid, mpwd, memail, mimg);
		// 2. (선택) 유효성검사.
		
		// 3. Dao 에게 전달하고 결과 받는다.
		boolean result = MemberDao.getInstance().signup(memberDto);
		
		// 4. AJAX 통신으로 결과 데이터를 응답을 보낸다. [ response ]
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	*/
	
	// 2. 회원정보 호출 / 로그아웃(세션초기화)호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청한다. [x]
		String type = request.getParameter("type");
			// 만약에
			if( type.equals("info") ) {
				//* 세션에 저장된 로그인 객체를 꺼내기
				// 1. 세션을 호출한다. [ 세션타입은 Object ]
			Object session = request.getSession().getAttribute("logindto");
					// 2. 타입변환한다.
			MemberDTO logindto = (MemberDTO)session;
			
				// dto는 js가 이해할수 없는 언어이므로 js가 이해할수 있게 js언어로 변환 [jackson 라이브러리]
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(logindto);
			
			response.setContentType("application/json;charset=UTF-8");
	   		response.getWriter().print(json);

				
			} else if ( type.equals("logout") ) {
				//* 세션에 저장된 로그인 객체를 없애기/초기화/삭제
				// 방법1 : (세션에 모든 속성) 초기화 하는 함수
				request.getSession().invalidate(); // 이건 로그인 정보 뿐만 아닐 모두 삭제...
				// 방법2 : (세션의 특정 속성) 초기화, JVM CG( 쓰레기 수집기 = 해당객체를 아무도 참조하고 있지 않으면 삭제)
				request.getSession().setAttribute("logindto", null);
			}
		// 2. 유효성/객체화 [x]
		// 3. DAO처리 [x]
		// 4. 응답한다.
		

	}



	// 3. 회원수정 
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("회원 수정하기 로직 입장");
		// ------------------------ 파일 업로드 -------------------------------------
		// multipart / form-data 전송 요청 // cos,jar [ MultipartRequest 클래스제공 ]
		MultipartRequest Multi = new MultipartRequest(
					request , 		
					request.getServletContext().getRealPath("/member/img") , 
					1024*1024*10,	
					"UTF-8" , 	
					new DefaultFileRenamePolicy()
				);
		// ------------------------ DB 처리 -------------------------------------
		// * form 전송일때는 input의 데이터 호출시
		// 일반 : Multi.getParameter("input name");
		// 첨부 :Multi.getFilesystemName("input name");
		String mimg = Multi.getFilesystemName("mimg");
		System.out.println(mimg);
		// DAO 처리 [ 로그인된 회원번호, 수정할 값 ]
		Object session = request.getSession().getAttribute("logindto");
		MemberDTO logindto = (MemberDTO)session;
		int loginMno = logindto.getMno();
		System.out.println(loginMno);
		
		
		// 만약에 수정할 첨부파일이 없다면 기존꺼 그대로 넣어야 함!
		if( mimg == null ) {
			mimg = logindto.getMimg(); // 세션에 있는 이미지 그대로 사용하기
			
		}

		boolean r = MemberDAO.getInstance().updateSQL(loginMno,mimg);
		System.out.println(r);
		// 4. 응답한다.
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(r);
		
	}

	// 4. 회원 탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청한다.
		String mpwd = request.getParameter("mpwd");
		// 2. 유효성검사/객체화
		// 3. DAO 처리 | 로그인된 회원정보[pk], 입력받은 패스워드[mpwd] 
			// 1. 현재 로그인된 회원정보 => 세션
				//1. 세션 호출
		Object session = request.getSession().getAttribute("logindto");
				//2. 타입 변환
		MemberDTO logindto = (MemberDTO)session;
				//3. 로그인객체안에 회원번호만 호출
		int loginMno = logindto.getMno();
			//2. DAO에게 전달
		boolean r = MemberDAO.getInstance().deleteInfoSQL(loginMno,mpwd);
		
		// 4. 응답한다.
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(r);
	}

}

/*
 	용량 단위
 		bit : 0 or 1 
 		byte: 01010101 -> 1byte
 		kb : 1024byte -> 1kb
 		mb : 1024kb -> 1mb
 */