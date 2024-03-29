select * from member;
create table member(
       		id varchar2(20) primary key,
       		pw varchar2(20),
       		name varchar2(20),
       		reg_date varchar2(20),
       		ssn varchar2(10)
            );
-- CREATE            
insert into member(id,pw,name,reg_date,ssn)
values('lee','1','이순신','2016-07-01','800101-1');
insert into member(id,pw,name,reg_date,ssn)
values('hong','1','홍길동','2015-07-01','901201-1');
insert into member(id,pw,name,reg_date,ssn)
values('you','1','유관순','2014-07-01','010701-4');
insert into member(id,pw,name,reg_date,ssn)
values('hong2','1','홍길동','2015-07-01','020601-1');
insert into member(id,pw,name,reg_date,ssn)
values('kim','1','김유신','2015-06-01','810611-1');
-- READ ()
select * from member; -- list
select * from member where id = 'hong'; -- findByPK (primary key)
select * from member where gender = '남'; -- findByNotPK
select count(*) as count from member; -- count

-- UPDATE
update member set pw = '999' where id = 'you';

-- DELETE
delete from member where id = 'you';


