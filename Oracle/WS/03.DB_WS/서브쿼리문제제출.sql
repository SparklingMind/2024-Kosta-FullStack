/*
--���� ���������Ѵ�.

--emp ���̺� ����
Create Table subEMP(
	emp_id 	   int, --�����ȣ
	emp_name	   Varchar2(20) Not Null,  --����̸�
	job      	               Varchar2(20) Not Null,  --����
	dept_id  	  int, --�μ���ȣ
	sal 	              int Not Null,--�޿�
	bonus	              int,--���ʽ�
	mgr_id	              int,--�����ڹ�ȣ
	hiredate             date  Not Null, --�Ի���
	constraint emp_id_pk22 Primary Key(emp_id) --��������
)

--�����ͻ���

INSERT INTO subEMP VALUES (6200,'��ö��','��ǥ',200,  5000,NULL,NULL, '1997-12-17');

INSERT INTO subEMP VALUES (6311,'�����','����',100, 3500,Null,6200, '1998-12-17');

INSERT INTO subEMP VALUES (7489,'�ε���','������',400,  1850,200,6321, '1999-02-27') ;

INSERT INTO subEMP VALUES (7522,'����ö','������',400, 1850,300,6321,'1998-02-28
') ;

INSERT INTO subEMP VALUES (6321,'������','����',400, 3800,500,6200,'1999-04-20') ;

INSERT INTO subEMP VALUES (6351,'������','����',300,   2850,NULL,6200,'2000-05-31');

INSERT INTO subEMP VALUES (7910,'�̿���','�渮',300, 1000,NULL,6351,'2001-05-01');

INSERT INTO subEMP VALUES (6361,'��ö��','����',200, 3200,NULL,6200,'2000-06-09') ;

INSERT INTO subEMP VALUES (7878,'����','������',200, 3000,NULL,6361,'2001-06-05') ;

INSERT INTO subEMP VALUES (7854,'������','������',400, 1500,0,6321,'2001-09-08') ;

INSERT INTO subEMP VALUES (7872,'�̹���','�繫��',100, 1500,NULL,6311,'2001-02-12') ;

INSERT INTO subEMP VALUES (7920,'������','�繫��',300, 1050,NULL,6351,'2001-03-18');

INSERT INTO subEMP VALUES (7901,'������','������',NULL, 3000,NULL,NULL,'2001-12-03');

INSERT INTO subEMP VALUES (7933,'��ö��','�繫��',200,  1050,NULL,6361,'2002-01-02');
--emp���̺� ���� / ���ڵ� �߰�

CREATE TABLE subdept(dept_id int, dname VARCHAR(20) );
INSERT INTO subdept VALUES(100,'������');
INSERT INTO subdept VALUES(200,'�渮��');
INSERT INTO subdept VALUES(300,'�����');
INSERT INTO subdept VALUES(400,'������');

SELECT * FROM subEMP;
SELECT *FROM subdept;
*/

------------------------------------------------------

--ex1) ������ ����� �μ���(dname)�� �˻��Ͻÿ�.
SELECT E.EMP_NAME,D.DNAME
FROM SUBEMP E
JOIN SUBDEPT D ON E.DEPT_ID = D.DEPT_ID
WHERE E.EMP_NAME = '������';

--ex2) dept_id�� 100�� ����޿��� �ִ밪���� ���� �޴� ����� �˻��Ͻÿ�.
SELECT *
FROM SUBEMP
WHERE SAL > (
    SELECT MAX(SAL)
    FROM SUBEMP
    WHERE DEPT_ID = 100
);

--ex3)�޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ��� 
 --  ������ �μ����� �ٹ��ϴ� ������� ����
 
SELECT *
FROM SUBEMP
WHERE DEPT_ID IN (
    SELECT DEPT_ID
    FROM SUBEMP
    WHERE SAL >= 3000
);

--ex4) �μ���ȣ�� 300�� ������߿��� �޿��� ���� ���� �޴� �������
      �� ���� �޿��� �޴� ����� ������ �˻�.
SELECT *
FROM SUBEMP
WHERE SAL > (
    SELECT MAX(SAL)
    FROM SUBEMP
    WHERE DEPT_ID = 300
);
   
-- ex5) �μ���ȣ�� 300�� ������߿��� �޿��� ���� ���� �޴� �������
--     �� ���� �޿��� �޴� ����� ������ �˻�
SELECT *
FROM SUBEMP
WHERE SAL > (
    SELECT MIN(SAL)
    FROM SUBEMP
    WHERE DEPT_ID = 300
);
--ex6)�������� �޿��� ���� �ϰų� �� ���� �޴� ����� �����˻�
SELECT *
FROM SUBEMP
WHERE SAL >= (
    SELECT SAL
    FROM SUBEMP
    WHERE EMP_NAME = '������'
);
 
--ex7)������ �繫���� ����� �μ���ȣ�� �μ��� ���
SELECT SUBEMP.JOB ����, SUBEMP.DEPT_ID �μ���ȣ, SUBDEPT.DNAME �μ���
FROM SUBEMP
JOIN SUBDEPT ON SUBEMP.DEPT_ID = SUBDEPT.DEPT_ID
WHERE JOB = '�繫��';

--ex8) �μ��� �渮���� ��� ����� �������
SELECT E.*
FROM SUBEMP E
JOIN SUBDEPT D ON E.DEPT_ID = D.DEPT_ID
WHERE D.DNAME = '�渮��';

--ex9)��ǥ ���� ���� �ϴ� ��� ����� �������
SELECT *
FROM SUBEMP
WHERE MGR_ID = (
    SELECT EMP_ID
    FROM SUBEMP
    WHERE JOB = '��ǥ'
);

--ex10) �̸��� '��'�� ���鼭 ��ձ޿����� ���� �޿��� �޴�
--     ����� ������ �μ����� �ٹ��ϴ� ����� ���� �˻�.
--      (��, �μ���ȣ null�� ������)
SELECT *
FROM SUBEMP
WHERE DEPT_ID IN (
    SELECT DEPT_ID
    FROM SUBEMP
    WHERE EMP_NAME LIKE '%��%' AND SAL > (
        SELECT AVG(SAL)
        FROM SUBEMP
    )
    AND DEPT_ID IS NOT NULL
);
--ex11) �� �μ��� � ��� �޿����� �޿��� ���� 
--      �޴� ����� ������ �˻�

SELECT *
FROM SUBEMP E
WHERE SAL > (
    SELECT AVG(SAL)
    FROM SUBEMP
    WHERE DEPT_ID = E.DEPT_ID
    GROUP BY DEPT_ID
);


--ex12)  ��� �繫�� ������� �޿��� �����鼭 �繫����
-- �ƴ� ��� ����� �����˻�
SELECT *
FROM SUBEMP
WHERE SAL < (
    SELECT MIN(SAL)
    FROM SUBEMP
    WHERE JOB = '�繫��'
)
AND NOT JOB = '�繫��';



