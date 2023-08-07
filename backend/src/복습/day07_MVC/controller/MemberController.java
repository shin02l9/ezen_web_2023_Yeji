package 복습.day07_MVC.controller;

import 복습.day07_MVC.model.dao.MemberDao;
import 복습.day07_MVC.model.dto.MemberDto;

//기능 처리(로직)
public class MemberController {
	
	private static MemberController memberController = new MemberController();
	public static MemberController getInstance(){return memberController;}
	private MemberController() {}
	
	// 회원가입 ------------------------------------------------------------------------
	public boolean joinLogic(String id, String pw, String name, String phone, int age) {
		// 생성자를 이용한 객체화 진행
		MemberDto m = new MemberDto(id, pw, name, phone, age);
		// 객체화 한것을 배열에 넣어주기
		for ( int i = 0; i< MemberDao.memberList.length; i++ ) {
			if( MemberDao.memberList[i] == null ) {
				MemberDao.memberList[i] = m;
				break;
			}
		}
		return true;
	}
	// 로그인 ------------------------------------------------------------------------
	public void loingLogic() {
		
	}
	// 아이디 찾기 ------------------------------------------------------------------------
	public void FindIdLogic() {
		
	}
	// 비밀번호 찾기 ------------------------------------------------------------------------
	public void FindPasswordLogic() {
		
	}
	
	

}
