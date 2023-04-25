select * from emp;
start transaction;
delete from emp where Eno = 'E3';
select * from emp;
rollback;
select * from emp;