# JDBC와 연결할 DB 선언
drop database if exists sqldb4web;
create database sqldb4web;

# 아이디 비밀번호 이름 전화 번호를 저장하는 member 테이블 생성
# 테이블과 비슷하게 memberDTo 클래스 설계 

use sqldb4web;
drop database if exists member;
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

# 3번 게시물 조회 
select* from borad where bno = 3;

# 3번 게시물을 조회하는데 member 테이블에 있는 mid 추가적으로 조회
	# 1단계 : 조인부터 하기  / mid는 다른 테이블에 존재하므로 
    select * from board natural join member;
	# 2단계 : 하나의 쿼리문에 테이블이 다수일때 별칭 권장
    select * from board b natural join member m;
    # 3단계 : 조건 ! where을 먼저 써야 한다.
    select * from board b natural join member m where b.bno = 3;
    # 4단계 : 정렬판단하기 ! [ 현재는 1개 조회 라서 무의미 ]
    select * from board b natural join member m where b.bno = 3 order by b.bdate desc;
    # 5단계 : 검색 레코드 개수 제한 ! [ 현재는 1개 조회 라서 무의미 ]
    select * from board b natural join member m where b.bno = 3 order by b.bdate desc limit 3;
    # 6단계 : 검색 레코드에 표시할 필드명 선택하기 
    select b.*, m.mid from board b natural join member m where b.bno = 3;
    # 7단계 : JAVA 매개변수 변환
    # select b.*, m.mid from board b natural join member m where b.bno = ?;