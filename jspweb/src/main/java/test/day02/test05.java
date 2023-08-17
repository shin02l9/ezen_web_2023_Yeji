package test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class test05
 */
@WebServlet("/test05")
public class test05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test05() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDto_test05 boardDto = new BoardDto_test05("제목2","안녕하세요"); 
		// DTO ----> JSON 변환 [ JS에 데이터 전달하는데 JS는 DTO타입 몰라 ]
			// JAVA가 문자열 타입의 JSON모양으로 만들어서 JS 에게 전달
		 	// 라이브러리 : jackson
				// ObjectMapper 클래스 : Java 객체를 JSON 형식으로 변환해주는 함수들을 제공하는 클래스 
					// 
		//1. Dto -- JSON 변환 해주는 변환객체 [ - ObjectMapper ]
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(boardDto); // JSON 형식으로 변환할 객체 넣기
		System.out.println(jsonData);
		//2. 응답 타입
		response.setContentType("application/json;charset=UTF-8");
		//3. 응답 데이타
		response.getWriter().print(jsonData);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
