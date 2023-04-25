select sx.sno, sx.status from s 
where sx.city = 'paris' and sx.status >20;

select sx.sno as firstno, sy.sno as secondno
from s sx, s sy
where sx.city = sy.city and sx.sno<sy.sno;
  
select sx.sno, sx.sname, sx.status, sx.city  from s as sx
where exists (select * from spj as spx where  sx.sno = spx.sno and spx.pno='P2');

select  sx.sname, sx.sno from s as sx
where exists (select * from spj as spx where sx.sno = spx.sno and exists (select * from p as px where px.pno = spx.pno and px.color = 'Red')); 

select distinct sx.sname from s as sx, spj as spy
where exists (select * from spj as spx where sx.sno = spx.sno and spx.pno = spy.pno and spy.sno = 's2');

select distinct sx.sname from s as sx
where not exists (select * from p as px where not exists (select * from spj as spx where sx.sno = spx.sno and px.pno = spx.pno));  

select sx.sname from s as sx 
where not exists (select * from spj as spx  where sx.sno = spx.sno and spx.pno = 'p2'); 

select sx.sno from s as sx
where not exists (select * from spj as spx where sx.sno= spx.sno and spx.sno = 's2');









