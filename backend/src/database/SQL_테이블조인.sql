drop database if exists sqldb4web;
create database sqldb4web;
use sqldb4web;
drop table if exists member;
create table member(
	mno int not null unique auto_increment,
	mid varchar(15) not null unique,
	mpw varchar(15) not null,
    mname varchar(15) not null,
    mphone varchar(13) not null,
    primary key( mno )
); select *from member;

use sqldb4web;
drop table if exists board;
create table board(
	bno int not null unique auto_increment,	# 정수, 자동번호 부여
    btitle varchar(50) not null,			# 문자50, 공백불가				
    bcontent longtext,						# 긴글
    bdate datetime default now(),			# 날짜/시간, 기본값 레코드삽입 기준으로 자동						
    bview int default 0,					# 정수, 기본
    mno int,							
    primary key( bno ),
	foreign key ( mno ) references member( mno ) on delete cascade # 회원탈퇴 PK 삭제 -> FK도 삭제
    #foreign key ( mno ) references membertable( mno ) on delete restrict, # 회원탈퇴 PK 삭제 -> FK가 존재하면 불가능
    #foreign key ( mno ) references membertable( mno ) on delete set null, # 회원탈퇴 PK 삭제 -> FK값을 null로
    #foreign key ( mno ) references membertable( mno ) on delete no action # 아무런 변화 없는 상태
);

show tables;
select * from board;


# 테이블 합치기 (합치는 이유 select를 한번에 하려고!!!!! 귀찮으니까 !!! )
#1. select * from 테이블명1 , 테이블명2;  -> 문제점 : 곱하기가 된다 그래서 중복이 생김
select * from member, board;
#2. 테이블을 합치는데 기준 ! [PK --- FK]
	# member 테이블에 PK는 mno
    # board 테이블에 FK는 mno
    # 1. 조건조인 [ PK와 FK가 일치할때 ] -> 문제점 : 일반 조건들과 가독성 떨어짐, 조인을 위한 조건인지 식별이 어려워질 수 있음
select * from member, board where member.mno = board.mno;
			# 테이블이 길어지면 SQL 문도 길어져서 그래서 별칭을 사용한다
            select * from member m, board b where m.mno = b.mno;
    # 2. 자연조인 [ 자동으로 두 테이블간 PK와 FK를 식별해서 조인한다. ] -> 문제점 : PK와 FK가 다수일때는 힘들다.
select * from member natural join board;
	# 보고 싶은 것만 필드 골라서 출력하기 
select b.* , m.mid from member m natural join board b;
select b.* , m.mid from member m natural join board b order by b.bdate desc;