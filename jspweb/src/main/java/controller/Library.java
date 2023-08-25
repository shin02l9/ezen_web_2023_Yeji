package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.LibraryDAO;
import model.dto.LibraryDTO;
import 과제.AccountbookDAO;
import 과제.AccountbookDTO;

@WebServlet("/Library")
public class Library extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Library() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		String r = LibraryDAO.getInstance().Ddata(sno);
		response.getWriter().print(r);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" 퇴실하기 로직 도착 ");
		// 요청
		int sno = Integer.parseInt(request.getParameter("sno"));
		System.out.println(sno);
		String sname = request.getParameter("sname");
		System.out.println(sname);
		String sphone = request.getParameter("sphone");
		System.out.println(sphone);
		
		// DAO에게 전달 및 반환 값 받기
		LibraryDTO dto = new LibraryDTO( sno , sname , sphone );
		System.out.println(dto);
		boolean r = LibraryDAO.getInstance().Dsql(dto);
		System.out.println(r);
		// 응답
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(r);
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
