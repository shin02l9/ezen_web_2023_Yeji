package 과제;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Accountbook")
public class AccountbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccountbookController() {
        super();

    }

    // function R() 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}


	// function C()
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" 컨트롤러 Controller ");
		
		// 요청
		String content = request.getParameter("content");System.out.println(content);
		String price = request.getParameter("price");System.out.println(price);
		String date = request.getParameter("date");System.out.println(date);
		// 전달 및 결과
		AccountbookDTO dto = new AccountbookDTO( content , price , date );
		boolean r = AccountbookDAO.getInstance().C(dto);
		// 응답 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(r);
			
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
