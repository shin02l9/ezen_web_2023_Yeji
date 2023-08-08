drop database if exists sqldb4web; # 만약에 존재하면 삭제
create database sqldb4web; # 생성하기
use sqldb4web; # 사용하기
drop table if exists member;
create table member(
	mno int not null unique auto_increment,
    mid varchar(20), 
    mpw varchar(20), 
    mname varchar(20), 
    mphone varchar(20)
);




# 1. 테이블의 모든 레코드 검색
select * from member;

# 2. 회원가입 : mno 자동부여 이므로 생략
insert into member( mid , mpw , mname, mphone ) values ( 'ezen02' , '1234', '이젠', '010-443-1234');
	# 자바에서 -> insert into member( mid , mpw , mname , mphone › values (?, ?, ?, ?);
    
# 3. 로그인 : 입력한 값이 존재하는지 검색
select * from member where mid = 'ezen02' and mpw = '1234';	 	# 로그인 성공 : 1개의 레코드 이상 검색 되면
select * from member where mid = 'ezen02' and mpw = '12345'; 	# 로그인 실패
	# 자바에서 -> select * from member where mid = ? and mpw = ?;
    
# 4. 아이디 / 전화번호 중복체크 (유효성검사) : 입력한 값이 존재하는지 검색
select * from member where mid = 'ezen02';			# 조건에 충족하는 모든 레코드 검색
select * from member where mphone = '010-443-1234'; # 조건에 충족하는 모든 레코드 검색
	# 자바에서 -> select * from member where mphone = ?;
    
# 5. 아이디 찾기 / 비밀번호 찾기 : 입력한 값의 레코드 검색 
select mid from member where mname = '이젠' and mphone = '010-443-1234';  	# 조건에 충족하는 mid 레코드만 검색
select mpw from member where mid = 'ezen02' and mphone = '010-443-1234'; 	# 조건에 충족하는 mpw 레코드만 검색
	# 자바에서 -> select mpw from member where mid = ? and mphone = ?;
    
# 6. 회원수정 : 비밀번호 수정 : pk 식별 조건 [pk필드는 수정 불가능(권장)]
update member set mpw ='12345' where mno = 1;
update member set mname = 'ezen', mphone = '010-443-1234' where mno = 4;
	# 자바에서 -> update member set mname = ?, mphone = ? where mno = ?;
    
# 7. 회원 탈퇴 : Pk 식별 조건 
delete from member where mno = 1;
	# 자바에서 -> delete from member where mno = ?;