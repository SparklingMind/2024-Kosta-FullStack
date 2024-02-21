--1-1. create ���� ����� �����Ѵ�.
	
CREATE TABLE users
( 
    user_seq   NUMBER  constraint users_seq_pk primary key,
    name  VARCHAR2(50) not null,
    email      VARCHAR2(50) not null unique,
    phone      VARCHAR2(15),
    is_Sleep    CHAR(1) default 'N'
);

select * from users;

drop table users;
	
CREATE TABLE users
( 
    user_seq   NUMBER ,
    name  VARCHAR2(50),
    email      VARCHAR2(50),
    phone      VARCHAR2(15),
    is_sleep    CHAR(1)
);


--1-2. user_seq �÷��� PK Constraint �� �����Ѵ�.
alter table users add constraint users_pk primary key (user_seq);

--1-3. email  �÷��� not null, unique �Ӽ��� �ο��Ѵ�.
alter table users add unique(email);
alter table users modify email not null;

--1-4. is_sleep  �÷��� default ������ ��N���� �����Ѵ�.
alter table users modify  (is_sleep  default 'N');


--1-5 users ���̺��� �⺻ ������ Ȯ���Ѵ�. 
desc users;

--2. ws_07 �� ServiceImpl ���� �׽�Ʈ�� ����� �����͸� �̿��ؼ� 3���� insert �� �����Ѵ�. ( ��, is_sleep �÷��� �����ϰ� default ���� Ȯ���Ѵ�. )
--111, "ȫ�浿", "hong@gildong@com", "010-1111-1111", false
--222, "�̱浿", "lee@gildong@com", "010-2222-2222", true
--333, "��浿", "sam@gildong@com", "010-3333-3333", false
		
insert into users  values (111, 'ȫ�浿', 'hong@gildong@com', '010-1111-1111', default);
insert into users (user_seq, name, email, phone) values (222, '�̱浿', 'lee@gildong@com', '010-2222-2222');
insert into users (user_seq, name, email, phone) values (333, '��浿', 'sam@gildong@com', '010-3333-3333');


--3. users ���̺� ��ϵ� 3 ���� �� ������ select  ������ Ȯ���Ѵ�. �� ��, is_sleep �÷��� ���� Ȯ���Ѵ�.
select * from users;

--4. user_seq �� 222 �� ���� is_sleep ���� ��Y�� �� �����ϰ� �� ����� select �� Ȯ���Ѵ�.

update users 
set is_sleep = 'Y' 
where user_seq = 222;

select * from users where user_seq = 222;

/*5. �Ʒ��� ������ ���ο� 1���� �����͸� insert �� ���� ������ Ȯ���Ѵ�.
   user_seq : 222,
   name : '�̱浿2'
   email : 'lee2@gildong.com��
   phone : '010-2222-2222'*/

insert into users (user_seq, name, email, phone) 
values (222, '�̱浿2', 'lee2@gildong@com', '010-2222-2222');
-- ORA-00001: unique constraint (SYSTEM.USERS_PK) violated


/*6. �Ʒ��� ������ ���ο� 1���� �����͸� insert �� ���� ������ Ȯ���Ѵ�.
   user_seq : 2222,
   name : ���̱浿2��
   email : ��lee@gildong.com��
   phone : ��010-2222-2222��*/

insert into users (user_seq, name, email, phone) 
values (2222, '�̱浿2', 'lee@gildong@com', '010-2222-2222');
-- ORA-00001: unique constraint (SYSTEM.SYS_C007011) violated -- SYS_C007011 �� �̸��� �ο����� �ʾ� �ڵ����� ���� �̸�

--7. �Ʒ��� ������ ���ο� 1���� �����͸� insert �� ���� ������ Ȯ���Ѵ�.
   user_seq : 2222,
   name : ���̱浿2��
   phone : ��010-2222-2222��

insert into users (user_seq, name, phone) values (2222, '�̱浿2', '010-2222-2222');
-- ORA-01400: cannot insert NULL into ("SYSTEM"."USERS"."EMAIL")


/*8. �Ʒ��� ������ ���ο� 1���� �����͸� insert �Ѵ�.
   user_seq : 2222,
   name : ���̱浿2��
   email : ��lee2@gildong.com��
   phone : ��010-2222-2222��*/

insert into users (user_seq, name, email, phone) 
values (2222, '�̱浿2', 'lee2@gildong@com', '010-2222-2222');
select * from users;

--9. �� 8�� ��� ���� Ȯ���ϰ� �����Ѵ�.
delete  users where user_seq = 2222;

--10. users ���̺��� �����ϰ� workshop 1 ? 4������ �ٽ� �����Ѵ�.
drop table users;

--�� 1-4�� �ݺ�

commit
