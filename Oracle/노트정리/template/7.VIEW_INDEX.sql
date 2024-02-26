/*
   VIEW : �������̺�
     - ���� �������� ������ ���� ���̺�� �Ȱ��� ����� : (select , insert , delete, update ����)
       : �����Ҷ� �ɼ��� ��� �����ϴ��Ŀ� ���� DML ���ΰ� �޶�����.
       : JOIN�� ��� ����������� DML �ȵ�
       
     -����ϴ� ����?? 
        :  ������ ��������(����, ��������)�̸� ��� ����� ����� �����ϰ� �˻� ������.(��,insert , delete, update �ȵ�)
        
        :  ������ ���� �����(������ ������ ���� Ư�� �÷� �� �����Ͽ� ������)
           - ���̺��� Ư���� �÷��� ���ڵ带 �����ؼ� �並 ����� ���ѿ� ������ �ִ� DBA���� �������̺��� �ƴ� ���� �̸���
              �˷������ν� DBA�� �丸 ���� �Ҽ� �ֵ��� ������ �д�. 

    -�� �������
     CREATE VIEW ���̸�
     AS ���ǳ���;
     
     --�� ���� + ����
     CREATE OR REPLACE VIEW ���̸�
     AS ���� ����;
     
     --�����
     DROP VIEW ���̸�;

*/
--SCOTT�������� ����
DROP TABLE COPY_EMP;



--���̺� ����
CREATE TABLE COPY_EMP AS SELECT * FROM EMP;

SELECT * FROM COPY_EMP;

--COPY_EMP �������� ����ϴ� VIEW ������.


--�����
CREATE OR REPLACE VIEW V_EMP
AS SELECT * FROM COPY_EMP;  -- ���� ���̺��� ������ ���� �ƴ϶� COPY_EMP�� �ٶ󺸴� �������̺��� ������ ���̴�.

--��˻�
SELECT * FROM V_EMP;



--�並 �˻��غ���.
SELECT * FROM V_EMP;

--��� ���̺�ó�� ���Ǳ� ������ SELECT, INSERT, UPDATE, DELETE �⺻������ �����ϴ�.

--�信 INSERT �غ���
INSERT INTO V_EMP(EMPNO, ENAME, JOB, SAL) VALUES(9000,'HEEJUNG','STUDENT',3000); --COPY_EMP���� ���ڵ尡 �� ������ Ȯ���� �� �ִ�. (���� ���̺��̱� ����)

--�信 DELETE �غ���
DELETE FROM V_EMP
WHERE ENAME = 'HEEJUNG';

--�信�� �����غ���.
DROP VIEW V_EMP;
-----------------------------------------------------------
-- �������� �������� VIEW�� ������ (���ǿ� �ش��ϴ� ���ڵ�� �÷��� �����ؼ� ���� ������)
SELECT * FROM COPY_EMP;

--EX)�μ���ȣ�� 20�� ����� ������ VIEW�� ������.
CREATE OR REPLACE VIEW V_EMP
AS SELECT * FROM COPY_EMP WHERE DEPTNO='20';

--�� �˻�
SELECT * FROM V_EMP;


--VIEW�� TABLE�� ���� INSERT (DEPTNO�� 20�� ���, 20�� �ƴ� ���)

--VIEW�� INSERT
INSERT INTO V_EMP(EMPNO, ENAME, DEPTNO)
VALUES (9000, 'HEE', 30);  --DEPTNO�� 20�� �ƴϴ��� ������ �ȴ�.

--�ٽ� �� �˻�
SELECT * FROM V_EMP; --DEPTNO 20�� �ƴ� ���ο� ���ڵ�� ������ �ʴ´�.
SELECT * FROM COPY_EMP; --COPY_EMP���� DEPT 30�� ���ο� ���ڵ尡 ���Ե� ���� Ȯ���� �� �ִ�.

/*
���� ������ ������ �ϰ� V_EMP�� �˻��غ��� V_EMP �� VIEW�� ������ 20�� �μ��� �˻��� VIEW �̱� ������ ���(COPY_EMP�� �߰�)�� �Ǿ����� �˻������� ������ �ʴ´�.
�並 ����ϴ� ���忡�� ��Ȳ�� �� �ִ�.
->VIEW�� ������ ��, WITH CHECK OPTION�̳� WITH READ ONLY�� ����ؼ� ���ǿ� �������� �ʴ� ���ڵ� ������ �� �� ������ ������ �� �ִ�.

      1) WITH CHECK OPTION : �並 �����Ҷ� ������ �̿��ؼ� ����� �Ǹ� INSERT, UPDATE, DELETE�� �� �� ���ǿ� �������� �ʴ�
                              ������ DML�� �Ҽ� ������ �ϴ°�!!
                              
      2) WITH READ ONLY : �б�����(DML �ȵ�)
      
*/

--�信 �ɼ��� �����غ���.
CREATE OR REPLACE VIEW V_EMP
AS SELECT * FROM COPY_EMP WHERE DEPTNO = 20 WITH CHECK OPTION;

--�ɼ� ������ ����� ���ǿ� ���ݵǴ� ���ڵ� ����
INSERT INTO V_EMP(EMPNO, ENAME, DEPTNO)
VALUES (9000, 'HEE', 30);   --���ǿ� ����Ǿ� ������� �ʴ´�.

--�並 �б� �������� �����غ���.
CREATE OR REPLACE VIEW V_EMP
AS SELECT * FROM COPY_EMP WHERE DEPTNO = 20 WITH READ ONLY;

--�б� ���� �信 ���� �õ�
INSERT INTO V_EMP(EMPNO, ENAME, DEPTNO)
VALUES (9000, 'HEE', 20);   --�б� ���� �信���� DML �۾��� ������ �� ���ٴ� ������ ���.
----------------------------------------------------------------
--2) ������ ����(JOIN, SUBQUERY)�� �̸� ��� ���� ��ȸ�Ҷ� ����ȭ �ϰ� ��ȸ �Ҽ� �ֵ��� �ϴ� �뵵


 ---------------------------------------------------------
 /*
   CREATE���� : TABLE, VIEW, SEQUENCE , INDEX
        - OBJECT=��ü - ������������ ���� �����ϴ� ��....
 */
 --���� �������� ����Ҽ� �ִ� ��ü���� ���� ������ �˻��ϰ� �ʹ�!!!!
 
 SELECT * FROM USER_TABLES;
 SELECT * FROM USER_VIEWS;
 SELECT * FROM USER_SEQUENCES;
 SELECT * FROM USER_INDEXES;
 
 SELECT *FROM EMP;
 
 
 /*
   INDEX
     : �ε����� ������ ���� ��ȸ������ �ش�ȭ �ϱ� ���� ����� ��ü�̴�.
     : �ε����� ������ ����ٰ� �ؼ� �������� �ƴϰ� ��ü ���̺��� ������ �� ���� �����ؾ��Ѵ�.
     : �ֳ��ϸ�, �ε����� Ư�����̺��� ���ڵ�˻� �ӵ��� ������ �ϴµ� ������ ������ ��ü�ý��� ������ �ʹ� ���� �ε����� ������ ��ü ������ ���ϵɼ� �ִ�. 
       ���� INSERT, UPDATE, DELETE�� �ϰ� �Ǹ� �׶����� INDEX������ ����Ǳ� ������ ��ü �����ȿ��� �ý��� ���ϰ� �����(��������)
       �˻��ӵ��� ���̱� ���ؼ� �ε����� ���� �����ϱ� ���ٴ� SQL������ ���� ȿ�������� ¥�� ����� �ϴ°� �� ����!!
      
      :�ַ� �ε��� ����� �Ǵ� �÷��� �˻��� �������� ���� Ȱ��Ǵ� �÷����� �����.
      
      : �ε��� ����
       CREATE INDEX �ε����� ON ���̺��̸�(�÷���, �÷���,....) ;
       
      : �ε��� ����
       DROP INDEX �ε�����;
 */
 

 CREATE INDEX INDEX_SAL ON EMP(SAL);
 
 DROP INDEX INDEX_SAL;
 
 
 
 
 
 
 
 
 
 
 
 
 
 





