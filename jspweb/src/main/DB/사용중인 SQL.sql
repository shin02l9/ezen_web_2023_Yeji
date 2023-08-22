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