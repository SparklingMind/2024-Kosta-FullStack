--WS_01���� �ۼ��ߴ� ����� �л��� ���õ� ���̺� 6���� �̿�
--1.������ ������ �л��� ������ �˻�
SELECT *
FROM STUDENT
WHERE ��_�ֹε�Ϲ�ȣ LIKE '______-2%';

--2. ��������� 1973���� ������ ������ �˻�(SUBSTR�̿�)
SELECT *
FROM STUDENT
WHERE SUBSTR(��_�ֹε�Ϲ�ȣ, 1, 2) = '73';

--3. ���� 'ȫ'�� �ƴ� ������ ���� �˻�
SELECT *
FROM TEACHER
WHERE NOT SUBSTR(�����̸�, 1, 1) = 'ȫ';

--4. �������� �����ϴ� ������ ���� �˻�
SELECT *
FROM TEACHER
WHERE �ּ� LIKE '%������%';

--5. JAVA�� �����ϴ� ���� ���� �˻�(�������� �̿�)
SELECT *
FROM TEACHER
WHERE �����ڵ� IN (
    SELECT �����ڵ�
    FROM SUBJECT
    WHERE ���� = 'java'
);

--6. �ּҰ� NULL�� �ƴ� ������ ���� �˻�
SELECT *
FROM TEACHER
WHERE �ּ� IS NOT NULL;

--7. SQL������ �����ϰ� �ִ� �л��� ������ �˻��ϴ� �� �ۼ�

SELECT *
FROM STUDENT
JOIN SUGANG ON STUDENT.��������ȣ = SUGANG.��������ȣ
JOIN SUBJECT ON SUGANG.�����ڵ� = SUBJECT.�����ڵ�
WHERE SUBJECT.���� = 'sql';

--8. ���簡 ����ϴ� ����� �� ������ ��� ���ǽǿ��� ����Ǹ� �� ���� �ξ��� �� ������ �˻�
SELECT TEACHER.�����ȣ, TEACHER.�����̸�, SUGANGTB.�����ڵ�, SUBJECT.����, ROOM.���ǽǹ�ȣ, ROOM.�����ο�
FROM TEACHER
JOIN SUGANGTB ON TEACHER.�����ȣ = SUGANGTB.�����ȣ
JOIN ROOM ON SUGANGTB.���ǽǹ�ȣ = ROOM.���ǽǹ�ȣ
JOIN SUBJECT ON TEACHER.�����ڵ� = SUBJECT.�����ڵ�;

--9. �л��� �̸�, �ֹι�ȣ, ������ ����ϱ�.
SELECT ��_�̸�, ��_�ֹε�Ϲ�ȣ,
    CASE
        WHEN SUBSTR(��_�ֹε�Ϲ�ȣ, 8, 1) IN ('1') THEN '����'
        WHEN SUBSTR(��_�ֹε�Ϲ�ȣ, 8, 1) IN ('2') THEN '����'
    END AS ����
FROM STUDENT;
    
--10. TEACHER ���� �̸��� �������� �ø��������� �����Ͽ� ���ĵ� ������� ROWNUM�� ���.
SELECT ROWNUM, T.*
FROM (
    SELECT �����̸�, ����ó, �ּ�
    FROM TEACHER
    ORDER BY �����̸� ASC
)T;
