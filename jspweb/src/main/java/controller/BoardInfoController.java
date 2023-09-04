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
    
    // 1. 글 조회 | type = 1 : 전체 조회, type = 2 : 개별 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" 글조회 컨트롤러 입장 ");
		// 1. 요청
		int type = Integer.parseInt(request.getParameter("type"));
		
		ObjectMapper mapper = new ObjectMapper();
		String json = null;

		// 2. type 분류하여 로직 처리
		if( type == 1 ) { // 전체 조회
			// 3. DAO
			ArrayList<BoardDTO> r = BoardDAO.getInstance().getList();
			System.out.println("글 전체 조회 BoardDTO : "+r);
				// 매핑해야한다. JAVA 객체를 JS 형식으로 변환해주는 것 
				json = mapper.writeValueAsString(r);
	   		
		} else if( type == 2 ) { // 개별 조회 
			int bno = Integer.parseInt(request.getParameter("bno"));
			// 3. DAO
			BoardDTO r = BoardDAO.getInstance().getBoard(bno);
			
				// 만약에!! ( 로그인 혹은 비로그인 ) 요청한 사람과 게시물 작성한 사람과 동일 ??
				// 로그인 정보 세션 불러와서 사용할 것
			Object object = request.getSession().getAttribute("logindto");
			
			// 비 로그인 상태 --------------------
			if ( object == null ) { r.setHost(false); }
				
			// 로그인 상태 ----------------------
			else { 
				MemberDTO login = (MemberDTO)object;
				// 내가 쓴글
				if( login.getMno() == r.getMno() ) { r.setHost(true); }
				// 남이 쓴글
				else { r.setHost(false); }
			}
			
			
			System.out.println("글 개별 조회 BoardDTO : "+r);
				// 매핑해야한다. JAVA 객체를 JS 형식으로 변환해주는 것 
				json = mapper.writeValueAsString(r);
		}
		// 4. 응답
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(json);

		
	}

	// 2. 글 쓰기
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
		
		// 3. 유효성검사, 객체화 , 타입분류로 DAO 로직 나누기
		
		
		
		BoardDTO boardDTO = new BoardDTO(btitle, bcontent, bfile, mno, bcno);
		System.out.println( "글쓰기 boardDTO : " + boardDTO);
		
		// 4. Dao 처리
		boolean r = BoardDAO.getInstance().bwrite(boardDTO);
		
		// 5. (Dao결과) 응답
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(r);
		
	}

	// 3. 글 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" 글수정 컨트롤러 입장 ");
		// 1. 수정할 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request, // 요청 방식
				request.getServletContext().getRealPath("/board/upload"), // 저장경로
				1024*1024*1024, // 업로드 허용용량
				"UTF-8",	// 인코딩 타입
				new DefaultFileRenamePolicy() // 만약에 업로드파일명이 서버내에 존재하면 자동으로 파일면 뒤에 숫자 붙이기
				);
		System.out.println("[경로 확인해보기] : "+ request.getServletContext().getRealPath("/board/upload"));
		// 2. 수정할 데이터 요청
		int bcno = Integer.parseInt(multi.getParameter("bcno"));
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		// 2. 수정할 게시물의 식별키 
		int bno = Integer.parseInt(multi.getParameter("bno"));
		BoardDTO boardDTO = new BoardDTO(bno,btitle,bcontent,bfile,bcno);
		System.out.println("수정 DTO : "+boardDTO);
		// * 만약에 새로운 첨부파일이 없으면 기존 첨부파일 그대로 사용하기
		if( boardDTO.getBfile() == null ) {
			boardDTO.setBfile(BoardDAO.getInstance().getBoard(bno).getBfile());
		}
		
		// DAO 처리하기
		boolean r = BoardDAO.getInstance().onUpdate(boardDTO);
		System.out.println( "onUpdate() r : "+r);
		// 응답하기
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(r);
		
	}
	

	// 4. 글 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println( " 글삭제 컨트롤러 입장 ");
		// 요청받기
		int bno = Integer.parseInt(request.getParameter("bno"));
		// DAO 처리하기
		boolean r = BoardDAO.getInstance().onDelete(bno);
		System.out.println( "삭제 r : "+r);
		// 응답하기
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(r);
	}

}
