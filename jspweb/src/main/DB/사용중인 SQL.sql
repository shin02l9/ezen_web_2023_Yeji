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