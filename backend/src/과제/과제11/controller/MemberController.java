package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {
	
	//싱글톤 
	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() {return memberController;}
	public MemberController() {}
	
	
	//2. 회원가입 -------------------------------------------------------------------------------
		//	리턴 1:성공 , 2: 실패{DB오류} , 3:아이디중복실패 , 4:전화번호중복실패
	public int signupLogic(String id, String pw, String name, String phone) {
		System.out.println("회원가입 도착");
		System.out.println(id + pw + name + phone);
		// 유효성 검사
			// 1. 아이디 중복체크
			if( MemberDao.getInstance().inFoCheck("mid", id )) return 3;
			// 2. 비밀번호 중복체크
			if( MemberDao.getInstance().inFoCheck("mphone", phone )) return 4;
		
		//1. 객체화하기 : 5개 변수들이 이동하면 매개변수의 코드가 길어져서 한곳에 담아서 이동할 것 ! 
		MemberDto member = new MemberDto(0, id, pw, name, phone);
		//2. Dao에게 전달하고 결과 받기
		boolean result = MemberDao.getInstance().signupSQL( member );
		
		//3. 결과를 view 에 전달
		if( result ) return 1;
		else {return 2;}
	}
	
	//3. 로그인 -------------------------------------------------------------------------------
	public boolean loginLogic(String id, String pw) {
		System.out.println("로그인 도착");
		System.out.println(id + pw );
		// 유효성 검사 했다 치고
		//1. 매개변수가 2개라서 객체화 굳이 안하고 진행 !
		//2. 바로 Dao에게 전달하기
		boolean result = MemberDao.getInstance().loginSQL( id, pw );

		return result;
		
	}
	
	//4. 아이디찾기 -------------------------------------------------------------------------------
	public String findById(String name, String phone) {
		System.out.println("입력받은 값 : "+ name +","+ phone);
		
		return MemberDao.getInstance().findById( name, phone );
	}
	
	//5. 비밀번호찾기 -------------------------------------------------------------------------------
	public String findByPw(String id, String phone) {
		System.out.println("입력받은 값 : "+ id +","+ phone);

		return MemberDao.getInstance().findById( id, phone );
	}
}






















