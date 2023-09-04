package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDAO;
import model.dto.BoardDTO;
import model.dto.MemberDTO;

@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardInfoController() {
        super();
    }
    
    // 1.  전체 조회, 개별 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" 글조회 컨트롤러 입장 ");
		// 1. 요청
		// 2. 유효성검사
		// 3. DAO
		ArrayList<BoardDTO> r = BoardDAO.getInstance().getList();
		System.out.println("글조회 BoardDTO : "+r);
			// 매핑해야한다. JAVA 객체를 JS 형식으로 변환해주는 것 
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(r);
		// 4. 응답
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(json);
		
	}

	// 2. 글쓰기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" 글쓰기 컨트롤러 입장 ");
		
		// 1. 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request, // 요청 방식
				request.getServletContext().getRealPath("/board/upload"), // 저장경로
				1024*1024*1024, // 업로드 허용용량
				"UTF-8",	// 인코딩 타입
				new DefaultFileRenamePolicy() // 만약에 업로드파일명이 서버내에 존재하면 자동으로 파일면 뒤에 숫자 붙이기
				);
		System.out.println("[경로 확인해보기] : "+ request.getServletContext().getRealPath("/board/upload"));
		
		// 2. (입력받은 매개변수) 요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		int mno = ((MemberDTO)request.getSession().getAttribute("logindto")).getMno();
		int bcno = Integer.parseInt(multi.getParameter("bcno"));	
		
		// 3. 유효성검사, 객체화
		BoardDTO boardDTO = new BoardDTO(btitle, bcontent, bfile, mno, bcno);
		System.out.println( "글쓰기 boardDTO : " + boardDTO);
		
		// 4. Dao 처리
		boolean r = BoardDAO.getInstance().bwrite(boardDTO);
		
		// 5. (Dao결과) 응답
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(r);
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
