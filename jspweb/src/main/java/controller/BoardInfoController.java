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
import model.dto.PageDTO;

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
			// ------- 6. 검색처리 ------------------------------
			String key = request.getParameter("key");
			String keyword = request.getParameter("keyword");
			
			// ------- 1. 카테고리 ------------------------------
			int bcno = Integer.parseInt(request.getParameter("bcno"));
			// ------- 2. 한 페이지에 최대 출력 게시물 수 -----------
			int listsize = Integer.parseInt(request.getParameter("listsize"));
			// ------- 3. 페이징 처리 ---------------------------
			int page = Integer.parseInt(request.getParameter("page"));
			
			// ------- 4. 페이징 버튼 출력 -----------------------
				// 1. 마지막 페이지번호/총페이지수 = 전체 게시물 수 / 페이지별 최대 게시물 수 (listsize)
				// 전체 게시물 수 
			int totalsize = BoardDAO.getInstance().totalsize(bcno, key, keyword);
				// 전체 페이지 수 
			int totalpage = totalsize%listsize == 0 ? // 만약에 나머지가 없으면
							totalsize/listsize : 	  // 몫만 넣고
							(totalsize/listsize)+1;	  // 아니면 나머지를 위한 페이지도 출력해야하니까 +1 해야함
					
			// ------- 5. 페이지번호 버튼 시작번호, 마지막번호
				//5개씩		: 1~5페이지(1,5) 6~10페이지(6,10) 11~15페이지(11~15)
				//10개씩		: 
				//15개씩
				// 1. 페이지버튼번호의 최대개수
			int btnsize =5;
				// 2. 페이지버튼번호의 시작번호
			int startbtn = ((page/btnsize)*btnsize)+1;
				// 3. 페이지버튼번호의 마지막번호
			int endbtn = startbtn+(btnsize-1);
					// 마지막 페이지는 총 페이지수보다 커질수 없음
					//만약에 마지막 번호가 총 페이지수보다 크다면 총페이지수로 제한두기
			if( endbtn >= totalpage ) { endbtn = totalpage; }
					
			// 3. DAO에게 게시물 리스크 받아오기
			ArrayList<BoardDTO> r = BoardDAO.getInstance().getList(bcno, listsize, page, key, keyword);
			
			// 4. PageDTO로 추가 구성하기 
			PageDTO pageDTO = new PageDTO(page, listsize, totalsize, totalpage, startbtn, endbtn, r);
			

			System.out.println("글 전체 조회 BoardDTO : "+pageDTO);
				// 매핑해야한다. JAVA 객체를 JS 형식으로 변환해주는 것 
				json = mapper.writeValueAsString(pageDTO);
				
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
		} else { // 만약에 수정할 첨부 파일 있으면 기존 첨부 파일은 서버업로드 폴더에서 삭제
			String filename = BoardDAO.getInstance().getBoard(bno).getBfile();
			filename = request.getServletContext().getRealPath("/board/upload")+"/"+filename;
			FileService.fileDelete(filename);
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
		// 삭제 실행 하기전에 업로드된 파일에 대한 정보 잠깐 담아두기
		// 삭제 완료되면 업로드 파일의 정보를 알수가 없어서 삭제를 못함
		String filename = BoardDAO.getInstance().getBoard(bno).getBfile();
		
		// DAO 처리하기
		boolean r = BoardDAO.getInstance().onDelete(bno);
		
		// 만약에 게시물 삭제가 완료되면 업로드된 파일도 같이 삭제해야한다.
		if( r ){ // 만약에 게시물 삭제가 성공이면 
			filename = request.getServletContext().getRealPath("/board/upload")+"/"+filename;
			FileService.fileDelete(filename);
		}
		
		
		System.out.println( "삭제 r : "+r);
		// 응답하기
		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(r);
	}

}
