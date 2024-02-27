select * from emp; --alt + x

select empno, ename, job, sal, hiredate from emp where empno=7499;

select empno, ename, job, sal, hiredate from emp where empno=9999;

--레코드 추가
insert into emp(empno, ename, job, sal, hiredate) values (9000,'chul','teacher',200,sysdate);

commit