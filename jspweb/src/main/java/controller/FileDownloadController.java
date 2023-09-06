package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FileDownloadController")
public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FileDownloadController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ------------------ 1. 다운로드할 첨부파일의 경로 찾기  
			// 1. 다운로드 할 파일명 요청
		String filename = request.getParameter("filename");
			// 2. 업로드 되었던 파일의 경로
		String uploadpath = request.getServletContext().getRealPath("board/upload");
			// 3. 다운로드 할 파일의 전체 경로
		String filepath = uploadpath+"/"+filename;
		// ------------------ 2. 응답할때 파일 다운로드 시 옵션 추가 / 아래 설정을 안하면 파일 다운로드 될때 서블릿 이름으로 다운로드가 되서 해야함.
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "UTF-8"));
			// URLEncoder 클래스 : import java.net.URLEncoder;
			// .encode(텍스트, "UTF-8")); : URL의 한글 깨짐 방지
		// ------------------ 3. 다운로드할 첨부파일을 내보내기
			// 1. 파일을 객체화 하기 
		File file = new File(filepath);
			// 2. 파일입력 스트림 객체 [ 파일 바이트로 읽어오기 ]
				// 1. 입력객체
		FileInputStream fin = new FileInputStream(file);
				// 2. 읽어온 바이트를 저장할 배열 선언 ( 배열의길이=파일의용량만큼 )
		byte[] bytes = new byte[ (int)file.length() ];
		 		// 3. 바이트를 읽어서 배열에 저장하기
		fin.read(bytes);
			// 3. 파일 출력 스트림 객체
				// 1. 파일 출력 스트림 객체 [ 출력할 위치가 response으로 가는 것임 ]
		//ServletOutputStreamt oin = response.getOutputStream()
		BufferedOutputStream oin = new BufferedOutputStream( response.getOutputStream() );
				// 2. 파일 내보내기 
		oin.write(bytes);
			// 4. 대용량 전송시 안전하게 스트림 닫기
		fin.close(); oin.flush(); oin.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

}
