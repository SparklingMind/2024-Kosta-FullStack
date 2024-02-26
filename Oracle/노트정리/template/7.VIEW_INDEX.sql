/*
   VIEW : 가상테이블
     - 실제 존재하지 않지만 실제 테이블과 똑같이 사용함 : (select , insert , delete, update 가능)
       : 생성할때 옵션을 어떻게 설정하느냐에 따라 DML 여부가 달라진다.
       : JOIN을 뷰로 만들었을때는 DML 안됨
       
     -사용하는 이유?? 
        :  복잡한 쿼리문을(조인, 서브쿼리)미리 뷰로 만들어 사용하 간단하게 검색 가능함.(단,insert , delete, update 안됨)
        
        :  보안을 위해 사용함(관리자 유형에 따라 특정 컬럼 만 선택하여 보여줌)
           - 테이블의 특정한 컬럼과 레코드를 선택해서 뷰를 만들어 권한에 제한이 있는 DBA에게 원본테이블이 아닌 뷰의 이름을
              알려줌으로써 DBA는 뷰만 접근 할수 있도록 제한을 둔다. 

    -뷰 생성방법
     CREATE VIEW 뷰이름
     AS 뷰의내용;
     
     --뷰 수정 + 생성
     CREATE OR REPLACE VIEW 뷰이름
     AS 뷰의 내용;
     
     --뷰삭제
     DROP VIEW 뷰이름;

*/
--SCOTT계정으로 접속
DROP TABLE COPY_EMP;



--테이블 복사
CREATE TABLE COPY_EMP AS SELECT * FROM EMP;

SELECT * FROM COPY_EMP;

--COPY_EMP 원본으로 사용하는 VIEW 만들어보자.


--뷰생성
CREATE OR REPLACE VIEW V_EMP
AS SELECT * FROM COPY_EMP;  -- 실제 테이블이 생성된 것이 아니라 COPY_EMP를 바라보는 가상테이블이 생성된 것이다.

--뷰검색
SELECT * FROM V_EMP;



--뷰를 검색해본다.
SELECT * FROM V_EMP;

--뷰는 테이블처럼 사용되기 때문에 SELECT, INSERT, UPDATE, DELETE 기본적으로 가능하다.

--뷰에 INSERT 해보기
INSERT INTO V_EMP(EMPNO, ENAME, JOB, SAL) VALUES(9000,'HEEJUNG','STUDENT',3000); --COPY_EMP에도 레코드가 들어가 있음을 확인할 수 있다. (같은 테이블이기 때문)

--뷰에 DELETE 해보기
DELETE FROM V_EMP
WHERE ENAME = 'HEEJUNG';

--뷰에서 삭제해본다.
DROP VIEW V_EMP;
-----------------------------------------------------------
-- 보안적인 측면으로 VIEW를 만들어보자 (조건에 해당하는 레코드와 컬럼을 선택해서 뷰을 만들어보자)
SELECT * FROM COPY_EMP;

--EX)부서번호가 20인 사원의 정보를 VIEW로 만들어본다.
CREATE OR REPLACE VIEW V_EMP
AS SELECT * FROM COPY_EMP WHERE DEPTNO='20';

--뷰 검색
SELECT * FROM V_EMP;


--VIEW와 TABLE에 각각 INSERT (DEPTNO가 20인 경우, 20이 아닌 경우)

--VIEW에 INSERT
INSERT INTO V_EMP(EMPNO, ENAME, DEPTNO)
VALUES (9000, 'HEE', 30);  --DEPTNO가 20이 아니더라도 삽입이 된다.

--다시 뷰 검색
SELECT * FROM V_EMP; --DEPTNO 20이 아닌 새로운 레코드는 보이지 않는다.
SELECT * FROM COPY_EMP; --COPY_EMP에는 DEPT 30인 새로운 레코드가 삽입된 것을 확인할 수 있다.

/*
위의 쿼리가 성공을 하고 V_EMP를 검색해보면 V_EMP 의 VIEW는 조건이 20번 부서만 검색된 VIEW 이기 때문에 등록(COPY_EMP에 추가)은 되었으나 검색에서는 나오지 않는다.
뷰를 사용하는 입장에서 당황할 수 있다.
->VIEW를 생성할 때, WITH CHECK OPTION이나 WITH READ ONLY를 사용해서 조건에 만족하지 않는 레코드 조작을 할 수 없도록 설정할 수 있다.

      1) WITH CHECK OPTION : 뷰를 생성할때 조건을 이용해서 만들게 되면 INSERT, UPDATE, DELETE를 할 때 조건에 충족하지 않는
                              정보는 DML을 할수 없도록 하는것!!
                              
      2) WITH READ ONLY : 읽기전용(DML 안됨)
      
*/

--뷰에 옵션을 설정해보자.
CREATE OR REPLACE VIEW V_EMP
AS SELECT * FROM COPY_EMP WHERE DEPTNO = 20 WITH CHECK OPTION;

--옵션 설정한 경우의 조건에 위반되는 레코드 삽입
INSERT INTO V_EMP(EMPNO, ENAME, DEPTNO)
VALUES (9000, 'HEE', 30);   --조건에 위배되어 실행되지 않는다.

--뷰를 읽기 전용으로 생성해보자.
CREATE OR REPLACE VIEW V_EMP
AS SELECT * FROM COPY_EMP WHERE DEPTNO = 20 WITH READ ONLY;

--읽기 전용 뷰에 삽입 시도
INSERT INTO V_EMP(EMPNO, ENAME, DEPTNO)
VALUES (9000, 'HEE', 20);   --읽기 전용 뷰에서는 DML 작업을 수행할 수 없다는 에러가 뜬다.
----------------------------------------------------------------
--2) 복잡한 쿼리(JOIN, SUBQUERY)를 미리 뷰로 만들어서 조회할때 간소화 하게 조회 할수 있도록 하는 용도


 ---------------------------------------------------------
 /*
   CREATE문장 : TABLE, VIEW, SEQUENCE , INDEX
        - OBJECT=객체 - 물리적공간에 정보 존재하는 것....
 */
 --현재 계정에서 사용할수 있는 객체들의 대한 정보를 검색하고 싶다!!!!
 
 SELECT * FROM USER_TABLES;
 SELECT * FROM USER_VIEWS;
 SELECT * FROM USER_SEQUENCES;
 SELECT * FROM USER_INDEXES;
 
 SELECT *FROM EMP;
 
 
 /*
   INDEX
     : 인덱스는 색인을 만들어서 조회성능을 극대화 하기 위해 만드는 객체이다.
     : 인덱스는 무조건 만든다고 해서 좋은것은 아니고 전체 테이블의 구조를 잘 보고 선택해야한다.
     : 왜냐하면, 인덱스는 특정테이블의 레코드검색 속도를 빠르게 하는데 도움이 되지만 전체시스템 내에서 너무 많은 인덱스가 있으면 전체 성능은 저하될수 있다. 
       잦은 INSERT, UPDATE, DELETE를 하게 되면 그때마다 INDEX설정이 변경되기 때문에 전체 계정안에서 시스템 부하가 생긴다(느려진다)
       검색속도를 높이기 위해서 인덱스를 먼저 선택하기 보다는 SQL문장을 좀더 효율적으로 짜는 노력을 하는것 더 좋다!!
      
      :주로 인덱스 대상이 되는 컬럼은 검색의 조건으로 많이 활용되는 컬럼으로 만든다.
      
      : 인덱스 생성
       CREATE INDEX 인덱스명 ON 테이블이름(컬럼명, 컬럼명,....) ;
       
      : 인덱스 삭제
       DROP INDEX 인덱스명;
 */
 

 CREATE INDEX INDEX_SAL ON EMP(SAL);
 
 DROP INDEX INDEX_SAL;
 
 
 
 
 
 
 
 
 
 
 
 
 
 





