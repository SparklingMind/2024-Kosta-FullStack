-- 계층형 쿼리: 직원의 상하 관계를 수직 형태로 표현하되, 트리 구조로 시각화
SELECT LEVEL, empno, mgr, LPAD(' ',4*(LEVEL-1)) || ename AS tree_view
FROM emp
START WITH mgr IS NULL -- 루트 노드 조건: 'mgr' (상사 번호)가 NULL인 직원부터 시작
CONNECT BY PRIOR empno = mgr; -- 연결 조건: 현재 직원(empno)가 다른 직원의 상사(mgr)인 관계 설정

---------------------
CREATE TABLE BOM (
            ITEM_ID     INTEGER NOT NULL,
            PARENT_ID   INTEGER references BOM(item_id),
            ITEM_NAME   VARCHAR2(20)  NOT NULL,
            ITEM_QTY    INTEGER, 
            PRIMARY KEY (ITEM_ID)
);
            

INSERT INTO BOM VALUES ( 1001, NULL, '컴퓨터', 1);
INSERT INTO BOM VALUES ( 1002, 1001, '본체', 1);
INSERT INTO BOM VALUES ( 1003, 1001, '모니터', 1);
INSERT INTO BOM VALUES ( 1004, 1001, '프린터', 1);

INSERT INTO BOM VALUES ( 1005, 1002, 'Mother Board', 1);
INSERT INTO BOM VALUES ( 1006, 1002, '랜카드', 1);
INSERT INTO BOM VALUES ( 1007, 1002, 'Power Supply', 1);

INSERT INTO BOM VALUES ( 1008, 1005, 'RAM', 1);
INSERT INTO BOM VALUES ( 1009, 1005, 'CPU', 1);
INSERT INTO BOM VALUES ( 1010, 1005, '그래픽장치', 1);
INSERT INTO BOM VALUES ( 1011, 1005, '기타장치', 1);

  
 select * from bom;
 
SELECT item_id, parent_id, LPAD(' ', 4*(LEVEL-1)) || item_name AS item_names
FROM bom
START WITH parent_id IS NULL -- 루트 노드 조건: 상위 항목이 없는 최상위 항목으로 시작
CONNECT BY parent_id = PRIOR item_id; -- 연결 조건: 상위 항목(parent_id)이 현재 항목의 item_id에 해당하는 경우

--------------------------CSV, CTL을 이용해 데이터 IMPORT--------------------------------------------------------------------------------------------
--테이블생성
create table zipcode(
  zip varchar2(20) ,
  sido	varchar2(100),
  si	varchar2(100),
  dong	varchar2(200),
  ri	varchar2(100),
  doseo	 varchar2(100),
  bunji	varchar2(100),
  apt	varchar2(100),
  address varchar2(300)
);

--엑셀 데이터 IMPORT 했다.

select * from zipcode; -- 
