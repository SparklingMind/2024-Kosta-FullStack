select * from users;
select * from account;

--1. 고객번호 ( user_seq ) 가 111 인 계좌 ( account ) 테이블을 조회한다.
select * from account where user_seq = 111;


--2. 잔고 ( balance ) 가 5000 미만인 계좌 ( account ) 테이블을 조회한다.
select * from account where balance < 5000;


--3. 잔고 ( balance ) 가 5000 이상 10000 이하인 계좌 ( account ) 테이블을 조회한다.
select * from account where balance between 5000 and 10000;


--4. 계좌번호 ( accountNumber ) 중 ‘4’ 를 포함하는 계좌 ( account ) 테이블을 조회한다. 
select * from account where account_number like '%4%';


--5. 고객명 ( name ) 이 ‘삼‘ 을 시작하는 고객 ( users ) 테이블을 조회한다.
select * from users where name like '삼%';


--6. 계좌 ( account ) 테이블에 있는 고객 번호 ( user_seq ) 를 중복없이 조회한다.
select  user_seq  from account;
select distinct user_seq  from account where user_seq is not null;


--7. 잔고 ( balance ) 가 없는 ( null ) 계좌 ( account ) 테이블을 조회한다.
select * from account where balance is null;


--8. 고객번호 ( user_seq ) 가 있는 계좌 ( account ) 테이블을 조회한다.
select * from account where user_seq is not null;

--9. 고객번호 ( user_seq ) 가 있고, 잔고가 4000 이하인 계좌 ( account ) 테이블을 조회한다.
select * from account 
 where user_seq is not null and balance <= 4000;


--10. 계좌 ( account ) 테이블을 고객번호 ( user_seq ) 기준으로 오름차순으로 정렬하여 조회한다.
select * from account order by user_seq ; 


/*11. 계좌 ( account ) 테이블을 고객번호 ( user_seq ) 기준으로 오름차순으로, 
그리고 그 안에서 잔고( balance ) 기준으로 내림차순으로 정렬하여 조회한다.*/
select * from account order by user_seq asc, balance desc; 


--12. 계좌 ( account ) 테이블을 조회하되, balance 값이 없으면 0 으로 표시한다.
select account_seq, account_number, balance, user_seq from account;

select account_seq, account_number, nvl(balance, 0), user_seq from account;

--select ac.* , balance*10 from account ac;

select  ac.* , nvl(balance, 0) from account ac;


/*13. 고객 ( users ) 테이블을 조회하되, email은 @포함 뒷 부분은 빼고 앞 아이디만 표시한다. 
컬럼명도 email 대신 email_id 로 변경한다.*/
select user_seq, email , instr(email, '@')
from users;

select user_seq,email ,  substr( email, 1, instr(email, '@')-1 ) email_id, phone, is_sleep 
from users;


/*14. 고객 ( users ) 테이블을 조회하되, phone 의 ‘-’ 를 제외하고 표시한다. 
컬럼명도 phone_short 로 변경한다.*/
select user_seq, email, phone, is_sleep from users;

select  phone, substr(phone,1,3) ||  substr(phone,5,4) || substr(phone,10)  
from users;

select  phone, replace(phone,'-','')  from users;

select user_seq, email, replace(phone,'-','') phone_short, is_sleep from users;


 