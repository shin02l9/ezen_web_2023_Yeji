
# 데이터베이스 생성하기
drop database if exists sqldb2team01animalHospital;
create database sqldb2team01animalHospital;
use sqldb2team01animalHospital;

#테이블 생성하기
drop database if exists treatment;
create table treatment( -- -----------진료과목-----------
	trNo tinyint, -- 진료과목
	trName varchar(10),
    primary key( trNo )
);
drop database if exists doctorInfo;
create table doctorInfo( -- -----------의사정보-----------
	dNo tinyint,
    dName varchar(10), 
    dAge tinyint,
    dPhone varchar(15),
    trNo tinyint,
    primary key( dNo ),
    foreign key( trNo ) references treatment( trNo )-- 진료과목번호
);
drop database if exists patientInfo;
create table patientInfo( -- -----------환자정보-----------
	paNo tinyint,
    paName varchar(10), -- 환자(동물명)
    protectorName varchar(10), -- 보호자명
    paAniAge tinyint,
    weight tinyint,
    breed varchar(10), -- 종
    paPhone varchar(10),
    primary key( paNo )
);
drop database if exists reservationInfo;
create table reservationInfo( -- -----------예약정보-----------
	paNo tinyint, -- 환자번호
    reserDate datetime,
    dNo tinyint, -- 의사번호
    foreign key( paNo ) references patientInfo( paNo ),-- 환자번호
    foreign key( dNo ) references doctorInfo( dNo ) -- 의사번호
);
drop database if exists disease;
create table disease( -- -----------질병정보-----------
	trNo tinyint, -- 진료과목
    diName varchar(10), -- 질병명
    diCode int, -- 질병코드
    primary key( diCode ), -- 질병코드
    foreign key( trNo ) references treatment( trNo )-- 진료과목번호
);
drop database if exists treatmentInfo;
create table treatmentInfo( -- -----------진료정보-----------
	paNo tinyint, -- 환자번호
    reserDate datetime,
    dNo tinyint, -- 의사번호
    diCode int, -- 질병코드
    entry longtext, -- 진료내용
    foreign key( diCode ) references disease( diCode ),-- 질병코드
    foreign key( paNo ) references patientInfo( paNo ),-- 환자번호
    foreign key( dNo ) references doctorInfo( dNo )-- 의사번호
);

