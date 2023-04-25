select p.pno, p.pname,spj.sno
from s,p,spj
where s.city='London' and spj.sno = s.sno  and spj.pno= p.pno;
