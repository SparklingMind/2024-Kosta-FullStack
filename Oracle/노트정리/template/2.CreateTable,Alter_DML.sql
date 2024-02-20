-- ������ �������� �����Ѵ�. conn ������/���

/*
  Datatype�� ����
  1) ���ڿ�   
      CHAR(BYTE��) : �������� - �ִ� 2000 BYTE
      VARCHAR2(BYTE��) : �������� -�ִ� 4000 BYTE
      
      *�����ڵ带 ����!!
      NCHAR(BYTE��)
      NVARCHAR2(BYTE��)
      
      * �ݵ�� ���ڴ� '��'  �������� ����Ѵ�.
      * ORACLE���� ���� UTF-8 ���ڵ����� �ѱ��ڴ� 3BYTE�̴�!!
      
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
          - ����Ű���� : ����Ҷ� �����ؼ� �𵨸� �����ӿ��� ����Ű�� �븮Ű�� ��ȯ�ϴ� ��� ����!!!
*/
--������ �������� �����ؼ� �Ʒ� ���̺��� TEST�غ���. 

--ex ���̺� ����
CREATE TABLE MEMBER(
    ID VARCHAR2(20) CONSTRAINT MEMBER_ID_PK PRIMARY KEY, --NOT NULL, �ߺ�X
    NAME VARCHAR2(10) NOT NULL,--����Ʈ �� 10���� ����
    JUMIN CHAR(13), --NULL���
    AGE NUMBER(2), -- -99 ~ 99
    ADDR VARCHAR2(10 CHAR),--������ 10�� ����
    REG_DATE DATE
);

--�˻� Ȯ��
SELECT * FROM MEMBER;

--���̺� ����
DROP TABLE MEMBER;

--���̺��� ���� Ȯ��
DESC MEMBER;

/*
  ���ڵ� ���
  INSERT INTO ���̺��̸�(�÷���, �÷���,....) VALUES(��, ��,��,....);
  INSERT INTO ���̺��̸� VALUES(��, ��,��,....); -- ��� �÷��� ������� ���� ������!!!
*/

INSERT INTO MEMBER VALUES('Jung', '������', '1111-2222', 20, '����', SYSDATE); --�������� ��ҹ��ڸ� ������ ������ VALUE�� ��ҹ��ڸ� ������.
INSERT INTO MEMBER (ID, NAME, AGE) VALUES('ROSE','���',22);

-���� �� �Ǵ� ����
INSERT INTO MEMBER(ID, NAME, AGE) VALUES('JUNG','���ϳ�',25); --X. PK�� �ߺ� �� ��.
INSERT INTO MEMBER(NAME, AGE) VALUES('���ϳ�',25); --X. PK�� NOT NULL.
INSERT INTO MEMBER(ID, NAME, AGE) VALUES('FLY','�ѳ���',100); --X. ���̴� 2�ڸ���.

--���� �Ǵ� ����
INSERT INTO MEMBER(ID, NAME, AGE) VALUES('jung','���̳�',25); -- �����Ͱ��� ��ҹ��� ������ ������ PK�ߺ� �ƴϴ�.

INSERT INTO MEMBER(ID,NAME,ADDR,REG_DATE) VALUES('TWO','�̵Ѹ�','ȭ��','2013-10-10');

-- 10 BYTE VS 10 CHAR ����
INSERT INTO MEMBER(ID, NAME, ADDR) VALUES('BB','�����ٶ�','�����'); --X. �ѱ��� ���ڴ� 3����Ʈ�� ������ ������ '�����ٶ�'�� 12����Ʈ�� �ʰ�.
INSERT INTO MEMBER(ID, NAME, ADDR) VALUES('BB','������','����� ������'); --O. ADDR 10 CHAR�̹Ƿ�.

-- CHAR VS VARCAHR2 ��
INSERT INTO MEMBER(ID, NAME, ADDR) VALUES('FF','A','B');
INSERT INTO MEMBER(ID, NAME, ADDR) VALUES('GG','A ','B ');

--VARCHAR2 �˻�
SELECT * FROM MEMBER WHERE NAME = 'A';
SELECT * FROM MEMBER WHERE NAME = 'A ';

--CHAR �˻�
SELECT * FROM MEMBER WHERE ADDR = 'B';
SELECT * FROM MEMBER WHERE ADDR = 'B ';

SELECT NAME, JUMIN, LENGTH(NAME), LENGTH(ADDR) FROM MEMBER WHERE ID = 'GG';


--�˻����� ���Ե� ��� Ȯ��
SELECT * FROM MEMBER;

--���̺� ����
DROP TABLE MEMBER;

--�ϳ��� ���̺� �� ���� �÷��� ��� PK �����ϱ�
CREATE TABLE MEMBER(
    ID VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    JUMIN CHAR(13) NOT NULL, -- NOT NULL ���� ���� �߰�
    AGE NUMBER(3),
    REG_DATE DATE,
    CONSTRAINT MEMBER_ID_JUMIN_PK PRIMARY KEY(ID, JUMIN) -- NOT NULL, INDEX ����, �ߺ�X
);

--���̺� ����Ȯ��
DESC MEMBER;

--���ڵ� �߰��ؼ� PK TEST�غ���.
INSERT INTO MEMBER VALUES('KIM', '�γ�', '1111-2222', 20, SYSDATE);
INSERT INTO MEMBER VALUES('HAN','�γ�','1111-3333',20,SYSDATE); --�ֹι�ȣ OR ID�� ���� ���� �ߺ� ���
INSERT INTO MEMBER VALUES('LEE','�γ�','1111-3333',20,SYSDATE);

INSERT INTO MEMBER VALUES('KIM', '�γ�', '1111-2222', 20, SYSDATE); --X ID AND JUMIN ��� ���Ƽ� �ߺ�


--���̺� �˻�
SELECT * FROM MEMBER;


----------------------------------------------------------------------------
/*
  2) FOREIGN KEY - FK = �ܷ�Ű
      : �ٸ� ���̺��� PK�� �����ϴ� ��.
      : ���̺� ���ڵ带 �߰��Ҷ� �����Ǵ� ����� ���̿ܿ��� ��� �Ҽ� ����.
          - �������Ἲ��Ģ!!!. ���ǿ� ���� �����͸� ������ ���ɼ��� ����.
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

--scott���� ����
SELECT * FROM EMP; --������̺�

--���� �������� �����ؼ� FK �ǽ�
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
    DEPT_CODE CHAR(3) CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE),
    HIRE_DATE DATE DEFAULT SYSDATE -- ����� ��, HIRE_DATE ���� ������ �ڵ����� �⺻���� ����.
);

--���̺� �˻�
SELECT * FROM DEPT;
SELECT * FROM EMP;

--��� ���
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (1, '����', 300, 'A01');
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (2, '����', 200, 'A01');
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (3, '�̹�', 300, NULL);

INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (4, '���', 100, 'A05'); --X. (�θ�Ű�� �����ϴ�.)

INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE, HIRE_DATE) VALUES (4, '���', 100, 'A02', '2024-01-20');


INSERT INTO EMP VALUES (6, '���', 100, 'A02', DEFAULT);


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
SELECT * FROM EMP;

--���ڵ� ����
DELETE FROM EMP;

ROLLBACK;

-- �θ��� �����ǰ� ���� �ʴ� ���ڵ带 �����غ���.(DEPT)
DELETE FROM DEPT WHERE DEPT_CODE='A03';
-- �θ����̺��� �����ǰ� �ִ� ���ڵ带 �����غ���.. (DEPT)
DELETE FROM DEPT WHERE DEPT_CODE='A02'; -- X(���Ἲ ���������� ����Ǿ����ϴ�.) A01�� �����ϰ� �ִ� �ڽ� ���ڵ尡 �����ϱ� ������ ������ �Ұ����ϴ�.

--�����ǰ� �ִ� �ڽķ��ڵ带 ���� ������ �Ŀ� �θ� ���ڵ带 �����ؾ� �Ѵ�.
DELETE FROM EMP WHERE DEPT_CODE='A02';
DELETE FROM DEPT WHERE DEPT_CODE='A02'; -- A01�� �����ϰ� �ִ� �ڽ� ���ڵ尡 ����.


--ON DELTE CASCADE : �θ� �����ϴ� �ڽİ����� ����.
--ON DELETE CASCADE VS ON DELETE SET NULL �ɼ� �����ؼ� ���غ���
DROP TABLE EMP;

--������̺� ����
CREATE TABLE EMP(
    EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
    ENAME VARCHAR2(15) NOT NULL,
    SAL NUMBER(5),
    DEPT_CODE CHAR(3) CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE) ON DELETE CASCADE, -- �θ� �����ϴ� �ڽİ����� ����.
    HIRE_DATE DATE DEFAULT SYSDATE -- ����� ��, HIRE_DATE ���� ������ �ڵ����� �⺻���� ����.
);

SELECT * FROM DEPT;
SELECT * FROM EMP;

INSERT INTO DEPT VALUES('A02','�λ��','�뱸');

--EMP ���ڵ� �߰�
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (1, '����', 300, 'A01'); --O
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (2, '����', 200, 'A01'); --O
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (3, '�̹�', 300, NULL); --O

-- �θ� ���̺��� �����ǰ� �ִ� ���ڵ带 �����غ���. (DEPT)
DELETE DEPT WHERE DEPT_CODE = 'A01'; --ON DELTE CASCADE �ɼ��� �ֱ� ������ ���� ����.

-- ���̺� �����ϰ�
DROP TABLE EMP;
-- �ɼ��� �����ؼ� FK ����
CREATE TABLE EMP(
    EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
    ENAME VARCHAR2(15) NOT NULL,
    SAL NUMBER(5),
    DEPT_CODE CHAR(3) CONSTRAINT EMP_DEPT_CODE_FK REFERENCES DEPT(DEPT_CODE) ON DELETE SET NULL, -- �θ� �����ϴ� �ڽİ��� NULL�� �ٲ�.
    HIRE_DATE DATE DEFAULT SYSDATE -- ����� ��, HIRE_DATE ���� ������ �ڵ����� �⺻���� ����.
);
-- ���ڵ� �߰��ϰ� 
INSERT INTO DEPT VALUES('A01','���ߺ�','����');
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (1, '����', 300, 'A01'); --O
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (2, '����', 200, 'A01'); --O
INSERT INTO EMP (EMP_NO, ENAME, SAL, DEPT_CODE) VALUES (3, '�ƿ�', 300, 'A02'); --O

-- �����غ���.
DELETE DEPT WHERE DEPT_CODE = 'A01'; --�����ǰ� �ִ� ������ NULL�� �ٲ��.

--FK ������ SQL���� �� �ڿ��� �ۼ��ϴ� ���...
DROP TABLE EMP;
CREATE TABLE EMP (
    EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
    ENAME VARCHAR2(15) NOT NULL,
    SAL NUMBER(5),
    DEPT_CODE CHAR(3),
    HIRE_DATE DATE DEFAULT SYSDATE, -- ����� ��, HIRE_DATE ���� ������ �ڵ����� �⺻���� ����.
    CONSTRAINT EMP_DEPT_CODE_FK FOREIGN KEY(DEPT_CODE) REFERENCES DEPT(DEPT_CODE) ON DELETE SET NULL
);
---------------------------------------------------------------
/*
  3) UNIQUE
      : �ߺ� �� ��, NULL���(NOT NULL�� �����ϸ� PK�� ����) 
      : �ĺ�Ű �߿� ��ǥŰ�� �� �� ���� Ű�� UNIQUE �����Ѵ�. 
      : �� ���̺� ���� ���� �÷��� �������� 
      
  4) CHECK
      : ������ �����Ͽ� ���ǿ� �������� �ʴ� ������ INSERT �Ҽ� ����!
    
  
  5) DEFAULT
      : �⺻�� ����(���� ���Ǵ� ���� �̸� �����س��� �ڵ����� ���� ���� �ֵ��� �ϴ°�)
      : EX) �����, ��ȸ��....
      : DEFAULT�� �����Ҷ��� CONSTRAINT ��Ī�� �Ⱦ���!!!
      : NOT NULL�� �����ϸ� DEFALUT�� �Բ� ����Ҷ��� �ݵ�� DEFAULT�� ���� �ۼ��Ѵ�.
*/



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

---------------------------------------------------------------------------
/*
SQL�� ����
 - DDL����(CREATE, DROP, ALTER, TRUNCATE)
 - DML����(INSERT ,UPDATE, DELETE)
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



/*
   --���̺� ����
   CREATE TABLE ���̺��̸�
   AS ���������̺�����;
   
   
    ���� : ���̺��� �����ϸ� ���������� ���� �ȵȴ�!!! - �������Ŀ� ���������� ALTER�� �̿��ؼ� �߰��Ѵ�.

*/
