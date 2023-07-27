package java1.day11.Ex05_디자인패턴02.controller;

import java1.day11.Ex05_디자인패턴02.model.dao.MemberDao;
import java1.day11.Ex05_디자인패턴02.model.dto.MemberDto;
import 과제.과제10.Member;

//기능 처리(로직) 처리하는 클래스 
public class MemberController { // MemberController s
	
	//1. 싱글톤 생성
	private static MemberController memberController = new MemberController();
	//2. 외부로 부터 싱글톤 호출 할수 있도록
	public static MemberController getInstance() {return memberController;}
	//3. 외부에서 객체 생성 차단 하기 위한 생성자 잠금
	public MemberController() {}
	
	
	//------------------------------------------------------------------------------------------------
	public boolean singupLogic (String id, String pw, String name, String phone, int age) { // singupLogic s
		MemberDto m = new MemberDto(id, pw, name, phone, age); // 입력 받은값 객체화 시킨 후 
		for ( int i = 0; i < MemberDao.memberList.length; i++) { // for s
			if ( MemberDao.memberList[i] == null ) { 
				MemberDao.memberList[i] = m; return true; // 회원가입 성공
				}
		}// for e
		 return false; // 회원가입 실패
	}// singupLogic e
	
	//------------------------------------------------------------------------------------------------
	public boolean loginLogic(String id, String pw) { // loginLogic s
		// 그냥 비교할거라서 객체를 생성할 필요는 없음 !
		//2. for문 돌려서 배열내에서 찾기
		for ( int i = 0 ; i <MemberDao.memberList.length; i++) { // for s
			if(MemberDao.memberList[i] != null && // 비어있는 곳은 비교 x
					MemberDao.memberList[i].getId().equals(id) &&
					MemberDao.memberList[i].getPw().equals(pw) ) {
				return true;
			}
		}  // for e
		return false;
		
	}// loginLogic e
	
	//------------------------------------------------------------------------------------------------
	public boolean findIdLogic( String name, String phone ) { // findIdLogic s
	// 그냥 비교할거라서 객체를 생성할 필요는 없음 !
		//2. for문 돌려서 배열내에서 찾기
		for ( int i = 0 ; i <MemberDao.memberList.length; i++) { // for s
			if(MemberDao.memberList[i] != null && // 비어있는 곳은 비교 x
					MemberDao.memberList[i].getName().equals(name) &&
					MemberDao.memberList[i].getPhone().equals(phone) ) {
				return true;
			}
		}  // for e
		return false;
	}// findIdLogic e
	
	//------------------------------------------------------------------------------------------------
	public boolean findPwLogic( String id, String phone ) { // findPwLogic s
		// 그냥 비교할거라서 객체를 생성할 필요는 없음 !
		//2. for문 돌려서 배열내에서 찾기
		for ( int i = 0 ; i <MemberDao.memberList.length; i++) { // for s
			if(MemberDao.memberList[i] != null && // 비어있는 곳은 비교 x
					MemberDao.memberList[i].getId().equals(id) &&
					MemberDao.memberList[i].getPhone().equals(phone) ) {
				return true;
			}
		}  // for e
		return false;
	} // findPwLogic e
	
} // MemberController e
