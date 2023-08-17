package test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test02
 */
@WebServlet("/test02") // @ : 어노테이션 , 해당클래스의 url 매핑[연결] 헤주는 어노테이션
public class test02 extends HttpServlet {
	// HttpServlet 클래스로 부터 상속을 받으면 main가 포함임! 멀티스레드,예외처리,HTTP 다 포함 
	// 자바서블릿은 HTTP를 기반으로 만들어진 클래스임 ! 
	
	// HTTP : Hypertext Transfer Protocol : 문서 교환 규칙/약속/규약/방법
		// HTTP 메소드
			// get    : 호출
			// post   : 저장
			// put	  : 수정
			// delete : 삭제
		// HTTP Body : 주고 받은 데이터 저장소 
	
	// 브라우저 [크롬,엣지 등]애서 주소 입력해서 웹사이트 접속하는 방식
		// 주소창 : www.naver.co-> get 방식
	

	private static final long serialVersionUID = 1L;

    public test02() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 콘솔출력
		System.out.println("test02 : Hello JS.");
		//2. 웹출력
		response.getWriter().append("test02 : Hello JS. ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
