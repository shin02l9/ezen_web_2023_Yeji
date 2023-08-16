package test.day01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test01
 */
@WebServlet("/Test01") // 해당 클래스의 URL 주소!!! // 해당 클래스를 호출하고 싶으면 ! 
	// http://localhost:8080/jspweb/Test01
public class Test01 extends HttpServlet {// HttpServlet 슈퍼클래스에게 상속 받은 것 
	private static final long serialVersionUID = 1L;
       

    public Test01() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>> JS input ");
		response.getWriter().append("JS output : Hello Servlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
