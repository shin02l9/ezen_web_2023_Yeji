package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberFindController() {
        super();

    }
    // 하나의 메소드의 여러개 ajax 통신할때. type전송( 숫자 1:아이디중복검사 2.이메일중복검사 vs 필드명  mid : 아이디중복검사 , memail : 이메일중복검사 )
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// 요청
		String type = request.getParameter("type");
		String data = request.getParameter("data");
		// 객체화 할 필요 없음 값 1개 받아온거라서 
		// DAO 에게 전달해서 결과 반환 받기
		boolean r = MemberDAO.getInstance().findIdSQL(type , data);
		
		// 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(r);
	}

	// 로그인
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청하기
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		System.out.println(mid);
		System.out.println(mpwd);
		
		// DAO 에게 전달해서 결과 반환 받기
		boolean r = MemberDAO.getInstance().loginSQL(mid, mpwd);
		// 만약에 로그인 성공하면 세션에 로그인한 정보를 담는다.
		if( r == true ) {
			// 1. 세션에 저장할 데이터를 요청.
			MemberDTO logindto = MemberDAO.getInstance().info(mid);
			// 2. 세션에 저장한다.
			request.getSession().setAttribute("logindto", logindto);
			// * 세션 상태 확인
			MemberDTO dto = (MemberDTO)request.getSession().getAttribute("logindto");
			System.out.println(dto);
		}
		// 응답하기
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(r);
		System.out.println(r);

	}
}

/*
	
		- 저장소
			1. JAVA/JS 메모리
				- JANA 종료되거나 JS 종료/페이지전환/새로고침 되면 휘발성/초기화/사라짐
				- DTO 이동객체, 로직 필요한 변수들 ( 생성조건에 따라 사용범위가 다름 )
				
				세션( static )
					- 장점 : 모든곳에서 동일한 메모리 사용
					- 단점 : 프로그램/서버 종료될떄까지 유지 ( 메모리 사용량 증가 )
					- 로그인 정보 : 페이지 전환 되더라도 로그인 상태 유지
				
				
			2. DB 메모리
				- 영구저장 [ 논리구조(관계형/표) 저장 ]
				- 회원정보, 게시판정보, 제품정보 등등
				- 실제 데이터 
				
			3. 파일
				- 영구저장 [ 문자열저장 ]
				- 로그/기록 ( 예외처림 오류 정보 , 최상위 보안 자료 )
				- 실제 데이터
				



		※ 로그인 했다는 증거 => 인증 [ 인증서 -> 세션 저장 ]
			
			- 세션: 미리 만들어진 전역메모리/변수
		   Js : sessionStorage		: 모든 JS에서 사용가능한 메모리 공간
			  세션타입 : 문자열 타입 ( 타입변환 필수 )
		      세션저장 : sessionStorage.setItem( 키, 데이터);
		      세션호출 : sessionStorage.getItem( 키 );
		   JAVA(서블릿) : request.getSession()
		   	  세션타입 : Object 타입 ( 타입변환 필수 )
		      세션저장 : request.getSession().setAttribute("속성명", 데이터);
		      세선호출 : request.getSession().getAttribute("속성명");
		      세션내 속성 초기화
		      	1. 방법1 : (세션에 모든 속성) 초기화 하는 함수
		      	2. 방법2 : (세션의 특정 속성) 초기화, JVM CG( 쓰레기 수집기 = 해당객체를 아무도 참조하고 있지 않으면 삭제)
		서블릿
		   내장객체
		      request : 요청객체
		         request.getParameter()                  	 : ajax로부터 전달된 데이터 요청
		         request.getServletContext().getRealPath()   : 서블릿 저장소의 실제(c:) 경로 검색
		         request.getSession()						 : 서버내 세션객체 호출
		      response : 응답객체
		         response.getWriter().print()          		 : ajax로부터 전달할 데이터 응답
		         response.setContentType("application/json;charset=UTF-8"); [ 데이터 타입 설정 ]
       
      

*/
