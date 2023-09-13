drop database if exists jspweb;
create database jspweb; 
use jspweb;


drop table if exists visitlogTable;
 create table visitlogTable(
	vno			int auto_increment,			# 식별번호 자동부여
    vwriter 	varchar(30) not null,		# 작성자 공백불가능
    vpwd 		varchar(10) not null,		# 비밀번호 공백불가능
    vcontent 	longtext not null,			# 내용
    vdatetime	datetime default now(),		# 자동날짜 시간등록
	primary key( vno )  					# <<PK>>
 ); 


drop table if exists accountbook;
create table accountbook(  
	bco int auto_increment, 			# 식별번호 자동부여
	bcontent varchar(15) not null,		
	bprice varchar(15) not null,
    bdate datetime default now(),
    primary key( bco )
);

drop table if exists membertable;
create table membertable(  
	mco int auto_increment, 			# 식별번호 자동부여
	mid varchar(50) not null unique,	# 회원아이디 공백불가능, 중복불가능
    mpwd varchar(20) not null,			# 회원비밀번호 공백불가능
    memail varchar(50) not null unique,	# 회원이메일 공백불가능
    mimg longtext ,						# 회원이메일 공백가능
	primary key( mco )
);

drop table if exists slibrary;
create table slibrary(  
    sno int auto_increment,
    sname varchar(5),
    sphone varchar(13),
    sstatus tinyint,
    primary key( sno )
);

drop table if exists hrm;
create table hrm(  
	hno int auto_increment, 
	himg longtext,
    hname char(5),
    hphone varchar(30),
    hposition char(5),
    hdate datetime default now(),
	primary key( hno )
);

# 게시판 카테고리 
drop table if exists bcategory;
create table bcategory(
	bcno int auto_increment , 		
    bcname varchar(30) not null ,
    primary key( bcno )
);
# 샘플 [ 공지사항 , 자유게시판  , 노하우 ] 
insert into bcategory value ( 1 , '공지사항');
insert into bcategory value ( 2 , '자유게시판');
insert into bcategory value ( 3 , '노하우');

# 게시판 
drop table if exists board;
create table board(
	bno			int auto_increment , 
    btitle		varchar(30) not null , 
    bcontent 	longtext , 
	bfile		longtext , 
    bdate		datetime default now() ,
    bview		int default 0 ,
    mno			int , 
    bcno		int ,
    primary key( bno ) ,
    foreign key( mno ) references member(mno) 
    		on delete cascade ,  -- 회원탈퇴시 게시물도 같이 삭제 [ 제약조건 ]
    foreign key( bcno ) references bcategory( bcno ) 
    		on delete cascade 
    		on update cascade  	-- 카테고리 삭제시 게시물도 삭제 , 카테고리번호 변경시 fk도 같이 변경   [ 제약조건 ]
);


# ------------------- 제품 --------------------------------------
use jspweb;
# 1. 제품 카테고리 
drop table if exists pcategory;
create table pcategory(
	pcno int auto_increment unique , 		-- 카테고리번호(PK) 
    pcname varchar(100) not null ,			-- 카테고리명
    primary key( pcno )
); 
select * from pcategory;

	# 샘플
insert pcategory(pcname) value ( ' 아우터' );
insert pcategory(pcname) value ( ' 상의' );
insert pcategory(pcname) value ( ' 하의' );
insert pcategory(pcname) value ( ' 신발' );
insert pcategory(pcname) value ( ' 가방' );


# 2. 제품
drop table if exists product;
create table product(
	pno int auto_increment ,			-- 제품번호(PK)
    pname varchar(100) not null ,			-- 제품명
    pcontent longtext,						-- 제품설명
    pprice int unsigned default 0 , 		-- 제품가격
    pstate tinyint default 0 , 				-- 상태 [ 0:판매중(기본값), 1:거래중, 2:판매대기, 3:판매완료 ]
    pdate datetime default now(),			-- 날짜 
    plat varchar(30),	
    plng varchar(30),
    pcno int,
    mno	int,
    primary key( pno ),
    foreign key( pcno ) references pcategory( pcno ) on delete set null on update cascade,
    foreign key( mno ) references membertable( mno ) on delete cascade on update cascade
);
select * from product;

# 3. 제품이미지
drop table if exists productimg;
create table productimg(
	pimgno	int auto_increment,
    pimg  longtext,
    pno int,
    primary key( pimgno ),
    foreign key( pno ) references product( pno ) on delete cascade on update cascade
);
select * from productimg;