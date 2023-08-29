package member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AuthSendEmailController")
public class AuthSendEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AuthSendEmailController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청하기
		String memail = request.getParameter("memail");
		System.out.println(memail);
		
		// 2. 인증번호 생성 [난수6자리]
		String auth = "";
		for ( int i = 0; i<6; i++ ) {
			Random random = new Random(); // 랜덤 객체 생성
			 //random.nextInt();	// 랜덤객체.nextInt(); : int 타입의 범위내 난수 생성
			auth += random.nextInt(10);		// random.nextInt(끝수); : 0~끝수 범위내 난수 생성 9.999까지 나옴 
		} System.out.println("생성된 6자리 난수 : "+ auth);
		
		// 3. 인증번호를 해당 이메일에게 전송 [ SMTP : 간이 우편 전송 프로토콜 라이브러리 필요 ]
		
		
		// 4. 인증번호 반환
		response.getWriter().print(auth);
	}
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
