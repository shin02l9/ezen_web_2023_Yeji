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
				return true;
			}
		} return false;
	}
	// 로그인 ------------------------------------------------------------------------
	public boolean loginLogic(String id, String pw) {
		for ( int i = 0; i< MemberDao.memberList.length; i++ ) {
			
		// MemberDao.memberList[i].getPw() == pw 이렇게 비교하는건 주소값을 비교해서 오류뜸
			if( MemberDao.memberList[i] != null &&
				MemberDao.memberList[i].getId().equals(id)&&
				MemberDao.memberList[i].getPw().equals(pw) ) {
				return true;
			} 
		} return false;
	}
	// 아이디 찾기 ------------------------------------------------------------------------
	public String FindIdLogic(String name, String phone) {
		for ( int i = 0; i< MemberDao.memberList.length; i++ ) {
			if( MemberDao.memberList[i] != null &&
				MemberDao.memberList[i].getName().equals(name) &&
				MemberDao.memberList[i].getPhone().equals(phone) ) {
				return MemberDao.memberList[i].getId();
			}
		} return "";
	}
	// 비밀번호 찾기 ------------------------------------------------------------------------
	public String FindPasswordLogic(String id, String phone) {
		for ( int i = 0; i< MemberDao.memberList.length; i++ ) {
			if( MemberDao.memberList[i] != null &&
				MemberDao.memberList[i].getId().equals(id) &&
				MemberDao.memberList[i].getPhone().equals(phone) ) {
				return MemberDao.memberList[i].getPw();
			}
		} return "";
	}
}
