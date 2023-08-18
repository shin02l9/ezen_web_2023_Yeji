package test.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test06
 */

// 서버내 동일한 HTTP 주소는 절대적으로 가질 수 없다.
// 서버내 주소는 꼭 하나여야 함!! 클래스처럼 패키지가 다르고 클래스 명이 같은경우는 식별이 가능하지만 서블릿은 주소가 패키지 상관없이 전부 달라야함
@WebServlet("/test06")
public class test06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test06() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JS가 통신 보내옴");
		// 1. 요청 request
		String value1 = request.getParameter("value1"); // ajax data 속성의 객체 내 value1인 속성의 값을 요청 한것
			System.out.println(" JS'ajax'가 보내온 데이터 :"+value1);
		// 2. 응답 response
		response.getWriter().print(true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

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
