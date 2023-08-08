# 한줄주석
# 확대, 축소 : 컨트롤 + 마우스휠
-- 한줄주석
/* 여러줄 주석 */


/*
	데이터베이스 : 데이터[자료], 베이스[모임]
		- 종류 
			1. 계층형 데이터베이스 : 트리 형태
            2. 네트워크형 데이터 베이스 : 양방향 형태
            3. *관계형 데이터 베이스 : 행/열 구성된 테이블[표]
			4. NoSQL 데이터 베이스 : key-value
		
        - 용어
			DBA [ 데이터 베이스 관리자 ]
				- 개발자 !
            DBMS [ 데이터베이스 관리 시스템 ]
				- MySQL, ORACLE, MARIADB, SQLSERVER - 각 회사별 소프트웨어
                - 표준 SQL [ 구조화된 쿼리(질의)언어 ]
            DB [ 데이터 베이스 ]
				- 실제 데이터가 저장된 곳 = DB 서버
                - 메모리[16진수/기계어] : 개발자는 직접적으로 관리가 힘들다.
		- 관계
			DBA	--------------------> DB    [X]
            개발자 					기계어
            
            DBA	--------------------> DBMA --------------------> DB   [O]
            개발자 					 관리시스템 					기계어
									  MySQL
									  ORACLE
                       표 만들어줘						기계어
                       create
                       SQL언어학습
                       
            이클립스 ------------------> JVM ---------------------> 메모리   [O]
            개발자 					  번역 				
						출력해줘						기계어
                        print()
						자바언어학습
			
		- SQL (외워야함) : DB 조작/관리/제어 할떄 사용되는 언어/문법 (대소문자 구분 x)
			-1. DDL [ 데이터베이스 정의어 ]
				-1. create		: 데이터베이스, 테이블(표) 생성
					- create database db명;
                    - create table table명(필드명 속성명, 필드명 속성명);
                -2. drop		: 데이터베이스, 테이블(표) 삭제
					- drop database db명;
                    - drop database if exists db명;      만약에 존재 하면 삭제하기 !
                -3. alter		: 테이블(표) 속성 수정 
                -4. truncate	: 테이블(표)내 데이터 초기화/삭제, 테이블은 그대로 남음!
                -5. rename		: 테이블(표) 삭제
                -6. show		: 데이터베이스 보기
					- show databases;					데이터베이스 전체 목록보기
                    - show variables like 'datadir';  데이터베이스가 저장된 로컬[pc]경로 확인
				-7. use 		: 데이터베이스 사용 준비
					use db명;
            -2. DML [ 데이터베이스 조작어 ]
				-1. insert		: 테이블(표)에 레코드(행) 삽입
                -2. select		: 테이블(표)에 레코드(행) 검색
					- select *from 테이블명 	: 테이블내 모든 레코드(행)를 검색 [ *: 와일드 카드]
                -3. update		: 테이블(표)에 레코드(행) 수정
                -4. delete		: 테이블(표)에 레코드(행) 삭제
            -3. DCL [ 데이터베이스 제어어 ]
				-1. grant		: 사용자 권한 부여
                -2. revoke		: 사용자 권한 취소
			-4. TCL [ 트랜잭션 제어어 ]
				-1. commit		: !! 트랜잭션[명령어 단위]완료
                -2. rollback	: 트랜잭션[명령어 단위]취소

		- 테이블 용어 / 테이블 [ 표 ]
				속성		colum	 열				필드
				 |	      |		 |				 |
				학번 		학생명	전화번호 	  		주소		ㅡ 행
                1010	신예지	01011117209		안산		ㅡ 레코드
                1011	김연실 	01024072222		안산		ㅡ row
			1. colum=열=필드=속성	: 테이블[표]의 열
				읽을때 -> 학번필드, 학생명필드, 전화번호필드, 주소필드
			2. row=헹=레코드		: 테이블[표]의 행
				읽을때 -> 1번 레코드, 2번 레코드
			3. 행/열로 구성된 테이블(표)를 다른 테이블(표)와 연결 = 관계형 데이터 베이스
            
		- 데이터 필드 타입 [ myslq기준 *DBMS 조금씩 다름 ]
			1. 정수
				tinyint		[1]	: -128 ~ 127
                smallint	[2] : +- 3만정도
                mediumint	[3]	: +- 8백만정도
                int			[4]	: +- 21억정도
                bigint		[8] : 21억 이상
			2. 실수
				float		[4]	: 소수점 7자리
                double		[8]	: 소수점 15자리
            3. 문자
				[글자수 최소1 ~ 최대255]
				char(문자길이)		: 고정길이	  char(3)-> 'ad' -> 3바이트 	 [*저장할 데이터의 글자수가 정확히 정해져 있는 경우]
                [글자수 최소1 ~ 최대65535]
                varchar(문자길이)	: 가변길이	  varchar(3)-> 'ad' -> 2바이트 [*저장할 데이터의 글자수가 정확하지 않는 경우]
			4. 대용량 문자
				[글자수 최소1 ~ 최대65535]
				text
                [글자수 최소1 ~ 최대16000000]
                mediumtext
                [최대 글자수 억대 넘어감 4G 정도]
                longtext		: 게시물의 내용물, 첨부파일, 이미지, 동영상 등등
            5. 날짜
				date			: (날짜) YYYY-MM-DD
                time			: (시간) HH:MM:SS
                datetime 		: (날짜시간) YYYY-MM-DD HH:MM:SS
            6. 논리
				boolean[1]		: 0 or 1
*/
/*
 		<제약조건>
 
		 1. PK[ 형태 : primary key(PK필드명) ]
		 	- 기본키[식별키] : 식별가능한 필드, 중복x, nullx ,공백x, 테이블당 1개 이상 권장
		 		예) 학번, 사번, 주민등록번호, ISBN, 상호코드 등등
		 2. FK[ 형태 : foreign key( FK필드명 ) references subwayorder( PK필드명 ) ]
		  	- 외래키[참조키] : 다른테이블에 PK필드를 참조하는 필드
 				예) 점수테이블(접수자), 출결(출근시 한번), 각종서류(주민등록번호), 대여(ISBN), 재고관리(상호코드) 등등

			# PK와 FK 필드 선정 
				PK : 데이터의 중복이 없는 식별 가능한 필드 [ 후보 : mno, mid ]
					- 번호 형태의 PK 권장하는 이유 : 문자열 데이터 필드보다 메모리 효율적으로 사용가능.
					테이블1개당 PK필드 1개 이상 권장 O
					
				FK : 다른 테이블에 있는 PK필드와 연결
					1. FK필드명은 PK필드명과 동일하게 사용 
					2. [필수] FK필드의 타입은 PK필드의 타입과 동일
					3. [참조하는 테이블]에서 FK필드 

		3. auto_increment	: insert(삽입) 할때 해당 필드를 생략하면 자동번호 부여 [ 자동으로 1씩 증가 ]
			* auto_increment를 사용 하려면 무조건 PK필드에서 사용 가능
			
		4. not null 		: insert(삽입) 할때 해당 필드의 공백 방지
		5. unique			: insert(삽입) 할때 해당 필드의 값 중복 방지




*/

		#예1 : 데이터베이스(여러개의 테이블(표)들을 저장 할수 있는 공간) 생성
			create database sqldb1;
				# create 	: 생성한다.
                # database 	: 데이터베이스 
                # sqldb1 	: db명 이름정의 [ 아무거나, 대소문자 구분x, 키워드x ]
                # ; 		: 하나의 명령어의 끝마침
					# 해당 명령어 줄에 커서 위치한 상태에서 컨트롤+엔터
			create database sqldb2;
            create database sqldb3;
            create database sqldb4;
            create database sqldb5;
            
		#예2 : 데이터베이스의 목록보기
			show databases;
        
        #예3 : 데이터베이스가 저장된 로컬[pc]경로 확인
			show variables like 'datadir';
        
        #예4 : 데이터베이스 삭제
			drop database sqldb1;
				# drop 		: 삭제한다.
                # database 	: 데이터베이스 
                # sqldb1 	: db명 이름정의 [ 아무거나, 대소문자 구분x, 키워드x ]
                # ; 		: 하나의 명령어의 끝마침
			drop database sqldb2;
            drop database sqldb3;
            drop database sqldb4;
            drop database sqldb5;

		#예5 : 만약에 데이터베이스 없을떄 삭제 명령어 사용하면 오류 발생
        drop database if exists sqldb1;
        drop database if exists membersqldb2;
	
		#예6 : 여러개의 데이터베이스중 사용할 데이터 베이스 선택 !!
        use sqldb1;
		use sqldb2;
        
        #활용1 : 데이터베이스 새롭게 생성하세요.
			#1. 데이터베이스 존재하면 삭제부터 하고 시작하기
			drop database if exists test1;
            #2. 데이터베이스 생성 
            create database test1;
            #3. 데이터베이스 사용 준비
            use test1;
            
            
		/* ------------------- 표만들기 ---------------------- */
		# 테이블(표)는 데이터 베이스 안에 저장 [ *무슨 데이터 베이스에 생성 할껀지?... use DB명;]
        #예1 : 테이블 생성
        use sqldb1; -- 테이블을 생성할 데이터베이스 선택 
		create table member(아이디 text, 비밀번호 text);
			# create		: 생성한다.
            # table			: 테이블
            # member		: 이름정의 [ 아무거나, 대소문자 구분x, 키워드x ]
            # ()			: 테이블 속성 정의/열/필드 정의 구역
				# ( 필드명 타입, 필드명 타입, 필드명 타입, 필드명 타입 ) : 테이블(표) 제목/속성/열/필드 정의
                
		#예2: 테이블 확인
        select *from member;
        
        #예2: 테이블 삭제
        drop table member;
        
        #활용2 : 
			/*
			문제 1:
				1.웹개발을 하는데 DB저장소가 필요해 'sqldb1web' 이름으로 DB 생성
                2. 해당 DB에 member 테이블 생성
					id (문자열 최대 20)
                    pw (문자열 최대 10)
			*/
            #1. 만약에 생성할 이름의 DB명이 존재하면 삭제하기
            drop database if exists sqldb1web;
            #2. DB 생성
            create database sqldb1web;
            #3. DB 사용 선택
            use sqldb1web;
            #4. 만약에 생성할 이름의 테이블명이 존재하면 삭제하기
			drop database if exists member;
            #5. 테이블 생성하기
            create table member(id varchar(20), pw varchar(10));
            
			/*
			문제 2:
				1.웹개발을 하는데 DB저장소가 필요해 'sqldb1web2' 이름으로 DB 생성
                2. 해당 DB에 board 테이블 생성
					게시물번호 		(필드명 : bno 			타입 : 최대 21억 정도)
					게시물제목 		(필드명 : btitle 		타입 : 문자열 최대 100)
                    게시물내용 		(필드명 : bcontent  	타입 : 문자열 최대 6만 5천자 이상)
                    게시물조회수 	(필드명 : bview 		타입 : 최대 21억 정도)
                    게시물작성일 	(필드명 : bdate 	타입 : 날짜/시간)
			*/
			#1. 만약에 생성할 이름의 DB명이 존재하면 삭제하기
            drop database if exists sqldb1web2;
            #2. DB 생성
            create database sqldb1web2;
            #3. DB 사용 선택
            use sqldb1web2;
            #4. 만약에 생성할 이름의 테이블명이 존재하면 삭제하기
			drop database if exists board;
            #5. 테이블 생성하기
            create table board(bno int, btitle varchar(100), bcontent longtext, bview int, bdate datetime);
            select *from board; -- 만든 테이블 확인하기~
            
            
            /*
				문제3 : 
					1. 웹개발 하는데 DB저장소 'sqldb2web1' 이름으로 DB 생성
					2. 해당 db에 memberboard 테이블 생성
							회원번호		( 필드명 : mno		타입 : 최대 21억정도 )
			                회원아이디		( 필드명 : mid		타입 : 문자열 최대 20 )
			                회원비밀번호 	( 필드명 : mpw		타입 : 문자열 최대 20 )
							게시물번호 	( 필드명 : bno  		타입 : 최대 21억정도 )
							게시물제목		( 필드명 : btitle 	타입 : 문자열 최대 100 )	
							게시물내용 	( 필드명 : bcontent 	타입 : 문자열 최대 6만5천 이상 )
							게시물조회수	( 필드명 : bview 		타입 : 최대 21억정도 )
							게시물작성일 	( 필드명 : bdate 		타입 : 날짜/시간 )
			*/
			# 1. 데이터베이스 생성 
			drop database if exists sqldb2web1; # 만약에 동일한 db명이 존재했을때 생성불가능 하기 때문에 만약에 존재하면 삭제
			create database sqldb2web1; 		# 실행 : [명령어]; 마다 컨트롤+엔터 
			# 2. 테이블 생성 
			use sqldb2web1;
			drop table if exists memberboard;
			create table memberboard(
					mno int , 			
			        mid varchar(20)	, 		
			        mpw varchar(20) , 		
					bno int ,				
					btitle varchar(100) , 	
					bcontent longtext , 	
					bview int , 			
					bdate datetime 		
			);
			select * from memberboard;
			
			/*
				문제4 : 
					1. 웹개발 하는데 DB저장소 'sqldb2web1' 이름으로 DB 선택
					2. 해당 db에 memberboard 테이블을 중복을 최소화 할수 있도록 2개의 테이블로 분리하여 각각 생성 [ 필드과 타입은 문제3 동일 ]
			*/
			
			use sqldb2web1;
			drop table if exists member;
			create table member(
					mno int , 				
			        mid varchar(20)	, 	
			        mpw varchar(20)  	
			);
			select * from member;
			
			drop table if exists board;
			create table board(
					bno int ,				
					btitle varchar(100) , 
					bcontent longtext , 	
					bview int , 			
					bdate datetime 		
			);
			select * from board;
			# ----------------------------> 테이블 관계 상태 확인 : 메뉴 -> database -> reverse enginner
			
			-- 예1 : 1:M 관계 / PK:FK 관계 
			use sqldb2web1;
			drop table if exists member2;
			create table member2(
					mno_pk int , 				
			        mid varchar(20)	, 		
			        mpw varchar(20) ,
					primary key( mno_pk )	-- 현재 테이블에서 mno_pk 라는 필드를 식별키로 사용 
			);
			drop table if exists board2;
			create table board2(
					bno int ,				
					btitle varchar(100) , 	
					bcontent longtext , 	
					bview int , 			
					bdate datetime ,
			        mno_fk int ,  			-- 1. FK 필드 선언 
			        foreign key( mno_fk ) references member2( mno_pk ) 	-- 2. 현재 테이블에서 mno_fk 라는 필드를 외래키로 사용 
						# foreign key( mno_fk ) 		: 'mno_fk' 라는 필드를 FK 필드로 설정 
			            # references member2( mno_pk ) 	: FK필드를 member2 테이블의 mno_pk 필드와 참조.. [ 관계 ] 
			);


            
            drop database if exists sqldb3web;
		    create database sqldb3web;
		    use sqldb3web;
		    drop database if exists member1;
		    create table member1(
				mno int auto_increment,
		        primary key(mno)
		    );
		    select * from member1;
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            