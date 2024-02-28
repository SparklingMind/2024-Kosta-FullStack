-- ������ �������� �����Ѵ�. conn ������/���

/*
  Datatype�� ����
  1) ���ڿ�   
      CHAR(BYTE��) : �������� - �ִ� 2000 BYTE
      VARCHAR2(BYTE��) : �������� -�ִ� 4000 BYTE
      
      *�����ڵ带 ����!! \uxxxx
      NCHAR(BYTE��)
      NVARCHAR2(BYTE��)
      
      * �ݵ�� ���ڴ� '��'  �������� ����Ѵ�.
      * ORACLE���� ���� UTF-8 ���ڵ����� �ѱ� �� ���ڴ� 3BYTE�̴�!!
      
        EX) CHAR(6) : �ѱ� 2��, ������ 6����
            VARCHAR2(6) : �ѱ� 2��, ������ 6����
            
      * CHAR(6 CHAR) : BYTE�� ������� 6���ڱ���
        VARCHAR2(6 CHAR) : BYTE�� ������� 6���ڱ���
        
      * ��뷮�� �������� �����ؾ��ϴ°�� 
       LOB : LARGE OBJECT ���ڷ� ��뷮�� �����͸� �����Ҽ� �ִ� ������ Ÿ�� 
         1) CLOB : �������� ���� �� ���ڿ��� �����Ҷ� 4GB
         2) BLOB :  �������� 2���� ���¸� �����Ҷ� 4GB
        - LOBŸ���� ���������� �ʴ´�
        
    
  2) ����
     : NUMBER
       SMALLINT
       INT
       
       * SMALLINT �Ǵ� INT�� �����ص� �ᱹ ����������  NUMBER Ÿ������ �ȴ�. 
         - ������, �Ǽ��� ǥ��
         EX) NUMBER(1) : ���� -9 ~ 9 ǥ��
             NUMBER(2) : -99 ~ 99 
             
             NUMBER(5,3) : ��ü 5�ڸ����� 3�ڸ��� �Ҽ����ڸ�.
  
  
  3) ��¥
     : DATE : ����� �ú��� ����
       TIMESTAMP : ����� �ú��� + MILS �������� �� �����ϰ� ǥ��!!!
      
      *��¥�� �ݵ�� '��-��-��' �������� ��� ����Ѵ�.
      * ���� ��¥�ͽð��� ���ϴ� �Լ� SYSDATE ����Ѵ�.
        EX) SELECT SYSDATE FROM DUAL;
*/


/*
  -���̺� ����
  create table ���̺��̸�(
    �÷��� datatype [default �⺻��] [ null | not null ] [ constraint ��Ī �������� ] ,
    �÷��� datatype [default �⺻��] [ null | not null ] [ constraint ��Ī �������� ] ,
    .....
)

  - ���������� ����
   1) PRIMARY KEY : ��ǥŰ, �ߺ�X, NOT NULL
   2) FOREIGN KEY :�ٸ� ���̺��� �÷��� ����
   3) UNIQUE : PK����(���̺��� ��ǥŰ�� �ɼ� ���� �׷����� �����ؾ��ϴ� �Ӽ��� ����) 
   4) CHECK : DOMAIN�� ���� �ִ� ���� ������ üũ
   
   5) DEFAULT  : �⺻�� ����

*/
/*
   1) PRIMARY KEY - PK, �⺻Ű, ��ǥŰ
      : PK�� �����ϸ� �ߺ��ȵ�, NOT NULL , �ڵ����� INDEX���� - EX) �й�, ����, �ֹι�ȣ, ��ǰ�ڵ�,...���̵�...
      : PK�� �ϳ��� ���̺� �ݵ�� �Ѱ��� ����
      : 2���� �̻��� �÷��� �ϳ��� ��� PK���� ���� 
          - ����Ű���� : ����Ҷ� �����ؼ� �𵨸� ����(��-��-��)�ӿ��� ����Ű�� �븮Ű�� ��ȯ�ϴ� ��� ����!!!
*/
--
--������ �������� �����ؼ� �Ʒ� ���̺���  TEST�غ���

--ex) ���̺� ����
CREATE TABLE MEMBER(
   ID VARCHAR2(20) CONSTRAINT MEMBER_ID_PK PRIMARY KEY , --NOT NULL, �ߺ�X
   NAME VARCHAR2(10) NOT NULL,
   JUMIN CHAR(13), --NULL���
   AGE NUMBER(2) ,  -- -99 ~ 99
   ADDR VARCHAR2(10 CHAR),
   REG_DATE DATE
);

--�˻� Ȯ��
SELECT * FROM MEMBER;

--���̺��� ���� Ȯ��
DESC MEMBER;


-- ���̺� ����
DROP TABLE MEMBER;


/*
  ���ڵ� ���
  INSERT INTO ���̺��̸�(�÷���, �÷���,....) VALUES(��, ��,��,....);
  INSERT INTO ���̺��̸� VALUES(��, ��,��,....); -- ��� �÷��� ������� ���� ������!!!
*/
 INSERT INTO MEMBER VALUES('JANG','������','1111-2222',20,'����',  SYSDATE );
 INSERT INTO MEMBER(ID,NAME,AGE) VALUES('HEE','�̹�',22);
 
 INSERT INTO MEMBER(ID, NAME, AGE)VALUES('JANG','���',27); --X PK�� �ߺ��ȵ�.
 INSERT INTO MEMBER( NAME, AGE)VALUES('���',27); --X  ID �� NOT NULL
 INSERT INTO MEMBER(ID, NAME, AGE)VALUES('KING', '���',100); --X  ���̴� 2�ڸ��� 
 
 INSERT INTO MEMBER(ID, NAME, AGE)VALUES('jang', '���',99); --�����Ͱ��� ��ҹ��� ������.
 insert into member(id,name,addr,reg_date) values('aa','���','����', '2023-10-10');
 
 -- 10byte vs 10 char ���� 
 insert into member(id, name,addr) values('bb','�����ٶ�','�����'); --x
insert into member(id, name,addr) values('bb','������','����� ������');-- addr 10 char �̹Ƿ� 
 
--char vs varchar2 ��
INSERT INTO MEMBER(ID, NAME, JUMIN) VALUES('FF','A','B');
INSERT INTO MEMBER(ID, NAME, JUMIN) VALUES('GG','A ','B ');

--VARCHAR2 �˻�
SELECT * FROM MEMBER WHERE NAME='A';
SELECT * FROM MEMBER WHERE NAME='A ';

--CHAR �˻�
SELECT * FROM MEMBER WHERE JUMIN='B';
SELECT * FROM MEMBER WHERE JUMIN='B ';

SELECT NAME, JUMIN, LENGTH(NAME), LENGTH(JUMIN) FROM MEMBER WHERE ID='FF';

--.�˻�
SELECT * FROM MEMBER;

--���̺����
DROP TABLE MEMBER;

-- �ϳ��� ���̺� �ΰ��� �÷��� �ϳ��� ��� PK�����ϱ� 
 CREATE TABLE MEMBER(
   ID VARCHAR2(20) ,
   NAME VARCHAR2(30) NOT NULL,
   JUMIN CHAR(13),
   AGE NUMBER(3),
   REG_DATE DATE ,
   CONSTRAINT MEMBER_ID_JUMIN_PK PRIMARY KEY(ID,JUMIN) --NOT NULLL, INDEX ����, �ߺ�X
 );
 
 --���̺� ����Ȯ��
 DESC MEMBER;
 
 --���ڵ� �߰��ؼ� PK TEST�غ���
 INSERT INTO MEMBER VALUES('JANG','����','11111-22222', 20 , SYSDATE );
 
 INSERT INTO MEMBER VALUES('JANG','����2','11111-3333', 20 , SYSDATE );
 INSERT INTO MEMBER VALUES('HEE','����3','11111-3333', 20 , SYSDATE );
 
INSERT INTO MEMBER VALUES('HEE','����4','11111-3333', 20 , SYSDATE ); --X - D AND JUMNIN ��� ���Ƽ� �ߺ�

INSERT INTO MEMBER VALUES(NULL,'����4','11111-3333', 20 , SYSDATE ); -- ID �÷� NULL�ȵ�

INSERT INTO MEMBER VALUES('hEE','����4','11111-3333', 20 , SYSDATE ); --o

 --���̺� �˻�
  SELECT * FROM MEMBER;


----------------------------------------------------------------------------
/*
  2) FOREIGN KEY - FK = �ܷ�Ű
      : �ٸ� ���̺��� PK�� �����ϴ� ��.
      : ���̺� ���ڵ带 �߰��Ҷ� �����Ǵ� ����� ���̿ܿ��� ��� �Ҽ� ����.
          - �������Ἲ��Ģ!!!
      : NULL���, �ߺ�����!!
      : �ϳ��� ���̺� �������� �÷��� FK���������ϴ�.
      
      : ��������� ���� - �ڱ��ڽ����̺��� PK�� �����ϴ°�!!!
      
      *���ǻ���
        INSERT �Ҷ� : �θ�Ű�� INSERT -> �ڽ� INSERT 
        DELETE�Ҷ� :  �����ϰ� �ִ� �ڽ� DELETE -> �θ� DELETE �ؾ��Ѵ�.
      
             * �̷��� ���ǻ��׿� ���� �������� �ذ��ϱ� ���ؼ�.
               FK�� �����Ҷ� ON DELETE CASCADE �� �߰��ϸ� �θ��ڵ带 �����ϸ�
              �� �θ�Ű�� �����ϴ� ��� ���̺��� ���ڵ带 �Բ� �����Ѵ�.
	      �Ǵ� FK�����Ҷ� on delete set null �� �߰��ϸ�
	      �θ��ڵ� �����ɶ� �����Ǵ� �ڽķ��ڵ��� ���� null�̵ȴ�.   
*/
--SCOTT���� ����
 SELECT  *FROM EMP; --������̺�
 
 --���� �������� �����ؼ� FK�ǽ��غ���
 --�μ����̺�
 CREATE TABLE DEPT(
   DEPT_CODE CHAR(3) CONSTRAINT DEPT_CODE_PK PRIMARY KEY,
   DNAME VARCHAR2(30) NOT NULL,
   LOC VARCHAR2(30)
 );
 
 --���÷��ڵ� �߰�
 INSERT INTO DEPT VALUES('A01','�渮��','����');
 INSERT INTO DEPT VALUES('A02','������','�뱸');
 INSERT INTO DEPT VALUES('A03','�λ��','����');

--���ڵ� �˻�
SELECT * FROM DEPT;

--������̺� ����
CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(15) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3)CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE),
  HIRE_DATE DATE DEFAULT SYSDATE -- ����Ҵ� HIRE_DATE���������� �ڵ����� �⺻���� ����
);

--���̺� �˻�
SELECT * FROM DEPT;
SELECT * FROM EMP;

--��� ���
INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE) VALUES(1,'����',300,'A01');-- O
INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE) VALUES(2,'����',200,'A01'); --O
INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE) VALUES(3,'�̹�',200,NULL);--O

INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE) VALUES(4,'���',100,'A05');--X(�θ� Ű�� �����ϴ�)

INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE,HIRE_DATE ) VALUES(4,'���',100,'A02', '2024-01-20');
INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE,HIRE_DATE ) VALUES(5,'���',100,'A02', NULL);

INSERT INTO EMP VALUES(6,'���',100,'A02', DEFAULT);

--����
/*
   ���ڵ� �������
    1) ROLLBACK ó������ - DML
      DELETE [FROM] ���̺��̸�
      [WHERE ���ǽ�]
      
        * FROM ��������, WHERE���� ������ ��� ���ڵ尡 �����ȴ�.
          
    2) ROLLBACK �ȵȴ�. - DDL
     TRUNCATE TABLE ���̺��̸�; --��緹�ڵ带 ����
      
*/
--���� ��Ȳ�� ��� ����Ϸ�
COMMIT;
SELECT * FROM DEPT;
SELECT * FROM EMP;

--���ڵ� ����
DELETE FROM EMP;
ROLLBACK;

-- �θ��� �����ǰ� ���� �ʴ·��ڵ带 �����غ���.(DEPT)
DELETE FROM DEPT WHERE DEPT_CODE='A03'; --O

--�θ����̺��� �����ǰ� �ִ� ���ڵ带 �����غ���..(DEPT)
DELETE FROM DEPT WHERE DEPT_CODE='A02';--���Ἲ ��������(C##JANG.EMP_DEPT_CODE_FK)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
 
 --�����ǰ� �ִ� �ڽķ��ڵ带 ���� �������Ŀ� �θ��ڵ带 �����ؾ��Ѵ�.
 DELETE FROM EMP WHERE DEPT_CODE='A02';
 DELETE FROM DEPT WHERE DEPT_CODE='A02';
 
 -- ON DELETE CASCADE VS ON DELETE SET NULL  �ɼ� �����ؼ� ���غ���
 
 DROP TABLE EMP;
 
 --������̺� ����
CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(15) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3)CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE) ON DELETE CASCADE ,
  HIRE_DATE DATE DEFAULT SYSDATE -- ����Ҵ� HIRE_DATE���������� �ڵ����� �⺻���� ����
);

 SELECT  *FROM DEPT;
  SELECT  *FROM EMP;
 INSERT INTO DEPT VALUES('A02','�λ��','�뱸');
 
--EMP ���ڵ� �߰�
INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE) VALUES(1,'����',300,'A01');-- O
INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE) VALUES(2,'����',200,'A01'); --O
INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE) VALUES(3,'�̹�',200,NULL);--O

--�θ����̺��� �����ǰ� �ִ� ���ڵ带 �����غ���(DEPT)
DELETE DEPT WHERE DEPT_CODE ='A01'; -- ON DELETE CASCADE 


--���̺� �����ϰ�
DROP TABLE EMP;

--�ɼ��� �����ؼ� FK ����
CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(15) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3)CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE) ON DELETE SET NULL ,
  HIRE_DATE DATE DEFAULT SYSDATE -- ����Ҵ� HIRE_DATE���������� �ڵ����� �⺻���� ����
);

--���ڵ� �߰��ϰ�
INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE) VALUES(1,'����',300,'A02');-- O
INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE) VALUES(2,'����',200,'A02'); --O
INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE) VALUES(3,'�̹�',200,NULL);--O

--�����غ���.
DELETE FROM DEPT WHERE DEPT_CODE='A02';


DROP TABLE EMP;
--FK������ SQL���� �ǵڿ��� �ۼ��ϴ� ���...
CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(15) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3) ,
  HIRE_DATE DATE DEFAULT SYSDATE, -- ����Ҵ� HIRE_DATE���������� �ڵ����� �⺻���� ����
  CONSTRAINT EMP_DEPT_CODE_FK FOREIGN KEY(DEPT_CODE) REFERENCES DEPT(DEPT_CODE) ON DELETE SET NULL 
);

---------------------------------------------------------------
/*
  3) UNIQUE
      : �ߺ��ȵ�, NULL���(NOT NULL�� �����ϸ� PK�� ����) 
      : �ĺ�Ű�߿� ��ǥŰ�� �ɼ� ���� Ű�� UNIQUE �����Ѵ�. 
      :  �����̺� �������� �÷��� ��������
      
  4) CHECK
      : ������ �����Ͽ� ���ǿ� �������� �ʴ� ������ INSERT �Ҽ� ����!
    
  
  5) DEFAULT
      : �⺻�� ����(���ֻ��Ǵ� ���� �̸� �����س��� �ڵ����� ���� ���� �ֶǷ� �ϴ°�)
      : EX) �����, ��ȸ��....
      : DEFAULT�� �����Ҷ��� CONSTRAINT ��Ī�� �Ⱦ���!!!
      : NOT NULL�� �����ϸ� DEFALUT�� �Բ� ����Ҷ��� �ݵ�� DEFAULT�� ���� �ۼ��Ѵ�.
*/
-- UNIQUE, DEFAULT , CHECK  TEST �غ���
CREATE TABLE TEST(
   ID VARCHAR2(10) PRIMARY KEY , --��Ī ����
   JUMIN CHAR(13) NOT NULL UNIQUE,
   NAME VARCHAR2(10) UNIQUE,
   AGE NUMBER(2) CHECK (AGE >=20 AND AGE <=30),
   GENDER CHAR(3) CHECK(GENDER ='��' OR GENDER='��'),
   REG_DATE DATE DEFAULT SYSDATE  NOT NULL
);

DESC TEST;

SELECT  *FROM TEST;

--���ڵ� �߰�
INSERT INTO TEST(ID, JUMIN, NAME)VALUES('JANG','111','����');
INSERT INTO TEST(ID, JUMIN, NAME)VALUES('HEE','222',NULL);
INSERT INTO TEST(ID, JUMIN, NAME)VALUES('KING','333',NULL);

INSERT INTO TEST(ID, JUMIN, NAME)VALUES('AAA','333','����'); --UNIQUE �ߺ��ȵ�.

INSERT INTO TEST(ID, JUMIN, NAME,AGE, GENDER)VALUES('BB','444','����2', 22,'��');

INSERT INTO TEST(ID, JUMIN, NAME,AGE, GENDER)VALUES('CC','55','����3', 25,'��');
---------------------------------------------------------------------------------------------------
/*
  ���̺� ����
  
 �� �÷��߰�
  alter table ���̺��̸� add 
     (�÷��� �ڷ��� [��������] , �÷��� �ڷ��� [��������] , ....)
 
 
 �� �÷�����
 alter table ���̺��̸� drop column �÷��̸�
 
 �� datatype����
    alter table ���̺��̸� modify �÷��̸� �����ڷ���
    
�� �÷��̸� ����
 alter table ���̺��̸� rename column �����÷��� to �����÷���
 
 �� �������� �߰�
  alter table ���̺��̸� ADD CONSTRAINT ��Ī ������������ ;
  
 -�������� ����
  ALTER TABLE ���̺��̸� DROP CONSTRAINT ��Ī;
  
 
 - ���̺� ����
 drop table ���̺��̸�
*/

drop table test;

create table test(
  id varchar2(20),
  name varchar2(10),
  gender char(3)
);

desc test;
--�������� �߰�
alter table test add constraint test_id_pk primary key(id);

--name not null����
alter table test modify name not null;

--gender default  ����
alter table test modify (gender default '��')


select reg_date, id from member;
---------------------------------------------------------------------------
/*
SQL�� ����
 - DDL����(CREATE, DROP, ALTER, TRUNCATE)
 - DML����(INSERT ,UPDATE, DELETE)
 - DQL����(SELECT)
*/

/*
  ������ ���� : DML(INSERT , UPDATE, DELETE)
   - ROLLBACK OR COMMIT ����
   
   1) INSERT����
       -INSERT INTO ���̺��̸�(�÷���, �÷���,....) VALUES(��, ��,��,....);
       -INSERT INTO ���̺��̸� VALUES(��, ��,��,....); -- ��� �÷��� ������� ���� ������!!!
   
   2) DELETE����
       DELETE [FROM] ���̺��̸�
       [WHERE ���ǽ�]
   
   3) UPDATE����
      UPDATE ���̺��̸�
      SET �÷���=���氪 , �÷���=���氪,....
      [WHERE ���ǽ�] 

*/
-----------------------------------------------------------------
/*
   --���̺� ����
   CREATE TABLE ���̺��̸�
   AS ���������̺�����;
   
    ���� : ���̺��� �����ϸ� ���������� ���� �ȵȴ�!!! - �������Ŀ� ���������� ALTER�� �̿��ؼ� �߰��Ѵ�.

*/

-- ���̺� �����غ���  - SCOTT���� ����
 SELECT * FROM EMP;
 
 --1) ��� ���ڵ�, ��� �÷��� �����غ���.
 CREATE TABLE COPY_EMP
 AS SELECT * FROM EMP; --�������� ���� �ȵ�.
 
 SELECT * FROM COPY_EMP;
 ALTER TABLE COPY_EMP ADD CONSTRAINT COPY_EMP_NO_PK PRIMARY KEY(EMPNO); --�������� �߰� 
 
 --2) ���ǿ� �����ϴ� Ư�� ���ڵ�� Ư���÷��� ������ �����ϰ� �ʹ�.
 CREATE TABLE COPY_EMP2
 AS SELECT EMPNO, ENAME, JOB , HIREDATE FROM EMP WHERE SAL > 2500;
 
 SELECT  *FROM COPY_EMP2;
 
 --3) ������ �����ϰ� �ʹ�.
 CREATE TABLE COPY_EMP3
 AS SELECT * FROM EMP WHERE 1=0 ;
 
 SELECT * FROM COPY_EMP3;
 
 COMMIT;
 --���ڵ� ���� ( COPY_EMP)
 SELECT * FROM COPY_EMP;
 
 ROLLBACK;
 --EX) EMPNO�� 7499�� ����� JOB�� TEACHER, ENAME �� HEEJUNG �����غ���
 UPDATE COPY_EMP
 SET JOB='TEACHER' , ENAME='HEEJUNG'
 WHERE EMPNO=7499;
 
UPDATE COPY_EMP
 SET JOB='TEACHER' , ENAME='HEEJUNG'
 WHERE SAL>9000;
 





