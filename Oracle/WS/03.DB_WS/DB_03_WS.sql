--WS_01에서 작성했던 강사와 학생에 관련된 테이블 6개를 이용
--1.성별이 여자인 학생의 정보를 검색
SELECT *
FROM STUDENT
WHERE 수_주민등록번호 LIKE '______-2%';

--2. 생년월일이 1973년인 수강생 정보를 검색(SUBSTR이용)
SELECT *
FROM STUDENT
WHERE SUBSTR(수_주민등록번호, 1, 2) = '73';

--3. 성이 '홍'이 아닌 강사의 정보 검색
SELECT *
FROM TEACHER
WHERE NOT SUBSTR(강사이름, 1, 1) = '홍';

--4. 강남구에 거주하는 강사의 정보 검색
SELECT *
FROM TEACHER
WHERE 주소 LIKE '%강남구%';

--5. JAVA를 강의하는 강사 정보 검색(서브쿼리 이용)
SELECT *
FROM TEACHER
WHERE 수강코드 IN (
    SELECT 수강코드
    FROM SUBJECT
    WHERE 과목 = 'java'
);

--6. 주소가 NULL이 아닌 강사의 정보 검색
SELECT *
FROM TEACHER
WHERE 주소 IS NOT NULL;

--7. SQL수업을 수강하고 있는 학생의 정보를 검색하는 뷰 작성

SELECT *
FROM STUDENT
JOIN SUGANG ON STUDENT.수강생번호 = SUGANG.수강생번호
JOIN SUBJECT ON SUGANG.수강코드 = SUBJECT.수강코드
WHERE SUBJECT.과목 = 'sql';

--8. 강사가 담당하는 과목과 그 과목이 어느 강의실에서 진행되며 총 수용 인언이 몇 명인지 검색
SELECT TEACHER.강사번호, TEACHER.강사이름, SUGANGTB.수강코드, SUBJECT.과목, ROOM.강의실번호, ROOM.수용인원
FROM TEACHER
JOIN SUGANGTB ON TEACHER.강사번호 = SUGANGTB.강사번호
JOIN ROOM ON SUGANGTB.강의실번호 = ROOM.강의실번호
JOIN SUBJECT ON TEACHER.수강코드 = SUBJECT.수강코드;

--9. 학생의 이름, 주민번호, 성별을 출력하기.
SELECT 수_이름, 수_주민등록번호,
    CASE
        WHEN SUBSTR(수_주민등록번호, 8, 1) IN ('1') THEN '남자'
        WHEN SUBSTR(수_주민등록번호, 8, 1) IN ('2') THEN '여자'
    END AS 성별
FROM STUDENT;
    
--10. TEACHER 강사 이름을 기준으로 올림차순으로 정렬하여 정렬된 순서대로 ROWNUM을 출력.
SELECT ROWNUM, T.*
FROM (
    SELECT 강사이름, 연락처, 주소
    FROM TEACHER
    ORDER BY 강사이름 ASC
)T;
