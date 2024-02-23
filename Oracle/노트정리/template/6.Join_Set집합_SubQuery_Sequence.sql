/*
  JOIN
   : �ѹ��� SELECT�������� 2�� �̻��� ���̺� �ִ� �÷��� ������ �˻��ϰ� ���� �� ����Ѵ�.
   : JOIN�� ����
     1) INNER JOIN
         - EQUI JOIN = �������� = NATURAL JOIN
         - NON EQUI JOIN : ���� ��� ���̺��� � �÷��� ���� ��ġ���� ���� �� ���
                          EX) BETWEEN AND , IS NULL, IS NOT NULL, IN, > , < ����  ���ǹ��� ����Ҷ� ����.
        
      2) OUTER JOIN
           : �⺻ EQUI JOIN�� �ϸ鼭 ������ ���̺��� ��� ������ �˻��ϰ� ������ ����Ѵ�.
              - LEFT OUTER JOIN
              - RIGHT OUTER JOIN
              - FULL OUTER JOIN
    
      3) SELF JOIN
           : �ڱ� �ڽ����̺��� �����ϴ� ��(�ϳ��� ���̺��� 2��ó�� ����ϴ� ��)
           : �ַ� ����������� �� ���� ����Ѵ�. (���������� �ڽ��ڽ����̺��� PK�� FK�� �����ϴ� ��)
           
    : JOIN �ڵ� ���
      1) SQL JOIN  - FULL OUTER JOIN�� �������� �ʴ´�. 
      2) ANSI JOIN : �̱�����ǥ�ؿ����ҿ��� ���� �̱��� ǥ���� �⺻���� �Ѵ�. - ����
*/

CREATE TABLE TEST1(
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30),
    ADDR VARCHAR2(50)
);

INSERT INTO TEST1 VALUES('JANG', '����', '����');
INSERT INTO TEST1 VALUES('KIM', '����', '�뱸');
INSERT INTO TEST1 VALUES('GYEEB', '�̳�', '�λ�');
INSERT INTO TEST1 VALUES('HEE', '�̿�', '����');
INSERT INTO TEST1 VALUES('KING', '����', '���ֵ�');

SELECT * FROM TEST1;

-- TEST1�� �����ϴ� ���̺� ����(ID�� �ش��ϴ� ����� ���� �ִ� JOB, SAL�� ���� ����)
CREATE TABLE TEST2(
    CODE CHAR(3) PRIMARY KEY,
    ID VARCHAR2(10) REFERENCES TEST1(ID),  ---FK
    JOB VARCHAR2(30),
    SAL NUMBER(3)
);


INSERT INTO TEST2 VALUES('A01', 'JANG','����',200);
INSERT INTO TEST2 VALUES('A02', 'JANG','������',300);
INSERT INTO TEST2 VALUES('A03', 'HEE','�����̳�',250);
INSERT INTO TEST2 VALUES('A04', 'KING','��ȹ��',400);
INSERT INTO TEST2 VALUES('A05', NULL,'����',500);

SELECT * FROM TEST2;





--------------------------------------------------------------------

-- 3���� ���̺� �����ϱ�
CREATE TABLE TEST3(
    CODE CHAR(3) PRIMARY KEY REFERENCES TEST2(CODE),  -- PK, FK (�ĺ�����)
    MANAGER_NAME VARCHAR2(30),
    PHONE VARCHAR2(30)
);


INSERT INTO TEST3 VALUES('A01', '���缮','111-1111');
INSERT INTO TEST3 VALUES('A02', '���߱�','222-2222');
INSERT INTO TEST3 VALUES('A03', '��ȿ��','333-3333');

SELECT * FROM TEST1;
SELECT * FROM TEST2;
SELECT * FROM TEST3;

-- EX) ID, NAME, ADDR, JOB, SAL, MANAGER_NAME, PHONE �˻�

   
   
-- ANSI ���ι��



-- ���ο� ���� �ֱ� -- SAL�� 300�̻��� ���ڵ� �����ϱ�





--NON-EQUI JOIN
-- EMP���̺��� ����� ���� + �޿������ �Բ� �˻��ϰ� �ʹ�

 
 
-- SELF JOIN - �ڱ��ڽ� ���̺��� 2���� ���� ����(���������)
-- EX) SMITH����� �����ڴ� FORD�Դϴ�. ���




--------------------------------------------------------------
/*
  SET ����
   1) ������
        UNION ALL - �ߺ����ڵ带����
        UNION - �ߺ����ڵ� ����
        
   2) ������ 
       INSERSECT : A�� B ���̺��� ����� ���ڵ� �˻�
       
   3) ������ 
        MINUS : A���̺��� B���̺��� ���ڵ带 �� ������ ���ڵ� �˻�






 -------------------------------------------------------------
 /*
   SUBQUERY - ������
    : ���������ȿ� �� �ٸ� ������ �����ϴ°�
    : ()��ȣ�� ���´�. ��ȣ�ȿ� ���๮���� ���� ������� �� ����� ���������� �������� �ַ� ����Ѵ�. 
    : ���������� ��� ���� �Ѱ� �϶�  �񱳿����� ���.
    : ���������� ��� ���� ������ �϶��� ANY, ALL, IN �����ڸ� ����Ѵ�. 
    : �ַ� SELECT���� ���� ��������� CREATE, INSERT, UPDATE ,DELTE, 
           HAVING, WHERE , FROM ,ORDER ������ ��밡���ϴ�.
 */
 
 --EMP���̺��� ��� �޿����� �� ���� �޴� ��� �˻�

                  
      
-- JOB�� 'A'���ڿ��� �� ����� �μ��� ���� ������ �ٹ��ϴ� ����� �μ��̸� �˻��ϰ� �ʹ�. 

  
  
 -- �μ���ȣ�� 30�� ������� �޿��߿��� ���� ���� �޴� ������� �� ���� �޴� ��������� �˻��ϰ� �ʹ�. 
--1) JOB�� 'A'���ڿ��� �� ����� �μ��� ���� ������ �ٹ��ϴ�
SELECT DISTINCT DEPTNO FROM EMP WHERE JOB LIKE '%A%';

SELECT SAL FROM EMP WHERE DEPTNO=30;

--�μ���ȣ�� 30�� ����� �߿��� ���� ���� �޴� ������� �� ���� �޴� ����� �˻��ϱ�.
SELECT * FROM EMP WHERE SAL> ALL (SELECT SAL FROM EMP WHERE DEPTNO=30);

--�����Լ� MAX�� �̿��� ���� ������ �����
SELECT * FROM EMP WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);

--�μ���ȣ�� 30�� ����� �߿��� ���� ���� �޴� ������� �� ���� �޴� ����� �˻��ϱ�.
SELECT * FROM EMP WHERE SAL < (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30); --MIN ���
SELECT * FROM EMP WHERE SAL < ALL(SELECT SAL FROM EMP WHERE DEPTNO=30); -- ALL ���

--�μ���ȣ�� 30�� ����� �߿��� ���� ���� �޴� ������� �� ���� �޴� ����� �˻��ϱ�.
SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30); --MIN ���
SELECT * FROM EMP WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO=30); --ANY ���

--���̺� ������ ����
CREATE TABLE SUB_EMP
AS SELECT * FROM EMP WHERE 1=0; --���ڵ� �ϳ��� ����

SELECT * FROM SUB_EMP;

-- SUBQUERY�� INSERT
INSERT INTO SUB_EMP (SELECT * FROM EMP WHERE DEPTNO=20); --DEPTNO�� 20�� ����� ����


--Ư���� Į���� �ٸ����̺�κ��� �����ͼ� INSERT
INSERT INTO SUB_EMP(EMPNO, ENAME, JOB, SAL)(SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=10); 



--SUBQUERY�� UPDATE
--EX) EMP���̺��� EMPNO 7900�� ����� JOB, MGR, DEPTNO�� SUB_EMP���̺��� 7566�� ����� ������ �����غ���.
UPDATE SUB_EMP
SET JOB=(SELECT JOB FROM EMP WHERE EMPNO=7900), 
MGR=(SELECT MGR FROM EMP WHERE EMPNO=7900), 
DEPTNO=(SELECT DEPTNO FROM EMP WHERE EMPNO=7900)
WHERE EMPNO=7566;

UPDATE SUB_EMP
SET (JOB,MGR,DEPTNO) = (SELECT JOB,MGR,DEPTNO FROM EMP WHERE EMPNO=7900) --SELECT ���� Į�� ������ SET. 
WHERE EMPNO=7566;

--SUBQUERY�� DELETE
  --EX) EMP���̺��� ��� �޿��� �������� ����ؼ� ��ձ޿����� ���� �޴� ������� �����Ѵ�. 
DELETE FROM SUB_EMP WHERE SAL> (SELECT AVG(SAL) FROM EMP);
SELECT * FROM SUB_EMP;

--------------------------------------------------------------
/*
  SUBQUERY ���� ���� �ϳ��� �ζ��κ�
   : FROM�� �ڿ� ���������� ���� ��.
*/

-- �޿��� �������� �����ؼ� ROWNUM(�ึ�� ��ȣ�� ���)�� �Բ� ����ϰ� �ʹ�.
SELECT E.*, ROWNUM FROM EMP E;

SELECT ROWNUM, EMPNO, ENAME, JOB, SAL FROM EMP --�������� ���� ������ ROWNUM�� ���� ���ԵǾ SAL������ ��ȣ�� �Ű����� �ʴ´�.
ORDER BY SAL;

--�ζ��� �� �̿�
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL);  --������ �� �ڿ�, ROWNUM�� �ٿ��� �� �ִ�. 

--ROWNUM�� ������� ������ ������.
--1. ROWNUM�� 3���� ���� ���ڵ� �˻�
SELECT ROWNUM ��ȣ, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC)
WHERE ROWNUM < 3;

--2. ROWNUM�� 3���� ū ���ڵ� �˻�
SELECT ROWNUM ��ȣ, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC)
WHERE ROWNUM > 3;



-- ROWNUM�� ������� ������ ������ .
--1. ROWUM�� 3���� ���� ���ڵ� �˻�


--2. ROWUM�� 3���� ū ���ڵ� �˻�


--3. ROWUM�� 5 ~ 7 ���� ���ڵ� �˻�


/*
  ROWNUM�� ���ڵ尡 ��������鼭 ��ȣ�� ���������� �ο��Ǵ� ������ ROWNUM 1 �� ������ 2�� �����Ҽ� ����. 
  �׷��� ROWNUM�� ��������  ~ ũ��  �Ǵ� �߰������� ���� �������� ����� �� ����. 
  ROWNUM�� ��� �ο��� ����� �������� ����ؾ��Ѵ�. 
*/





----------------------------------------------------------
/*
  SEQUENCE : �ڵ� ���� �� ����
    :�������
      CREATE SEQUENCE �������̸�
      [START WITH �ʱⰪ]
      [INCREMENT BY ������]
      [MAXVALUE �ִ�]
      [MINVALUE �ּڰ�]
      [CACHE | NOCACHE]
      [CYCLE | NOCYCLE]
      
    : �����
      �������̸�.NEXTVAL : �������� ����
      �������̸�.CURRVAL : �������� ���簪 ��������
       
    : ������ ����
    ALTER SEQUENCE �������̸�;
    
    : ������ ����
    DROP SEQUENCE �������̸�;
*/



