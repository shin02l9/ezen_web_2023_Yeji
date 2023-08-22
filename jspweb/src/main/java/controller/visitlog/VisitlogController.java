package controller.visitlog;

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


@WebServlet("/VisitlogController") // 해당 서블릿의 HTTP주소 
public class VisitlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VisitlogController() {
        super();
    }


	// C (저장)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청하기 request.getParameter(".객체의속성명");
		String vwriter = request.getParameter("vwriter");
		String vpwd = request.getParameter("vpwd");
		String vcontent = request.getParameter("vcontent");
		System.out.println("vwriter : "+vwriter);
		System.out.println("vpwd : "+vpwd);
		System.out.println("vcontent : "+vcontent);
		
		// 객체화해서 DAO 에게 전달 후 결과 받고
		VisitlogDTO dto = new VisitlogDTO(vwriter, vpwd, vcontent);
		boolean r = VisitlogDAO.getInstance().vwriteSQL(dto);
		
		// 응답하기
		response.setContentType("Application/json;charset=UTF-8");
		if(r) {
			System.out.println("등록 성공");
			response.getWriter().print(r);
		} else {
			System.out.println("등록 실패");
			response.getWriter().print(r);
		}
		
	}

	// R (호출)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청할게 없음!
		// 객체화 할 것도 없음 ! 매개변수가 없음 !
		// DAO
		ArrayList<VisitlogDTO> r = VisitlogDAO.getInstance().vreadSQL();
			// *JS는 ArrayList 이라는걸 모름 그래서 JSON 배열로 변환해서 전달 해야함 
			// 그떄 사용하는 것이 jackson 라이브러리 이다. 
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(r);
			System.out.println(jsonArray);
		// 응답
		//response.getWriter().print(r); 응답은 가능하나 문제발생한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}
	
	// U (수정)
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	// D (삭제)
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
