--1-1. create 문을 만들어 실행한다.
CREATE TABLE users
( 
    user_seq   NUMBER ,
    name  VARCHAR2(50),
    email      VARCHAR2(50),
    phone      VARCHAR2(15),
    is_sleep    CHAR(1)
);

--1-2. user_seq 컬럼에 PK Constraint 를 적용한다.
alter table users add constraint users_pk primary key (user_seq);

--1-3. email  컬럼에 not null, unique 속성을 부여한다.
alter table users add unique(email);
alter table users modify email not null;

--1-4. is_sleep  컬럼에 default 값으로 ‘N’을 설정한다.
alter table users modify  (is_sleep  default 'N');


--1-5 users 테이블의 기본 설정을 확인한다. 
desc users;

--2. ws_07 의 ServiceImpl 에서 테스트한 사용자 데이터를 이용해서 3개의 insert 를 실행한다. ( 단, is_sleep 컬럼은 제외하고 default 값을 확인한다. )
--111, "홍길동", "hong@gildong@com", "010-1111-1111", false
--222, "이길동", "lee@gildong@com", "010-2222-2222", true
--333, "삼길동", "sam@gildong@com", "010-3333-3333", false
		
insert into users  values (111, '홍길동', 'hong@gildong@com', '010-1111-1111', default);
insert into users (user_seq, name, email, phone) values (222, '이길동', 'lee@gildong@com', '010-2222-2222');
insert into users (user_seq, name, email, phone) values (333, '삼길동', 'sam@gildong@com', '010-3333-3333');


--3. users 테이블에 등록된 3 개의 고객 정보를 select  문으로 확인한다. 이 때, is_sleep 컬럼의 값을 확인한다.
select * from users;

--4. user_seq 가 222 인 고객의 is_sleep 값을 ‘Y’ 로 변경하고 그 결과를 select 로 확인한다.

update users 
set is_sleep = 'Y' 
where user_seq = 222;

select * from users where user_seq = 222;

/*5. 아래의 값으로 새로운 1건의 데이터를 insert 해 보고 오류를 확인한다.
   user_seq : 222,
   name : '이길동2'
   email : 'lee2@gildong.com’
   phone : '010-2222-2222'*/

insert into users (user_seq, name, email, phone) 
values (222, '이길동2', 'lee2@gildong@com', '010-2222-2222');
-- ORA-00001: unique constraint (SYSTEM.USERS_PK) violated


/*6. 아래의 값으로 새로운 1건의 데이터를 insert 해 보고 오류를 확인한다.
   user_seq : 2222,
   name : ‘이길동2’
   email : ‘lee@gildong.com’
   phone : ‘010-2222-2222’*/

insert into users (user_seq, name, email, phone) 
values (2222, '이길동2', 'lee@gildong@com', '010-2222-2222');
-- ORA-00001: unique constraint (SYSTEM.SYS_C007011) violated -- SYS_C007011 은 이름을 부여하지 않아 자동으로 생긴 이름

--7. 아래의 값으로 새로운 1건의 데이터를 insert 해 보고 오류를 확인한다.
   user_seq : 2222,
   name : ‘이길동2’
   phone : ‘010-2222-2222’

insert into users (user_seq, name, phone) values (2222, '이길동2', '010-2222-2222');
-- ORA-01400: cannot insert NULL into ("SYSTEM"."USERS"."EMAIL")


/*8. 아래의 값으로 새로운 1건의 데이터를 insert 한다.
   user_seq : 2222,
   name : ‘이길동2’
   email : ‘lee2@gildong.com’
   phone : ‘010-2222-2222’*/

insert into users (user_seq, name, email, phone) 
values (2222, '이길동2', 'lee2@gildong@com', '010-2222-2222');
select * from users;

--9. 위 8번 등록 건을 확인하고 삭제한다.
delete  users where user_seq = 2222;

--10. users 테이블을 삭제하고 workshop 1 ? 4번까지 다시 실행한다.
drop table users;

--위 1-4번 반복

commit;

--어제 USERS 테이블을 생성한 계정에서 작업한다.
select * from users;

insert into users (user_seq, name, email, phone) values (444, '사길동', 'sa@gildong@com', '010-4444-4444');
insert into users (user_seq, name, email, phone) values (555, '오길동', 'o@gildong@com', '010-5555-5555');

CREATE TABLE account
( 
    account_seq   NUMBER,
    account_number VARCHAR2(50) not null,
    balance       NUMBER,
    user_seq      NUMBER,
	CONSTRAINT account_pk PRIMARY KEY (account_seq)
);

insert into account (account_seq, account_number, balance, user_seq) values (50, '00500505005005', 3000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (10, '00100101001001', 1000, 111);
insert into account (account_seq, account_number, balance, user_seq) values (30, '00300303003003', 5000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (70, '00700707007007', 7000, 444);
insert into account (account_seq, account_number, balance, user_seq) values (40, '00400404004004', 4000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (60, '00600606006006', 2000, 222);
insert into account (account_seq, account_number) values (80, '00800808008008');
insert into account (account_seq, account_number, balance, user_seq) values (20, '00200202002002', 6000, 111);

SELECT * FROM USERS;
SELECT * FROM ACCOUNT;


