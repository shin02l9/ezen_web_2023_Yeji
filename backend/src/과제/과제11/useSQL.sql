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