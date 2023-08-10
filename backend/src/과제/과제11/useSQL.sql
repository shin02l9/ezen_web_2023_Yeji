# JDBC와 연결할 DB 선언
drop database if exists sqldb4web;
create database sqldb4web;

# 아이디 비밀번호 이름 전화 번호를 저장하는 member 테이블 생성
# 테이블과 비슷하게 memberDTo 클래스 설계 

use sqldb4web;
drop database if exists membertable;
create table membertable(
	mno int not null unique auto_increment,
	mid varchar(15) not null unique,
	mpw varchar(15) not null,
    mname varchar(15) not null,
    mphone varchar(13) not null,
    primary key( mno )
); select *from membertable;

use sqldb4web;
drop database if exists board;
create table board(
	bno int not null unique auto_increment,	# 정수, 자동번호 부여
    btitle varchar(50) not null,			# 문자50, 공백불가				
    bcontent longtext,						# 긴글
    bdate datetime default now(),			# 날짜/시간, 기본값 레코드삽입 기준으로 자동						
    bview int default 0,					# 정수, 기본
    mno int,								# 
    primary key( bno )
	foreign key ( mno ) references membertable( mno ) on delete cascade # 회원탈퇴 PK 삭제 -> FK도 삭제
    #foreign key ( mno ) references membertable( mno ) on delete restrict, # 회원탈퇴 PK 삭제 -> FK가 존재하면 불가능
    #foreign key ( mno ) references membertable( mno ) on delete set null, # 회원탈퇴 PK 삭제 -> FK값을 null로
    #foreign key ( mno ) references membertable( mno ) on delete no action # 아무런 변화 없는 상태
);