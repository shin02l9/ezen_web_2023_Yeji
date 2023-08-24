package 과제;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.VisitlogDAO;
import model.dto.VisitlogDTO;


@WebServlet("/Accountbook")
public class AccountbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccountbookController() {
        super();

    }

    // 출력 function R() 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" Get Controller ");
		// 요청할 값 없음 매개변수도 없음
		// 그냥 DAO 한테 반환 받아오기
		ArrayList<AccountbookDTO> r = AccountbookDAO.getInstance().R();
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(r);
		System.out.println(jsonArray);
		
		// 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	}


	// 등록 function C()
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" Post Controller ");
		
		// 요청
		String content = request.getParameter("content");System.out.println(content);
		String price = request.getParameter("price");System.out.println(price);
		String date = request.getParameter("date");System.out.println(date);
		// DAO에 전달 및 결과
		AccountbookDTO dto = new AccountbookDTO( content , price , date );
		boolean r = AccountbookDAO.getInstance().C(dto);
		// 응답 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(r);
			
	}

	// 수정 function U()
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" Put Controller ");
		
		// 요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		String content = request.getParameter("content");
		String price = request.getParameter("price");
		System.out.println(bno);
		System.out.println(content);
		System.out.println(price);
		
		// 객체 만들어서 DAO에 전달 및 결과
		AccountbookDTO dto = new AccountbookDTO( bno , content , price );
		boolean r = AccountbookDAO.getInstance().U(dto);
		// 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(r);
	}

	// 삭제 function D()
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" Delete Controller ");
		
		// 요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		// 값 한개라서 객체는 필요없고 DAO 에게 전달하고 결과 받기
		boolean r = AccountbookDAO.getInstance().D(bno);	
		// 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(r);
	}

}
