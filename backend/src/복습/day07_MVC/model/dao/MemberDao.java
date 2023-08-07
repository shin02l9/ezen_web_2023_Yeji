package 복습.day07_MVC.model.dao;


import 복습.day07_MVC.model.dto.MemberDto;

//데이터 저장을 담당 (서버실, 서랍장)
public class MemberDao {
	
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance(){return memberDao;}
	private MemberDao() {}

	public static MemberDto[] memberList = new MemberDto[100];
	
}
