-- 각자의 계정으로 접속한다. conn 계정명/비번

/*
  Datatype의 종류
  1) 문자열   
      CHAR(BYTE수) : 고정길이 - 최대 2000 BYTE
      VARCHAR2(BYTE수) : 가변길이 -최대 4000 BYTE
      
      *유니코드를 지원!!
      NCHAR(BYTE수)
      NVARCHAR2(BYTE수)
      
      * 반드시 문자는 '값'  형식으로 사용한다.
      * ORACLE에서 요즘 UTF-8 인코딩으로 한글자는 3BYTE이다!!
      
        EX) CHAR(6) : 한글 2자, 영문은 6글자
            VARCHAR2(6) : 한글 2자, 영문은 6글자
            
      * CHAR(6 CHAR) : BYTE와 관계없이 6글자까지
        VARCHAR2(6 CHAR) : BYTE와 관계없이 6글자까지
        
      * 대용량의 데이터을 저장해야하는경우 
       LOB : LARGE OBJECT 약자로 대용량의 데이터를 저장할수 있는 데이터 타입 
         1) CLOB : 가변길의 아주 긴 문자열을 저장할때 4GB
         2) BLOB :  가변길의 2진수 형태를 저장할때 4GB
        - LOB타입은 권장하지는 않는다
        
    
  2) 숫자
     : NUMBER
       SMALLINT
       INT
       
       * SMALLINT 또는 INT를 선언해도 결국 내부적으로  NUMBER 타입으로 된다. 
         - 정수형, 실수형 표현
         EX) NUMBER(1) : 정수 -9 ~ 9 표현
             NUMBER(2) : -99 ~ 99 
             
             NUMBER(5,3) : 전체 5자리에서 3자리가 소수점자리.
  
  
  3) 날짜
     : DATE : 년월일 시분초 설정
       TIMESTAMP : 년월일 시분초 + MILS 단위까지 더 정밀하게 표현!!!
      
      *날짜는 반드시 '년-월-일' 형식으로 묶어서 사용한다.
      * 현재 날짜와시간을 구하는 함수 SYSDATE 사용한다.
        EX) SELECT SYSDATE FROM DUAL;
*/


/*
  -테이블 생성
  create table 테이블이름(
    컬럼명 datatype [default 기본값] [ null | not null ] [ constraint 별칭 제약조건 ] ,
    컬럼명 datatype [default 기본값] [ null | not null ] [ constraint 별칭 제약조건 ] ,
    .....
)

  - 제약조건의 종류
   1) PRIMARY KEY : 대표키, 중복X, NOT NULL
   2) FOREIGN KEY :다른 테이블의 컬럼을 참조
   3) UNIQUE : PK유사(테이블에서 대표키는 될수 없는 그렇지만 유일해야하는 속성에 설정) 
   4) CHECK : DOMAIN에 들어갈수 있는 값을 범위를 체크
   
   5) DEFAULT  : 기본값 설정

*/
/*
   1) PRIMARY KEY - PK, 기본키, 대표키
      : PK를 설정하면 중복안됨, NOT NULL , 자동으로 INDEX설정 - EX) 학번, 군번, 주민번호, 상품코드,...아이디...
      : PK는 하나의 테이블에 반드시 한개만 존재
      : 2개의 이상의 컬럼을 하나로 묶어서 PK설정 가능 
          - 복합키설정 : 사용할때 불편해서 모델링 과정속에서 복합키를 대리키로 변환하는 경우 많다!!!
*/
--각자의 계정으로 접속해서 아래 테이블을 TEST해보자. 

--ex 테이블 생성
CREATE TABLE MEMBER(
    ID VARCHAR2(20) CONSTRAINT MEMBER_ID_PK PRIMARY KEY, --NOT NULL, 중복X
    NAME VARCHAR2(10) NOT NULL,--바이트 수 10으로 설정
    JUMIN CHAR(13), --NULL허용
    AGE NUMBER(2), -- -99 ~ 99
    ADDR VARCHAR2(10 CHAR),--무조건 10개 문자
    REG_DATE DATE
);

--검색 확인
SELECT * FROM MEMBER;

--테이블 삭제
DROP TABLE MEMBER;

--테이블의 구조 확인
DESC MEMBER;

/*
  레코드 등록
  INSERT INTO 테이블이름(컬럼명, 컬럼명,....) VALUES(값, 값,값,....);
  INSERT INTO 테이블이름 VALUES(값, 값,값,....); -- 모든 컬럼에 순서대로 값을 넣을때!!!
*/

INSERT INTO MEMBER VALUES('Jung', '정우주', '1111-2222', 20, '서울', SYSDATE); --쿼리문은 대소문자를 가리지 않지만 VALUE는 대소문자를 가린다.
INSERT INTO MEMBER (ID, NAME, AGE) VALUES('ROSE','장미',22);

-삽입 안 되는 예시
INSERT INTO MEMBER(ID, NAME, AGE) VALUES('JUNG','정하나',25); --X. PK는 중복 안 됨.
INSERT INTO MEMBER(NAME, AGE) VALUES('정하나',25); --X. PK는 NOT NULL.
INSERT INTO MEMBER(ID, NAME, AGE) VALUES('FLY','한나라',100); --X. 나이는 2자리만.

--삽입 되는 예시
INSERT INTO MEMBER(ID, NAME, AGE) VALUES('jung','정미나',25); -- 데이터값은 대소문자 가리기 때문에 PK중복 아니다.

INSERT INTO MEMBER(ID,NAME,ADDR,REG_DATE) VALUES('TWO','이둘리','화성','2013-10-10');

-- 10 BYTE VS 10 CHAR 차이
INSERT INTO MEMBER(ID, NAME, ADDR) VALUES('BB','가나다라','서울시'); --X. 한글은 글자당 3바이트라서 위에서 설정한 '가나다라'가 12바이트를 초과.
INSERT INTO MEMBER(ID, NAME, ADDR) VALUES('BB','가나다','서울시 강남구'); --O. ADDR 10 CHAR이므로.

-- CHAR VS VARCAHR2 비교
INSERT INTO MEMBER(ID, NAME, ADDR) VALUES('FF','A','B');
INSERT INTO MEMBER(ID, NAME, ADDR) VALUES('GG','A ','B ');

--VARCHAR2 검색
SELECT * FROM MEMBER WHERE NAME = 'A';
SELECT * FROM MEMBER WHERE NAME = 'A ';

--CHAR 검색
SELECT * FROM MEMBER WHERE ADDR = 'B';
SELECT * FROM MEMBER WHERE ADDR = 'B ';

SELECT NAME, JUMIN, LENGTH(NAME), LENGTH(ADDR) FROM MEMBER WHERE ID = 'GG';


--검색으로 삽입된 행들 확인
SELECT * FROM MEMBER;

--테이블 삭제
DROP TABLE MEMBER;

--하나의 테이블에 두 개의 컬럼을 묶어서 PK 설정하기
CREATE TABLE MEMBER(
    ID VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    JUMIN CHAR(13) NOT NULL, -- NOT NULL 제약 조건 추가
    AGE NUMBER(3),
    REG_DATE DATE,
    CONSTRAINT MEMBER_ID_JUMIN_PK PRIMARY KEY(ID, JUMIN) -- NOT NULL, INDEX 설정, 중복X
);

--테이블 구조확인
DESC MEMBER;

--레코드 추가해서 PK TEST해보자.
INSERT INTO MEMBER VALUES('KIM', '두나', '1111-2222', 20, SYSDATE);
INSERT INTO MEMBER VALUES('HAN','두나','1111-3333',20,SYSDATE); --주민번호 OR ID가 같은 것은 중복 허용
INSERT INTO MEMBER VALUES('LEE','두나','1111-3333',20,SYSDATE);

INSERT INTO MEMBER VALUES('KIM', '두나', '1111-2222', 20, SYSDATE); --X ID AND JUMIN 모두 같아서 중복


--테이블 검색
SELECT * FROM MEMBER;


----------------------------------------------------------------------------
/*
  2) FOREIGN KEY - FK = 외래키
      : 다른 테이블의 PK를 참조하는 것.
      : 테이블에 레코드를 추가할때 참조되는 대상의 값이외에는 등록 할수 없다.
          - 참조무결성원칙!!!. 현실에 없는 데이터를 참조할 가능성이 없다.
      : NULL허용, 중복가능!!
      : 하나의 테이블에 여러개의 컬럼이 FK설정가능하다.
      
      : 재귀적관계 설계 - 자기자신테이블의 PK를 참조하는것!!!
      
      *주의사항
        INSERT 할때 : 부모키가 INSERT -> 자식 INSERT 
        DELETE할때 :  참조하고 있는 자식 DELETE -> 부모 DELETE 해야한다.
      
             * 이러한 주의사항에 대한 불편함을 해결하기 위해서.
               FK를 설정할때 ON DELETE CASCADE 를 추가하면 부모레코드를 삭제하를
              그 부모키를 참조하는 모든 테이블의 레코드를 함께 삭제한다.
	      또는 FK설정할때 on delete set null 를 추가하면
	      부모레코드 삭제될때 참조되는 자식레코드의 값이 null이된다.
      
     
*/

--scott계정 접속
SELECT * FROM EMP; --사원테이블

--각자 계정으로 접속해서 FK 실습
CREATE TABLE DEPT(
    DEPT_CODE CHAR(3) CONSTRAINT DEPT_CODE_PK PRIMARY KEY,
    DNAME VARCHAR2(30) NOT NULL,
    LOC VARCHAR2(30)
);

--샘플레코드 추가
INSERT INTO DEPT VALUES('A01','경리부','서울');
INSERT INTO DEPT VALUES('A02','교육부','대구');
INSERT INTO DEPT VALUES('A03','인사부','서울');

--레코드 검색
SELECT * FROM DEPT;

--사원테이블 생성
CREATE TABLE EMP(
    EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
    ENAME VARCHAR2(15) NOT NULL,
    SAL NUMBER(5),
    DEPT_CODE CHAR(3) CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE),
    HIRE_DATE DATE DEFAULT SYSDATE -- 등록할 때, HIRE_DATE 넣지 않으면 자동으로 기본값이 설정.
);

--테이블 검색
SELECT * FROM DEPT;
SELECT * FROM EMP;

--사원 등록
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (1, '희정', 300, 'A01');
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (2, '나영', 200, 'A01');
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (3, '미미', 300, NULL);

INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (4, '삼식', 100, 'A05'); --X. (부모키가 없습니다.)

INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE, HIRE_DATE) VALUES (4, '삼식', 100, 'A02', '2024-01-20');


INSERT INTO EMP VALUES (6, '삼식', 100, 'A02', DEFAULT);


--삭제
/*
   레코드 삭제방법
    1) ROLLBACK 처리가능 - DML
      DELETE [FROM] 테이블이름
      [WHERE 조건식]
      
        * FROM 생략가능, WHERE절이 없으면 모든 레코드가 삭제된다.
          
    2) ROLLBACK 안된다. - DDL
     TRUNCATE TABLE 테이블이름; --모든레코드를 삭제
*/
--현재 상황을 모두 저장완료
COMMIT;
SELECT * FROM EMP;

--레코드 삭제
DELETE FROM EMP;

ROLLBACK;

-- 부모의 참조되고 있지 않는 레코드를 삭제해본다.(DEPT)
DELETE FROM DEPT WHERE DEPT_CODE='A03';
-- 부모테이블의 참조되고 있는 레코드를 삭제해본다.. (DEPT)
DELETE FROM DEPT WHERE DEPT_CODE='A02'; -- X(무결성 제약조건이 위배되었습니다.) A01은 참조하고 있는 자식 레코드가 존재하기 때문에 삭제가 불가능하다.

--참조되고 있는 자식레코드를 먼저 삭제한 후에 부모 레코드를 삭제해야 한다.
DELETE FROM EMP WHERE DEPT_CODE='A02';
DELETE FROM DEPT WHERE DEPT_CODE='A02'; -- A01은 참조하고 있는 자식 레코드가 존재.


--ON DELTE CASCADE : 부모를 참조하는 자식값까지 삭제.
--ON DELETE CASCADE VS ON DELETE SET NULL 옵션 설정해서 비교해보자
DROP TABLE EMP;

--사원테이블 생성
CREATE TABLE EMP(
    EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
    ENAME VARCHAR2(15) NOT NULL,
    SAL NUMBER(5),
    DEPT_CODE CHAR(3) CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE) ON DELETE CASCADE, -- 부모를 참조하는 자식값까지 삭제.
    HIRE_DATE DATE DEFAULT SYSDATE -- 등록할 때, HIRE_DATE 넣지 않으면 자동으로 기본값이 설정.
);

SELECT * FROM DEPT;
SELECT * FROM EMP;

INSERT INTO DEPT VALUES('A02','인사부','대구');

--EMP 레코드 추가
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (1, '희정', 300, 'A01'); --O
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (2, '나영', 200, 'A01'); --O
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (3, '미미', 300, NULL); --O

-- 부모 테이블의 참조되고 있는 레코드를 삭제해보자. (DEPT)
DELETE DEPT WHERE DEPT_CODE = 'A01'; --ON DELTE CASCADE 옵션이 있기 때문에 삭제 가능.

-- 테이블 삭제하고
DROP TABLE EMP;
-- 옵션을 설정해서 FK 생성
CREATE TABLE EMP(
    EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
    ENAME VARCHAR2(15) NOT NULL,
    SAL NUMBER(5),
    DEPT_CODE CHAR(3) CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE) ON DELETE SET NULL, -- 부모를 참조하는 자식값은 NULL로 바꿈.
    HIRE_DATE DATE DEFAULT SYSDATE -- 등록할 때, HIRE_DATE 넣지 않으면 자동으로 기본값이 설정.
);
-- 레코드 추가하고 
INSERT INTO DEPT VALUES('A01','개발부','서울');
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (1, '희정', 300, 'A01'); --O
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (2, '나영', 200, 'A01'); --O
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (3, '아영', 300, 'A02'); --O

-- 삭제해본다.
DELETE DEPT WHERE DEPT_CODE = 'A01'; --참조되고 있던 값들이 NULL로 바뀐다.

--FK 설정을 SQL문장 맨 뒤에서 작성하는 경우...
DROP TABLE EMP;
CREATE TABLE EMP (
    EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
    ENAME VARCHAR2(15) NOT NULL,
    SAL NUMBER(5),
    DEPT_CODE CHAR(3),
    HIRE_DATE DATE DEFAULT SYSDATE, -- 등록할 때, HIRE_DATE 넣지 않으면 자동으로 기본값이 설정.
    CONSTRAINT EMP_DEPT_CODE_FK FOREIGN KEY(DEPT_CODE) REFERENCES DEPT(DEPT_CODE) ON DELETE SET NULL
);
---------------------------------------------------------------
/*
  3) UNIQUE
      : 중복 안 됨, NULL허용(NOT NULL을 설정하면 PK와 동일) 
      : 후보키 중에 대표키가 될 수 없는 키를 UNIQUE 설정한다. 
      : 한 테이블에 여러 개의 컬럼에 설정가능 
      
  4) CHECK
      : 조건을 설정하여 조건에 만족하지 않는 정보는 INSERT 할수 없다!
    
  
  5) DEFAULT
      : 기본값 설정(자주 사용되는 값을 미리 설정해놓고 자동으로 값이 들어갈수 있도록 하는것)
      : EX) 등록일, 조회수....
      : DEFAULT를 설정할때는 CONSTRAINT 별칭은 안쓴다!!!
      : NOT NULL을 설정하면 DEFALUT를 함께 사용할때는 반드시 DEFAULT를 먼저 작성한다.
*/



---------------------------------------------------------------------------------------------------
/*
  테이블 수정
  
 ① 컬럼추가
  alter table 테이블이름 add 
     (컬럼명 자료형 [제약조건] , 컬럼명 자료형 [제약조건] , ....)
 
 ② 컬럼삭제
 alter table 테이블이름 drop column 컬럼이름
 
 ③ datatype변경
    alter table 테이블이름 modify 컬럼이름 변경자료형
    
④ 컬럼이름 변경
 alter table 테이블이름 rename column 기존컬럼명 to 변경컬럼명
 
 ⑤ 제약조건 추가
  alter table 테이블이름 ADD CONSTRAINT 별칭 제약조건종류 ;
  
 -제약조건 삭제
  ALTER TABLE 테이블이름 DROP CONSTRAINT 별칭;
  
 
 - 테이블 삭제
 drop table 테이블이름

*/

---------------------------------------------------------------------------
/*
SQL의 종류
 - DDL문장(CREATE, DROP, ALTER, TRUNCATE)
 - DML문장(INSERT ,UPDATE, DELETE)
*/

/*
  데이터 조작 : DML(INSERT , UPDATE, DELETE)
   - ROLLBACK OR COMMIT 가능
   
   1) INSERT문장
       -INSERT INTO 테이블이름(컬럼명, 컬럼명,....) VALUES(값, 값,값,....);
       -INSERT INTO 테이블이름 VALUES(값, 값,값,....); -- 모든 컬럼에 순서대로 값을 넣을때!!!
   
   2) DELETE문장
       DELETE [FROM] 테이블이름
       [WHERE 조건식]
   
   3) UPDATE문장
      UPDATE 테이블이름
      SET 컬럼명=변경값 , 컬럼명=변경값,....
      [WHERE 조건식] 

*/



/*
   --테이블 복사
   CREATE TABLE 테이블이름
   AS 복사할테이블정보;
   
   
    주의 : 테이블을 복사하면 제약조건은 복사 안된다!!! - 복사한후에 제약조건을 ALTER를 이용해서 추가한다.

*/
