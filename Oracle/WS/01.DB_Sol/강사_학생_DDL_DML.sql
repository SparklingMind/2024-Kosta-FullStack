--system�������� �����Ѵ�.  cmdâ���� conn system/admin

--��������
create user c##exam identified by 1234;

--���Ѽ���
 grant connect, resource , dba to c##exam;
 
 --���� ����Ѵ�.
 
 --���� ���� �������� �����Ѵ�. 

--�������̺�
create table subject(
	�����ڵ� varchar2(5) constraint ����_pk primary key,
	���� varchar2(20) not null
);

--���ǽ� ���̺�
create table room(
	���ǽǹ�ȣ number primary key ,
	�����ο� number not null
);

desc room;

--���� ���̺�
create table teacher(
	�����ȣ number constraint tpk primary key,
	�����̸� varchar2(12) not null,
	�ֹε�Ϲ�ȣ varchar2(14) not null,
	����ó varchar2(14) not null,
	�ּ� varchar2(50),
	�̸��� varchar2(20),
	�����ڵ� varchar2(5) not null constraint tfk  references subject(�����ڵ�)
);

--������ ���̺�
create table student(
	��������ȣ number constraint student_��������ȣ_pk primary key,
	��_�̸� varchar2(12) not null,
	��_�ֹε�Ϲ�ȣ varchar2(14)  not null,
	��_����ó varchar2(14) not null,
	��_�ּ� varchar2(50),
	��_�̸��� varchar2(20)
);

--���� ���̺�
create table sugang(
	��������ȣ number constraint su_pk primary KEY  
                      constraint su_fk references student(��������ȣ),
	�����ڵ�  varchar2(5) constraint aa references subject(�����ڵ�)

);

--��������
create table sugangTB(
	�����ڵ� varchar2(5) primary KEY   ,
	���ǽǹ�ȣ number references Room(���ǽǹ�ȣ),
	�ð� number not null,
	�����ȣ number constraint tbfk  references teacher(�����ȣ),
	foreign key(�����ڵ�) references subject(�����ڵ�)
);

insert into subject values('j1001','sql');
insert into subject values('j1002','Win2000');
insert into subject values('j1003','ASP');
insert into subject values('j1004','Php');
insert into subject values('j1005','java');
insert into subject values('j1006','javascript');


insert into room values(901,34);
insert into room values(902,35);
insert into room values(903,25);
insert into room values(904,32);
insert into room values(905,30);
insert into room values(906,35);

insert INTO teacher values(01,'ȫ�浿','700918-1622011','031-295-1234','������ �߿��� ���ﵿ','kkk@jok.or.kr','j1001');
insert INTO teacher values(02,'������','710419-2018916','02-345-2345','���� ������ ������','kkk@jok.or.kr','j1002');
insert INTO teacher values(03,'�̽º�','730112-1344911','031-1234-6789','����� ������ ������','sss@jok.or.kr','j1003');
insert INTO teacher values(04,'���õ�','730301-1167623','031-567-5678','����� ���ʱ� ���ʵ�','mmm@jok.or.kr','j1004');
insert INTO teacher values(05,'�ַ���','730322-2037921','031-789-3456','����� ������ ���絿','xxx@jok.or.kr','j1005');
insert INTO teacher values(06,'�̼���','731122-1646213','031-234-8901','����� ���ϱ� �̾Ƶ�','ppp@jok.or.kr','j1006');


insert INTO student values(01,'������','771212-2346111','017-888-8888','�λ�','aaa@hanmail.net');
insert INTO student values(02,'�輮��','720112-1234812','016-999-9999','���','bbb@hanmail.net');
insert INTO student values(03,'���Ʊ�','730102-1555555','017-555-5555','����','ccc@hanmail.net');
insert INTO student values(04,'���ΰ�','801111-2222222','017-222-2222','����','ddd@hanmail.net');
insert INTO student values(05,'�迵��','811231-1777777','017-777-7777','����','eee@hanmail.net');
insert INTO student values(06,'�ڻ��','790915-1333333','017-333-3333','����','fff@hanmail.net');


insert into sugang values(01,'j1001');
insert into sugang values(02,'j1002');
insert into sugang values(03,'j1003');
insert into sugang values(04,'j1004');
insert into sugang values(05,'j1005');
insert into sugang values(06,'j1006');


insert into sugangtb values('j1001',901,2,01);
insert into sugangtb values('j1002',902,2,02);
insert into sugangtb values('j1003',903,2,03);
insert into sugangtb values('j1004',904,2,04);
insert into sugangtb values('j1005',905,2,05);
insert into sugangtb values('j1006',906,2,06);

select *from  subject;
select *from  room;
select *from  teacher;
select *from  student;
select *from  sugang;
select *from  sugangtb;


