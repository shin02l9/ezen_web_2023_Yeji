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
		// 1. AJAX data 데이터 요청한다.
			// request.getParameter("속성명"); String 반환
		int vno = Integer.parseInt( request.getParameter("vno") ) ;	System.out.println( "vno : " + vno );
		String vcontent = request.getParameter("vcontent");			System.out.println( "vcontent : " + vcontent );
		String vpwd = request.getParameter("vpwd");					System.out.println( "vpwd : " + vpwd );
			
		// 2. (데이터 많으면) 객체화
		// 3. Dao 에게 전달후 SQL결과를 받는다.
		boolean r = VisitlogDAO.getInstance().vupdateSQL(vno, vcontent, vpwd);
		// 4. 결과를 AJAX에게 전달한다.
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(r);
				
	}


	// D (삭제)
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX data 데이터 요청한다.
		int vno = Integer.parseInt( request.getParameter("vno") ) ;		System.out.println( "vno : " + vno );
		String vpwd = request.getParameter("vpwd");						System.out.println( "vpwd : " + vpwd );
		
		// 2. (데이터 많으면) 객체화
		// 3. Dao 에게 전달후 SQL결과를 받는다.
		boolean r = VisitlogDAO.getInstance().vdeleteSQL(vno, vpwd);
		// 4. 결과를 AJAX에게 전달한다.
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(r);
	}
			
		/* 
		 	- HTTP서블릿클래스는 기본적으로 get,post,put,delete 함수 제공 
		 	- 기본 톰캣서버는 get,post만 매개변수(데이터) 전달 가능 
		 	- put,delete 함수도 매개변수 전달 가능하도록 설정 [ 서버마다 설정]
		 	server.xml [ Source ]
		 		63줄 쯤 원본 코드
		 			<Connector connectionTimeout="20000" maxParameterCount="1000" port="80" protocol="HTTP/1.1" redirectPort="8443"/>
		 		put,delete에도 매개변수 전달가능하도록 코드 설정 [ parseBodyMethods="POST,PUT,DELETE" URIEncoding="UTF-8" 추가 ]
		 			<Connector connectionTimeout="20000" port="80" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="POST,PUT,DELETE" URIEncoding="UTF-8"/>
		 			
		 */
}


